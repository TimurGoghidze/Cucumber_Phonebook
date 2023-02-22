package steps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Map;
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
    private void click(By locator) {
        driver.findElement(locator).click();
    }

    @When("Enter invalid data")
    public void enterInvalidCreds(DataTableType){
        List<Map<String, String>> dataTable = table.asMaps(); ///Start mistakes
        String email = dataTable.get(0).get("email");
        String password = dataTable.get(0).get("password");

        //type email
        click(By.xpath("//input[@placeholder=\"Email\"]"));
        invalidEmail.sendKeys("test1234a@dvss.ru");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

         //type email
        click(By.xpath("//input[@placeholder=\"Password\"]"));
        invalidPass.sendKeys("snklvnskl");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //type password
    }
    @And("Click on Login button")
            public void pushTheButton() {

        WebElement loginButton = driver.findElement(By.xpath("//button[@type=\"submit\"]")); // find button
        click(By.xpath("//button[@type=\"submit\"]"));
        loginButton.click(); // click button
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }
    @Then ("Alert is displayed")
            public void alertDisplayed(){
        WebElement invalidEmailOrPass = driver.findElement(By.xpath("//div[@id='error-message']"));
        Assert.assertEquals(invalidEmailOrPass.getText(), " Please check your activation or Login + Password combination");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }



}
