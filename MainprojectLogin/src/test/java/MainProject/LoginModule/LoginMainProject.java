package MainProject.LoginModule;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginMainProject {
    static WebDriver driver;
    
    public static String userName = "unaispk"+ System.currentTimeMillis();
    public static String password = "uxpk123@123";

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://carrental1.pythonanywhere.com/");
        
//        TC_LOG_01	Verify the "Login" heading is displayed at the top of the page
//        TC_LOG_02	Modal Layout	Verify the login div appears correctly and is centered on the screen
//        TC_LOG_03	Navigation bar 	Check navigation bar is visible on the top of the login page
//        TC_LOG_04	Labels	Check that the username and password labels are present.
//        TC_LOG_05	Labels	All labels are aligned properly.
//        TC_LOG_06	Input Fields	Check that the username and password input fields are present.
//        TC_LOG_07	Input Fields	All  input fields are aligned properly.
//        TC_LOG_08	Input Fields	Check that the username and password input fields have appropriate placeholder text.
//        TC_LOG_09	Login Button	Check that the Login button is present.
//        TC_LOG_11	Signup Link	Check that the Signup link is present.
//        TC_LOG_13	Signup Link	Check that clicking on the signup link redirect to the signup page.
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[5]")));
        loginMenu.click();
        Thread.sleep(1000);
        WebElement signUpLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/a")));
        signUpLink.click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(userName);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("unaispk@gmail.com");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1"))).sendKeys(password);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2"))).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/form/button")).click();
	}

	@BeforeMethod
	public void beforeMethod() {
		List<WebElement> menuItems = driver.findElements(By.xpath("//*[@id='navbarCollapse']/div/a"));
		int menuItemsNumber = menuItems.size();
		if (menuItemsNumber == 5) {
			menuItems.get(4).click();
		}
	}

	@Test(priority = 1)
	public void loginPageUI() throws InterruptedException {

	//  TC_LOG_10	Login Button	Check that on hovering over the login button changes the button color.
		
		Actions action = new Actions(driver);
		WebElement loginSubmitButton = driver.findElement(By.xpath("/html/body/div/form/a/button"));
		action.moveToElement(loginSubmitButton).perform();
		Thread.sleep(2000);
		
	//  TC_LOG_12	Signup Link	Check that on hovering over the Signup Link changes the cursor style.
		
		WebElement signUpLink = driver.findElement(By.xpath("/html/body/div/a"));
		action.moveToElement(signUpLink).perform();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void testFieldAcceptingInputs() throws InterruptedException {
		
//		TC_LOG_14	Check that the username and password input fields are accept input.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(userName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(password);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();
	}
	@Test(priority  = 3)
	public void testSpaceOnlyAsInput() throws InterruptedException {
		
//		TC_LOG_15	Check username accepts space only as input
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(Keys.SPACE);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(Keys.SPACE);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();
	}
	
	@Test(priority  = 4)
	public void testUppercaseCaseSensitivityPassword() throws InterruptedException {
//		TC_LOG_16	Verify login with uppercase password when the registered password is lowercase
//		TC_LOG_17	Check Show/hide password toggle works (if present)
//		TC_LOG_21	Ensure password field is always masked (dots/asterisks)
//		TC_LOG_22   Ensure password is not visible in browser autofill or on copy-paste.  
//		TC_LOG_23	Check if the "Forgot Password" link is present and clickable
//		TC_LOG_24	Make sure error messages are clear and disappear after correcting the input
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(userName); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys("UXPK123@123");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();
	}

	@Test(priority  = 5)
	public void testTabKeyNavigation() throws InterruptedException {
		// TC_LOG_18	Check Tab key navigation works between fields and buttons
		
		WebElement username  = driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]"));
		username.click();
		username.sendKeys(Keys.TAB);
		Thread.sleep(2000);
        WebElement activeElement = driver.switchTo().activeElement();
        activeElement.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        activeElement.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        activeElement.sendKeys(Keys.TAB);
        Thread.sleep(2000);
//      TC_LOG_20	Check if "Remember Me" for password and username works and does not store password in plain text.  
	}
	
	@Test(priority  = 6)
	public void testValidUsernameValidPassword() throws InterruptedException {
//		TC_LOG_25	Verify login with a valid username and valid password	
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(userName); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(password);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();
	}
	
	@Test(priority  = 7)
	public void testRefreshClearInputData() throws InterruptedException {

//      TC_LOG_19	Ensure refreshing the page is not clear the input field data
		
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(userName); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(password);
		Thread.sleep(1000);
		driver.navigate().refresh();
	}

	@Test(priority  = 8)
	public void testRedirectionAfterLoginSuccess() throws InterruptedException {
//		TC_LOG_26	Verify that after a successful login, the user is redirected to the homepage
//		TC_LOG_27	Verify that a welcome message pop up is displayed after successful login
//		TC_LOG_28	Verify that the "Log in" button disappears from navigation bar after a successful login
//		TC_LOG_29	Verify that "Log out" is available after successful login
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(userName); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(password);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();
	}
	
	@Test(priority  = 9)
	public void testAccountPersistanceAfterMovingToOtherPage() throws InterruptedException {
		
//		TC_LOG_30	Verify that the session remains active after logging in and navigating to another page
//		TC_LOG_31	Verify that refreshing the page after login does not log out the user
//		TC_LOG_32	Check  Pressing Enter key submits the form
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(userName); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(Keys.ENTER);		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[2]"))).click();
		Thread.sleep(2500);
		driver.navigate().back();
		Thread.sleep(2500);
		driver.navigate().refresh();
		Thread.sleep(2500);
	}
	
	@Test(priority  = 10)
	public void testEmptyUsername() throws InterruptedException {
//		TC_LOG_35	Verify login attempt with an empty user-name field and valid password
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(""); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(password);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();		
	}
	
	@Test(priority  = 11)
	public void testEmptyPassWord() throws InterruptedException {
//		TC_LOG_36	Verify login attempt with an empty password field and valid username

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(userName); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys("");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();		
	}
	
	@Test(priority  = 12)
	public void testEmptyInputFields() throws InterruptedException {
//		TC_LOG_37	Verify login attempt with both username and password fields empty
//		TC_LOG_38	Verify the pop-up message "Please fill out Username and Password." when trying to log in with empty fields
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(""); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys("");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();		
		Thread.sleep(3000);
	}
	
	@Test(priority  = 13)
	public void testWrongPassword() throws InterruptedException {
//		TC_LOG_39	Verify login with an incorrect username and valid password		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(userName); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys("kagfj;alglja");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();		
		Thread.sleep(3000);
	}
	
	@Test(priority  = 14)
	public void testWrongUsername() throws InterruptedException {
//		TC_LOG_40	Verify login with an incorrect password and valid username
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys("jhdslkf"); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(password);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();		
		Thread.sleep(3000);
	}
	
	@Test(priority  = 15)
	public void testWrongUsernameAndWrongPassword() throws InterruptedException {
//		TC_LOG_41	Verify login with both incorrect username and incorrect password
//		TC_LOG_42	Verify that clicking "OK" on the pop-up allows the user to re-enter credentials
//		TC_LOG_43	Verify that multiple failed login attempts display the correct error message
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys("jhdslkf"); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys("kjhdsjhflk8763287462");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();		
		Thread.sleep(3000);
	}
	
	
	@Test(priority  = 16)
	public void testUsernameOnlyNumbers() throws InterruptedException {
//		TC_LOG_44	Verify login attempt with a username containing only numbers
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys("8897543295"); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(password);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();		
	}
	
	@Test(priority  = 17)
	public void testUsernameOnlySpecialCharecters() throws InterruptedException {
//		TC_LOG_45	Verify login attempt with a username containing only special characters
//		TC_LOG_46	Verify account lockout after multiple failed attempts
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys("!$%^&*$()(&??"); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(password);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();		
	}
	
	@Test(priority  = 18)
	public void testLogout() throws InterruptedException {
//		TC_LOG_47	Logout Redirection	Verify user is redirected to the homepage after logout
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(userName); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(password);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();		
	}
	
	
	@Test(priority = 19)
	public void testLogoutPersistence() throws InterruptedException {
	    // TC_LOG_48: Logout Persistence - Verify user remains logged out after closing and reopening the browser

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(userName);
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(password);
	    Thread.sleep(1000);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();
	    Thread.sleep(3000);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[4]"))).click();
	    
	    driver.quit();
	    
	    driver = new EdgeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://carrental1.pythonanywhere.com/");
	    
	}

	@Test(priority = 20)
	public void testLogoutandBack() throws InterruptedException {
	    // TC_LOG_49: Logout and Back Button - Ensure session is not restored via browser back button

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(userName);
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(password);
	    Thread.sleep(1000);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();
	    Thread.sleep(3000);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[4]"))).click();

	    driver.navigate().back();
	    Thread.sleep(3000);

	}
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> menuItems = driver.findElements(By.xpath("//*[@id='navbarCollapse']/div/a"));
		int menuItemsNumber = menuItems.size();
		if (menuItemsNumber == 4) {
            menuItems.get(3).click(); 
        }
	}

	@AfterClass
	public void afterClass() {
      if (driver != null) {
          driver.quit();
      }
	}
}
