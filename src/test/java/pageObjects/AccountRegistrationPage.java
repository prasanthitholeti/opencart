package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;


public class AccountRegistrationPage extends BasePage {
	
	Actions actions = new Actions(driver);
	WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
//Elements
	@FindBy(name = "firstname")
	WebElement txtFirstname;
	
	@FindBy(name = "lastname")
	WebElement txtLasttname;
	
	@FindBy(name = "email")
	WebElement txtEmail;
	
	//@FindBy(name="telephone")
	//WebElement txtTelephone;
	
	@FindBy(name = "password")
	WebElement txtPassword;
	
	//@FindBy(name = "confirm")
	//WebElement txtConfirmPassword;
	
	@FindBy(name = "agree")
	//@FindBy(xpath = "//input[@name='agree']")
	WebElement chkdPolicy;
	
	
	//@FindBy(xpath = "//input[@value='Continue']")
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;


	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);

	}

	public void setLastName(String lname) {
		txtLasttname.sendKeys(lname);

	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);

	}

	/*public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);

	}*/

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);

	}

	/*public void setConfirmPassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);

	}*/

	public void setPrivacyPolicy() {
		//actions.moveToElement(chkdPolicy).click().build().perform();
		jse2.executeScript("arguments[0].scrollIntoView()", chkdPolicy);
		//Point location = chkdPolicy.getLocation();
		//actions.moveToElement(chkdPolicy).click();
		//actions.moveToElement(chkdPolicy).click().perform();
		//actions.moveByOffset(935,759).click().build().perform();
		//mywait.until(ExpectedConditions.elementToBeClickable(chkdPolicy)).click();
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].scrollIntoView()", chkdPolicy); 
		mywait.until(ExpectedConditions.elementToBeClickable (chkdPolicy)).click();;
		//chkdPolicy.click();
		
		
	}


	public void clickContinue() {
		//sol1 
		//btnContinue.click();
		
		//sol2 
		//btnContinue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();;
		//btnContinue.click();
		
	}

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}

	}
	
	
	
}
