/**
 * Check Contributor Home page
 * Check on Contributor Image & Name
 * Click on Follow button
 * Click on Full Bio
 * Click on Show More

 */

package contributorPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import iSAFE.ApplicationKeywords;


import objectsRepository.OR;


import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class ContributorPageValidation.
  */
public class ContributorPageValidation extends ApplicationKeywords {

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Contributor Page Validation
	// Created by :Shakira
	// Created on :6 June 2016

	// ///////////////////////////////////////////////////////////////////////////////
	/** The obj. */
	BaseClass obj;

	/**
	 * Instantiates a new contributor page validation.
	 *
	 * @param obj the obj
	 */
	public ContributorPageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	
	/**
	 * Instantiates a new contributor page validation.
	 */
	public ContributorPageValidation() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * Validate contributor page.
	 */
	public void validateContributorPage() {
		testStepInfo("************************************************** Contributor Page ****************************************************");
		if (currentExecutionMachineName.equalsIgnoreCase("Cont_BV"))
		{
			//clickOn(OR.txt_Home_User_Zone_US);
			/*clickOnMainArticle();
			
			clickOn(OR.img_Article_Page_Contributor);
			verifyAuthorName();
			clickOnBackButton();
			clickOn(OR.txt_Article_Page_Author_Name);
			verifyAuthorName();	*/	
			
			boolean articleLink=elementPresent(OR.txt_Home_Page_Top_Stories1);
			if(articleLink==true)
			{
				clickOn(OR.txt_Home_Page_Top_Stories1);
				boolean authorName=elementPresent(OR.txt_Article_Page_Author_Name);
				if(authorName==true)
				{
				String getUrl=getAttributeValue(OR.txt_Article_Page_Author_Name, "href");
				//String appendedURL=getUrl.concat("?view=csf_contrib");
				testStepPassed("Contributor Page Url is -"+getUrl);
				
				validatePageLoadTime(getUrl, 14, "Contributor Page");
				
			//driver.get("http://www.forbes.com/sites/lewisdvorkin/?view=csf_contrib");
			verifyAuthorName();
			//validateContributorImage(OR.img_Reg_Contributor_Page_Image);
			validatecontributorDetails(OR.img_Reg_Contributor_Page_Image,OR.txt_Reg_Contributor_Page_TypeOFContributor,"Individual");
			validateSocialnetworks(OR.img_Reg_contributor_Page_SocialShares);
			
			validateTagLine(OR.txt_Reg_Contributor_Page_TagLine);
			verifyFullBio();
			
			verifyFollowInDeskyop(OR.btn_Contributor_Page_Follow);
			validateNetworkShares(OR.img_Reg_Contributor_Page_NetworkShares);
			validateTopAds(OR.ads_Reg_Contributor_Page_TopAds);
			validateRecAds(OR.ads_Reg_Contributor_Page_RecAds);
			validateRecAds(OR.ads_Reg_Contributor_Page_RecAds2);
			validateTopxAds(OR.ads_Reg_Contributor_Page_TopxAds);
			validatePromoVideoBlock();
			validateArchiveContributor();
			//validateLatestPostsImages();
			clickingAllLatestPosts();
			validateMostPopularArticles();
			
				}
				
		}
			else
			{
				testStepFailed("Top Stories First Link is not Displayed");
			}
		}
		else
		{
		
			waitTime(3);
			boolean mainArticle=elementPresent(OR.txt_Mob_Contributor_Page_Article);
			if(mainArticle==true)
			{
				
				
			clickOn(OR.txt_Mob_Contributor_Page_Article);
			verifyContributorDetailsInMobile();
			verifyAuthorNameInMobile();
			validatecontributorDetails(OR.img_Reg_Contributor_Page_Image,OR.txt_Reg_Contributor_Page_TypeOFContributor,"Individual");
			validateTagLine(OR.txt_Reg_Contributor_Page_TagLine);
			boolean shareButton=elementPresent(OR.btn_contributor_Page_ShareButton);
			if(shareButton==true)
			{
				clickOn(OR.btn_contributor_Page_ShareButton);
				validateSocialnetworks(OR.img_Reg_contributor_Page_SocialShares);
				clickOn(OR.btn_contributor_Page_ShareButton);
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("Share Button is not displayed");
			}
			
			verifyFollowInDeskyop(OR.btn_Contributor_Page_Follow);
			validateNetworkShares(OR.img_Reg_Contributor_Page_NetworkShares);
			validateTopAds(OR.ads_Welcome_Page_Ads);
			validateArchiveContributor();
			validateLatestPostsInMobile();
			validateRecAds(OR.ads_Podcasts_Page_TopAds);
			validateMostPopularArticlesInMobile();
			
			}
			else
			{
				testStepFailed("Main Article is not displayed");
			}
				
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public void validateArchive()
	{
		scrollBy(0, 100);	
		takeAdScreenshot(OR.button_Mob_BVPage_Validation_Archive,"Archive");
		waitForElement(OR.button_Mob_BVPage_Validation_Archive);
		boolean archive=elementPresent(OR.button_Mob_BVPage_Validation_Archive);
			if(archive==true)
			{
			clickOn(OR.button_Mob_BVPage_Validation_Archive);
			if(elementPresent(OR.txt_Mob_BVPage_Validation_ArchiveFirstlabel) && elementPresent(OR.txt_Mob_BVPage_Validation_ArchiveFirstlabelPostCount)){
				testStepPassed("BV Mobile Page validation: Archive List is displayed");
				clickOn(OR.button_Mob_BVPage_Validation_inactiveLatest);
			}
			else{
				testStepFailed("BV Mobile Page validation: Archive List is not displayed");
			}
		}
		else{
			testStepFailed("BV Mobile Page validation: Latest and Archive are not displayed on the page");
		}
	}
	
	public void validateMostPopularInMobile()
	{
		testStepInfo("************************************** Most Popular *******************************************");
		scrollBy(0, 600);
		boolean mostPopular=elementPresent(OR.txt_Contributor_Page_Most_Popular);
		if(mostPopular==true)
		{
			int count=getElementCount(OR.txt_Contributor_Page_Most_Popular);
			testStepPassed("Total number of Most Popular Links"+count);
			for (int i = 1; i <=count; i++) {
				
				String getMostPopular=getText("Most Popular#xpath=//div[@class='contrib-most-popular ng-scope']//ol//li["+i+"]//h3");
				testStepPassed("Most Popular Links are --->"+getMostPopular);
				clickOn(getMostPopular);
				
				validateHeadLineArticleInMobile();
				
			}
			validateShowMoreButton(OR.btn_contributor_Page_Show_More, "Most Popular");
		}
		else
		{
			testStepFailed("Most Popular Links are not displayed");
		}
		
	}

	public void validateShowMoreButton(String showMore,String sectionName)
	{
		try {
			boolean showMoreBtn=elementPresent(showMore);
			if(showMoreBtn==true)
			{
				testStepPassed("Show More Button is Present in"+sectionName);
			}
			else
			{
				testStepFailed("Show more button is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void valdateLatestPostsInMobile()
	{
		testStepInfo("******************************************** Latest Posts ************************************************");
		//scrollBy(0, 500);
		scrollBy(0, -100);
		boolean contributorLatestPosts=elementPresent(OR.txt_BVPage_Validation_BVPosts);
		if(contributorLatestPosts==true)
		{
			int countLatestPosts=getElementCount(OR.txt_BVPage_Validation_BVPosts);
			testStepPassed("Total Number of Latest Posts --->"+countLatestPosts);
			for (int i = 1; i <=countLatestPosts; i++) {
				
				
				if(getAttributeValue("#xpath=//ul[@class='common-stream articles edittools-stream']/li["+i+"]/div", "ng-switch-when").equals("blog")){
					testStepPassed("Validating Article post");
					scrollToElement("Latest Posts#xpath=//div[@ng-controller='ContribStreamController']//ul//li["+i+"]//h3");
					clickOn("Latest Posts#xpath=//div[@ng-controller='ContribStreamController']//ul//li["+i+"]//h3");
					validateHeadLineArticleInMobile();
					scrollBy(0, -100);					
				}
				else if(getAttributeValue("#xpath=//ul[@class='common-stream articles edittools-stream']/li["+i+"]/div", "ng-switch-when").equals("slide")){
					testStepPassed("Validating Gallery post");
					scrollToElement("Latest Posts#xpath=//div[@ng-controller='ContribStreamController']//ul//li["+i+"]//h3");
					clickOn("Latest Posts#xpath=//div[@ng-controller='ContribStreamController']//ul//li["+i+"]//h3");
					validateGalleryInMobile();
					scrollBy(0, -100);
				}
			
			}
		}
		
		
	}
	
	public void validateGalleryInMobile()
	{
		
		try {
			boolean gallery=elementPresent(OR.txt_GalleryCheck_mobileGalleryArea);
			String getTitle=driver.getTitle();
			if(gallery==true && !getTitle.contains("404"))
			{
				testStepPassed("Gallery is present");
				clickOnBackButton();
			}
			else
			{
				testStepFailed("Gallery is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	public void validatePromoSectionInMobile()
	{
		testStepInfo("******************************************** Promo Section ************************************************");
		scrollToElement(OR.txt_contributor_Page_Top_Features);
		scrollBy(0, -200);
		boolean promoSection=elementPresent(OR.txt_contributor_Page_Top_Features);
		if(promoSection==true)
		{
			int getCount=getElementCount(OR.txt_contributor_Page_Top_Features);
			testStepPassed("Total Number of Promo Articles--->"+getCount);
			for (int i =1; i <=getCount; i++) {
				String promoArticles="Contributor Top Features#xpath=//div[@class='stack contrib-top-feature clearfix ng-scope']//ul//li["+i+"]//h3";
			
				clickOn(promoArticles);
				validateHeadLineArticleInMobile();
				scrollBy(0, 100);
			}
			scrollBy(0, 50);
		}
	}
	

	public void validateTypeOfAutor(String authorType)
	{

		try {
			boolean author=elementPresent(authorType);
			if(author==true)
			{
				String getAuthorType=getText(authorType);
				testStepPassed("Type Of Author --->"+getAuthorType);
			}
			else
			{
				testStepFailed("Author Type is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	

	
}
