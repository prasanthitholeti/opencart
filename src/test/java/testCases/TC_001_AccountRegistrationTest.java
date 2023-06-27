package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import testBase.BaseClass;

import pageObjects.HomePage;
import pageObjects.AccountRegistrationPage;


public class TC_001_AccountRegistrationTest extends BaseClass {
	
    @Test(groups= {"Regression","Master"})
	public void test_account_Registration()
	{
    	logger.info("********** staring TC_001_AccountRegistrationTest  ********");
    	logger.info("*** Generatingdebug logs...");
    	
    	//try
    	//{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account link");
		
		hp.clickRegister(); //opens registration page
		logger.info("Clicked on Registerlink");
		
        AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
        logger.info("Providing customer details.....");
		regpage.setFirstName(randomeString().toUpperCase());
        //regpage.setFirstName("ABCDEF");
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		//regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		//regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();	
		regpage.clickContinue();
		
		logger.info("Clicked on Continue button..");
		
		String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
			{
			logger.info("test passed");
			AssertJUnit.assertTrue(true);
			}
		else
		{
			logger.error("test failed");
			AssertJUnit.assertTrue(false);
		}
		
		/*catch(Exception e)
		{
			Assert.fail();
		}*/
		logger.info("********** Finished TC_001_AccountRegistrationTest  ********");
	}

}
