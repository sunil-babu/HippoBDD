package hippoPages;

import core.actions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class dashboardPage  {
	
	By usernametxt = By.id("RandomAdmin");
	By usernametb =  By.cssSelector("#id2");
	By passwordtb =  By.name("password");
	By loginbtn =  By.id("ida");
	By newslnk =  By.cssSelector("div.even:nth-child(3) span");
	By titletb =  By.cssSelector("div.hippo-window form table input");
	By okbtn =  By.cssSelector("div.hippo-window-buttons input");
	By cancelbtn = By.cssSelector("div.hippo-window-buttons input:nth-child(2)");
	By newstitiletb = By.cssSelector("div.hippo-editor-field-subfield input");
	By summaryta = By.cssSelector("div.hippo-editor-field-subfield textarea");
	By savecloselnk = By.cssSelector("span[title=\"Save & Close\"]");
	By publicationlnk= By.cssSelector("div.hippo-toolbar-menu li:nth-child(2) a span");
	By publishlnk= By.cssSelector("ul.hippo-toolbar-menu-item li:nth-child(3) a");
	By sitenewslnk = By.cssSelector("ul#main-navigation li:nth-child(2) a span");
	
	
	private static WebDriver driver;
	actions objactions = new actions(driver);
	String mainTitle = "SomeTitle " + objactions.generateRandomNumber();
	
	
	@Before
	public void setup(){
		 //driver = new FirefoxDriver();
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\SBabu7\\workspace\\HippoCMSAsses\\bin\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
	}
	

	@Given("^user already logged in to Hippo$")
	public void UserLogin() throws Throwable {
	    driver.navigate().to("https://cms.demo.onehippo.com/");
	    String temp = driver.findElement(usernametxt).getText();
	    String[] user = temp.split("-",0);
		driver.findElement(usernametb).sendKeys(user[0]);
    	driver.findElement(passwordtb).sendKeys(user[1]);
    	driver.findElement(loginbtn).click();
	}
	
	@Given("^user in dashboard page$")
	public void verifyUserInDashboardPage() throws Throwable {
		driver.getPageSource().contains("Hippo CMS 10.2.0 Enterprise Edition");
	}
	
	@When("^the user clicks create a news document link$")
	public void CreateDocumentLink() throws Throwable {
		objactions = new actions(driver);
		objactions.waitforElementVisible(newslnk);
		driver.findElement(newslnk).click();
	}
	
	@When("^then enters all the valid data and saves the document$")
	public void EnterValidDataAndSubmit() throws Throwable {
		objactions = new actions(driver);
		String title = "Title" +objactions.generateRandomNumber();
		objactions.waitforElementPresent(titletb);
		driver.findElement(titletb).sendKeys(title);
		driver.findElement(okbtn).click();
		objactions.waitforElementPresent(newstitiletb);
		driver.findElement(newstitiletb).sendKeys(mainTitle);
		driver.findElement(summaryta).sendKeys("32432 324af fdsf d fdsf dsf sf dsff sfd fds f");
		driver.findElement(savecloselnk).click();
		driver.getPageSource().contains(title);
	
	}
	
	@When("^publishes the document$")
	public void PublishDocument() throws Throwable {
		objactions =new actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(1000);
		objactions.handleStaleElement(publicationlnk);
		wait.until(ExpectedConditions.elementToBeClickable(publicationlnk));
		driver.findElement(publicationlnk).click();
		wait.until(ExpectedConditions.elementToBeClickable(publishlnk));
		driver.findElement(publishlnk).click();
	}
	
	@Then("^the data should be published to website$")
	public void VerfiyDataPresentInWebsite() throws Throwable {
	    driver.navigate().to("https://www.demo.onehippo.com/");
	    driver.findElement(sitenewslnk).click();
	    Assert.assertTrue(driver.getPageSource().contains(mainTitle));
	    
	}
	
	@After
	public void teardown(){
		driver.quit();
	}
	
}
