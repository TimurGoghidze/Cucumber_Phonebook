package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class LoginSteps {

    WebDriver driver;
    @Given("Navigate to Page Phone Book")
        public void navigateToLoginPage(){
        System.setProperty("webdriver.chrome.driver", "D:\\2 tel run\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://phonebook.telran-edu.de:8080/user/login");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }
    @When("Register new account link")
    public void clickOnRegistrationLink(){
        click(By.xpath("//a[contains(text(),'Register new Account')]"));
    }

    @Then("Registration form should appear")
    public void isRegistrationFormPresent(){
        Assert.assertTrue(isElementPresent(By.xpath("//h3[contains(text(),'Registration page')]")));
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }
    private void click(By xpath) {
    }

}
