package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("surveyor@edgehill.co.uk");
    }

    @When("^enter value in the Password field$")
    public void enter_value_in_the_Password_field() {
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Realm34$");
    }

    @When("^press Login button$")
    public void press_Login_button() {
        WebElement login = driver.findElement(By.xpath("//button[@class='ant-btn loginButton___1DINl']"));
        login.click();
    }

    @Then("^Open home page$")
    public void Open_home_page() {
        WebElement home = driver.findElement(By.linkText("Home"));
        driver.quit();
    }
}
