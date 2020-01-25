import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest {
    //-----------------------------------Global Variables-----------------------------------
//Declare a Webdriver variable
    public WebDriver driver;
    //Declare a test URL variable
    public String testURL = "https://jpapez-myplan.web.app/";

    //-----------------------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        //Create a new ChromeDriver
        driver = new ChromeDriver();
        //Go to www.swtestacademy.com
        driver.navigate().to(testURL);
    }

    @Test
    public void trySignInWithoutSignUp() throws InterruptedException {
        // driver.manage().window().maximize();
        Thread.sleep(500);
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailInput.sendKeys("josip@josip.com");
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordInput.sendKeys("josip");
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[3]/button"));
        submitButton.click();
        Thread.sleep(1500);
        WebElement testLink = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[3]/div/p"));
        Assert.assertEquals(testLink.getText(), "Login failed");
    }

    //-----------------------------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        driver.quit();
    }
}