package MainProject.MainProjectAddCar;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class AddCarModule {
	static WebDriver driver;

	public static String userName = "unaispk" + System.currentTimeMillis();
	public static String password = "uxpk123@123";

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://carrental1.pythonanywhere.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement loginMenu = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[5]")));
		loginMenu.click();
		Thread.sleep(1000);
		WebElement signUpLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/a")));
		signUpLink.click();
		Thread.sleep(1000);

//        Sign-Up
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(userName);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("unaispk@gmail.com");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password1"))).sendKeys(password);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password2"))).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/form/button")).click();

//        Log-in

		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(userName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(password);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();
	}

	@BeforeMethod
	public void beforeMethod() {
		String expectedURL = "https://carrental1.pythonanywhere.com/login_app/add/";
		String currentURL = driver.getCurrentUrl();
		if (!currentURL.equals(expectedURL)) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[2]")))
					.click();
		}
	}

	@Test(priority = 1)
	public void testPageLoad() throws InterruptedException {
				
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(1000);

		long startTime = System.currentTimeMillis();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[2]"))).click();
		long endTime = System.currentTimeMillis();
		long loadTime = endTime - startTime;

		System.out.println("Page Load Time: " + loadTime + " milliseconds");
		
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll to bottom
				
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);

		// Scroll to top
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_owner\"]"))).click();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void testAddCarValidData() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Add car

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_owner\"]"))).sendKeys(userName);
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

		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[2]"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_owner\"]"))).sendKeys(userName);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_car_model\"]")))
				.sendKeys("Nissan Altima");
		Thread.sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_color\"]"))).sendKeys("Black");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_image\"]")))
				.sendKeys("C:\\Users\\lenovo\\OneDrive\\Pictures\\Saved Pictures\\PNG_Car.png");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_phone_number\"]")))
				.sendKeys("+91909648925");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_price\"]"))).sendKeys("12000");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_location\"]"))).sendKeys("Kozhikode");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/button"))).click();

		Thread.sleep(2000);

		// log-out
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[4]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[3]"))).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll to bottom
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);

