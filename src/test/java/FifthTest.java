import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FifthTest {
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
    public void createProjectNotificationTest() throws Exception {
        double randomNumber = Math.random() * 10000;
        driver.get("https://jpapez-myplan.web.app/signin");
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign up")));
        driver.findElement(By.linkText("Sign up")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("netko@netko" + randomNumber + ".com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("1234567");
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("netko");
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("netko");
        driver.findElement(By.id("firstName")).sendKeys(Keys.ENTER);
        wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("New Project")));
        driver.findElement(By.linkText("New Project")).click();
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div/label")).click();
        driver.findElement(By.id("title")).clear();
        driver.findElement(By.id("title")).sendKeys("novi projekt" + randomNumber);
        driver.findElement(By.id("content")).clear();
        driver.findElement(By.id("content")).sendKeys("newwwwww");
        driver.findElement(By.xpath("//div[@id='root']/div/div/form/div[3]/button")).click();
        String newProjectName= "Added a new project named: \"novi projekt" + randomNumber + "\"";
        System.out.println(newProjectName);
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div/div/ul/li[1]/span[2]"), newProjectName));
        Assert.assertTrue(true);
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}