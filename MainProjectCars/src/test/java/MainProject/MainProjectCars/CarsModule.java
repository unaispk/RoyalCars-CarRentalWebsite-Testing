package MainProject.MainProjectCars;

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

public class CarsModule {
	static WebDriver driver;

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://carrental1.pythonanywhere.com/");
	}

	@Test
	public void testGeneralTestCases() throws InterruptedException {
		
//		TC_CARS_01		Page loading	Verify page loads successfully        
//		TC_CARS_02		Page loading	Verify the page is loaded in an acceptable time
//		TC_CARS_03		Heading			heading is present and styled correctly
//		TC_CARS_04		Navigation-bar 	Check navigation bar is visible on the top of the contact page
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(1000);

		long startTime = System.currentTimeMillis();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[3]"))).click();
		long endTime = System.currentTimeMillis();
		long loadTime = endTime - startTime;

		System.out.println("Page Load Time: " + loadTime + " milliseconds");
		
//		TC_CARS_06	Social media icons	Verify social media icons 
		
		Thread.sleep(2500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/a[1]/i"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/a[2]/i"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/a[3]/i"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/a[4]/i"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/a[5]/i"))).click();
		Thread.sleep(1000);
		
//		TC_CARS_07	Refresh	Verify contents are stable after page refresh

		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		
//		TC_CARS_08	Spacing between elements	Verify alignment and spacing of elements
//		TC_CARS_09	Car Image Display			Each card displays a car image
//		TC_CARS_10	Model Readable				Car model is clearly visible and readable
//		TC_CARS_11	Color Visible				Color label and value are visible and properly formatted
//		TC_CARS_12	Price Formatted				Price per day is visible and formatted as $X.XX
//		TC_CARS_13	Chat Button Present			Chat with Seller button is present and styled consistently
//		TC_CARS_14	Grid Alignment				Cards are aligned and spaced evenly in the grid
//		TC_CARS_15	Responsive Layout			Card layout is responsive on mobile, tablet, and desktop
//		TC_CARS_16	Loading Spinner	Loading 	spinner appears while images or data are being fetched
//		TC_CARS_17	No Broken Images			No broken or missing images displayed
//		TC_CARS_18	Color Matches				Color value matches the database record
//		TC_CARS_19	Fetch Error					Error message is shown if the data fetch fails
//		TC_CARS_20	Session Stable				Session timeout does not break the car list display
//		TC_CARS_21	Dynamic Updates				Dynamic updates reflect immediately in the UI
//		TC_CARS_22	No Unintended Actions		Clicking on an image or model does not trigger unintended actions
//		TC_CARS_23	Multiple Cards				Multiple cards can be displayed without performance issues
//		TC_CARS_24	Chat Disabled				Chat with Seller button is disabled if the user is not logged in
//		TC_CARS_25	Chat Enabled				Chat with Seller button is enabled if the user is logged in
//		TC_CARS_26	No Sensitive Data			No sensitive data is exposed in network requests
//		TC_CARS_27	Access Control				Access to the car list is granted to all users or as per access policy
		
		Thread.sleep(1000);
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	
    	for (int i = 0; i < 1000; i += 30) {
			js.executeScript("window.scrollTo(0, arguments[0])", i);
			Thread.sleep(30);
		}

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		Thread.sleep(2000);

		for (int i = 1000; i > 0; i -= 30) {
			js.executeScript("window.scrollTo(0, arguments[0])", i);
			Thread.sleep(30);
		}
		js.executeScript("window.scrollTo(0, 0)");

        Thread.sleep(3000);
        
//      TC_CARS_28	Authenticated Chat		Chat with Seller button is only available to authenticated users
//      TC_CARS_29	Hover Feedback			Hover or focus state provides visual feedback on cards
//      TC_CARS_30	Hover Feedback			Hover or focus state provides visual feedback on buttons
        
        
        Actions action = new Actions(driver);
		WebElement carCard = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div"));
		action.moveToElement(carCard).perform();
		Thread.sleep(2000);
		
		WebElement ChatWithSellerBtn = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/a/button"));
		action.moveToElement(ChatWithSellerBtn).perform();
		Thread.sleep(2000);
		
		
//		TC_CARS_31	Chat Opens				Clicking the Chat with Seller button opens a chat interface or initiates a chat
//		TC_CARS_32	Navigation State		Browser back and forward navigation preserves the car list state
//		TC_CARS_33	Pagination	Verify pagination is available for car listings
		
		WebElement chatWithSellerBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Chat with Seller']")));
		chatWithSellerBtn.click();
        Thread.sleep(2000);
        
        
        driver.navigate().back();
        
        Thread.sleep(1000);
    	
    	
		for (int i = 0; i < 1000; i += 30) {
			js.executeScript("window.scrollTo(0, arguments[0])", i);
			Thread.sleep(30);
		}

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		Thread.sleep(2000);

		for (int i = 1000; i > 0; i -= 30) {
			js.executeScript("window.scrollTo(0, arguments[0])", i);
			Thread.sleep(30);
		}
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(2000);
	}
	@AfterClass
	public void afterClass() {
		if(driver != null) {
			driver.quit();
		}
	}
}