//      Log-in
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[5]"))).click();

		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys(userName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(password);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();
	}

	@Test(priority = 3)
	public void testEmptySubmissionBlocked() throws InterruptedException {

//		TC_ADD_21	Empty Submission Blocked	Verify that the form is not submitted with all fields empty

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_owner\"]"))).sendKeys("");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_car_model\"]"))).sendKeys("");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_color\"]"))).sendKeys("");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_image\"]"))).sendKeys("");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_phone_number\"]"))).sendKeys("");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_price\"]"))).sendKeys("");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_location\"]"))).sendKeys("");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/button"))).click();
	}

	@Test(priority = 4)
	public void testEmptySingleFieldSubmissionBlocked() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    By ownerLocator = By.id("id_owner");
	    By modelLocator = By.id("id_car_model");
	    By colorLocator = By.id("id_color");
	    By imageLocator = By.id("id_image");
	    By phoneLocator = By.id("id_phone_number");
	    By priceLocator = By.id("id_price");
	    By locationLocator = By.id("id_location");
	    By submitBtn = By.xpath("/html/body/div/form/button");

	    List<Map<By, String>> singleFieldData = List.of(
	        Map.of(ownerLocator, "TestOwner"),
	        Map.of(modelLocator, "Toyota"),
	        Map.of(colorLocator, "Black"),
	        Map.of(imageLocator, "C:\\Users\\lenovo\\OneDrive\\Pictures\\Saved Pictures\\PNG_Car.png"),
	        Map.of(phoneLocator, "+91909648925"),
	        Map.of(priceLocator, "12000"),
	        Map.of(locationLocator, "Kochi")
	    );

	    for (Map<By, String> fieldMap : singleFieldData) {
	        // Clear all fields first
	        clearFieldIfEnabled(wait, ownerLocator);
	        clearFieldIfEnabled(wait, modelLocator);
	        clearFieldIfEnabled(wait, colorLocator);
	        clearFieldIfEnabled(wait, imageLocator);
	        clearFieldIfEnabled(wait, phoneLocator);
	        clearFieldIfEnabled(wait, priceLocator);
	        clearFieldIfEnabled(wait, locationLocator);

	        // Fill only one field
	        for (Map.Entry<By, String> entry : fieldMap.entrySet()) {
	            WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(entry.getKey()));
	            if (el.isEnabled()) {
	                el.sendKeys(entry.getValue());
	            }
	        }
	        // Submit the form
	        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
	        submit.click();
	        Thread.sleep(1000);
	    }
	}

	private void clearFieldIfEnabled(WebDriverWait wait, By locator) {
	    try {
	        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	        String type = el.getAttribute("type");

	        if (el.isEnabled() && el.getAttribute("readonly") == null && !"file".equalsIgnoreCase(type)) {
	            el.clear();
	        }
	    } catch (Exception e) {
	        System.out.println("Skipping clear for field: " + locator + ", reason: " + e.getMessage());
	    }
	}

	@Test(priority = 5)
	public void testModelInvalidRejected() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    Map<By, String> carData = Map.of(
	        By.id("id_owner"), userName,
	        By.id("id_car_model"), "jdahgjldsjg;",
	        By.id("id_color"), "Black",
	        By.id("id_image"), "C:\\Users\\lenovo\\OneDrive\\Pictures\\Saved Pictures\\PNG_Car.png",
	        By.id("id_phone_number"), "+91987648925",
	        By.id("id_price"), "20000",
	        By.id("id_location"), "Kannur"
	    );

	    for (Map.Entry<By, String> entry : carData.entrySet()) {
	        clearFieldIfEnabled(wait, entry.getKey());
	        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(entry.getKey()));
	        field.sendKeys(entry.getValue());
	    }

	    By submitButton = By.xpath("/html/body/div/form/button");
	    wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
	}

	
	@Test(priority = 6)
	public void testColorInvalidRejected() {
	    // TC_ADD_24 - Check that invalid characters in the color field are rejected
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    Map<By, String> carData = Map.of(
	        By.id("id_owner"), userName,
	        By.id("id_car_model"), "Nissan Altima",
	        By.id("id_color"), "ajfkjlkaj",
	        By.id("id_image"), "C:\\Users\\lenovo\\OneDrive\\Pictures\\Saved Pictures\\PNG_Car.png",
	        By.id("id_phone_number"), "+91987648925",
	        By.id("id_price"), "20000",
	        By.id("id_location"), "Kannur"
	    );

	    for (Map.Entry<By, String> entry : carData.entrySet()) {
	        clearFieldIfEnabled(wait, entry.getKey());
	        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(entry.getKey()));
	        field.sendKeys(entry.getValue());
	    }

	    By submitButton = By.xpath("/html/body/div/form/button");
	    wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
	}
	
	@Test(priority = 7)
	public void testNonImageRejected() {
	    // TC_ADD_25 - Verify that a non-image file (e.g., .pdf) is rejected
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    Map<By, String> carData = Map.of(
	        By.id("id_owner"), userName,
	        By.id("id_car_model"), "Nissan Altima",
	        By.id("id_color"), "Black",
	        By.id("id_image"), "",
	        By.id("id_phone_number"), "+91987648925",
	        By.id("id_price"), "20000",
	        By.id("id_location"), "Kannur"
	    );

	    for (Map.Entry<By, String> entry : carData.entrySet()) {
	        clearFieldIfEnabled(wait, entry.getKey());
	        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(entry.getKey()));
	        field.sendKeys(entry.getValue());
	    }

	    By submitButton = By.xpath("/html/body/div/form/button");
	    wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
	}

	@Test(priority = 8)
	public void testShortPhoneNumberRejected() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		  Map<By, String> carData = Map.of(
			        By.id("id_owner"), userName,
			        By.id("id_car_model"), "Nissan Altima",
			        By.id("id_color"), "Black",
			        By.id("id_image"), "C:\\Users\\lenovo\\OneDrive\\Pictures\\Saved Pictures\\PNG_Car.png",
			        By.id("id_phone_number"), "+9115",
			        By.id("id_price"), "20000",
			        By.id("id_location"), "Kannur"
			    );

		for (Map.Entry<By, String> entry : carData.entrySet()) {
			clearFieldIfEnabled(wait, entry.getKey());
			WebElement field = wait.until(ExpectedConditions.elementToBeClickable(entry.getKey()));
			field.sendKeys(entry.getValue());
		}

		By submitButton = By.xpath("/html/body/div/form/button");
		wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();

	}
	
	@Test(priority = 9)
	public void testLongPhoneNumberRejected() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		  Map<By, String> carData = Map.of(
			        By.id("id_owner"), userName,
			        By.id("id_car_model"), "Nissan Altima",
			        By.id("id_color"), "Black",
			        By.id("id_image"), "C:\\Users\\lenovo\\OneDrive\\Pictures\\Saved Pictures\\PNG_Car.png",
			        By.id("id_phone_number"), "+917887754587795859815",
			        By.id("id_price"), "20000",
			        By.id("id_location"), "Kannur"
			    );

		for (Map.Entry<By, String> entry : carData.entrySet()) {
			clearFieldIfEnabled(wait, entry.getKey());
			WebElement field = wait.until(ExpectedConditions.elementToBeClickable(entry.getKey()));
			field.sendKeys(entry.getValue());
		}

		By submitButton = By.xpath("/html/body/div/form/button");
		wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
	}	

	@Test(priority = 10)
	public void testNegativePriceRejected() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		  Map<By, String> carData = Map.of(
			        By.id("id_owner"), userName,
			        By.id("id_car_model"), "Nissan Altima",
			        By.id("id_color"), "Black",
			        By.id("id_image"), "C:\\Users\\lenovo\\OneDrive\\Pictures\\Saved Pictures\\PNG_Car.png",
			        By.id("id_phone_number"), "+917887754587",
			        By.id("id_price"), "-1200",
			        By.id("id_location"), "Kannur"
			    );

		for (Map.Entry<By, String> entry : carData.entrySet()) {
			clearFieldIfEnabled(wait, entry.getKey());
			WebElement field = wait.until(ExpectedConditions.elementToBeClickable(entry.getKey()));
			field.sendKeys(entry.getValue());
		}

		By submitButton = By.xpath("/html/body/div/form/button");
		wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
	}	
	
	@Test(priority = 11)
	public void testZeroPriceRejected() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		  Map<By, String> carData = Map.of(
			        By.id("id_owner"), userName,
			        By.id("id_car_model"), "Nissan Altima",
			        By.id("id_color"), "Black",
			        By.id("id_image"), "C:\\Users\\lenovo\\OneDrive\\Pictures\\Saved Pictures\\PNG_Car.png",
			        By.id("id_phone_number"), "+917887754587",
			        By.id("id_price"), "0",
			        By.id("id_location"), "Kannur"
			    );

		for (Map.Entry<By, String> entry : carData.entrySet()) {
			clearFieldIfEnabled(wait, entry.getKey());
			WebElement field = wait.until(ExpectedConditions.elementToBeClickable(entry.getKey()));
			field.sendKeys(entry.getValue());
	        Thread.sleep(1000); 
		}

		By submitButton = By.xpath("/html/body/div/form/button");
		wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
	}	
	
	@Test(priority = 12)
	public void testSpacesOnlyFieldRejected() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		  Map<By, String> carData = Map.of(
			        By.id("id_owner"), "  ",
			        By.id("id_car_model"), "  ",
			        By.id("id_color"), "  ",
			        By.id("id_image"), "C:\\Users\\lenovo\\OneDrive\\Pictures\\Saved Pictures\\PNG_Car.png",
			        By.id("id_phone_number"), "  ",
			        By.id("id_price"), "  ",
			        By.id("id_location"), "  "
			    );

		for (Map.Entry<By, String> entry : carData.entrySet()) {
			clearFieldIfEnabled(wait, entry.getKey());
			WebElement field = wait.until(ExpectedConditions.elementToBeClickable(entry.getKey()));
			field.sendKeys(entry.getValue());
	        Thread.sleep(1000); 
		}

		By submitButton = By.xpath("/html/body/div/form/button");
		wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
	}	
	
	@Test(priority = 13)
	public void testBacktoHomeNavigation() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(2000); 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/a"))).click();
        Thread.sleep(2000); 
	}
	
	@Test(priority = 14)
	public void testTabKeyAccess() throws InterruptedException {

		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

		WebElement body = driver.findElement(By.tagName("body"));

		Actions action = new Actions(driver);
		action.moveToElement(body).click().perform();

		for (int i = 1; i < 10; i++) {
			action.sendKeys(Keys.TAB).perform();
			Thread.sleep(1000);
		}
	}


	@Test(priority = 15)
	public void testEnterKeySubmission() throws InterruptedException {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    Map<By, String> carData = Map.of(
	        By.id("id_owner"), userName,
	        By.id("id_car_model"), "Mercedes-AMG GT",
	        By.id("id_color"), "Matte Gray",
	        By.id("id_image"), "C:\\Users\\lenovo\\OneDrive\\Pictures\\Saved Pictures\\pexels-mikebirdy-112452.jpg",
	        By.id("id_phone_number"), "+917807754587",
	        By.id("id_price"), "3000", 
	        By.id("id_location"), "Calicut"
	    );

	    WebElement priceField = null;

	    for (Map.Entry<By, String> entry : carData.entrySet()) {
	        clearFieldIfEnabled(wait, entry.getKey());
	        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(entry.getKey()));
	        field.sendKeys(entry.getValue());
	        Thread.sleep(1000);

	        if (entry.getKey().equals(By.id("id_price"))) {
	            priceField = field;
	        }
	    }

	    if (priceField != null) {
	        priceField.sendKeys(Keys.ENTER); 
	        Thread.sleep(1000);
	    }
	}
	
	 @AfterClass
		public void afterClass() {
	      if (driver != null) {
	          driver.quit();
	      }
		}
}
