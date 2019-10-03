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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@CucumberOptions
@cucumber.api.CucumberOptions

public class Login {

    public static WebDriver driver;

    @Given("^open start page$")
    public void open_start_page() {
        System.setProperty("webdriver.chrome.driver", "C://drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://uat.test-aws.reams-elias.co.uk/user/login");
        WebDriverWait wait = new WebDriverWait (driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//input[@id='email']" )));
    }
    @When("^enter value in the Email field$")
    public void enter_value_in_the_Email_field() {
        WebElement valueEmail = driver.findElement(By.xpath("//input[@id='email']"));
       valueEmail.click();
        valueEmail.clear();
        valueEmail.sendKeys("surveyor@edgehill.co.uk");
    }
    @And("^enter value in the Password field$")
    public void enter_value_in_the_Password_field() {
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.clear();
        password.sendKeys("Realm34$");
    }
    @And("^press Login button$")
    public void press_Login_button() {
        WebElement login = driver.findElement(By.xpath("//button[@class='ant-btn loginButton___1DINl']"));
        login.click();
    }
    @Then("^go to home page$")
    public void go_to_home_page() {
        WebDriverWait wait = new WebDriverWait (driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//span[contains(text(),'Home')]" )));
        Boolean isPresent = driver.findElements(By.xpath("//span[contains(text(),'Home')]")).size() > 0;
    }
    @When("^Facilities block check$")
    public void Facilities_block_check() {
        WebDriverWait wait = new WebDriverWait (driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("span")));
        WebElement Facilities = driver.findElement(By.tagName("span"));
        if (Facilities.isDisplayed()) {
            System.out.println("Block checked!");
        } else {
            System.out.println("Block not found");
        }
    }
        @And("^Check displayed colums$")
        public void Check_displayed_colums() {
            WebDriverWait wait = new WebDriverWait (driver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-table-column-title")));
            WebElement name = driver.findElement(By.className("ant-table-column-title"));
            WebElement Status = driver.findElement(By.xpath("//span[contains(text(),'Status')]"));
            WebElement Site = driver.findElement(By.xpath("//span[contains(text(),'Site')]"));
            WebElement Postcode = driver.findElement(By.xpath("//span[contains(text(),'Postcode')]"));
            WebElement Assets = driver.findElement(By.xpath("//span[contains(text(),'Assets')]"));
           // WebElement LastEdited = driver.findElement(By.xpath("//span[contains(text(),'Last edited id=\"LastEdited\"')]")).findElement(By.name("Last edited"));
            if (name.isDisplayed()) {
                System.out.println("Colum name checked!");
            } else {
                System.out.println("Colum name not found");
            }

            if (Status.isDisplayed()) {
                System.out.println("Colum Status checked!");
            } else {
                System.out.println("Colum Status not found");
            }

            if (Site.isDisplayed()) {
                System.out.println("Colum Site checked!");
            } else {
                System.out.println("Colum Site not found");
            }
            if (Postcode.isDisplayed()) {
                System.out.println("Colum Postcode checked!");
            } else {
                System.out.println("Colum Postcode not found");
            }
            if (Assets.isDisplayed()) {
                System.out.println("Colum Assets checked!");
            } else {
                System.out.println("Colum Assets not found");
            }
            driver.quit();
        }

    }

