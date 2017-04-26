package loginPage;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseClass.BaseClass;

public class LoginPageValidation extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Login  Page Validation
	// Created by :Shakira
	// Created on :Dec 2016

	// ///////////////////////////////////////////////////////////////////////////////

	public LoginPageValidation(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public LoginPageValidation() {

	}

	public void validateLoginPage() {
		

		if (currentExecutionMachineName.equalsIgnoreCase("Wel_HP_Article_LvlUp")) {
			testStepInfo("**************** Login Page *******************");
			verifyLoginForm();
			verifyLoginPage();

			
		}
		else if(currentExecutionMachineName.equalsIgnoreCase("AndroidMobile"))
		{
			verifyLoginForm();
			verifyLoginPage();
			
		}
		else
		{
			verifyLoginForm();
			verifyLoginPage();
		}
			
	}
	
	public void validateEditToolLogin()
	{
		testStepInfo("************** Edit Tool Login Page *********************");
		try {
			//driver.get("https://edittools.forbes.com/");
			
			clickOn(OR.img_EditTool_Login_Avatar);
			
			
			typeIn(OR.txt_EditToo_Login_UserName, retrieve("txtEditToolUserName"));
			typeIn(OR.txt_EditTool_Login_Password, retrieve("txtEditToolPassword") );
			clickOn(OR.btn_EditTool_Login_Submit);
			
			boolean loginFrame=elementPresent(OR.txt_EditTool_login_Frame);
			if(loginFrame==true)
			{
			switchToFrame(OR.txt_EditTool_login_Frame);
			
			boolean duoPage=elementPresent(OR.btn_EditTool_Login_Phone);
			if(duoPage==true)
			{
				
				testStepPassed("Login Successfully");
			}
			//clickOn(OR.btn_EditTool_Login_Phone);
			switchToDefaultFrame();
			//clickOn(OR.btn_EditTool_Login_Logout);
			
			}
			else
			{
				testStepFailed("Login Failed");
			}
			/*	driver.switchTo().frame("duo_iframe");
				clickOn(OR.btn_EditTool_Login_Phone);
				waitTime(20);
				driver.switchTo().defaultContent();*/
				
			
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void verifyLoginSuccessful()
	{
		try {
			boolean checkLoggedIcon=elementPresent(OR.icon_LoginPage_LoggedIcon);
			if(checkLoggedIcon==true)
			{
				clickOn(OR.icon_LoginPage_LoggedIcon);
				boolean checkUserName=elementPresent(OR.txt_LoginPage_UserName);
				if(checkUserName==true)
				{
					String getUserName=getText(OR.txt_LoginPage_UserName);
					testStepPassed("Logged In user name is present --"+getUserName);
				}
				else
				{
					testStepFailed("Logged In User name is not present");
				}
				
				boolean checkLogout=elementPresent(OR.txt_LoginPage_Logout);
				if(checkLogout==true)
				{
					clickOn(OR.txt_LoginPage_Logout);
					boolean checkLogoutSuccessMessage=elementPresent(OR.txt_LoginPage_Logout_Message);
					if(checkLogoutSuccessMessage==true)
					{
						String getLogoutMessage=getText(OR.txt_LoginPage_Logout_Message);
						
						testStepPassed("Logoout is successful--"+getLogoutMessage);
						boolean checkLogoutClose=elementPresent(OR.btn_LoginPage_Close);
						if(checkLogoutClose==true)
						{
							clickOn(OR.btn_LoginPage_Close);
							testStepPassed("Logout window close button is closed");
						}
						else
						{
							testStepFailed("Logout window close button is not closed");
						}
					}
					else
					{
						testStepFailed("Logout Successfull message is not present");
					}
				}
				else
				{
					testStepFailed("Logout link is not present");
				}
			}
			else
			{
				testStepFailed("Logged In Icon is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void verifyLoginPage() {

		try {
			waitForElement(OR.txt_Login_Page_User_Name);
			boolean loginUsername=elementPresent(OR.txt_Login_Page_User_Name);
			boolean loginPassword=elementPresent(OR.txt_Login_Page_Password);
			if(loginUsername==true && loginPassword==true)
			{
			typeIn(OR.txt_Login_Page_User_Name, retrieve("txtUserName"));
			typeIn(OR.txt_Login_Page_Password, retrieve("txtPassword"));
			clickOn(OR.btn_Login_Page_Login);
			
			boolean checkLoginSuccessmessage=elementPresent(OR.txt_LoginPage_Success_Message);
			if(checkLoginSuccessmessage==true)
			{
				String getLoginMessage=getText(OR.txt_LoginPage_Success_Message);
				testStepPassed("Login is successful--"+getLoginMessage);
				boolean checkCloseButton=elementPresent(OR.btn_LoginPage_Close);
				if(checkCloseButton==true)
				{
					clickOn(OR.btn_LoginPage_Close);
					testStepPassed("Login window close button is closed"); 
					
					verifyLoginSuccessful();
				}
				else
				{
					testStepFailed("Login window close button is not present");
				}
			}
			else
			{
				testStepFailed("Login is failed");
			}
			}
			else
			{
				testStepFailed("Login Page is not Opened");
			}
			waitTime(5);
			// boolean errorMsg =
			// elementPresent(OR.txt_Login_Page_Error_Message);
			// boolean fieldError =
			// elementPresent(OR.txt_Login_Page_Field_Req_Error);
			/*boolean user = elementPresent(OR.txt_Login_Page_User_Link);
			if (user == true) {

				String userName = getText(OR.txt_Login_Page_User_Link);
				testStepPassed("Logged into this user-" + userName);
				clickOn(OR.txt_Login_Page_Logout);
				testStepPassed("Login is verified Successfully");

			} else {
				

				testStepFailed("Invalid User Name and Password");

			}*/
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateLoginThroughAvatar() {

		testStepInfo("******************* Login Through Avatar********************");
		try {
			waitTime(5);
			boolean loginAcctBtn = elementPresent(OR.btn_Login_Page_Account);
			if (loginAcctBtn == true) {
				clickOn(OR.btn_Login_Page_Account);

			} else {
				testStepFailed("Login Avatar is not Enabled ");
			}
			verifyLoginPage();
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public Actions action = new Actions(driver);

	public void validateLoginThroughAvatarLogin() {
		testStepInfo("**************** Avatar Login *****************");
		try {

			waitTime(8);
			WebElement login = driver.findElement(By
					.xpath("//a[@class='button account ga_tracked']//img"));
			action.moveToElement(login).build().perform();

			// mouseOver(OR.btn_Login_Page_Account);
			waitTime(10);
			boolean loginAcctBtn = elementPresent(OR.txt_Login_Page_Avatar_Login);
			if (loginAcctBtn == true) {
				clickOn(OR.txt_Login_Page_Avatar_Login);

			} else {
				testStepFailed("Login Avatar is not Enabled ");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		verifyLoginPage();
	}

	
	
}
