import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) //запустить процесс
@CucumberOptions(plugin = {"json:build/cucumber-report/cucmber.json", "pretty"},
        features = "src\\test\\resources\\features",
        tags = "@navigate")

public class RunCucumberTests {
}
