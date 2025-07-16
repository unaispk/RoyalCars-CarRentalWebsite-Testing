package MainProjectContactTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

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

public class ContactTest {
	static WebDriver driver;

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://carrental1.pythonanywhere.com/");
	}

	@BeforeMethod
	public void BeforeMethod() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[4]"))).click();
	}
	
//		TC_CONT_01	Page loading	Verify page loads successfully 
	
	@Test(priority = 1)
	public void testGeneralTestCases() throws InterruptedException {
		
//		TC_CONT_03	Heading	Verify the "Contact Us" heading is displayed at the top of the page.  
//		TC_CONT_04	Navigation bar 	Check navigation bar is visible on the top of the contact page
//		TC_CONT_05	Incognito 	Verify page in incognito mode	
//		TC_CONT_06	Social media icons	Verify social media icons 
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll to bottom
		
//		TC_CONT_07	Back to Top Button	Verify "Back to Top" button     
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(4000);

		// Scroll to top
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(4000);
	}
	
	@Test(priority = 2)
	public void testPageLoading() throws InterruptedException {
		
//		TC_CONT_02	page loading	Check page load time  
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Thread.sleep(800);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[1]"))).click();

		long startTime = System.currentTimeMillis();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[4]"))).click();
		long endTime = System.currentTimeMillis();
		long loadTime = endTime - startTime;

		System.out.println("Page Load Time: " + loadTime + " milliseconds");
	}
	
	@Test(priority = 3)
	public void testAfterLogin() throws InterruptedException {
		
//		TC_CONT_08	Availability after login	Verify that about page still available after login the web-site
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[5]"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys("unaispk");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys("uxpk123@123");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/form/a/button"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[4]"))).click();
//		navigate to contact page after logout
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarCollapse\"]/div/a[4]"))).click();
		
//		TC_CONT_09	Brocken links	Verify there is no brocken links
		
		// Scroll to bottom
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div[2]/div/a"))).click();
		Thread.sleep(2000);
		driver.navigate().back();
		
        // Scroll to bottom
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div[3]/div/div[1]/a/img"))).click();
		Thread.sleep(800);
		// Scroll to bottom
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div[3]/div/div[2]/a/img"))).click();
		Thread.sleep(800);
		// Scroll to bottom
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div[3]/div/div[3]/a/img"))).click();
		Thread.sleep(800);
		// Scroll to bottom
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div[3]/div/div[4]/a/img"))).click();
		Thread.sleep(800);
		// Scroll to bottom
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div[3]/div/div[5]/a/img"))).click();
		Thread.sleep(800);
		// Scroll to bottom
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div[3]/div/div[6]/a/img"))).click();
		Thread.sleep(800);
	}

	@Test(priority = 4)

		public void testPrintability() throws InterruptedException, AWTException {
		
//	TC_CONT_11	Printability  Verify page printability

		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
	}
	
	@Test(priority = 5)
	public void testRefresh()  throws InterruptedException {
		
//		TC_CONT_12	Refresh	Verify contents are stable after page refresh
		
//		TC_CONT_13	Spacing between elements	Verify alignment and spacing of elements
//		TC_CONT_14	Head Office Display	Head Office label is displayed correctly
//		TC_CONT_15	Head Office Address	Head Office address (Kochi, Kerala) is visible and spelled correctly
//		TC_CONT_16	Branch Office Display	Branch Office label is displayed correctly
//		TC_CONT_17	Branch Address Visible	Branch Office address (Edappally, Ernakulam, Kerala) is visible and spelled correctly
//		TC_CONT_18	Customer Service Display	Customer Service label is displayed correctly
//		TC_CONT_19	Email Format Check	Customer Service email (carrent1824@gmail.com) is visible and correctly formatted
//		TC_CONT_20	Spelling Grammar Validation	No spelling or grammatical errors in contact information
//		TC_CONT_21	Info Responsive Layout	Contact information is readable on all devices (mobile, tablet, desktop)
//		TC_CONT_22	Contact Readability Check	Contact section background color contrasts well with text for readability
//		TC_CONT_23	Text Overflow Check	No overlapping or cut-off text in the contact info box
//		TC_CONT_24	Get In Touch	Get In Touch label is present and styled consistently
//		TC_CONT_25	Branch Address Repeat	Branch address is repeated accurately under Get In Touch
//		TC_CONT_26	Phone Number Visible	Phone number (+91 9012345678) is visible and correctly formatted
		
		
		Thread.sleep(1000);
    	driver.navigate().refresh();
    	Thread.sleep(2000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 1000; i += 10) {
            js.executeScript("window.scrollTo(0, arguments[0])", i);
            Thread.sleep(30);
        }
        Thread.sleep(2000);

        for (int i = 1000; i > 0; i -= 10) {
            js.executeScript("window.scrollTo(0, arguments[0])", i);
            Thread.sleep(30);
        }
        Thread.sleep(3000);
    }

	@Test(priority = 6)
	public void testKeyboardAccess() throws InterruptedException {

//		TC_CONT_29	Duplicate Info Check	No duplicate or conflicting contact details between sections
//		TC_CONT_30	Keyboard Info Access	Contact details are accessible via keyboard navigation

		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

		WebElement body = driver.findElement(By.tagName("body"));

		Actions action = new Actions(driver);
		action.moveToElement(body).click().perform();

		for (int i = 0; i < 20; i++) {
			action.sendKeys(Keys.TAB).perform();
			Thread.sleep(1200);
		}

	}
	@Test(priority = 7)
	public void testBottomPart()  throws InterruptedException {
//		TC_CONT_32	Useful Links Label	USEFULL LINKS label is present and styled consistently
//		TC_CONT_33	Registration Link Visible	New Member Registration link is visible
//		TC_CONT_34	Registration Link Redirect	New Member Registration link navigates to the correct page
//		TC_CONT_35	Broken Links Test	No broken links in the Useful Links section
//		TC_CONT_36	Links Section Separation	Useful Links section is clearly separated from other sections
//		TC_CONT_37	Useful Spelling Check	No spelling errors in  Useful Links (should be USEFUL)
//		TC_CONT_38	Link Text Clarity	Link text is descriptive and clear
//		TC_CONT_39	Gallery Label Visible	"CAR GALLERY label is present and styled consistently.
//		Six car images are displayed in a grid"
//		TC_CONT_40	Gallery Image Load	All car images load successfully (no broken images)
//		TC_CONT_41	Image Quality Check	All car images are clear and not pixelated
//		TC_CONT_44	Duplicate Image Check	No duplicate images in the gallery
//		TC_CONT_45	Image Load Speed	Images do not slow down page load excessively
//		TC_CONT_46	Footer Text Display	Footer displays © Royal Cars. All Rights Reserved.
//		TC_CONT_47	Footer Responsive Layout	Footer is present on all device sizes and is not cut off
//		TC_CONT_48	Footer Text Contrast	Footer text is readable and contrasts with background
//		TC_CONT_49	Copyright Symbol	No broken or missing copyright symbol
//		TC_CONT_50	Footer Overlap Check	Footer does not overlap with other page content
//		TC_CONT_53	Hidden Element Check	No UI elements are hidden or inaccessible on any device
		
//		TC_CONT_57	Accessible Name Check	All links and buttons have accessible names or labels

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll to bottom
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		Thread.sleep(6500);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div[2]/div/a"))).click();
		Thread.sleep(3000);
		driver.navigate().back();
	}
	
	@AfterClass
	public void afterClass() {
      if (driver != null) {
          driver.quit();
      }
	}
}
