package Steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataSteps {
    WebDriver driver;

    @Given("^check link$")
    public void user_is_already_on_login_page() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\machabba\\Documents\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.marmiton.org/espace-perso/login.aspx");
    }

    @When("^user enters username and password$")
    public void user_enters_username_and_password() {
        driver.findElement(By.name("ctl00$cphMainContent$ctl00$UserName")).sendKeys("TheBestStagiaire");
        driver.findElement(By.name("ctl00$cphMainContent$ctl00$Password")).sendKeys("JeSuisExplo1té!");
    }

    @When("^user clicks on login button$")
    public void user_clicks_on_login_button() {
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='ctl00_cphMainContent_ctl00_Connect']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", loginBtn);
    }

    @Then("^user is on profil page$")
    public void user_is_on_profil_page() {
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("Mon profil", title);
    }

}
