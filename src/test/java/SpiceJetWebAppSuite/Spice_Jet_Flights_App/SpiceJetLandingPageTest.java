package SpiceJetWebAppSuite.Spice_Jet_Flights_App;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.TestBase;

public class SpiceJetLandingPageTest extends TestBase{
	
	public WebDriver driver;
		
	@BeforeTest
	public void startUp() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void verifyRoundTripRadio() {
		
		log.info("inside verify round trip radio");
		
		SpiceJetLandingPage lp = new SpiceJetLandingPage(driver);
		Assert.assertFalse(lp.getRoundTrip().isDisplayed());
		
	}
	
	@Test(priority = 2)
	public void verifyStudentCheckBox() {
		SpiceJetLandingPage lp = new SpiceJetLandingPage(driver);
		Assert.assertTrue(lp.getStudentCheckBox().isDisplayed());		
	}
	
	
	@Test(dataProvider = "testdata")
	public void selectCurAndPax(String cur, int pax) {
	
		driver.navigate().refresh();
		
		SpiceJetLandingPage lp = new SpiceJetLandingPage(driver);
		Select drpDown = new Select(lp.getCurDropDown());
		drpDown.selectByValue(cur);
		
		lp.getPaxNum().click();
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		for(int i = 1; i< pax ;i++ ) {
			wait.until(ExpectedConditions.elementToBeClickable(lp.getAddPax())).click();;
		}
		
		lp.getDone().click();
		
		Assert.assertEquals(drpDown.getFirstSelectedOption().getText(), cur);
		Assert.assertEquals(lp.getPaxNum().getText().charAt(0), Integer.toString(pax).charAt(0));
		
	}
	
	@Test
	public void verifyFlightButton() {
		SpiceJetLandingPage lp = new SpiceJetLandingPage(driver);
		Assert.assertTrue(lp.getFlight().isDisplayed());
	}
	
	
	@DataProvider(name = "testdata")
	public static Object[][] details() {
		return new Object[][] { {"USD", 2} , {"INR", 3} };

	
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		//driver = null;
	}
	
}	
