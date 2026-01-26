package askomdch.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        glue = {"askomdch"},
        features = "src/test/resources/askomdch/features",
        plugin = "pretty",
        tags = "@addToCart"
)
public class MyTestNGRunnerTest extends AbstractTestNGCucumberTests {


    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}