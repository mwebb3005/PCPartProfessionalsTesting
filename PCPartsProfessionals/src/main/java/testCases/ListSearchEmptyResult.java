package testCases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration;

public class ListSearchEmptyResult {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\lazym\\Downloads\\pc_parts_professionals-main test\\pc_parts_professionals-main\\PCPartsProfessionals\\src\\main\\webapp\\WEB-INF\\lib\\win\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testListSearchEmptyResult() throws Exception {
    driver.get("http://ec2-54-236-27-225.compute-1.amazonaws.com:8080/PCPartsProfessionals/pc_parts_Listings.html");
    driver.findElement(By.id("search")).click();
    driver.findElement(By.id("search")).clear();
    driver.findElement(By.id("search")).sendKeys("EmptySearchReturn");
    driver.findElement(By.id("param")).click();
    new Select(driver.findElement(By.id("param"))).selectByVisibleText("City");
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
    driver.get("http://ec2-54-236-27-225.compute-1.amazonaws.com:8080/PCPartsProfessionals/searchListings?searchParam=city");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
