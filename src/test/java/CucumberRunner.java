import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(glue = "com/rxr/framework/StepDefinition", 
features = "src/test/java/com/rxr/framework/Feature", 
format = { "html:target/cucumber-htmlreport", "json:target/cucumber-report.json" }, 
//tags = { "@Wag_LoginScreen_Scenario,@Wag_soapUI_runner"}, monochrome = true)
tags = { "@Testrun"}, monochrome = true)
public class CucumberRunner extends AbstractTestNGCucumberTests {                                                                                                                                    // @Walgreens_HomeScreen_Scenario  //@JPMC_Login_Scenario

}
