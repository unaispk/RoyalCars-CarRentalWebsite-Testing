package MainProject.MainProjectMyCars;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyCarsModule {
	static WebDriver driver;

	public static String userName = "unaispk46" + System.currentTimeMillis();
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

	@Test(priority = 1)
	public void pageLoading() throws InterruptedException {

//	  TC_MYCAR_01	Page loading		Verify page loads successfully        
//	  TC_MYCAR_02	Page loading		Verify the page is loaded in an acceptable time
//	  TC_MYCAR_03	Page title	T		he page title "My Cars" is displayed correctly.
//	  TC_MYCAR_04	Navigation bar 		Check navigation bar is visible on the top of the my cars page
//	  TC_MYCAR_05	No item message	Verify there is a information message if  no car is added

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Thread.sleep(1000);

		long startTime = System.currentTimeMillis();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[3]"))).click();
		long endTime = System.currentTimeMillis();
		long loadTime = endTime - startTime;
		System.out.println("Page Load Time: " + loadTime + " milliseconds");

		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void testAddCar() throws InterruptedException {

//		TC_MYCAR_07	Car Listing		Verify added car is displayed in the my cars page
//		TC_MYCAR_08	Car Listing		Verify multiple cars can added to list
//		TC_MYCAR_09	Refresh	Verify	contents are stable after page refresh
//		TC_MYCAR_10	Spacing 		Verify alignment and spacing of elements and input fields
//		TC_MYCAR_11	Logo			Verify the "ROYAL CARS"  logo  is visible and styled correctly.
//		TC_MYCAR_12	Hamburger menu	The hamburger menu appears and functions on mobile devices.
//		TC_MYCAR_13	multiple cars	Each car added by the user is displayed as a separate card.
//		TC_MYCAR_14	image visibility	Car image is visible and loads correctly for each car.
//		TC_MYCAR_15	Image quality	Car image is not pixelated or distorted.
//		TC_MYCAR_16	Car model name display	Car model name (e.g., Chevrolet El Camino) is displayed correctly.
//		TC_MYCAR_17	Car color display	Car color is displayed and matches the data stored.
//		TC_MYCAR_18	Price display	Price per day is displayed in correct currency and format.

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

		Thread.sleep(3000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[2]"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_owner\"]"))).sendKeys(userName);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_car_model\"]")))
				.sendKeys("Mercedes-AMG GT");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_color\"]"))).sendKeys("Black");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_image\"]")))
				.sendKeys("C:\\Users\\lenovo\\OneDrive\\Pictures\\Saved Pictures\\pexels-mikebirdy-112452.jpg");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_phone_number\"]")))
				.sendKeys("+917807754587");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_price\"]"))).sendKeys("2000");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_location\"]"))).sendKeys("Calicut");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/button"))).click();

		Thread.sleep(4000);

//		refresh
		driver.navigate().refresh();

	}

	@Test(priority = 3)
	public void testHoverOnButtons() throws InterruptedException {

//		TC_MYCAR_24	Edit button visibility	Edit button is visible for each car card.
//		TC_MYCAR_25	Edit Button Hover	Verify that hovering on edit button changes button color
		
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		Actions action = new Actions(driver);
		WebElement editBtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/a")); 
		action.moveToElement(editBtn).perform();
		Thread.sleep(2000);
		
//		TC_MYCAR_19	Delete button visibility	Delete button is visible for each car card
//		TC_MYCAR_20	Delete Button Hover	Verify that hovering on delete button changes button color
		
		WebElement deleteBtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/form/a/button"));
		action.moveToElement(deleteBtn).perform();
		
		Thread.sleep(4000);
		
//		TC_MYCAR_21	Cancel delete action	Canceling the delete confirmation does not remove the car
//		TC_MYCAR_22	Delete confirmation dialog	Delete button prompts a confirmation dialog before deletion
//		TC_MYCAR_23	Confirm delete action	Confirming the delete action removes the car from the list
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[1]/div/div/form/a/button"))).click();
	}
	
	
	@Test(priority = 4)
	public void testEditCarDetails() throws InterruptedException {
		
//		TC_MYCAR_26	Edit navigation	Edit button navigates to the car edit page when clicked.
//		TC_MYCAR_27	Edited data Verify that the edited data is updated in my cars page
//		TC_MYCAR_28	Access control without login	Attempting to access the page without login redirects to the login page.
//		TC_MYCAR_29	Responsive layout	Page layout is responsive on mobile, tablet, and desktop.
//		TC_MYCAR_30	No horizontal scroll	No horizontal scrolling is required on any device.
//		TC_MYCAR_31	UI alignment and spacing	All UI elements are aligned and spaced consistently.
//		TC_MYCAR_32	Labels and buttons correctness	No spelling or grammatical errors in labels or buttons.
//		TC_MYCAR_33	Keyboard accessibility	All interactive elements are accessible via keyboard navigation.
//		TC_MYCAR_34	Duplicate car prevention	No duplicate cars are displayed for the same entry.
//		TC_MYCAR_35	Visual separation of cards	Car cards are visually separated for clarity.
//		TC_MYCAR_36	List update on refresh	Refreshing the page displays the current list of cars.
//		TC_MYCAR_37	Browser navigation	Browser back and forward navigation works as expected without errors.
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[1]/div/div/a"))).click();
		Thread.sleep(1000);	
		driver.navigate().back();
		Thread.sleep(1500);	
		driver.navigate().forward();
		Thread.sleep(1000);	
		
		WebElement modelName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_car_model\"]")));
		modelName.clear();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_car_model\"]"))).sendKeys("Nissan");
		Thread.sleep(1000);	
		
		
		WebElement Location = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_location\"]")));
		Location.clear();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_location\"]"))).sendKeys("Mumbai");
		Thread.sleep(1000);	
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/button"))).click();
		Thread.sleep(4000);

	}
	
	@AfterClass
	public void afterClass() {
		if(driver != null) {
			driver.quit();
		}
	}

}
