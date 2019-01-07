package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public Properties prop; 
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	
	public WebDriver initializeDriver() throws IOException {
		
		prop = new Properties();
		
		FileInputStream finp = new FileInputStream("src/main/java/resources/data.properties");
		prop.load(finp);
		
		log.info("Name is browser is "+prop.getProperty("browser"));
		
		if(prop.getProperty("browser").equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if(prop.getProperty("browser").equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "src/main/java/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			 
		}		
				
		return driver;
	}
	
	public void getScreenShot(String result) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test//" + result + "screenshot.png"));
	}
	
}
