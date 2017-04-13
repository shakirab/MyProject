package signUpPage;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseClass.BaseClass;

public class SignUpValidation extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Login Page Validation
	// Created by :Shakira
	// Created on :24 August 2016

	// ///////////////////////////////////////////////////////////////////////////////

	public SignUpValidation(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public SignUpValidation() {

	}

	public void validateSignUpPage() {
		testStepInfo("************************************** Sign Up Page *****************************************");

		if (currentExecutionMachineName.equalsIgnoreCase("Wel_HP_Article")) {
			  validateSignUp();
			  validateAvatarSignUp();
		}
	}
	
	public void validateEditToolLogin()
	{
		testStepInfo("************************************** Edit Tool Login Page *****************************************");
		try {
			driver.get("https://edittools.forbes.com/");
			typeIn(OR.txt_EditToo_Login_UserName, retrieve("txtEditToolUserName"));
			typeIn(OR.txt_EditTool_Login_Password, retrieve("txtEditToolPassword") );
			clickOn(OR.btn_EditTool_Login_Submit);
			
			boolean loginFrame=elementPresent(OR.txt_EditTool_login_Frame);
			if(loginFrame==true)
			{
			switchToFrame(OR.txt_EditTool_login_Frame);
			clickOn(OR.btn_EditTool_Login_Phone);
			waitTime(10);
			switchToDefaultFrame();
			waitTime(5);
			clickOn(OR.btn_EditTool_Login_Logout);
			testStepPassed("Login Successfully");
			waitTime(5);
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

	
	public Actions action = new Actions(driver);

	
	public void validateSignUp() {
		testStepInfo("***************************************** SignUp ******************************************");
		try {
			waitTime(5);
			boolean signUp = elementPresent(OR.txt_Login_Page_Facebook_Logout);
			if (signUp == true) {
				clickOn(OR.txt_Login_Page_Facebook_Logout);
			} else {
				testStepFailed("SignUp is not Displayed");
			}

			boolean name = elementPresent(OR.txt_Login_Page_Signup_Name);
			boolean email = elementPresent(OR.txt_Login_Page_Signup_Email);
			boolean pwd = elementPresent(OR.txt_Login_Page_Signup_Password);
			boolean submit = elementPresent(OR.btn_Login_Page_Signup_Submit);

			if (name == true && email == true && pwd == true && submit == true) {
				testStepPassed("Sign Up window is opened");
				clickOn(OR.btn_Login_Page_Facebook_Cancel);
				waitTime(5);
			} else {
				testStepFailed("Sign up window is not opened");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}
	
	public void mouseHoverOnElement()
	{
		try {
			waitTime(10);
			waitForElement(OR.btn_Login_Page_Account);
			boolean loginAccount=elementPresent(OR.btn_Login_Page_Account);
			if(loginAccount==true)
			{
			WebElement login = driver.findElement(By
					.xpath("//a[@class='button account ga_tracked']//img"));
			action.moveToElement(login).build().perform();

			 mouseOver(OR.btn_Login_Page_Account);
			 
			waitTime(20);
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateAvatarSignUp() {
		testStepInfo("***************************************** Avatar SignUp  ******************************************");
		try {
			//driver.get("http://www.forbes.com/home_usa/");
			//waitTime(10);
			try {
				waitTime(5);
				WebElement login = driver.findElement(By
						.xpath("//a[@class='button account ga_tracked']//img"));
				action.moveToElement(login).build().perform();
				 this.sleep(2);
				 
			} catch (Exception e) {
				
			}

			// mouseOver(OR.btn_Login_Page_Account);
			waitTime(10);

			boolean signUp = elementPresent(OR.btn_Sigup_Page_Button);
			if (signUp == true) {
				clickOn(OR.btn_Sigup_Page_Button);
			} else {
				testStepFailed("SignUp is not Displayed");
			}

			boolean name = elementPresent(OR.txt_Login_Page_Signup_Name);
			boolean email = elementPresent(OR.txt_Login_Page_Signup_Email);
			boolean pwd = elementPresent(OR.txt_Login_Page_Signup_Password);
			boolean submit = elementPresent(OR.btn_Login_Page_Signup_Submit);

			if (name == true && email == true && pwd == true && submit == true) {
				testStepPassed("Sign Up window is opened");
				clickOn(OR.btn_Login_Page_Facebook_Cancel);
				waitTime(5);
			} else {
				testStepFailed("Sign up window is not opened");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}
	public void sleep(int seconds) 
	{
	    try {
	        Thread.sleep(seconds * 1000);
	    } catch (InterruptedException e) {

	    }
	}


	
	
}
