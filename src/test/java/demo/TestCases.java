package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */
    @Test
    public void testCase01() throws InterruptedException{
        Wrappers wrapper = new Wrappers();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
      Thread.sleep(2000);
       WebElement nameInput = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[1]"));
       wrapper.setText(nameInput, "Crio Learner");

        WebElement practiceTextArea = driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
        wrapper.setText(practiceTextArea, wrapper.getCurrentEpochTime());

        WebElement automationExperience = driver.findElement(By.xpath("(//div[@class='AB7Lab Id5V1'])[2]"));
        wrapper.clickElement(automationExperience);
        WebElement java = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[1]"));
        wrapper.clickElement(java);
        WebElement selenium = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[2]"));
        wrapper.clickElement(selenium);
        WebElement testNg = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[4]"));
         wrapper.clickElement(testNg);
        WebElement salutationDropdown = driver.findElement(By.xpath("(//div[@jsname='d9BH4c'])[1]"));
         wrapper.clickElement(salutationDropdown);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='Mr'])[2]")));
        WebElement dropDownValue = driver.findElement(By.xpath("(//span[text()='Mr'])[2]"));
        wrapper.clickElement(dropDownValue);
        WebElement date = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[2]"));
        wrapper.setText(date, wrapper.getDateBeforeSevenDays());
        WebElement hour = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        wrapper.setText(hour, "07");
        WebElement min = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
        wrapper.setText(min, "30");
        WebElement btnSubmit = driver.findElement(By.xpath("(//div[@role='button'])[1]"));
        wrapper.clickElement(btnSubmit);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='vHW8K']")));
        WebElement thankYouText = driver.findElement(By.xpath("//div[@class='vHW8K']"));
        System.out.println(thankYouText.getText());
        
    }
     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}