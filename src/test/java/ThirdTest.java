import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThirdTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String testURL = "https://jpapez-myplan.web.app/";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }

    @Test
    public void signUpLogOutSignInTest() throws Exception {
        double randomNumber = Math.random() * 10000;
        driver.get("https://jpapez-myplan.web.app/signin");
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign up")));
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
        wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out")));
        driver.findElement(By.linkText("Log Out")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("new@new" + randomNumber + ".com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("1234567");
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/button")).click();
        wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out")));
        Assert.assertTrue(true);
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}