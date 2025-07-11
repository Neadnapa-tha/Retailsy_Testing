// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class Case04Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void checkoutpass() {
    driver.get("http://45.144.164.182:8080/");
    driver.manage().window().setSize(new Dimension(784, 816));
    driver.findElement(By.linkText("Add to cart")).click();
    driver.findElement(By.linkText("Add to cart")).click();
    driver.findElement(By.cssSelector(".header-wrap-right #cart-bag > .fa:nth-child(1)")).click();
    driver.findElement(By.linkText("Checkout")).click();
    driver.findElement(By.id("customer_details")).click();
    driver.findElement(By.id("billing_last_name")).click();
    driver.findElement(By.cssSelector(".woocommerce-billing-fields__field-wrapper")).click();
    driver.findElement(By.id("billing_company")).click();
    driver.findElement(By.cssSelector(".col-1")).click();
    driver.findElement(By.id("select2-billing_country-container")).click();
    driver.findElement(By.id("billing_address_1")).click();
    driver.findElement(By.id("customer_details")).click();
    driver.findElement(By.id("billing_city")).click();
    driver.findElement(By.id("customer_details")).click();
    js.executeScript("window.scrollTo(0,600)");
    driver.findElement(By.id("select2-billing_state-container")).click();
    driver.findElement(By.id("customer_details")).click();
    driver.findElement(By.id("customer_details")).click();
    driver.findElement(By.id("billing_email")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".blog-details"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".blog-details"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".blog-details"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.cssSelector(".blog-details")).click();
    driver.findElement(By.id("ship-to-different-address-checkbox")).click();
    {
      WebElement element = driver.findElement(By.id("ship-to-different-address-checkbox"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.id("shipping_first_name")).click();
    driver.findElement(By.id("shipping_last_name")).click();
    driver.findElement(By.cssSelector(".woocommerce-shipping-fields__field-wrapper")).click();
    driver.findElement(By.id("shipping_company")).click();
    driver.findElement(By.id("customer_details")).click();
    driver.findElement(By.id("select2-shipping_country-container")).click();
    driver.findElement(By.id("customer_details")).click();
    driver.findElement(By.id("shipping_address_1")).click();
    driver.findElement(By.id("shipping_city")).click();
    driver.findElement(By.id("shipping_city")).click();
    driver.findElement(By.id("select2-shipping_state-container")).click();
    driver.findElement(By.id("customer_details")).click();
    driver.findElement(By.id("place_order")).click();
  }
}
