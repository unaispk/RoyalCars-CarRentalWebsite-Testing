package CompatibilityTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	WebDriver driver;
	
  @Test
  public void pageLoading() {
	  
	  driver.get("http://carrental1.pythonanywhere.com/");
	  driver.manage().window().maximize();  
	  try {
		    Thread.sleep(3000); 
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
  }
  
  @Parameters("browser1")
  @BeforeTest
	public void beforetest(String b) {

		if (b.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (b.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (b.equals("edge")) {
			driver = new EdgeDriver();
		}
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }
}


