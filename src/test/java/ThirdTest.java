import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThirdTest {
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
    public void signUpLogOutSignInTest() throws Exception {
        double randomNumber = Math.random() * 10000;
        driver.get("https://jpapez-myplan.web.app/signin");
        Thread.sleep(1000);
        driver.findElement(By.linkText("Sign up")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("new@new"+randomNumber+".com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("1234567");
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("new");
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("new");
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[5]/button")).click();
        Thread.sleep(2000);
        Boolean isPresent2 = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div/form/div[5]/div/p")).size() > 0;
        if (isPresent2) {
            System.out.println("The email address is already in use by another account.");
            Assert.fail();
        }
        driver.findElement(By.linkText("Log Out")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("new@new" + randomNumber + ".com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("1234567");
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/button")).click();
        Thread.sleep(3000);
        Boolean isPresent = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div/form/div[3]/div/p")).size() > 0;
        if (isPresent) {
            System.out.println("Log in Failed");
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }

    //-----------------------------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        driver.quit();
    }
}