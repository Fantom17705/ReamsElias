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
import org.openqa.selenium.support.ui.Select;
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
        WebElement topbar = driver.findElement(By.xpath("//div[@class='topbar___VGc3o']"));
        if (topbar.isDisplayed()) {
            System.out.println("you are logged in!!!");
        } else
            {
                System.out.println("you are not logged in");
       }
    }
    @When("^Facilities block check$")
    public void Facilities_block_check() {
        WebElement Facilities = driver.findElement(By.xpath("//div[@class='facilitiesContainer___1u0SN']"));
        Facilities.isDisplayed();
        if (Facilities.isDisplayed()) {
            System.out.println("Block checked!");
        } else {
            System.out.println("Block not found");
        }
    }
        @And("^Check displayed colums$")
        public void Check_displayed_colums() {
            WebElement name = driver.findElement(By.xpath("//div[@class='ant-table ant-table-default ant-table-scroll-position-left']//span[@class='ant-table-column-title'][contains(text(),'Name')]"));
            WebElement Status = driver.findElement(By.xpath("//span[contains(text(),'Status')]"));
            WebElement Site = driver.findElement(By.xpath("//span[contains(text(),'Site')]"));
            WebElement Postcode = driver.findElement(By.xpath("//span[contains(text(),'Postcode')]"));
            WebElement Assets = driver.findElement(By.xpath("//span[contains(text(),'Assets')]"));
            WebElement LastEdited = driver.findElement(By.xpath("//th[@class='rightAlign___3pvJO borderRightNone___Ffwe1 ant-table-column-has-actions ant-table-column-has-sorters ant-table-column-sort']//span[@class='ant-table-column-title'][contains(text(),'Last Edited')]"));
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

