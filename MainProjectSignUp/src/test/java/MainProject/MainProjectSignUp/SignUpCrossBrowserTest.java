package MainProject.MainProjectSignUp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SignUpCrossBrowserTest {
	WebDriver driver;
  @Test
  public void pageLoading()  {
	  
//	  TC_SU_39	Compatibility	Cross-browser/device compatibility
	  
		driver.get("https://carrental1.pythonanywhere.com/login_app/login");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement signUpLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/a")));
		signUpLink.click();
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


