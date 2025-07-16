package HomeModule;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeModule {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://carrental1.pythonanywhere.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);

//		TC_HM_01	Ensure the "Royal Cars" logo is displayed correctly and aligned properly.
//		TC_HM_02	Check navigation bar  is displayed correctly and aligned properly
//		TC_HM_03	Verify clicking the Home link reloads the homepage.
//		TC_HM_04	Verify clicking the About menu loads to the about section of the website.
//		TC_HM_05	Verify clicking the Cars menu loads to the Cars module of the website.
//		TC_HM_06	Verify clicking the Contact menu loads to the Contact page of the website.
//		TC_HM_07	Verify clicking the Login menu loads to the Login page of the website.
//		TC_HM_08	Verify that the active page in the navigation bar is visually distinct from the other menu items.

		driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[5]")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[1]")).click();
		Thread.sleep(3000);

//		TC_HM_09	Ensure that on hover, the cursor changes to indicate interactivity (e.g., cursor changes to 'pointer') for all navigation menu items.

		List<WebElement> menuItems = driver.findElements(By.xpath("//*[@id='navbarCollapse']/div/a"));
		Actions action = new Actions(driver);

//		System.out.println("Test Case: Hovering on navigation menu items\n");

		for (int i = 0; i < menuItems.size(); i++) {

			WebElement item = menuItems.get(i);

			action.moveToElement(item).perform();
			Thread.sleep(1000);

//		    String menuColor = item.getCssValue("color");
//		    System.out.println("Menu Item " + (i + 1) + ": " + (menuColor.equals("rgba(247, 125, 10, 1)") ? "PASS" : "FAIL"));
		}

//		TC_HM_10	Confirm that the hero section displays the "Rent A Car" headline and associated images correctly.
//		TC_HM_11	Confirm that "Register for rent your car" button visible correctly

//		TC_HM_12	Confirm that "Register for rent your car" functions correctly

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement registerBtn = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header-carousel\"]/div/div[1]/div/div/a")));
		registerBtn.click();
		Thread.sleep(2000);
		driver.navigate().back();

//		TC_HM_13	 button	Ensure that hovering on "Register for rent your car" button changes the button style 
//		TC_HM_14	 button	Ensure that hovering on "Register for rent your car" button changes the cursor style. 

//	    TC_HM_15	Check consistency of fonts and colors
//	    TC_HM_16	Validate image loading time
//	    TC_HM_17	Validate image quality	
//	    TC_HM_18	Verify alignment and spacing of elements
//	    TC_HM_19	Ensure footer content is displayed correctly
//	    TC_HM_20	Verify homepage loads successfully

//	    TC_HM_21	Validate contact information links

		Thread.sleep(2000);
		action.moveToElement(registerBtn).perform();

//	    TC_HM_22	Test image carousel functionality.

		WebElement carouselNextButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header-carousel\"]/a[2]/div/span")));
		carouselNextButton.click();
		Thread.sleep(1000);
		WebElement carouselPreviousButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header-carousel\"]/a[1]/div/span")));
		carouselPreviousButton.click();
		Thread.sleep(1000);
		carouselNextButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header-carousel\"]/a[2]/div/span")));
		carouselNextButton.click();
		Thread.sleep(1000);
		carouselPreviousButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header-carousel\"]/a[1]/div/span")));
		carouselPreviousButton.click();
		Thread.sleep(1000);
		carouselNextButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header-carousel\"]/a[2]/div/span")));
		carouselNextButton.click();
		Thread.sleep(1000);

//	    TC_HM_23	Confirm that "Start Now" button visible correctly
//	    TC_HM_24	Confirm that "Start Now" functions correctly
//	    TC_HM_25	Ensure that hovering on "Start Now" button changes the button style 
//	    TC_HM_26	Ensure that hovering on "Start Now" button changes the cursor style. 

		WebElement startNowButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div/div/div/div/div/a")));
		startNowButton.click();

		driver.navigate().back();

		startNowButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div/div/div/div/div/a")));
		action.moveToElement(startNowButton).perform();
//	    
//	    TC_HM_27	Ensure scrolling is smooth without lag, glitches, or layout shifts across devices and browsers.
//	    TC_HM_29	Verify that there is a introduction about the website is present on home page
//	    TC_HM_30	Validate text content spelling and grammar

		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);

		// Scroll back to top
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);

		// Scroll to bottom
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1000);

		// Scroll up
		js.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(1000);

		// Scroll back to top
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);

//      TC_HM_32	Check browser back/forward navigation
//      TC_HM_34	Verify that the footer remains at the bottom of the page regardless of screen size.
//      TC_HM_35	Verify that the footer is aligned properly and does not overlap content.
//      TC_HM_36	Verify that the copyright text is present and correctly formatted.
//      TC_HM_37	Verify that footer links are accessible via keyboard navigation.

		WebElement aboutMenu = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"navbarCollapse\\\"]/div/a[2]")));
		aboutMenu.click();
		Thread.sleep(2000);

		driver.navigate().back();
		Thread.sleep(1000);

		driver.navigate().forward();
		Thread.sleep(1000);

		driver.navigate().back();
		Thread.sleep(1000);
	}
}
