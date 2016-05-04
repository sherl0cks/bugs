package example.rules;

import org.junit.Assert;
import org.junit.Test;

import example.app.DecisionService;

public class RuleTest {

	DecisionService decisionService = new DecisionService();
	
	@Test
	public void shouldFailToLoadKieContainer() {
		System.setProperty("org.guvnor.m2repo.dir", "~/.m2/repository");
		String string = decisionService.updateKieContainer("example", "order-processing-rules", "1.5") ;
		Assert.assertEquals("Cannot find KieModule: foo:bar:baz", string);
	}

}
