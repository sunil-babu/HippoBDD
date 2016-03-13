package core;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Author : Sunil 
 * Description : Selenium Helper actions
 */
public class actions {
	
	WebDriver driver;
	int timeinSeconds = 30;
	public actions(WebDriver driver){	 
        this.driver = driver;
    }
	public WebElement waitforElementPresent(By element){
		WebElement myDynamicElement = (new WebDriverWait(driver, timeinSeconds))
				  .until(ExpectedConditions.presenceOfElementLocated(element));
		return myDynamicElement;
    }
	public WebElement waitforElementVisible(By element){
		WebElement myDynamicElement = (new WebDriverWait(driver, timeinSeconds))
				  .until(ExpectedConditions.elementToBeClickable(element));
		return myDynamicElement;
    }
	public void javascriptScrolltoView(By element){
		WebElement elements = driver.findElement(element);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true);" ,elements);
	}
	public By replaceLocator(By element,String value){
		String newElement =  element.toString().replace("[*]", value);
		By newElement1 = By.cssSelector(newElement.substring(15));
		return newElement1;
	}
	public void javascriptclick(WebDriver driver,By element){
		WebElement elem = driver.findElement(element);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", elem);
	}
	public WebElement handleStaleElement(By elementName) { 
		int count = 0; 
		WebElement staledElement =null;
		while (count < 4) {
			try { 
				//If exception generated that means It Is not able to find element then catch block will handle It.
				staledElement = driver.findElement(elementName);
				//If exception not generated that means element found and element text get cleared. staledElement.clear(); 
				} catch (StaleElementReferenceException e) {
					e.toString();
					System.out.println("Trying to recover from a stale element :" + e.getMessage());
					count = count + 1;
					} 
			count = count + 4; } 
		return staledElement;
		}
	public int generateRandomNumber(){
		Random rn = new Random();
		int rnNumber = rn.nextInt(1000) + 1;
		return rnNumber;
	}
		

}
