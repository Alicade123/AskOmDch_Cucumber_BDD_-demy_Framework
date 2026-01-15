package askomdch.hooks;


import askomdch.context.dependency_injection.TestContext;
import askomdch.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;


public class MyHooks {
    private WebDriver driver;
    private final TestContext testContext;

    public MyHooks(TestContext testContext){
        this.testContext = testContext;
    }

    @Before
    public void before(Scenario scenario){
        testContext.scenarioName = scenario.getName();
        System.out.println("BEFORE: THREAD ID : " + Thread.currentThread().threadId() + "," +
                "SCENARIO NAME: " + scenario.getName());
        driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
        testContext.driver = driver;
    }
    @After
    public void after(Scenario scenario){
        System.out.println("AFTER: THREAD ID : " + Thread.currentThread().threadId() + "," +
                "SCENARIO NAME: " + scenario.getName());
        driver.quit();
    }
}
