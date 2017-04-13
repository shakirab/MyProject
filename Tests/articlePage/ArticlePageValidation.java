/**
 * Validate Author info & image
 * Article Ads
 * Social sharing

 */
package articlePage;


import java.util.ArrayList;
import java.util.List;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * class names are written in mixed case with the first letter of each internal
 * word capitalized.
 */
public class ArticlePageValidation extends ApplicationKeywords {

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Article Page Validation
	// Created by :Shakira
	// Created on :9 June 2016

	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Instantiates a new article page validation.
	 *
	 * @param obj
	 *            the obj
	 */
	public ArticlePageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
	}

	/**
	 * Verify ads in article page. methods are written in mixed case with the
	 */
	public void validateArticlePage() {

		String articleText = null;

		try {

			if (currentExecutionMachineName.equalsIgnoreCase("Wel_HP_Article_LvlUp")) {

				// clickOn(OR.txt_Home_User_Zone_US);
				
				
				waitTime(5);
				boolean topStory=elementPresent(OR.txt_Home_Page_Top_Stories1);
				if(topStory==true)
				{
					
				int pageViewCounts=openArticleLinksInWindow(OR.txt_Home_Page_Top_Stories1,OR.txt_Article_Page_View_Count);
				driver.manage().deleteAllCookies();
				String getUrl=getAttributeValue(OR.txt_Home_Page_Top_Stories1, "href");
				testStepPassed("Article Page Url is "+getUrl);
				
				String articlePageUrl=getUrl.concat("?view=prod");
				String articlePageUrl1=articlePageUrl.concat("?nowelcome");
				//clickOnMainArticle();
				
				validatePageLoadTime(articlePageUrl1, 23,"Article Page");
				driver.get(articlePageUrl1);
				waitTime(8);
				refreshPage();
				int viewCounts=0;
				boolean pageView=elementPresent(OR.txt_Article_Page_View_Count);
				if(pageView==true)
				{
				String pageViewCount=getText(OR.txt_Article_Page_View_Count);
				String replaceComma=pageViewCount.replace(",","");
				//testStepPassed(replaceComma);
				  viewCounts=Integer.parseInt(replaceComma);
				
				
				testStepPassed("Second Time View Count is "+viewCounts);
				}
				else
				{
					testStepFailed("Page View Count is not Displayed");
				}
				
				if(viewCounts>pageViewCounts)
				{
					testStepPassed("Page View Count is Increased");
				}
				else
				{
					getCurrentPageURL();
					testStepFailed("Page View Count is not Increased");
				}		
				validateAuthorName(OR.txt_Article_Page_Author_Name);
				
				validateAuthorDetailsForDesktop();
				validateSocialnetworks(OR.img_Reg_Article_Page_Social_Shares);
				//validateLeftStreamArticle(OR.txt_Reg_Article_Page_LeftRailArticle);
				validateLeftStreamArticle();
				validateLeftRailArticleNavigation(
						OR.txt_Reg_Home_Page_HeadLine_Article,
						OR.txt_Reg_Article_Page_LeftRail_Article_Heading);
				validateHashTag(OR.txt_Reg_Article_Page_HashTag);
				validateAdOnLeftRail();
				validateFeaturedImage(OR.img_Reg_Article_Page_Featured_Image);;
				validateTopImage();
			
				
				validateFullBio();
				clickOn(OR.btn_Reg_Article_Page_Close);
				validateGallery(OR.txt_Reg_Article_Page_Gallery,OR.txt_Reg_Article_Page_Gallery_Name);
				validateMidOfArticleVideo();
				validateTopAds(OR.ads_Article_Page_Top_Ads);
				verifyAdsInArticle();
				validateRecommended();
				validatePrintBar();

				validateComments();
				validateSeeAlso();
				validateRevContent(OR.txt_Article_Page_RevContent_Desk);
				validateFromTheWeb();
				//validateLoadMoreNextArticle();
				validateArticleByScroll();
				}
				else
				{
					testStepFailed("Promo Section is not displayed");
				}
			 
			}
			else 
			{
				waitTime(5);
				waitForText("Top Stories");
				
				boolean promoSection=elementPresent(OR.txt_Mob_Home_Page_Top_Stories);
				if(promoSection==true)
				{
				String getUrl=getAttributeValue(OR.txt_Mob_Home_Page_Top_Stories, "href");
				testStepPassed("Article Page Url is "+getUrl);
				
				validatePageLoadTime(getUrl, 23, "Article Page");
				
				//clickOnMainArticle();
				ValidateHashTagInMobile();
				validateSocialShare();
				
				validateAuthorDetailsForMobile();
				//verifyeFullBioInArticlePage();
				validateAuthorName(OR.txt_Mob_Article_Page_Author_Name);
				
				validateFullBio();
				scrollBy(0, 400);
				clickOn(OR.btn_Mob_Article_Page_Full_Bio);
				verifyAdsInMobileArticle();
				validateRecommendedLabel();
				scrollBy(0, 2000);
				waitTime(3);
				scrollBy(0, 700);
				validateCommentsInMobile();
				validatePrintBar();
				validateFromWebInMobile();
				validateAdStream();
				validateRelatedTopics(OR.txt_Article_Page_Related_Topics);
				
				
				validateRevContent(OR.txt_Article_Page_RevContent);
				//validateRevContentInMobile();
				this.scrollToElement(OR.txt_Article_Page_Next_Article);
				this.scrollBy(0, -60);
				articleText = getText(OR.txt_Article_Page_Next_Article);
				clickOn(OR.txt_Article_Page_Next_Article);
				testStepPassed("Article Text: "
						+ getText(OR.txt_Article_Page_Article_Header));
				verifyPageShouldContainText(articleText);
				}
				else
				{
					testStepFailed("Promo Section is not Displayed");
				}
				
				
			}

		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}


	
	
	public void validateLeftStreamArticle()
	{
		testStepInfo("******************************* Left Rail Stream Article ****************************************");
		try {
			//int count=getElementCount(OR.txt_Reg_Article_Page_LeftRailArticle);
			
			List<WebElement> allArticle=driver.findElements(By.cssSelector("li .headline.ng-isolate-scope .ng-binding.ng-scope"));
			int sizeArticles=allArticle.size();
			
			testStepPassed("Total Number of Left Rail Article-----"+sizeArticles);
			for (int i = 1; i <=sizeArticles; i++) {
				String getArticle=allArticle.get(i).getText();
				testStepPassed("Leftrail Article---"+getArticle);
				/*String getLeftRailArticles=getText("LeftRail Articles#cssselector=li:nth-of-type("+i+") .headline.ng-isolate-scope .ng-binding.ng-scope");
				testStepPassed("Leftrail article --- "+i+"-"+getLeftRailArticles);*/
				scrollBy(0, 80);
			}
			
			/*int count=getElementCount(OR.txt_Reg_Article_Page_LeftRailArticle);
			testStepPassed("Total----"+count);
			for (int i = 1; i <=count; i++) {
				String getLeftRailArticles=getText("LeftRail Articles#cssselector=li:nth-of-type("+i+") .headline.ng-isolate-scope .ng-binding.ng-scope");
				testStepPassed("Leftrail article --- "+i+"-"+getLeftRailArticles);	
			}*/
			/*if(sizeArticles>=10)
			{
				testStepPassed("Left Rail Article Stream is Present");
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("Left Rail Article Stream is not Present");
			}*/
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	
		

	

	

	
	
	//***********************************************************************************

	
	
	

	
	/**
	 * Validate from the web.
	 */
	public void validateFromTheWeb() {
		testStepInfo("******************************* Article Speed Bump Wrapper ****************************************");
		try {
			boolean fromTheWeb = elementPresent(OR.txt_Reg_Article_Page_From_Web);
			if (fromTheWeb == true) {
				int countSpeedBump = getElementCount(OR.txt_Reg_Article_Page_From_Web);
				for (int i = 1; i <= countSpeedBump; i++) {
					String speedBump = "Speed Bump#xpath=//article[@id='article-container-0']//div[@id='rc-row-container']//div[@class='rc-item']["
							+ i + "]//div[@class='rc-content']";
					String getSpeedBump = getText(speedBump);
					testStepPassed(getSpeedBump);
				}
				testStepPassed("Article Speed Bump Wrapper is Displayed -"
						+ countSpeedBump);
			} else {
				getCurrentPageURL();
				testStepFailed("Article Speed Bump Wrapper is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	//Mobile 
	
	
	



	


/*
	

	*//**
	 * Validate full bio filter.
	 *//*
	public void validateFullBioFilter() {
		testStepInfo("******************************* Full Bio Filter****************************************");
		boolean fullBioFilter = elementPresent(OR.tab_Reg_Article_Page_FullBio_Filter);
		if (fullBioFilter == true) {
			int count = getElementCount(OR.tab_Reg_Article_Page_FullBio_Filter);
			for (int i = 1; i <= count; i++) {
				String getFullBioTab = "Full Bio Filter#xpath=//div[@class='masked-content']//nav//li["
						+ i + "]";
				if (i == 2) {
					clickOn(getFullBioTab);
					int countRecent = getElementCount(OR.txt_Reg_Article_Page_Recent_Posts);
					for (int j = 1; j <= countRecent; j++) {
						String recentPosts = "Recent Posts#xpath=//ul[@id='authorMostRecent']//li["
								+ j + "]//a";
						String getRecent = getText(recentPosts);
						testStepPassed(getRecent);
					}

				} else if (i == 3) {
					clickOn(getFullBioTab);
					int countRecent = getElementCount(OR.txt_Reg_Article_Page_Popular_Posts);
					for (int j = 1; j <= countRecent; j++) {
						String popularPosts = "Popular Posts#xpath=//ul[@id='authorMostPopular']//li["
								+ j + "]//a";
						String getPopular = getText(popularPosts);
						testStepPassed(getPopular);
					}
					String getPopularPost = getText(getFullBioTab);
					testStepPassed(getPopularPost);
				}

			}
		}
	}

	

	




	


	
	



	*//**
	 * Verify ads in desktop article.
	 *//*
	public void verifyAdsInDesktopArticle() {
		int topAdArticleNo = 0;
		int adRailArticleNo = 0;
		for (int i = 0; i <= 15; i++) {

			if (driver.getPageSource().contains(
					"top-ad-article-" + topAdArticleNo)
					|| driver.getPageSource().contains(
							"ad-rail-article-" + adRailArticleNo)) {
				if (driver.getPageSource().contains(
						"top-ad-article-" + topAdArticleNo)
						&& driver.getPageSource().contains(
								"ad-rail-article-" + adRailArticleNo)) {
					testStepPassed("Top Ad");
					takeAdScreenshot("Ad " + topAdArticleNo
							+ "#id=top-ad-article-" + topAdArticleNo,
							"topAdArticleNo" + (topAdArticleNo + 1) + ","
									+ "SideAds" + (adRailArticleNo + 1));
					if (driver.getPageSource().contains(
							"ad-rail-article-" + adRailArticleNo)) {
						int railAdCount = driver
								.findElements(
										By.xpath("//*[@id='ad-rail-article-"
												+ adRailArticleNo
												+ "']/div[@ng-repeat-start='ad_unit in ad_units']"))
								.size();
						testStepPassed("Rail Ad Count: " + railAdCount);
						for (int j = 0; j < railAdCount; j++) {
							takeAdScreenshot(
									driver.findElements(
											By.xpath("//*[@id='ad-rail-article-"
													+ adRailArticleNo
													+ "']/div[@ng-repeat-start='ad_unit in ad_units']"))
											.get(j), "SideAds"
											+ (adRailArticleNo + 1));
						}
					}
					topAdArticleNo++;
					adRailArticleNo++;
				} else if (driver.getPageSource().contains(
						"top-ad-article-" + topAdArticleNo)) {
					takeAdScreenshot("Ad " + topAdArticleNo
							+ "#id=top-ad-article-" + topAdArticleNo,
							"topAdArticleNo" + (topAdArticleNo + 1));
					topAdArticleNo++;

				}

			} else {
				((JavascriptExecutor) driver)
						.executeScript("window.scrollBy(0,100)");
			}
		}

	}

	// Start Date : 21 June 2016

	*//**
	 * Verifye full bio in article page.
	 *//*
	public void verifyeFullBioInArticlePage() {
		testStepInfo("************************************************** Full Bio  ****************************************************");
		try {
			boolean fullBio = elementPresent(OR.btn_Mob_Article_Page_Full_Bio);
			if (fullBio == true) {
				clickOn(OR.btn_Mob_Article_Page_Full_Bio);
				String fullBioDetails = getText(OR.txt_Mob_Article_Page_Full_Bio_Details);
				testStepPassed(fullBioDetails);
				scrollBy(0, 250);
				// scrollToElement(OR.btn_Mob_Article_Page_Full_Bio);
				validateFollowOnForbes(OR.txt_Reg_Article_Page_Follow_OnForbes);
				clickOn(OR.btn_Mob_Article_Page_Full_Bio);
			} else {
				testStepFailed("Full Bio is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	*/
	

	
	
	
	
}
