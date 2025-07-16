package CompatibilityTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestSignupAndLogin {
	WebDriver driver;
	public static String userName_1 = "user1" + System.currentTimeMillis();
	public static String userName_2 = "user2" + System.currentTimeMillis();
	public static String userName_3 = "user3" + System.currentTimeMillis();

	public static String password_1 = "user123@xyz";
	public static String password_2 = "user234@xyz";
	public static String password_3 = "user345@xyz";


	@Test(priority = 1)
	public void signupAndLoginEdge() throws InterruptedException {
		driver = new EdgeDriver();

		driver.get("http://carrental1.pythonanywhere.com/");
		driver.manage().window().maximize();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Login menu
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[5]"))).click();
		Thread.sleep(1000);
		WebElement signUpLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/a")));
		signUpLink.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(userName_1);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("user@gmail.com");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1"))).sendKeys(password_1);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2"))).sendKeys(password_1);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/form/button")).click();
		Thread.sleep(2000);

		
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(userName_1);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(password_1);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();
	}

  @Test(priority = 2)
	public void signupAndLoginChrome() throws InterruptedException {
		driver = new ChromeDriver();

		driver.get("http://carrental1.pythonanywhere.com/");
		driver.manage().window().maximize();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Login menu
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[5]"))).click();
		Thread.sleep(1000);
		WebElement signUpLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/a")));
		signUpLink.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(userName_2);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("user22@gmail.com");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1"))).sendKeys(password_2);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2"))).sendKeys(password_2);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/form/button")).click();
		Thread.sleep(2000);

		
		
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(userName_2);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(password_2);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();
		Thread.sleep(2000);
	}
  @Test(priority = 3)
  public void signupAndLoginFirefox() throws InterruptedException {
		driver = new FirefoxDriver();

		driver.get("http://carrental1.pythonanywhere.com/");
		driver.manage().window().maximize();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Login menu
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[5]"))).click();
		Thread.sleep(1000);
		WebElement signUpLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/a")));
		signUpLink.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(userName_3);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("user333@gmail.com");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1"))).sendKeys(password_3);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2"))).sendKeys(password_3);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/form/button")).click();
		Thread.sleep(2000);

		
		
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(userName_3);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(password_3);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();
		Thread.sleep(2000);
	}
  
  @Test(priority = 4)
  public void addCarFunctionalityEdge() throws InterruptedException {
		driver = new EdgeDriver();

		driver.get("http://carrental1.pythonanywhere.com/");
		driver.manage().window().maximize();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Login menu
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[5]"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(userName_1);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(password_1);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();
		Thread.sleep(2000);
		
		// Add car menu
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[2]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_owner\"]"))).sendKeys(userName_1);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_car_model\"]"))).sendKeys("Chaverlet");
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_color\"]"))).sendKeys("Orange");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_image\"]"))).sendKeys("C:\\Users\\lenovo\\OneDrive\\Pictures\\Saved Pictures\\pexels-loobo-114867-634281.jpg");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_phone_number\"]"))).sendKeys("+91994848925");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_price\"]"))).sendKeys("20000");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_location\"]"))).sendKeys("Kannur");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/button"))).click();
 
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[3]"))).click();
		Thread.sleep(2000);

		
  }
  
  @Test(priority = 5)
  public void addCarFunctionalityChrome() throws InterruptedException {
	  driver = new ChromeDriver();

		driver.get("http://carrental1.pythonanywhere.com/");
		driver.manage().window().maximize();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Login menu
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[5]"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(userName_2);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(password_2);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();
		Thread.sleep(2000);

		// Add car menu
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[2]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_owner\"]"))).sendKeys(userName_2);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_car_model\"]")))
				.sendKeys("Chaverlet");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_color\"]"))).sendKeys("Orange");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_image\"]")))
				.sendKeys("C:\\Users\\lenovo\\OneDrive\\Pictures\\Saved Pictures\\pexels-loobo-114867-634281.jpg");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_phone_number\"]")))
				.sendKeys("+91994848825");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_price\"]"))).sendKeys("20000");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_location\"]"))).sendKeys("Kannur");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/button"))).click();

		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[3]"))).click();
		Thread.sleep(2000);

	}
  
  @Test(priority = 6)
  public void addCarFunctionalityFirefox() throws InterruptedException {
	  driver = new FirefoxDriver();
	  
	  driver.get("http://carrental1.pythonanywhere.com/");
		driver.manage().window().maximize();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Login menu
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[5]"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(userName_3);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(password_3);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();
		Thread.sleep(2000);

		// Add car menu
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[2]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_owner\"]"))).sendKeys(userName_3);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_car_model\"]")))
				.sendKeys("Chaverlet");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_color\"]"))).sendKeys("Orange");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_image\"]")))
				.sendKeys("C:\\Users\\lenovo\\OneDrive\\Pictures\\Saved Pictures\\pexels-loobo-114867-634281.jpg");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_phone_number\"]")))
				.sendKeys("+91987648925");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_price\"]"))).sendKeys("20000");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_location\"]"))).sendKeys("Kannur");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/button"))).click();

		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[3]"))).click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[4]"))).click();
		Thread.sleep(3000);

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Zoom to 125%
		js.executeScript("document.body.style.zoom='125%'");
		Thread.sleep(3000); 

		// Zoom to 150%
		js.executeScript("document.body.style.zoom='150%'");
		Thread.sleep(5000); 
		
		// Zoom to 75%
		js.executeScript("document.body.style.zoom='75%'");
		Thread.sleep(4000);

		// Zoom to 100%
		js.executeScript("document.body.style.zoom='100%'");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[5]"))).click();
		Thread.sleep(2000);
  }

    @AfterMethod
    public void  afterMethod() throws InterruptedException {
    	Thread.sleep(2000);
    	driver.quit();
    }
    
	
}
