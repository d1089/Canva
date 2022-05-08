package tests.scenario;

import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.DrawActions;
import utils.PropertiesReader;


public class ScenarioTest 
{
	WebDriver driver;
	String baseURL;
	PropertiesReader read = new PropertiesReader();
	String driverFolder = System.getProperty("user.dir") + "/src/main/java/asset/drivers";
	@Before
	public void initialSetup() throws Exception {
		String browser = read.PropertiesReaderBrowser();
		System.out.println("CurrentBrowser: "+browser);
		baseURL = "http://www.htmlcanvasstudio.com/";
		switch(browser.toLowerCase()){
			case "chrome":
				System.setProperty("webdriver.chrome.driver", driverFolder+"/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", driverFolder+"/geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				break;
			case "edge":
				System.setProperty("webdriver.edge.driver", driverFolder+"/microsoftwebdriver.exe");
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				break;
			default:
				throw new NotFoundException("Browser not found, please provide valid browser");
		}
	}
	
    @Test
    public void tc1()
    {
        driver.get(baseURL);
        DrawActions activity = new DrawActions(driver);
        activity.drawLine(200, 200, 400, 400);
        activity.drawLine(300, 100, 300, 300);
    }
    
    @After
    public void tearDown() throws Exception {
    	Thread.sleep(3000);
    	driver.quit();
    }
    
}
