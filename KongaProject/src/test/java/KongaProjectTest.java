import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class KongaProjectTest {

    //import Selenium WebDriver
  private WebDriver driver;

  @org.testng.annotations.BeforeTest
  public void SETUP() throws InterruptedException {
      //Locate where chrome driver is
      System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\IdeaProjects\\KongaProject\\src\\main\\resources\\chromedriver.exe");
      //open Chrome browser
      driver = new ChromeDriver();



      //input Konga page url
      driver.get("https://www.konga.com/");
      //maximize the page
      driver.manage().window().maximize();
      //click on the login/signup button
      driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div[4]/a")).click();
      //input valid email
      driver.findElement(By.id("username")).sendKeys("");
      //input valid password
      driver.findElement(By.id("password")).sendKeys("");
      //click on login button
      driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
      Thread.sleep(10000);



      //HOMEPAGE

      //on the home page click on All Categories
      driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/nav/div/div[2]/div/a[1]")).click();
      Thread.sleep(10000);

      //click on laptops in the subcategory (computers and accessories
      driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
      Thread.sleep(10000);

      //click on laptops
      driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[1]/section/section/section/div/section/div[2]/div[2]/ul/li[3]/a")).click();
      Thread.sleep(10000);

       //click on Apple Macbook in laptops
      driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[1]/section/section/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span")).click();
      Thread.sleep(10000);

      //click on product item
      driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[1]/section/section/section/section/section/ul/li[4]/article/div[2]/a/h3")).click();
      //driver.findElement(By.className("af885_1iPzH")).click();
      Thread.sleep(10000);
      //  //*[@id="mainContent"]/section[1]/section/section/section/section/section/ul/li[4]/article/div[2]/a/h3



      // ADD TO CART PAGE

      //Add Item to Cart
      driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div[3]/div[1]/div[1]/div/div[2]/div[2]/form/div[5]/div[1]/button")).click();
      Thread.sleep(10000);

      // Close pop up
      driver.findElement(By.xpath("/html/div/div/div[1]/button")).click();
      Thread.sleep(10000);

      //Click on continue to checkout
      WebElement element = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[3]/div[3]/div/div[2]/a"));
      JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("arguments[0].click();", element);
          Thread.sleep(10000);



          //PAYMENT PAGE

      //click pay now
      driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
      Thread.sleep(20000);

      //click continue to payment
      driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
      Thread.sleep(10000);

      //switch to iframe
      WebElement iframeElement = driver.findElement(By.xpath("//*[@id=\"kpg-frame-component\"]"));
      driver.switchTo().frame(iframeElement);
      Thread.sleep(10000);

      //click on card
      driver.findElement(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[3]/button")).click();
      Thread.sleep(5000);

      // enter wrong card detail
      driver.findElement(By.id("card-number")).sendKeys("4920690182556718");
      Thread.sleep(10000);

      //Locate error message invalid card number
      WebElement element1 = driver.findElement(By.xpath("//*[@id=\"card-number_unhappy\"]"));
      Thread.sleep(10000);

      // print error message
      System.out.println("Error Message: " + element1.getText());
      Thread.sleep(10000);

      // close frame
      //driver.findElement(By.xpath("//*[@id=\"kpg-frame-component\"]")).click();
      driver.switchTo().defaultContent();
  }


@AfterTest
public void CloseBrowser() {
          //16. quit
          driver.quit();
      }
  }
