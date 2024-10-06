import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(io.cucumber.junit.Cucumber.class)
@CucumberOptions
        (features = "src/test/resources/features/submitForm.feature",
        glue = {"stepDefinition"},
        plugin = {"pretty",
                "json:test-output/cucumber.json",
                "html:test-output/cucumber-reports.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true )
public class RunCucumberTest {

}
