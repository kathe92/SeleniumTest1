package Tests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pages.BasePage;
import org.junit.jupiter.api.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features="src/test/java/features",
        glue = "stepDefinitions",
        monochrome = true,
        tags = "@Smoke"
)

public class RunnerTests {
    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
}


