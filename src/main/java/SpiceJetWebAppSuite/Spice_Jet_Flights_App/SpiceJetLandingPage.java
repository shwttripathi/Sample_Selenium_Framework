package SpiceJetWebAppSuite.Spice_Jet_Flights_App;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpiceJetLandingPage {
	
	public WebDriver driver;
	
	@FindBy(css = "input[value = 'RoundTrip']")
	private WebElement roundTrip;

	@FindBy(id = "ctl00_mainContent_chk_StudentDiscount")
	private WebElement studentCheckBox;
	
	@FindBy(id = "ctl00_mainContent_DropDownListCurrency")
	private WebElement curDropDown;
	
	@FindBy(id = "divpaxinfo")
	private WebElement paxNum;
	
	@FindBy(xpath = "//span[@id = 'hrefIncAdt']")
	private WebElement addPax;
	
	@FindBy(css = "input[value = 'Done']")
	private WebElement done;
	
	@FindBy(id ="ctl00_mainContent_btn_FindFlights")
	private WebElement flight;
	
	public SpiceJetLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	
	public WebElement getRoundTrip() {
		return roundTrip;
	}
	
	public WebElement getStudentCheckBox() {
		return studentCheckBox;
	}
	
	public WebElement getCurDropDown() {
		return curDropDown;
	}
	
	public WebElement getPaxNum() {
		return paxNum;
	}
	
	public WebElement getAddPax() {
		return addPax;
	}
	
	public WebElement getDone() {
		return done;
	}
	
	public WebElement getFlight() {
		return flight;
	}
}
