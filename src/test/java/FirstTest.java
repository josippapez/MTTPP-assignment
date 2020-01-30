import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {
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
    public void trySignInWithoutSignUp() throws InterruptedException {
        // driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]")));
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailInput.sendKeys("josip@josip.com");
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordInput.sendKeys("josip");
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[3]/button"));
        submitButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/form/div[3]/div/p")));
        WebElement testLink = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[3]/div/p"));
        Assert.assertEquals(testLink.getText(), "Login failed");
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}