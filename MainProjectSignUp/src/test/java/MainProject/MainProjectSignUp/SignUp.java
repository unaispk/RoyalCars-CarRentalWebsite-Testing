package MainProject.MainProjectSignUp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUp {
    static WebDriver driver;
    
    @BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://carrental1.pythonanywhere.com/");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[5]")));
        loginMenu.click();
        Thread.sleep(1000);
	}
    @BeforeMethod
    public void beforeMethod() {
    	String expectedURL = "https://carrental1.pythonanywhere.com/login_app/signup/";
    	String currentURL = driver.getCurrentUrl();
    	if(!currentURL.equals(expectedURL)) {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    WebElement signUpLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/a")));
    	    signUpLink.click();
    	}
    }
  @Test(priority = 1)
  public void testPageLoadAndUI() throws InterruptedException {
	  
//	  TC_SU_01	Page loading	Verify page loads successfully        
//	  TC_SU_02	page loading	Check page load time    
//	  TC_SU_03	Heading	    	Verify the "Signup" heading is displayed at the top of the page.  
//	  TC_SU_04	Form_divLayout	Verify the login div appears correctly and is centered on the screen
//	  TC_SU_05	Navigation bar  Check navigation bar is visible on the top of the login page
//	  TC_SU_06	browser tab  	Verify page title in browser tab       
//	  TC_SU_07	Input field 	Check the  user-name text field is present and visible
//	  TC_SU_08	Input field 	Check the email text field is present and visible
//	  TC_SU_09	Input field 	Check the password text field is present and visible
//	  TC_SU_10	Input field 	Check the confirm password text field is present and visible
//	  TC_SU_11	Incognito 		Verify page in incognito mode	
//	  TC_SU_12	Label name		Check that all input fields have matching labels
//	  TC_SU_13	Placeholder 	Verify that all required text fields have a valid placeholder text
//	  TC_SU_14	sign-up button	Check the sign-up button presence and visibility
	
	driver.navigate().back();
	
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement signUpLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/a")));
   
    long startTime = System.currentTimeMillis();

    signUpLink.click();

	long endTime = System.currentTimeMillis();

	long loadTime = endTime - startTime;

	System.out.println("Page Load Time: " + loadTime + " milliseconds");
	Thread.sleep(2000);
	
//	TC_SU_15	sign-up button	Check on hovering over the sign up button changes button color
//	TC_SU_16	sign-up button	Check on hovering over the sign up button changes cursor style
//	TC_SU_17	Required fields	Verify that all required fields have a red mark
	
	Actions actions = new Actions(driver);
	WebElement signUpBtn = driver.findElement(By.xpath("/html/body/div/form/button"));
	actions.moveToElement(signUpBtn).perform();
	Thread.sleep(3000);
  }
  
  @Test(priority = 2)
  public void testInputfields() throws InterruptedException {
	  
//	  TC_SU_18	Input Field	 Acceptance	Verify that all input fields are accepting values
//	  TC_SU_19	Remember_Me	 Check "Remember Me" functionality (if present)
//	  TC_SU_20	Username 	 Validation	Username field rejects special characters/spaces
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  Thread.sleep(1000);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("$ @##");
      Thread.sleep(1000);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("sam@gmail.com");
      Thread.sleep(1000);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1"))).sendKeys("sam123456");
      Thread.sleep(1000);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2"))).sendKeys("sam123456");
      Thread.sleep(1000);
      driver.findElement(By.xpath("/html/body/div/form/button")).click();
      
//    TC_SU_21	Email Validation	Email field accepts only valid formats
//    TC_SU_22	Password Masking	Password fields mask input
      
      WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
      usernameField.clear();
      usernameField.sendKeys("alex321");
      Thread.sleep(1000);
      WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
      emailField.clear();
      emailField.sendKeys("alex.com");
      Thread.sleep(1000); 
      WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1")));
      passwordField.clear();
      passwordField.sendKeys("alex1@alex");
      Thread.sleep(1000);
      WebElement confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2")));
      confirmPasswordField.clear();
      confirmPasswordField.sendKeys("alex1@alex");
      
      Thread.sleep(1000);
      driver.findElement(By.xpath("/html/body/div/form/button")).click();
      
      
//    TC_SU_23	Password Complexity 	Password fields enforce minimum length/complexity
      
      usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
      usernameField.clear();
      usernameField.sendKeys("arun12");
      Thread.sleep(1000);
      emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
      emailField.clear();
      emailField.sendKeys("arun12@gmail.com");
      Thread.sleep(1000); 
      passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1")));
      passwordField.clear();
      passwordField.sendKeys("12");
      Thread.sleep(1000);
      confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2")));
      confirmPasswordField.clear();
      confirmPasswordField.sendKeys("12");
      
      Thread.sleep(1000);
      driver.findElement(By.xpath("/html/body/div/form/button")).click();
      
//    TC_SU_24	Password Confirmation 	Verify password confirmation matches
      
      usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
      usernameField.clear();
      usernameField.sendKeys("jacobsebastian");
      Thread.sleep(1000);
      emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
      emailField.clear();
      emailField.sendKeys("seba@gmail.com");
      Thread.sleep(1000);
      passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1")));
      passwordField.clear();
      passwordField.sendKeys("sebjacob4321");
      Thread.sleep(1000);
      confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2")));
      confirmPasswordField.clear();
      confirmPasswordField.sendKeys("sebjacob43");
      Thread.sleep(1000);
      driver.findElement(By.xpath("/html/body/div/form/button")).click();
      
      
//    TC_SU_25	Sign Up Button State	Sign Up button disabled until mandatory fields valid
   
      
      usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
      usernameField.clear();
      usernameField.sendKeys("ann");
      Thread.sleep(1000);
      emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
      emailField.clear();
      emailField.sendKeys("ann@gmail.com");
      Thread.sleep(1000);
      passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1")));
      passwordField.clear();
      passwordField.sendKeys("987654321");
      Thread.sleep(1000);
      confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2")));
      confirmPasswordField.clear();
      confirmPasswordField.sendKeys("123456789");
      Thread.sleep(1000);
      driver.findElement(By.xpath("/html/body/div/form/button")).click();
             
      passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1")));
      passwordField.clear();
      passwordField.sendKeys("987654321");
      Thread.sleep(1000);
      confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2")));
      confirmPasswordField.clear();
      confirmPasswordField.sendKeys("987654321");
      Thread.sleep(1000);
      driver.findElement(By.xpath("/html/body/div/form/button")).click();
      
      passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1")));
      passwordField.clear();
      passwordField.sendKeys("xyz987654321");
      Thread.sleep(1000);
      confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2")));
      confirmPasswordField.clear();
      confirmPasswordField.sendKeys("xyz987654321");
      Thread.sleep(1000);
      driver.findElement(By.xpath("/html/body/div/form/button")).click();
  }
  
  @Test(priority = 3)
  public void testInputfieldsValueIsTrimming() throws InterruptedException {
	  
//	  TC_SU_26	Inline Error Message	Inline error messages for invalid/missing inputs
//	  TC_SU_27	Input Trimming	Username and Email trim leading/trailing spaces
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  WebElement usernameField  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
      usernameField.clear();
      usernameField.sendKeys("");
      Thread.sleep(1000);
      WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
      emailField.clear();
      emailField.sendKeys("");
      Thread.sleep(1000);
      WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1")));
      passwordField.clear();
      passwordField.sendKeys("");
      Thread.sleep(1000);
      WebElement confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2")));
      confirmPasswordField.clear();
      confirmPasswordField.sendKeys("");
      Thread.sleep(1000);
      driver.findElement(By.xpath("/html/body/div/form/button")).click();
      
      
      Thread.sleep(1000);
	  usernameField  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
      usernameField.clear();
      usernameField.sendKeys(" uxyzzzzzz ");
      Thread.sleep(1000);
      emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
      emailField.clear();
      emailField.sendKeys("uxyzzz@gmail.com");
      Thread.sleep(1000);
      passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1")));
      passwordField.clear();
      passwordField.sendKeys("ksjk6576");
      Thread.sleep(1000);
      confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2")));
      confirmPasswordField.clear();
      confirmPasswordField.sendKeys("ksjk6576");
      Thread.sleep(1000);
      driver.findElement(By.xpath("/html/body/div/form/button")).click();
  }

	@Test(priority = 4)
	public void testKeyboardNavigation() throws InterruptedException {
//    TC_SU_28	Keyboard Navigation (Tab)	Verify tab key functionality on the sign-up page
//    TC_SU_29	Keyboard Navigation (Enter)	Verify enter key functionality for the sign-up button
//    TC_SU_30	Form Data Retention	Valid data remains after failed submission (except passwords)
//    TC_SU_31	Successful Submission	Submit form with all valid inputs

		Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

        WebElement body = driver.findElement(By.tagName("body"));

        Actions action = new Actions(driver);
        action.moveToElement(body).click().perform();

		for (int i = 0; i < 5; i++) {
			action.sendKeys(Keys.TAB).perform();
			Thread.sleep(800);
		}
        
	  WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
      usernameField.clear();
      usernameField.sendKeys("albin12codex");
      Thread.sleep(1000);
      WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
      emailField.clear();
      emailField.sendKeys("albin12codex@gmail.com");
      Thread.sleep(1000); 
      WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1")));
      passwordField.clear();
      passwordField.sendKeys("userrr123cvbvcn");
      Thread.sleep(1000);
      WebElement confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2")));
      confirmPasswordField.clear();
      confirmPasswordField.sendKeys("userrr123cvbvcn");
      Thread.sleep(1000);
      driver.findElement(By.xpath("/html/body/div/form/button")).click();  
      Thread.sleep(1000);
      passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1")));
      passwordField.clear();
      passwordField.sendKeys("android1213");
      Thread.sleep(1000);
      confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2")));
      confirmPasswordField.clear();
      confirmPasswordField.sendKeys("android1213");
      Thread.sleep(1000);
      confirmPasswordField.sendKeys(Keys.ENTER);		
	}

	@Test(priority = 5)
	public void testDuplicateUsername_DuplicateEmail() throws InterruptedException {
    
//    TC_SU_36	Post-Signup Navigation	Check navigation to homepage/login after signup
//    TC_SU_37	Login with New Credentials	Login with new credentials
//    TC_SU_38	Remember Me 	"Remember Me" functionality (if present)
//    TC_SU_40	Password Transmission Security	Password encrypted during transmission

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		usernameField.sendKeys("dezooza10");
		Thread.sleep(1000);
		WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
		emailField.sendKeys("dezooza10@gmail.com");
		Thread.sleep(1000);
		WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1")));
		passwordField.sendKeys("amazeamazon321");
		Thread.sleep(1000);
		WebElement confirmPasswordField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2")));
		confirmPasswordField.sendKeys("amazeamazon321");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/form/button")).click();

		
		String expectedURL = "https://carrental1.pythonanywhere.com/login_app/login/";
		String currentURL = driver.getCurrentUrl();
		if (currentURL.equals(expectedURL)) {
			WebElement signUpLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/a")));
			signUpLink.click();
		}
		
		Thread.sleep(1000);
		usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		usernameField.clear();
		usernameField.sendKeys("dezooza10");
		Thread.sleep(1000);
		emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
		emailField.clear();
		emailField.sendKeys("dezooza10@gmail.com");
		Thread.sleep(1000);
		passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1")));
		passwordField.clear();
		passwordField.sendKeys("amazeamazon321");
		Thread.sleep(1000);
		confirmPasswordField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2")));
		confirmPasswordField.clear();
		confirmPasswordField.sendKeys("amazeamazon321");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/form/button")).click();
	}
	
	@Test(priority = 6)
	public void testSQLInjection () throws InterruptedException {
		
//		TC_SU_41	SQL Injection 	SQL injection in User-name / Email
//		TC_SU_42	Error Message	Error messages do not reveal sensitive info
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		usernameField.sendKeys("sarah_jones' --");
		Thread.sleep(1000);
		WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
		emailField.sendKeys("sarah.jones@example.com' --");
		Thread.sleep(1000);
		WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1")));
		passwordField.sendKeys("SummerBreeze1");
		Thread.sleep(1000);
		WebElement confirmPasswordField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2")));
		confirmPasswordField.sendKeys("SummerBreeze1");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/form/button")).click();
	}
	
	@Test(priority = 7)
	public void testAccountLockout() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		usernameField.sendKeys("sarah_jones' --");
		Thread.sleep(1000);
		WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
		emailField.sendKeys("sarah.jones@example.com' --");
		Thread.sleep(1000);
		WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1")));
		passwordField.sendKeys("SummerBreeze1");
		Thread.sleep(1000);
		WebElement confirmPasswordField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2")));
		confirmPasswordField.sendKeys("SummerBreeze1");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/form/button")).click();
		
		for (int i = 0; i < 10; i++ ) {
			
			
			usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
			usernameField.clear();
			usernameField.sendKeys("sarah_jones' --");
			Thread.sleep(1000);
			emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
			emailField.clear();
			emailField.sendKeys("sarah.jones@example.com' --");
			Thread.sleep(1000);
			passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1")));
			passwordField.clear();
			passwordField.sendKeys("SummerBreeze1");
			Thread.sleep(1000);
			confirmPasswordField = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2")));
			confirmPasswordField.clear();
			confirmPasswordField.sendKeys("SummerBreeze1");
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/div/form/button")).click();
			
		}
		
	}
	@Test(priority = 8)
	public void testSessionManagement() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		usernameField.clear();
		usernameField.sendKeys("userunais1242");
		Thread.sleep(1000);
		WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
		emailField.clear();
		emailField.sendKeys("userunais1242@gmail.com");
		Thread.sleep(1000);
		WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1")));
		passwordField.clear();
		passwordField.sendKeys("devntest2022");
		Thread.sleep(1000);
		WebElement confirmPasswordField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2")));
		confirmPasswordField.clear();
		confirmPasswordField.sendKeys("devntest2022");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/form/button")).click();
		
		Thread.sleep(1000);

		String expectedURL = "https://carrental1.pythonanywhere.com/login_app/login/";
		String currentURL = driver.getCurrentUrl();
		if (currentURL.equals(expectedURL)) {
			Thread.sleep(800);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"exampleInputEmail1\"]"))).sendKeys("userunais1242");
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"exampleInputPassword1\\\"]"))).sendKeys("devntest2022");
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();
		}		
		
		Thread.sleep(800);
		String expectedPageURL = "http://carrental1.pythonanywhere.com/login_app/view/";
		String currentPageURL = driver.getCurrentUrl();
		if (currentPageURL.equals(expectedPageURL)) {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[4]"))).click();
		}		
			
	}
	
  @AfterClass
	public void afterClass() {
    if (driver != null) {
        driver.quit();
    }
	}
}
