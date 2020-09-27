package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FirstTest {
	
	WebDriver driver;
	//frameowrk called datadriven Testing in TestNG
  @Test(dataProvider = "dp")
  public void testcase1(String n, String s) throws InterruptedException {
	  driver.findElement(By.id("txtUsername")).sendKeys(n);
	  driver.findElement(By.id("txtPassword")).sendKeys(s);
	  driver.findElement(By.id("btnLogin")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.id("welcome")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
      new Object[] { "linda.anderson", "linda.anderson" },
    };
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\702080.CTS\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
//		//To open an URL i was using driver.get
//		//i can also use driver.navigate.to to open the URL
		driver = new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.close();
  }


}
