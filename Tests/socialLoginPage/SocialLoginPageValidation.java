package socialLoginPage;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseClass.BaseClass;

public class SocialLoginPageValidation extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Login Page Validation
	// Created by :Shakira
	// Created on :24 August 2016

	// ///////////////////////////////////////////////////////////////////////////////

	public SocialLoginPageValidation(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public SocialLoginPageValidation() {

	}

	public void validateSocialLoginPage() {
		testStepInfo("************************************** Login Page *****************************************");

		if (currentExecutionMachineName.equalsIgnoreCase("Wel_HP_Article")) {

			
			 validateFacebookLogin();
			 waitTime(10);
			 validateLinkedInLogin();
			 waitTime(10);
			 validateGoogleLogin();
			 waitTime(10);
			 validateYahooLogin();
			 
			 
			validateTwitterLogin();
			validateMicrosoftLogin();
			
		}
	}
	
	

	public void validateFacebookLogin() {
		testStepInfo("******************************** Facebook Login Page ************************************");
		try {
			
		//	mouseHoverOnElement();
			verifyLoginForm();
			boolean facebookBtn = elementPresent(OR.btn_Login_Page_Facebook);
			if (facebookBtn == true) {
				clickOn(OR.btn_Login_Page_Facebook);

				
				String winHandleBefore = getCurrentWindowHandle();
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);

				}

				typeIn(OR.txt_Login_Page_Facebook_Email,retrieve("txtFBEmail"));
				typeIn(OR.txt_Login_Page_Facebook_Password,retrieve("txtFBPassword"));
				clickOn(OR.btn_Login_Page_Facebook_Login);

				waitTime(8);
				driver.switchTo().window(winHandleBefore);
				boolean user = elementPresent(OR.txt_Login_Page_User_Link);
				if (user == true) {
					String userName = getText(OR.txt_Login_Page_User_Link);
					testStepPassed("Logged into this user-" + userName);
					clickOn(OR.txt_Login_Page_Facebook_Logout);
					testStepPassed("Facebook Login verified Successfully");
					
				} else {
					testStepFailed("Invalid User name And Password");

					/*boolean fbErrorMsg = elementPresent(OR.txt_Login_Page_Facebook_Error_Message);
					if (fbErrorMsg == true) {
						String errorMsg = getText(OR.txt_Login_Page_Facebook_Error_Message);
						testStepPassed(errorMsg);
						testStepFailed("Invalid User name And Password");
						clickOn(OR.btn_Login_Page_Facebook_Cancel);
						waitTime(2);
						clickOn(OR.btn_Login_Page_Close);
						// driver.switchTo().window(winHandleBefore);
						testStepFailed("Redirected to Home Page");
					}*/

				}
			}

			else {
				testStepFailed("Facebook is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateGoogleLogin() {
		testStepInfo("******************************** Google Login Page ************************************");
		verifyLoginForm();
		try {
			waitTime(5);
			boolean googleBtn = elementPresent(OR.btn_Login_Page_Google);
			if (googleBtn == true) {
				clickOn(OR.btn_Login_Page_Google);

				String winHandleBefore = getCurrentWindowHandle();
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);

				}

				typeIn(OR.txt_Login_Page_Google_Email, retrieve("txtGoogleEmail"));
				clickOn(OR.btn_Login_Page_Google_Submit);

				typeIn(OR.txt_Login_Page_Google_Password,retrieve("txtGooglePassword"));
				clickOn(OR.btn_Login_Page_Google_Signin);
				waitTime(8);

				driver.switchTo().window(winHandleBefore);
				boolean user = elementPresent(OR.txt_Login_Page_User_Link);
				if (user == true) {
					String userName = getText(OR.txt_Login_Page_User_Link);
					testStepPassed("Logged into this user-" + userName);
					clickOn(OR.txt_Login_Page_Facebook_Logout);
					testStepPassed("Gmail Login verified Successfully");
				} else {
					testStepFailed("Failed to Login");
				}

			} else {
				testStepFailed("Google is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateTwitterLogin() {
		
		try {
			testStepInfo("******************************** Twitter Login Page ************************************");
			verifyLoginForm();
			boolean twitterBtn = elementPresent(OR.btn_Login_Page_Twitter);
			if (twitterBtn == true) {
				clickOn(OR.btn_Login_Page_Twitter);
			
				String winHandleBefore = getCurrentWindowHandle();
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);

				}
				/*refreshPage();
				waitTime(10);
				WebElement textbox = driver.findElement(By.id("username_or_email"));
				((JavascriptExecutor) driver).executeScript("arguments[0].enabled = true", textbox); */
				//clickOn(OR.txt_Login_Page_Twitter_User_Name);
				
				//typeIn(OR.txt_Login_Page_Twitter_User_Name, retrieve("txtTwitterEmail"));
				driver.findElement(By.id("username_or_email")).sendKeys("testingtwitter08@gmail.com");
				typeIn(OR.txt_Login_Page_Twitter_Password, retrieve("txtTwitterPassword"));
			
				clickOn(OR.btn_Login_Page_Twittern_Login);

				waitTime(3);

				driver.switchTo().window(winHandleBefore);
				boolean user = elementPresent(OR.txt_Login_Page_User_Link);
				if (user == true) {
					String userName = getText(OR.txt_Login_Page_User_Link);
					testStepPassed("Logged into this user-" + userName);
					clickOn(OR.txt_Login_Page_Facebook_Logout);
					testStepPassed("Twitter Login verified Successfully");
				} else {
					testStepFailed("Failed to Login");
				}

			} else {
				testStepFailed("Twitter Button is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateLinkedInLogin() {
		testStepInfo("******************************** LinkedIn Login Page ************************************");
		try {
			verifyLoginForm();
			waitTime(5);
			boolean linkedInBtn = elementPresent(OR.btn_Login_Page_LinkedIn);
			if (linkedInBtn == true) {
				clickOn(OR.btn_Login_Page_LinkedIn);

				String winHandleBefore = getCurrentWindowHandle();
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);

				}

				typeIn(OR.txt_Login_Page_LinkedIn_User_Name,retrieve("txtLinkedInEmail"));

				typeIn(OR.txt_Login_Page_LinkedIn_Password, retrieve("txtLinkedInPassword"));
				clickOn(OR.btn_Login_Page_LinkedIn_Authorize);
				waitTime(8);

				driver.switchTo().window(winHandleBefore);
				boolean user = elementPresent(OR.txt_Login_Page_User_Link);
				if (user == true) {
					String userName = getText(OR.txt_Login_Page_User_Link);
					testStepPassed("Logged into this user-" + userName);
					clickOn(OR.txt_Login_Page_Facebook_Logout);
					testStepPassed("LinkedIn Login verified Successfully");
				} else {
					testStepFailed("Failed to Login");
				}

			} else {
				testStepFailed("LinkedIn Button is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	public void validateYahooLogin() {
		testStepInfo("******************************** Yahoo Login Page ************************************");
		verifyLoginForm();
		try {
			waitTime(5);
			boolean googleBtn = elementPresent(OR.btn_Login_Page_Yahoo);
			if (googleBtn == true) {
				clickOn(OR.btn_Login_Page_Yahoo);

				String winHandleBefore = getCurrentWindowHandle();
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);

				}

				typeIn(OR.txt_Login_Page_Yahoo_User_Name, retrieve("txtYahooEmail"));
				clickOn(OR.btn_Login_Page_Yahoo_SignIn);
				waitTime(8);
				clickOn(OR.txt_Login_Page_Yahoo_User_Password);
				
				WebElement textbox = driver.findElement(By.id("login-passwd"));
				((JavascriptExecutor) driver).executeScript("arguments[0].enabled = true", textbox); 
				
				typeIn(OR.txt_Login_Page_Yahoo_User_Password,retrieve("txtYahooPassword"));
				//driver.findElement(By.xpath("//input[@name='passwd'")).sendKeys("Forbes123");
				clickOn(OR.btn_Login_Page_Yahoo_SignIn);
				waitTime(8);

				boolean agree=elementPresent(OR.btn_Login_Page_Yahoo_Agree);
				if(agree==true)
				{
					clickOn(OR.btn_Login_Page_Yahoo_Agree);
					
				}
				else
				{
					testStepInfo("Agree button is not displayed");
				}
				
				driver.switchTo().window(winHandleBefore);
				boolean user = elementPresent(OR.txt_Login_Page_User_Link);
				if (user == true) {
					String userName = getText(OR.txt_Login_Page_User_Link);
					testStepPassed("Logged into this user-" + userName);
					clickOn(OR.txt_Login_Page_Facebook_Logout);
					testStepPassed("Yahoo Login verified Successfully");
				} else {
					testStepFailed("Failed to Login");
				}

			} else {
				testStepFailed("Yahoo Button is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}


	public void validateMicrosoftLogin() {
		testStepInfo("******************************** Microsoft Login Page ************************************");
		try {
			verifyLoginForm();
			waitTime(5);
			boolean linkedInBtn = elementPresent(OR.btn_Login_Page_Microsoft);
			if (linkedInBtn == true) {
				clickOn(OR.btn_Login_Page_Microsoft);

				String winHandleBefore = getCurrentWindowHandle();
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);

				}
			/*	clickOn(OR.txt_Login_Page_Microsoft_UserName);
				
				WebElement textbox = driver.findElement(By.id("i0116"));
				((JavascriptExecutor) driver).executeScript("arguments[0].enabled = true", textbox); */

				
				driver.findElement(By.xpath("//input[@name='loginfmt']")).sendKeys("testingforbes@gmail.com");
				/*typeIn(OR.txt_Login_Page_Microsoft_UserName,retrieve("txtMicrosoftEmail"));*/
				System.out.println(retrieve("txtMicrosoftEmail"));
				
				//waitTime(7);
				typeIn(OR.txt_Login_Page_Microsoft_Password, retrieve("txtMicrosoftPassword"));
				clickOn(OR.btn_Login_Page_Microsoft_Signin);
				waitTime(8);

				driver.switchTo().window(winHandleBefore);
				boolean user = elementPresent(OR.txt_Login_Page_User_Link);
				if (user == true) {
					String userName = getText(OR.txt_Login_Page_User_Link);
					testStepPassed("Logged into this user-" + userName);
					clickOn(OR.txt_Login_Page_Facebook_Logout);
					testStepPassed("Microsoft Login verified Successfully");
				} else {
					testStepFailed("Failed to Login");
				}

			} else {
				testStepFailed("Microsoft Button is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
}
