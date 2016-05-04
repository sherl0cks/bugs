package example.app;

import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

public class DecisionService {

	private KieContainer kieContainer;

	public String updateKieContainer(String group, String artifact, String version) {
		try {
			ReleaseId id = KieServices.Factory.get().newReleaseId(group, artifact, version);
			KieContainer newKieContainer = KieServices.Factory.get().newKieContainer(id);
			this.kieContainer = newKieContainer;
			return "Rules updated sucessfully to " + group + ":" + artifact + ":" + version;
		} catch (Throwable e) {
			e.printStackTrace( System.err );
			return e.getMessage();
		}

	}

	private StatelessKieSession createKieSession() {
		return kieContainer.newStatelessKieSession();
	}

}
