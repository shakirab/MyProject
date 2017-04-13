/**
 * Check the ads on the page 
 * Check Market to form display
 * Trending Stories display
 * Most Read Stories display
 * Active on Social Web 
 * Popular Galleries
 * Active Converstation
 * Inside Forbes 

 */

package mostPopularPage;


import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

// TODO: Auto-generated Javadoc
/**
 * The Class MostPopularPageValidation.
 * class names are written in mixed case with the first letter of each internal word capitalized
 */
public class MostPopularPageValidation extends ApplicationKeywords {

	

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Most Popular Page Validation
	// Created by :Shakira
	// Created on :13 June 2016
	
	/**
	 * Instantiates a new most popular page validation.
	 *
	 * @param obj the obj
	 */
	// ///////////////////////////////////////////////////////////////////////////////
	public MostPopularPageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
	}

	/**
	 * Verify most popular page.
	 * Methods are written in mixed case with the
	 * first letter lower case, with the first letter of each internal word
	 * capitalized.
	 * variables are written in mixed case with the first letter lower case, with the first letter of each internal word capitalized.
	 *
	 * @throws Exception the exception
	 */
	public void verifyMostPopularPage() throws Exception {
		testStepInfo("************************************MOST POPULAR PAGE******************************************");
		//waitTime(10);
		if (currentExecutionMachineName.equalsIgnoreCase("NP_MP_Gallery"))
		{
			validatePageLoadTime("http://www.forbes.com/most-popular/stats/",15,"Most Popular Page");
			
			validateEmailPromo();
			validateSocialnetworks(OR.img_Reg_Most_Popular_SocialNetwork);
			//validateSocialconnect();
			scrollBy(0, 500);
			scrollBy(0, -200);
			validateTopForbesWriter();
			validateDropDownForbesWriter();
			validateDropDownTrendingStories();
			validateMostRead();
			verifySocialWeb();
		
			waitTime(3);
			validateMostPopularGallery();
			verifyRealTimeAds();
			validateTrendingStories();
			

			validateInsideForbes();
			validateYouMayAlsoLike();
			validateActiveConversation();
		}
		else
		{
			validatePageLoadTime("http://www.forbes.com/most-popular/stats/",9,"Most Popular Page");
			waitTime(3);
			verifyBottomAdsInMobile();
			verifyTopForbesWriterInMobile();
			verifySocialslidersInMobile();
			verifyRelatedTopicsInMob();
			verifyMostReadOnForbesInMobile();
			verifySwitchToFullWebsiteInMobile();
			//validatePopularGalleries();
			
		}

	}
	
	public void validateActiveConversation()
	{
		testStepInfo("********************************* Active Conversation **************************************");
		try {
			boolean activeCon=elementPresent(OR.txt_Reg_Most_Popular_ActiveConversation);
			if(activeCon==true)
			{
				int count=getElementCount(OR.txt_Reg_Most_Popular_ActiveConv);
				testStepPassed("Total Active conversation links are - "+count);
				testStepPassed("Active Conversation section is present");
			}
			else
			{
				testStepInfo("Active Conversation is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	
	public void validateYouMayAlsoLike()
	{
		testStepInfo("********************************* You May Also Like **************************************");
		try {
			//scrollBy(0, 100);
			this.scrollToElement(OR.txt_Reg_Most_Popular_YouMayAlsoLike);
			this.scrollBy(0, -60);
			boolean youmayAlsoLike=elementPresent(OR.txt_Reg_Most_Popular_YouMayAlsoLike);
			if(youmayAlsoLike==true)
			{
				testStepPassed("You May Also Like is displayed");
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("You May Also Like is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateMostPopularGallery()
	{
		testStepInfo("********************************* Most Popular Gallery **************************************");
		try {
			
			boolean gallery=elementPresent(OR.txt_Reg_MostPopular_Gallery);
			if(gallery==true)
			{
				int galleryCount=getElementCount(OR.txt_Reg_MostPopular_Gallery);
				for (int i = 1; i <=1; i++) {
					verifyArticleTextsInNewtab("Gallery#xpath=//section[@class='top_galleries']//ul//li["+i+"]//a//h5", "Gallery#xpath=//section[@class='top_galleries']//ul//li["+i+"]//a//h5", OR.txt_Reg_New_Posts_Gallery_Title);
				}
			}
			else
			{
				testStepFailed("Most Popular Gallery is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	public void validateMostRead()
	{
		testStepInfo("********************************* Most Read **************************************");
		try {
			boolean mostRead=elementPresent(OR.txt_Most_Popular_Page_Most_Read);
			if(mostRead==true)
			{
				int count=getElementCount(OR.txt_Most_Popular_Page_Most_Read);
				for (int i =1; i <=1; i++) {
					
					verifyArticleTextsInNewtab("Most Read#xpath=//section[@class='most_read']//ol//li["+i+"]//a", "Most Read#xpath=//section[@class='most_read']//ol//li["+i+"]//a", OR.txt_Reg_Home_Page_HeadLine_Article);
				}
			}
			else
			{
				testStepFailed("Most Read Links are not Loaded Properly");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateDropDownTrendingStories()
	{
		try {
			boolean drpForbesStories=elementPresent(OR.sel_Reg_MostPopular_TrendingStories);
			if(drpForbesStories==true)
			{
				int count=getElementCount(OR.opt_Reg_MostPopular_TrendingStories);
				testStepPassed("Total Options Present in the Trending Stories -"+count);
				for (int i = 0; i <count; i++) {
					
					testStepPassed("Trending Stories options are Displayed");
				}
				
				
			}
			else
			{
				testStepFailed("Top forbes writer Select box is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	public void validateDropDownForbesWriter()
	{
		
		try {
			boolean drpForbesWriter=elementPresent(OR.sel_Reg_MostPopular_TopForbesWriter);
			if(drpForbesWriter==true)
			{
				int count=getElementCount(OR.opt_Reg_MostPopular_TopForbesWriter);
				testStepPassed("Total Options Present in the Top Forbes Writer -"+count);
				for (int i = 0; i <count; i++) {
					testStepPassed("Top Forbes Writers options are Displayed");
				}
				
				
			}
			else
			{
				testStepFailed("Top forbes writer Select box is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	public void validateTopForbesWriter()
	{
		testStepInfo("********************************* Top Forbes Writer **************************************");
		try {
			boolean topForbesWriter=elementPresent(OR.img_Reg_MostPopular_Leaderboard);
			if(topForbesWriter==true)
			{
				testStepPassed("Top Forbes Writers are Displayed");
				/*int count=getElementCount(OR.img_Reg_MostPopular_Leaderboard);
				for (int i = 1; i <=count; i++) {
					String leaderBoard="LeaderBoard#xpath=//form[@action='/most-popular/get-contributor-leaderboard/']//ul//li["+i+"]//a//img";
					mouseOver(leaderBoard);
					waitTime(5);
					boolean writerDetail=elementPresent(OR.txt_Reg_MostPopular_Writer_Detail);
					if(writerDetail==true)
					{
						waitTime(3);
						String getWriterDetails=getText(OR.txt_Reg_MostPopular_Writer_Detail);
						testStepPassed(getWriterDetails);
					}
					else
					{
						testStepFailed("Writer Details not displayed");
					}
				}*/
			}
			else
			{
				testStepFailed("Top Forbes Writers are not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	

	/**
	 * Validate gallery.
	 *
	 * @throws Exception the exception
	 */
	public void validateTrendingStories()throws Exception {
		testStepInfo("*************************************** Trending Stories **************************");
		try {
			scrollToElement(OR.txt_Most_Popular_links_TrendingStories);
			scrollBy(0, -60);
			boolean mostPopular=elementPresent(OR.txt_Most_Popular_links_TrendingStories);
			if (mostPopular==true) {
				int mostPopularLink=getElementCount(OR.txt_Most_Popular_links_TrendingStories);
				testStepPassed(""+mostPopularLink);
				for (int i = 1; i <=1; i++) 
				{
					verifyArticleTextsInNewtab("TreandingStories#xpath=//div[@class='stories_wrapper']//ol[@class='all']//li["+i+"]//a", "TreandingStories#xpath=//div[@class='stories_wrapper']//ol[@class='all']//li["+i+"]//a", OR.txt_Reg_Home_Page_HeadLine_Article);
				
				//	String getAllMostPopularLinks="TreandingStories#xpath=//div[@class='stories_wrapper']//ol[@class='all']//li["+i+"]//a"
				}
			}
			else
			{
			testStepFailed("Recently posted Most Popular are not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	

	}

	

	/**
	 * Gets the most popular article text.
	 *
	 * @return the most popular article text
	 */
	public String getMostPopularArticleText() {
		String strXpath = "Most Popular Article heading#xpath=//div[@class='stories_wrapper']//ol[@class='all']/li//a";
		return this.getText(strXpath);
	}

	/**
	 * Click on most popular article.
	 */
	Actions actions = new Actions(driver);

	/**
	 * Click on most popular article.
	 */
	public void clickOnMostPopularArticle() {
		String strXpath = "Most Popular Article #xpath=//div[@class='stories_wrapper']//ol[@class='all']/li//a";
		this.clickOn(strXpath);
	}

	/**
	 * Gets the contributor details.
	 *
	 * @return the contributor details
	 */
	public void getContributorDetails() {
		testStepInfo("************************Contributor Avatars**********************************");
		waitTime(2);
		int authorCount = getElementCount(OR.txt_Most_Popular_Page_Author);
		testStepPassed("Total Authors/contributors" + authorCount);
		waitTime(2);

		WebElement menu = driver
				.findElement(By
						.xpath("//section[@class='top_writers']//form//div[@class='leaderboard_holder']//ul//li//a"));
		actions.moveToElement(menu).perform();

		waitTime(2);
		String contributorDetails = getText(OR.txt_Most_Popular_Page_Contributor_Details);
		testStepPassed("Contributor Details---" + contributorDetails);
	}

	

/**
 * Mobile Script
 * Created On : 22 June 2016.
 */
	public void verifySocialslidersInMobile() {
		testStepInfo(" ************************* Social Web ***************");
		try {
			this.scrollToElement(OR.img_Most_Popular_FacebookIcon);
			this.scrollBy(0, -60);
			boolean checkFacebook = elementPresent(OR.img_Most_Popular_FacebookIcon);
			if (checkFacebook == true) {
				clickOn(OR.img_Most_Popular_FacebookIcon);

				boolean facebookLinks = elementPresent(OR.txt_Most_Popular_FacebookLists);
				if (facebookLinks == true) {
					int facebookCount = getElementCount(OR.txt_Most_Popular_FacebookLists);
					testStepPassed("Total Links Present on Facebook--"
							+ facebookCount);
					String facebook = getText(OR.txt_Most_Popular_FacebookLists);
					testStepPassed(facebook);
					testStepPassed("Facebook links are displayed");
				} else {
					testStepFailed("Facebook links are not displayed");
				}

			} else {
				testStepFailed("Facebook Tab is not displayed");
			}

			boolean checkTwitter = elementPresent(OR.img_Most_Popular_TwitterIcon);
			if (checkTwitter == true) {
				clickOn(OR.img_Most_Popular_TwitterIcon);
				boolean twitterLinks = elementPresent(OR.txt_Most_Popular_TwitterLists);
				if (twitterLinks == true) {
					int twitterCount = getElementCount(OR.txt_Most_Popular_TwitterLists);
					testStepPassed("Total Links Present on Twitter--"
							+ twitterCount);
					String twitter = getText(OR.txt_Most_Popular_TwitterLists);
					testStepPassed(twitter);
					testStepPassed("Twitter Links are displayed");
				} else {
					testStepFailed("Twitter links are not displayed");
				}

			} else {
				testStepFailed("Twitter Tab is not displayed");
			}
			
			boolean checkLinkedIn = elementPresent(OR.img_Most_Popular_LinkedInIcon);
			if (checkLinkedIn == true) {
				clickOn(OR.img_Most_Popular_LinkedInIcon);
				boolean linkedInLinks = elementPresent(OR.txt_Most_Popular_LinkedInLists);
				if (linkedInLinks == true) {
					int linkedInCount = getElementCount(OR.txt_Most_Popular_LinkedInLists);
					testStepPassed("Total Links Present on LinkedIn--"
							+ linkedInCount);
					String linkedIn = getText(OR.txt_Most_Popular_LinkedInLists);
					testStepPassed(linkedIn);
					testStepPassed("LinkedIn links are displayed");

				} else {
					testStepFailed("LinkedIn links are not Displayed");
				}

			} else {
				testStepFailed("LinkedIn tab is not displayed");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}


	
	/**
	 * Validate popular galleries.
	 */
	public void validatePopularGalleries()
	{
		testStepInfo("*************************** Popular Gallery ******************************************");
		try {
			scrollBy(0, -650);
			boolean gallery=elementPresent(OR.btn_Mob_Most_Popular_Page_Galleries);
			
			//waitTime(10);
			if(gallery==true)
			{
				waitTime(3);
				
				
				//swipeToLeft();
				waitTime(3);
			testStepPassed("Popular Galleries is swipped");
			}
			else
			{
				testStepFailed("Popular Galleries can not be swipped");
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	


	/**
	 * Verify switch to full website in mobile.
	 */
	public void verifySwitchToFullWebsiteInMobile()
	{
		testStepInfo("*************************** Switch To Full Website ******************************************");
		scrollBy(0, 150);
		boolean switchToFullWeb=elementPresent(OR.txt_Mob_Most_Popular_Switch_Full_Website);
		if (switchToFullWeb==true) 
		{
			testStepPassed("Switch to full website is displayed");
		}
		else
		{
			testStepFailed("Switch to full website is not displayed");
		}
	}
	
	/**
	 * Author : Shakira
	 * Created On : 23 June 2016.
	 */
	
	public void verifyTopForbesWriterInMobile()
	{
		testStepInfo("*************************** Top Forbes Writers ******************************************");
		scrollBy(0, 500);
		scrollToElement(OR.img_Mob_Most_Popular_Top_Forbes_Writers);
		boolean topForbesWriters=elementPresent(OR.img_Mob_Most_Popular_Top_Forbes_Writers);
		if(topForbesWriters==true)
		{
		String writersDetails=getText(OR.txt_Mob_Most_Popular_Top_Forbes_Writers_Details);
		testStepPassed(writersDetails);
		testStepPassed("Top Forbes Writers label is displayed");
		}
		else
		{
			testStepFailed("Top Forbes Writers label is not displayed");
		}
	}

	
}
