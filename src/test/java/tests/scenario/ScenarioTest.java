package tests.scenario;

import java.time.Duration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
	static WebDriver driver;
	static String baseURL;
	static PropertiesReader read = new PropertiesReader();
	static String driverFolder = System.getProperty("user.dir") + "/src/main/java/asset/drivers";
	
	@BeforeClass
	public static void initialSetup() throws Exception {
		String browser = read.PropertiesReaderBrowser();
		System.out.println("CurrentBrowser: "+browser);
		baseURL = "http://www.htmlcanvasstudio.com/";
		switch(browser.toLowerCase()){
			case "chrome":
				System.setProperty("webdriver.chrome.driver", driverFolder+"/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", driverFolder+"/geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			case "edge":
				System.setProperty("webdriver.edge.driver", driverFolder+"/msedgedriver.exe");
				driver = new EdgeDriver();
				break;
			default:
				throw new NotFoundException("Browser not found, please provide valid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Before
	public void scenarioStart() throws Exception {
		System.out.println("Scenario execution started successfully.");
	}
	
    @Test
    public void scenario1()
    {
        driver.get(baseURL);
        DrawActions activity = new DrawActions(driver);
        activity.drawLine(200, 250, 400, 250); // -100  0  100  0
        activity.drawLine(300, 150, 300, 350); //   0  -100  0 100
    }  
    
    
    @After
    public void scenarioClose() throws Exception {
    	Thread.sleep(9000);
    	System.out.println("Scenario execution done");
    }
    
    
    @AfterClass
    public static void tearDown() throws Exception {
    	Thread.sleep(9000);
    	driver.quit();
    }
    
}
