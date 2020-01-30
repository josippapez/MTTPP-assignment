import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SecondTest {
    public WebDriver driver;
    public String testURL = "https://jpapez-myplan.web.app/";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.gecko.driver", "C:/Drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.navigate().to(testURL);
    }

    @Test
    public void signUpTest() throws Exception {
        driver.get("https://jpapez-myplan.web.app/signin");
        Thread.sleep(1000);
        driver.findElement(By.linkText("Sign up")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div/label")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("new@new"+Math.random()*10000+".com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("new");
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("new");
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[5]/button")).click();
        Thread.sleep(3000);
        Boolean isPresent = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div/form/div[5]/div/p")).size() > 0;
        if (isPresent){
            System.out.println("The email address is already in use by another account.");
            Assert.fail();
        }
        else{
            Assert.assertTrue(true);
        }
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}