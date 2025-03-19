//import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignUpTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
       // System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\IdeaProjects\\FacebookTest\\Resources\\chromedriver.exe");
        driver = new ChromeDriver();
        //verify that user input the right url and is on the right webpage (Test1)
        driver.get("https://selenium-blog.herokuapp.com/");
        //pass
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
            System.out.println("Successfully opened the website");
        //fail
        else
            System.out.println("Failed to open the website");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
    }
    @Test (priority = 4)
    //verify that user cannot sign up with username less than 3 characters
    public void NegativeSignUpLessThanThreeCharacters() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        driver.findElement(By.id("user_username")).sendKeys("in");
        driver.findElement(By.id("user_email")).sendKeys("sullivanalice99@gmail.com");
        driver.findElement(By.id("user_password")).sendKeys("admin");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        //clear username field
        driver.findElement(By.id("user_username")).clear();
        //clear user email field
        driver.findElement(By.id("user_email")).clear();
        //clear password field
        driver.findElement(By.id("user_password")).clear();
        Thread.sleep(5000);
    }

    @Test (priority = 5)
    //verify that user cannot sign up with invalid email address
    public void NegativeSignUpInvalidEmail() throws InterruptedException {
       // driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        driver.findElement(By.id("user_username")).sendKeys("in");
        driver.findElement(By.id("user_email")).sendKeys("sullivanalice99@");
        driver.findElement(By.id("user_password")).sendKeys("admin");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        //clear username field
        driver.findElement(By.id("user_username")).clear();
        //clear user email field
        driver.findElement(By.id("user_email")).clear();
        //clear password field
        driver.findElement(By.id("user_password")).clear();
        Thread.sleep(5000);
    }

    @Test (priority = 6)
    //verify that user cannot sign up with password less than or equal to one character
    public void NegativeSignUpShortPassword() throws InterruptedException {
       // driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        driver.findElement(By.id("user_username")).sendKeys("in");
        driver.findElement(By.id("user_email")).sendKeys("sullivanalice99@gmail.com");
        driver.findElement(By.id("user_password")).sendKeys("a");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        //clear username field
        driver.findElement(By.id("user_username")).clear();
        //clear user email field
        driver.findElement(By.id("user_email")).clear();
        //clear password field
        driver.findElement(By.id("user_password")).clear();
        Thread.sleep(5000);
    }


    @Test (priority = 7)
    // verify that user cannot signin with either or all of the fields blank
    public void NegativeSignUpBlankFields() throws InterruptedException {
       // driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        driver.findElement(By.id("user_username")).sendKeys("");
        driver.findElement(By.id("user_email")).sendKeys("");
        driver.findElement(By.id("user_password")).sendKeys("");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        //clear username field
        driver.findElement(By.id("user_username")).clear();
        //clear user email filed
        driver.findElement(By.id("user_email")).clear();
        //clear password field
        driver.findElement(By.id("user_password")).clear();
        Thread.sleep(5000);
    }



    @Test (priority = 0)
    public void PositiveSignUp() throws InterruptedException {
        driver.findElement(By.id("user_username")).sendKeys("Enitan09898");
        driver.findElement(By.id("user_email")).sendKeys("sullivanalice09898@gmail.com");
        driver.findElement(By.id("user_password")).sendKeys("admin");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }



    @Test (priority = 1)
    //verify that when user clicks on the signup button, the user is directed to the sign up page (test 2)
    public void User1Item() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/ul/div/div/li[1]")).click();
        String expectedurl = "https://selenium-blog.herokuapp.com/signup";
        String actualurl = driver.getCurrentUrl();
        //pass
        if (actualurl.contains(expectedurl))
            System.out.println("Successfully opened the website");
        //fail
        else
            System.out.println("Failed to open the website");
        Thread.sleep(5000);


       // Thread.sleep(5000);
    }
        @Test (priority = 2)
        //verify that user1 is present (test7)
        public void VerifyItem() throws InterruptedException {
            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[1]")).click();
            String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/2";
            String actualPageUrl = driver.getCurrentUrl();
            //pass
            if (actualPageUrl.contains(expectedPageUrl))
                System.out.println("Successfully opened the website");
            //fail
            else
                System.out.println("Failed to open the website");
            Thread.sleep(5000);
        }

        @Test (priority = 3)
        public void VerifyTitle() throws InterruptedException {
            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
            String expectedTitle = "AlphaBlog";
            String actualTitle = driver.getTitle();
            //pass
            if (actualTitle.contains(expectedTitle))
                System.out.println("Successful");
            //fail
            else
                System.out.println("Failed");
            Thread.sleep(5000);
        }


    @AfterTest
    public void CloseBrowser() {
        driver.quit();
    }
}






