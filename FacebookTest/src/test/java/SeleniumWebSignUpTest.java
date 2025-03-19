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

    //import the selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        //1.Locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\IdeaProjects\\FacebookTest\\Resources\\chromedriver.exe");
        //2.open chrome browser
        driver = new ChromeDriver();
        //3.input selenium demo page url
        driver.get("https://selenium-blog.herokuapp.com/");
        //verify that user input the right url and is on the right webpage (Test1)
        //pass
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
            System.out.println("Successfully opened the website");
        //fail
        else
            System.out.println("Failed to open the website");
        //4.wait globally for full loading
        Thread.sleep(5000);
        //5.maximize the page
        driver.manage().window().maximize();
        //6.click on the sign up button
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
    }
    @Test (priority = 4)
    //verify that user cannot sign up with username less than 3 characters
    public void NegativeSignUpLessThanThreeCharacters() throws InterruptedException {
        //7.click on the sign up button
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //8.input your username on the user name field
        driver.findElement(By.id("user_username")).sendKeys("in");
        //9.input user email
        driver.findElement(By.id("user_email")).sendKeys("sullivanalice99@gmail.com");
        //10.input user password
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //11click on signup button to open sign up page
        driver.findElement(By.id("submit")).click();
        //wait globally for full loading
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
        //input username on username field
        driver.findElement(By.id("user_username")).sendKeys("in");
        //input user email
        driver.findElement(By.id("user_email")).sendKeys("sullivanalice99@");
        //input user password
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //click on signup button to open sign up page
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
        //input username
        driver.findElement(By.id("user_username")).sendKeys("in");
        //input user email
        driver.findElement(By.id("user_email")).sendKeys("sullivanalice99@gmail.com");
        //input user password
        driver.findElement(By.id("user_password")).sendKeys("a");
        //click on sign up button to open sign up page
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
        //input username
        driver.findElement(By.id("user_username")).sendKeys("");
        //input user email
        driver.findElement(By.id("user_email")).sendKeys("");
        //input user password
        driver.findElement(By.id("user_password")).sendKeys("");
        //click on signup button to open sign up page
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
        //input username
        driver.findElement(By.id("user_username")).sendKeys("Enitan09498");
        //input user email
        driver.findElement(By.id("user_email")).sendKeys("sullivanalice09848@gmail.com");
        //input user password
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //click on sign up button to open sign up page
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }



    @Test (priority = 1)
    //verify that when user clicks on the signup button, the user is directed to the sign up page (test 2)
    public void User1Item() throws InterruptedException {
        //13.click on the user icon on the page
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/ul/div/div/li[1]")).click();
        //t
        String expectedurl = "https://selenium-blog.herokuapp.com/signup";
        String actualurl = driver.getCurrentUrl();
        //pass
        if (actualurl.contains(expectedurl))
            System.out.println("Successfully opened the website");
        //fail
        else
            System.out.println("Failed to open the website");
        Thread.sleep(5000);


    }
        @Test (priority = 2)
        //verify that user1 is present (test7)
        public void VerifyItem() throws InterruptedException {
        //14.search for an element and confirm its present
            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[1]")).click();
            //t
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
        //15.logout
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
        //16. quit
        driver.quit();
    }
}






