package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

@CucumberOptions
@cucumber.api.CucumberOptions

public class Login {

    public static WebDriver driver;
    @Given("^open start page$")
    public void open_start_page() {
        System.setProperty("webdriver.chrome.driver", "C://drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://uat.test-aws.reams-elias.co.uk/user/login");

    }

    @When("^enter value in the Email field$")
    public void enter_value_in_the_Email_field() {

        WebElement valueEmail = driver.findElement(By.id("email"));
        valueEmail.sendKeys("surveyor@edgehill.co.uk");
    }

    @And("^enter value in the Password field$")
    public void enter_value_in_the_Password_field() {
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Realm34$");
    }

    @And("^press Login button$")
    public void press_Login_button() {
        WebElement login = driver.findElement(By.xpath("//button[@class='ant-btn loginButton___1DINl']"));
        login.click();
    }

    @Then("^go to home page$")
    public void go_to_home_page() {

        String exp = "ok online";
       String actual = driver.findElement(By.xpath("//span[contains(text(),'ok online')]")).getText();
        Assert.assertEquals(exp,actual);
        driver.quit();
    }
}
