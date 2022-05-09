package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DrawActions 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//*[@id='imageTemp']")
	private WebElement canvasDrawArea;
	
	@FindBy(xpath = "//*[@type='button' and contains(@class, 'pencil')]")
	private WebElement btnPencilDraw;
	
	@FindBy(xpath = "//*[@type='button' and contains(@class, 'line')]")
	private WebElement btnLineDraw;
	
	@FindBy(xpath = "//*[@type='button' and contains(@class, 'rectangle')]")
	private WebElement btnRectangleDraw;
	
	@FindBy(xpath = "//*[@type='button' and contains(@class, 'ellipse')]")
	private WebElement btnEllipseDraw;
	
	@FindBy(xpath = "//*[@type='button' and contains(@class, 'new')]")
	private WebElement btnNewCanvas;
	
	@FindBy(xpath = "//*[@type='button' and contains(@class, 'undo')]")
	private WebElement btnUndoDraw;
	
	@FindBy(xpath = "//*[@type='button' and contains(@class, 'redo')]")
	private WebElement btnRedoDraw;
	
    public DrawActions(WebDriver driver) {
    	this.driver = driver;
    	this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	PageFactory.initElements(driver, this);
	}
    
    public void drawLine(int x1,int y1,int x2,int y2) {
    	
    	//shift of origin
    	int height = canvasDrawArea.getSize().getHeight()/2;
    	int width = canvasDrawArea.getSize().getWidth()/2;
    	x1 -= width;
    	x2 -= width;
    	y1 -= height;
    	y2 -= height;
    	System.out.println("Origin set to (0, 0)");
    	btnLineDraw.click();
    	Actions action = new Actions(driver);
    	action.moveToElement(canvasDrawArea, x1, y1).click();
    	action.moveToElement(canvasDrawArea, x2, y2).click().build().perform();
    }
}
