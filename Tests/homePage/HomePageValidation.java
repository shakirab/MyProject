/**
 * Check ads on whole page
 * Hamburger menu
 * Home, newposts, Popular tabs
 * Search icon
 * Top Stories
 * Most polular section with see more popular stories link
 * ForbesBrandVoice 
 * Featured
 * Video
 * Forbes Lists section
 * Login
 */

package homePage;


import java.util.Set;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseClass.BaseClass;

public class HomePageValidation extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Home Page Validation
	// Created by :Shakira
	// Created on :6 June 2016

	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Instantiates a new home page validation.
	 *
	 * @param obj
	 *            the obj
	 */
	public HomePageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates a new home page validation.
	 */
	public HomePageValidation() {

		// TODO Auto-generated constructor st ub
	}

	/**
	 * Verify links in home page. methods are written in mixed case with the
	 */
	public void verifyHomePage() {

		if (currentExecutionMachineName.equalsIgnoreCase("Wel_HP_Article_LvlUp")) {
			
			validatePageLoadTime("http://www.forbes.com/home_usa/", 16, "Home Page");
			validateFreeIssuesOfForbes();
			validateTopAds(OR.adsHomePageTopAds);
			validateRecAds(OR.adsHomePageRecAds);
			validateTopxAds(OR.adsHomePageTopxAds);
			validateTabs();
			// verifyTopStory();
			validateSocialnetworks(OR.img_Home_Page_Social_Web);
			verifyTopStory1();

			verifyPromoBlock();
			verifyTopVideoOnHomePage();
			//verifyVideo();
			verifyMarketToform();
			validateEmailPromo();
			validateLevelUpLogo(OR.img_Reg_Home_Page_LevelUp,OR.txt_Home_Page_LevelUP_ShortBio);
			validateLevelUpLinks();
			validateMostPopularLinks();
			validateSeeMostPopular();
			verifySocialWeb();
			verifyForbesBrandVoice();
			validateForbesBVLinks();
			validateForbesBVItemLists();
			validateFeatured();
			validateForbesVideo();
			validateForbesFeaturedVideos();
			validateMarketGraph();
			validateInvestingStories();
			validateRecommended();
			verifyForbesList();
			validatePromoteStories();
			validateTopLists();
			verifyFooter();

		} else {
			
			validatePageLoadTime("http://www.forbes.com/home_usa/", 17, "Home Page");
		waitTime(5);
			validateGeographyDropDown();
			validateHamburgerMenu();
			validateMobileAdsInHomePage();
			scrollBy(0, 30);
			verifyTopStoryInMobile();
			validatePromoVideo();
			scrollBy(0, -200);
			validateLevelUpLogo(OR.img_Reg_Home_Page_LevelUp,OR.txt_Home_Page_LevelUP_ShortBio);
			validateEmailPromo();
			//scrollBy(0, -200);
			validateLevelUpLinksInMobile();
			getMostPopularLinks();
			validateSeeMostPopularInmobile();
			
			//verifyMostPopularSeeMoreStories();
			verifyHomePageForbesBrandVoice();
			verifyForbesBrandVoiceInMobile();
			validateForbesBVItemListsInMobile();
			verifyHomePageFeatures();

			validateForbesVideosInMobile();
			validateRecommendedInMobile();
			validateForbesListsInMobile();
			verifyVideoOnHomePage();
			verifyRelatedTopicsInMob();
			verifyMostReadOnForbesInMobile();
			validateSwitchTofullSite(OR.txt_Mob_Reg_Home_Page_FullSite);
			verifyBottomAdsInMobile();
		}

	}
	
	
	public void verifyTopVideoOnHomePage() {

		testStepInfo("****************************Top Video***************************************");
		try {
			
			/*testStepPassed("Before Video plays");
			takeAdScreenshot(OR.vidHomePageVideo, "Home Page Video");*/
			waitTime(5);
			waitForElement(OR.vidHomePageVideo);
			scrollBy(0, 1000);
			scrollToElement(OR.vidHomePageVideo);
			boolean video=elementPresent(OR.vidHomePageVideo);
			if(video==true)
			{
				testStepPassed("Video is displayed");
			}
			else
			{
				testStepFailed("Video is not displayed");
			}
			try {
				boolean playButton = isElementDisplayed(OR.btn_Home_Page_Video_Play_button);
				if (playButton == true) {
					clickOn(OR.btn_Home_Page_Video_Play_button);
					waitTime(5);
					//testStepPassed("Video Played for 5 seconds");
					boolean video1=elementPresent(OR.vidHomePageVideo);
					if(video1==true)
					{
					takeAdScreenshot(OR.vidHomePageVideo, "Home Page Video");
					//clickOn(OR.vidHomePageVideo);
					getCurrentPageURL();
					}
					else
					{
						testStepFailed("Error on the Video ");
					}
				} else {
					getCurrentPageURL();
					testStepFailed("Video Play button is not loaded");
				}
			} catch (Exception e) {
				testStepFailed("Video is not played");
			}


		} catch (Exception e) {
			testStepFailed("Error occured in the video");
		}
	}

	/**
	 * Verify top story1.
	 */
	public void verifyTopStory1() {
		testStepInfo("************************************Top Stories ************************************");
		try {
			boolean topStories = elementPresent(OR.txt_Reg_Home_Page_Top_Stories);
			if (topStories == true) {
				int countTopstories = getElementCount(OR.txt_Reg_Home_Page_Top_Stories);
				testStepPassed("Total Top Stories -" + countTopstories);
				for (int i = 1; i <= 1; i++) {

					openArticlesInNewWindow("TopStory#xpath=//div[@id='list_headline_hp']//li["
									+ i + "]//h4//a");
					/*verifyArticleTextsInNewtab(
							"TopStory#xpath=//div[@id='list_headline_hp']//li["
									+ i + "]//h4//a",
							"TopStoryt#xpath=//div[@id='list_headline_hp']//li["
									+ i + "]//h4//a",
							OR.txt_Reg_Home_Page_HeadLine_Article);*/
				}

			} else {
				getCurrentPageURL();
				testStepFailed("Top Stories Links are not displayed");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	

	/**
	 * Verify promo block.
	 */
	public void verifyPromoBlock() {
		testStepInfo("************************************ Main Article Promo Block ************************************");
		try {
			boolean promoBlock = elementPresent(OR.img_Reg_Home_Page_Promo_Block);
			boolean promoTitle = elementPresent(OR.txt_Reg_Home_Page_Promo_Title);
			if (promoBlock == true && promoTitle == true) {
				
				verifyArticleTextsInNewtab(OR.txt_Reg_Home_Page_Promo_Title, OR.txt_Reg_Home_Page_Promo_Title, OR.txt_Reg_Home_Page_HeadLine_Article);
				String promo = getText(OR.txt_Reg_Home_Page_Promo_Title);
				testStepPassed("Promo Block is Displayed-" + promo);
			} else {
				getCurrentPageURL();
				testStepFailed("Promo Block is not Displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Verify video.
	 */
	public void verifyVideo() {

		testStepInfo("**************************** Top Video ***************************************");
		try {
			boolean videoBlock = elementPresent(OR.vid_Reg_Home_Page_Video);
			boolean videoTitle = elementPresent(OR.txt_Reg_Home_Page_Video_Title);
			if (videoBlock == true && videoTitle == true) {
				String vidTitle = getText(OR.txt_Reg_Home_Page_Video_Title);
				testStepPassed("Video Title is - " + vidTitle);
				this.scrollToElement(OR.vid_Reg_Home_Page_Video);
				this.scrollBy(0, -60);
				/*clickOn(OR.vid_Reg_Home_Page_Video);
				waitTime(5);
				clickOn(OR.vid_Reg_Home_Page_Video);*/

				testStepPassed("Video is Displayed");
			} else {
				getCurrentPageURL();
				testStepFailed("Video block is broken ");
			}

		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	/**
	 * Verify market toform.
	 */
	public void verifyMarketToform() {
		testStepInfo("****************************MarkeTo Forms***************************************");
		try {
			int countvideo = getElementCount(OR.vid_Reg_Home_Pag_MarkeTo);
			int countvideobtn = getElementCount(OR.btn_Reg_Home_Page_Video_MarkeTo);
			if (countvideo == countvideobtn) {
				testStepPassed("Total MarkeTo videos " + countvideo);
				testStepPassed("MarkeTo Form  is Displayed");
				for (int i = 1; i <= countvideo; i++) {

					String markeTovideo = "MarkeTo video#xpath=//ul[@class='homepage_playlist']//li["
							+ i + "]/.//div[@class='title ng-binding']";
					String allVideoLinks = getText(markeTovideo);
					testStepPassed(allVideoLinks);
				}

			} else {
				testStepFailed("MarkeTo Form is not Displayed");

			}
			testStepPassed("*******************************************************");
			boolean firstVideo = elementPresent(OR.btn_Reg_Home_Page_MarkeTo1);
			if (firstVideo == true) {
				clickOn(OR.btn_Reg_Home_Page_MarkeTo1);
				waitTime(5);
				clickOn(OR.vid_Reg_Home_Page_Video);
				testStepPassed("Video is Played ");
			} else {
				testStepFailed("MarkeTo Form video is not played");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}
	
	
	public void validateLevelUpLinks() {
		testStepInfo("************************************ Level Up ************************************");
	

		try {
			boolean levelUpLinks = elementPresent(OR.txt_Reg_Home_Page_Level_Up_Article);
			if (levelUpLinks == true) {
				int count = getElementCount(OR.txt_Reg_Home_Page_Level_Up_Article);
				testStepPassed("Total number of articles present---"+count);
				/*for (int i = 1; i <= 1; i++) {

					openArticlesInNewWindow("Level Up Article#xpath=//section[@class='stack level-up' or @class='level-up']//div[@class='headline_list']//ul//li["
									+ i + "]//h4//a");
					verifyArticleTextsInNewtab(
							"Level Up Article#xpath=//section[@class='stack level-up' or @class='level-up']//div[@class='headline_list']//ul//li["
									+ i + "]//h4//a",
							"Level Up Article#xpath=//section[@class='stack level-up' or @class='level-up']//div[@class='headline_list']//ul//li["
									+ i + "]//h4//a",
							OR.txt_Reg_Home_Page_HeadLine_Article);
				}*/
			} else {
				testStepFailed("Level Up Articles are not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}
	
	/**
	 * Validate most popular links.
	 */
	public void validateMostPopularLinks() {
		testStepInfo("****************************Most Popular********************************************");
		try {
			boolean mostPop = elementPresent(OR.txt_Reg_Home_Page_Most_Popular);
			if (mostPop == true) {
				int countMostPopular = getElementCount(OR.txt_Reg_Home_Page_Most_Popular);
				testStepPassed("Total Most popular Links are-"
						+ countMostPopular);

				for (int i = 2; i <= 2; i++) {
					
					openArticlesInNewWindow("Most Popular #xpath=//section[@class='popular_top_stories' or @id='stackMostPopular']//ol//li["
									+ i + "]//h3//a");
					/*verifyArticleTextsInNewtab(
							"Most Popular #xpath=//section[@class='popular_top_stories' or @id='stackMostPopular']//ol//li["
									+ i + "]//h3//a",
							"Most Popular #xpath=//section[@class='popular_top_stories' or @id='stackMostPopular']//ol//li["
									+ i + "]//h3//a",
							OR.txt_Reg_Home_Page_HeadLine_Article);*/

				}
				testStepPassed("Most Popular Links are Present");
			} else {
				testStepFailed("Most Popular Links are not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}
	
	
	/**
	 * Validate see most popular.
	 */
	public void validateSeeMostPopular() {
		testStepInfo("****************************See Most Popular********************************************");
		this.scrollToElement(OR.txt_Reg_Home_Page_See_MostPopular);
		this.scrollBy(0, -60);
		boolean seeMost = elementPresent(OR.txt_Reg_Home_Page_See_MostPopular);
		if (seeMost == true) {
			/*
			 * clickOn(OR.txt_Reg_Home_Page_See_MostPopular); boolean
			 * mostPopular =
			 * elementPresent(OR.txt_Reg_Home_Page_MostPopular_Title); if
			 * (mostPopular == true) {
			 * testStepPassed("See Most popular is Displayed");
			 * clickOnBackButton(); }
			 */
			testStepPassed("See Most popular is Displayed");
		} else {
			testStepFailed("See Most Popular is not Displayed");
		}
	}
	
	
	/**
	 * Verify forbes brand voice.
	 */
	public void verifyForbesBrandVoice() {
		testStepInfo("****************************************** Forbes BrandVoice *****************************************");
		// scrollBy(0, 700);
		try {
			waitTime(8);
			/*this.scrollToElement(OR.txt_Home_Page_BrandVoice);
			this.scrollBy(0, 800);*/
			scrollBy(0, 800);
			boolean brandVoice = elementPresent(OR.txt_Home_Page_BrandVoice);
			boolean brandVoiceLogo = elementPresent(OR.log_Home_Page_BrandVoice);

			// scrollBy(0, 100);
			if (brandVoice == true && brandVoiceLogo == true) {
				String brandVoiceName = getText(OR.txt_Home_Page_BrandVoice);
				String getValue = driver.findElement(
						By.className("str-brand-header")).getAttribute("href");

				String[] brandVoiceValue = getValue.split("/");
				String getBrandVoiceValue = brandVoiceValue[4];
				testStepPassed(getBrandVoiceValue + "" + brandVoiceName);

				String bvName = brandVoiceName.replaceAll("\\s+", "");

				// String[] name=brandVoiceName.split(" ");
				// System.out.println("************************************************************"
				// + getBrandVoiceValue);

				if (bvName.equalsIgnoreCase(getBrandVoiceValue)) {
					testStepPassed(brandVoiceName + "-"
							+ "---Forbes Brand voice is matched---"
							+ getBrandVoiceValue);
					boolean forbesBVlink = elementPresent(OR.txt_Home_Page_Forbes_Branvoice1);
					if (forbesBVlink == true) {
						String firstLink = getText(OR.txt_Home_Page_Forbes_Branvoice1);
						testStepPassed("First Link of Forbes BrandVoice is-"
								+ firstLink);
					}

				} else {
					testStepFailed("Forbes Brand Voice is not matched");
				}

			} else {
				testStepInfo("Forbes Brandvoice Logo and Name is not displayed");
			}

		} catch (Exception e) {
			testStepInfo("WARNING:   Forbes BrandVoice is not displayed");
		}

	}
	
	/**
	 * Validate forbes bv links.
	 */
	public void validateForbesBVLinks() {
		try {
			
			testStepInfo("***************************************** Forbes BrandVoice - Read More *********************************************");
			// boolean forbesBV1 =
			// elementPresent(OR.txt_Home_Page_Forbes_Branvoice1);
			/*this.scrollToElement(OR.txt_Reg_Home_Page_Read_More);
			this.scrollBy(0, -60);*/
			scrollBy(0, 800);
			boolean readMore = elementPresent(OR.txt_Reg_Home_Page_Read_More);
			if (readMore == true) {
				openArticlesInNewWindow(OR.txt_Reg_Home_Page_Read_More);
			
				/*clickOn(OR.txt_Reg_Home_Page_Read_More);
				
				String title=driver.getTitle();
				if(title.contains("Voice"))
				{
					testStepPassed("Navigated to BrandVoice page");
				}
				else
				{
					testStepFailed("BrandVoice page is not Displayed");
				}
				clickOnBackButton();*/
				//validateHeadLineArticle();
			} else {
				testStepInfo("Forbes BrandVoice is not Loaded ");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	/**
	 * Validate featured.
	 */
	public void validateFeatured() {
		testStepInfo("**************************** Featured ********************************************");
		try {
			scrollBy(0, 700);
			boolean featuresLeft = elementPresent(OR.txt_Reg_Home_Page_Features_Left);
			boolean featuresRight = elementPresent(OR.img_Reg_Home_Page_Features_Right);
			if (featuresLeft == true && featuresRight == true) {
				String features = getText(OR.txt_Reg_Home_Page_Features_Left);
				testStepPassed("Featured Left Block Promo Story is -"
						+ features);
				testStepPassed("Featured Section is Displayed");

				this.scrollToElement(OR.txt_Reg_Home_Page_Features_Left);
				this.scrollBy(0, -60);
				clickOn(OR.txt_Reg_Home_Page_Features_Left);
				refreshPage();
				String title = driver.getTitle();
				testStepPassed("Title of the Featured is --" + title);
				waitTime(2);
				clickOnBackButton();

				/*waitTime(3);
				scrollBy(0, -100);
				boolean rightFeatured=elementPresent(OR.img_Reg_Home_Page_Features_Right);
				if(rightFeatured==true)
				{
					this.scrollToElement(OR.img_Reg_Home_Page_Features_Right);
					this.scrollBy(0, -60);
				clickOn(OR.img_Reg_Home_Page_Features_Right);
				refreshPage();
				String featuredTitle = driver.getTitle();
				testStepPassed("Title of the Featured is --" + featuredTitle);
				clickOnBackButton();
				if (title.equalsIgnoreCase(featuredTitle)) {
					testStepPassed("Featured Link and Featured Promo both are navigating to the same Page");
				} else {
					testStepFailed("Featured link and Promo are not matching");
				}
				}
				else
				{
					testStepPassed("Right Featured Block is not Displayed");
				}*/
				
			} else {
				testStepFailed("Featured Promo Story is not Displayed");
			}

		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateForbesVideo() {
		testStepInfo("**************************** Forbes Video ********************************************");
		try {
			scrollBy(0, 400);
			boolean video = elementPresent(OR.img_Reg_Home_Page_Video);
			if (video == true) {
				String videoTitle = getText(OR.txt_Reg_Home_Page_Video);
				testStepPassed(videoTitle);
				this.scrollToElement(OR.txt_Reg_Home_Page_Video);
				this.scrollBy(0, -60);
				clickOn(OR.txt_Reg_Home_Page_Video);
				boolean vidtitle = elementPresent(OR.txt_Reg_Home_Page_Videos_Title);
				if (vidtitle == true) {
					validateVideoTitle();
				} else {
					validateHeadLineArticle();
				}
				testStepPassed("Forbes Video is Displayed");
			} else {
				testStepFailed("Forbes Vidoe is not Displayed");
			}

		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	/**
	 * Validate forbes featured videos.
	 */
	public void validateForbesFeaturedVideos() {

		try {
			boolean videoFeatures = elementPresent(OR.img_Reg_Home_Page_Video_Four_Feature);
			if (videoFeatures == true) {
				int count = getElementCount(OR.img_Reg_Home_Page_Video_Four_Feature);
				testStepPassed("Total video Features " + count);
				testStepPassed("Forbes Video Four Features are displyed");

				
					for (int i = 1; i <= 1; i++) {
						String forbesVideos = "Forbes Four Videos#xpath=//div[@class='four_features fleft col-sm-6 clearfix']//ul[1]//li["
								+ i + "]//h4//a";
						this.scrollToElement(forbesVideos);
						this.scrollBy(0, -100);
						clickOn(forbesVideos);
						boolean video = elementPresent(OR.txt_Reg_Home_Page_Videos_Title);
						if (video == true) {
							validateVideoTitle();
						} else {
							validateHeadLineArticle();
						}
					}
				
				

				/*for (int j = 1; j <= 2; j++) {
					String forbesVideos = "Forbes Four Videos#xpath=//div[@class='four_features fleft col-sm-6 clearfix']//ul[2]//li["
							+ j + "]//h4//a";
					this.scrollToElement(forbesVideos);
					this.scrollBy(0, -100);
					clickOn(forbesVideos);
					boolean video = elementPresent(OR.txt_Reg_Home_Page_Videos_Title);
					if (video == true) {
						validateVideoTitle();
					} else {
						validateHeadLineArticle();
					}
				}*/
			} else {
				testStepFailed("Forbes Video Four Features are not displyed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	/**
	 * Validate market graph.
	 */
	public void validateMarketGraph() {
		testStepInfo("****************************Forbes Market ********************************************");

		try {
			scrollBy(0, 200);
			boolean market = elementPresent(OR.grp_Reg_Home_Page_Market);
			boolean marketGraphiq = elementPresent(OR.txt_Reg_Home_Page_Market_Graphiq);
			if (market == true && marketGraphiq == true) {

				testStepPassed("Forbes Market Graph is Displayed");
			} else {
				testStepInfo("Forbes Market Graph is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	/**
	 * Validate investing stories.
	 */
	public void validateInvestingStories() {
		testStepInfo("**************************** Top Investing Stories ********************************************");
		try {
			boolean investingStories = elementPresent(OR.txt_Reg_Home_Page_Top_Investing_Stories);
			if (investingStories == true) {

				int countStories = getElementCount(OR.txt_Reg_Home_Page_Top_Investing_Stories);
				testStepPassed("Total Top Investing Stories-" + countStories);
				for (int i = 1; i <= 1; i++) {

					verifyArticleTextsInNewtab(
							"Top Investing Stories #xpath=//div[@class='investing_stories clearfix']//ul//li["
									+ i + "]//h3//a",
							"Top Investing Stories #xpath=//div[@class='investing_stories clearfix']//ul//li["
									+ i + "]//h3//a",
							OR.txt_Reg_Home_Page_HeadLine_Article);

				}

			} else {
				testStepFailed("Top Investing Stories are not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	/**
	 * Validate recommended.
	 */
	public void validateRecommended() {
		testStepInfo("**************************** Recommended ********************************************");
		try {
			scrollBy(0, 400);
			boolean imgRec = elementPresent(OR.img_Reg_Home_Page_Recommended);
			if (imgRec == true) {
				String recomm = getText(OR.img_Reg_Home_Page_Recommended1);
				testStepPassed(recomm);

				for (int i = 2; i <= 4; i++) {

					String recommededPromo = "#xpath=//div[@class='feature promostory promostory-"
							+ i + "']//h3";
					String getRecom = getText(recommededPromo);
					boolean promoBlock = elementPresent(recommededPromo);
					testStepPassed(getRecom + " is present -" + promoBlock);
				}
				String recomm5 = getText(OR.img_Reg_Home_Page_Recommended5);
				testStepPassed(recomm5);

				for (int j = 6; j <= 8; j++) {

					String recommededPromo = "#xpath=//div[@class='feature promostory promostory-"
							+ j + "']//h3";
					String getRecom = getText(recommededPromo);
					boolean promoBlock = elementPresent(recommededPromo);
					testStepPassed(getRecom + " is present - " + promoBlock);
				}
			} else {
				testStepFailed("Recommended is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	/**
	 * Validate top lists.
	 */
	public void validateTopLists() {
		testStepInfo("**************************** Top Lists ********************************************");
		try {

			boolean topLists = elementPresent(OR.txt_Reg_Home_Page_Top_Lists);
			if (topLists == true) {

				int countTopLists = getElementCount(OR.txt_Reg_Home_Page_Top_Lists);
				testStepPassed("Total Top lists -" + countTopLists);
				for (int i = 1; i <= 1; i++) {
					
					/*verifyArticleTextsInNewtab("Top Lists#xpath=//div[@class='top_lists']//li["
							+ i + "]//a", "Top Lists#xpath=//div[@class='top_lists']//li["
							+ i + "]//a", title);*/
					
					/*String allTopLists = "Top Lists#xpath=//div[@class='top_lists']//li["
							+ i + "]//a";
					waitForElement(allTopLists);
					String getAlltopLists = getText(allTopLists);

					testStepPassed(i + "." + getAlltopLists);
					clickOn(allTopLists);
					waitTime(3);
					String title = driver.getTitle();
					boolean error = elementPresent(OR.txt_Testing_Buckets_404_Error);
					if (error == true) {
						testStepFailed("Erro: 404 -Forbes");
					}

					else {
						testStepPassed("Title of the Page is -"+title);
						testStepPassed("Navigated to Top List Page");
						clickOnBackButton();
					}*/

					// testStepPassed("Navigated to Top Lists PAge");
					// validateTopListsHeading();

					
					openArticlesInNewWindow("Top Lists#xpath=//div[@class='top_lists']//li["
							+ i + "]//a");
				}
				testStepPassed("Top Lists are Displayed");
			} else {
				testStepFailed("Top Lists are not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify footer.
	 */
	public void verifyFooter() {
		testStepInfo("******************************Footer**************************************");

		int channel = 1;
		for (channel = 1; channel <= 9; channel++) {
			String footerChannels = "Channels#xpath=//div[@class='channels']//ul[@class='edittools-list']//li["
					+ channel + "]";
			String getChannels = getText(footerChannels);
			testStepPassed("Footer Channels are " + getChannels);
		}

		boolean mediaLLC=elementPresent(OR.txt_Home_Page_Media_Forbes);
		
		if (mediaLLC==true) {
			String mediallc = getText(OR.txt_Home_Page_Media_Forbes);
			testStepPassed("Lower Footer is displayed--" + mediallc);

		} else {
			testStepFailed("Lower Footer is not displayed");
		}

	}
	
	
	
	

	// ************************************************************** MOBILE
	// SCRIPT
	// ********************************************************************

	
	/**
	 * Validate geography.
	 */
	
	
	public void validateGeographyDropDown()
	{
		try {
			boolean geography = elementPresent(OR.txt_Reg_Home_Page_Geography);
			if(geography==true)
			{
				clickOn(OR.txt_Reg_Home_Page_Geography);
				
					testStepPassed("Europe Zone is Displayed");
					testStepPassed("Asia Zone is  Displayed");
					testStepPassed("Usa Zone is Displayed");
				
					
				}
			
			else
			{
				testStepFailed("Geograpgy Drop down is not Displayed");
				testStepFailed("Europe Zone is not Displayed");
				testStepFailed("Asia Zone is not Displayed");
				testStepFailed("Usa Zone is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	/**
	 * Validate hamburger menu.
	 */
	public void validateHamburgerMenu() {
		testStepInfo("************************************ Hamburger Menu **************************************");
		boolean hamburgerMenu=elementPresent(OR.txt_Mob_Header_Navigation_Forbes);
		if(hamburgerMenu==true)
		{
		clickOn(OR.txt_Mob_Header_Navigation_Forbes);
		boolean channel = elementPresent(OR.txt_Mob_Header_Navigation_Business_Channel);
		if (channel == true) {
			testStepPassed("Channel is displayed");

			clickOn(OR.txt_Mob_Header_Navigation_Forbes);
		} else {
			testStepFailed("Channel is  not displayed");
		}
		}
		else
		{
			testStepFailed("Hamburger Menu is not Displayed");
		}

	}

	
	
	/**
	 * Validate mobile ads in home page.
	 */
	public void validateMobileAdsInHomePage() {
		testStepInfo("************************************ Ads **************************************");
		try {
			/*
			 * scrollBy(0, 400); waitTime(5);
			 */
			this.scrollToElement(OR.ads_Mob_Home_Page_Top_ads);
			waitForElement(OR.ads_Mob_Home_Page_Top_ads);
			boolean topAds = elementPresent(OR.ads_Mob_Home_Page_Top_ads);
			if (topAds == true) {
				testStepPassed("Mobile Rec Ads is present");

			} else {
				testStepFailed("Mobile Rec Ads is not present");
			}
			verifyBottomAdsInMobile();
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	/**
	 * Verify top story in mobile.
	 */
	public void verifyTopStoryInMobile() {
		testStepInfo("****************************Top Stories********************************************");

		//scrollBy(0, 50);
		// takeAdScreenshot(OR.txt_Mob_Reg_Home_Page_Top_Stories,
		// "Top Stories");
		boolean topStories = elementPresent(OR.txt_Mob_Reg_Home_Page_Top_Stories);
		if (topStories == true) {
			int countTopStories = getElementCount(OR.txt_Mob_Reg_Home_Page_Top_Stories);
			testStepPassed("Total Top Stories ---" + countTopStories);

			for (int i = 1; i <=1; i++) {
				boolean topStory=elementPresent("Top Stories#xpath=//div[@id='list_headline_hp']//ul//li["
						+ i + "]//a");
				
				if(topStory==true)
				{
				String topStoryArticle = "Top Stories#xpath=//div[@id='list_headline_hp']//ul//li["
						+ i + "]//a";
				
				String getTopStories = getText(topStoryArticle);
				testStepPassed("" + getTopStories);
				this.scrollToElement("Top Stories#xpath=//div[@id='list_headline_hp']//ul//li["
						+ i + "]//a");
				this.scrollBy(0, -60);
				clickOn("Top Stories#xpath=//div[@id='list_headline_hp']//ul//li["
						+ i + "]//a");
				

				// scrollToElement(topStory);
				
				validateHeadLineArticleInMobile();
				scrollBy(0, 50);
				}
				else
				{
					testStepFailed("--->"+i+"Top Story article is not present");
				}
			}
			testStepPassed("All Top Stories are Present");
		} else {
			testStepFailed("Top Story is not displayed");
		}
	}
	
	/**
	 * Validate promo video.
	 */
	public void validatePromoVideo() {
		scrollBy(0, 100);
		try {
			boolean promoVideo = elementPresent(OR.txt_Mob_Reg_Home_Page_PromoVideo);
			if (promoVideo == true) {

				//scrollBy(0, -50);
				this.scrollToElement(OR.txt_Mob_Reg_Home_Page_PromoVideo);
				this.scrollBy(0, -60);
				clickOn(OR.txt_Mob_Reg_Home_Page_PromoVideo);
				validateVideoTitle();
			} else {
				testStepFailed(" Video Promo is Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	

	public void validateLevelUpLinksInMobile() {
		testStepInfo("************************************ Level Up ************************************");
	
		
		try {
			//scrollBy(0, 500);
			scrollBy(0,200);
			boolean levelUpLinks = elementPresent(OR.txt_Reg_Home_Page_Level_Up_Article);
			if (levelUpLinks == true) {
				int count = getElementCount(OR.txt_Reg_Home_Page_Level_Up_Article);
				for (int i = 1; i <= 1; i++) {

					this.scrollToElement("Level Up article#xpath=//section[@class='stack level-up' or @class='level-up']//div[@class='headline_list']//ul//li["
									+ i + "]//h4//a");
					this.scrollBy(0, -60);
					clickOn("Level Up article#xpath=//section[@class='stack level-up' or @class='level-up']//div[@class='headline_list']//ul//li["
									+ i + "]//h4//a");
					validateHeadLineArticleInMobile();
				}
			} else {
				testStepFailed("Level Up Articles are not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}
	
	
	/**
	 * Gets the most popular links.
	 *
	 * @return the most popular links
	 */
	public void getMostPopularLinks() {
		testStepInfo("****************************Most Popular********************************************");

		scrollBy(0, 200);
		try {
			int allLinks = getElementCount(OR.txt_Home_Most_Popular_Links);
			testStepPassed("Total Most Popular Links-" + allLinks);
			if (allLinks <= 5) {
				for (int linksCount = 1; linksCount <= 1; linksCount++) {

					/*String mostPopular = "Most Popular#xpath=//section[@class='popular_top_stories' or @id='stackMostPopular']//ol//li["
							+ linksCount + "]//a";

					waitForElement(mostPopular);
					String getLinks = getText(mostPopular);
					testStepPassed(getLinks);*/
					this.scrollToElement("Most Popular#xpath=//section[@class='popular_top_stories' or @id='stackMostPopular']//ol//li["
								+ linksCount + "]//a");
					this.scrollBy(0, -60);
					 clickOn("Most Popular#xpath=//section[@class='popular_top_stories' or @id='stackMostPopular']//ol//li["
								+ linksCount + "]//a"); 
					 validateHeadLineArticleInMobile();
					 scrollBy(0, 50);
				}
				//testStepPassed("Most Popular Links are present");
			} else {
				testStepFailed("Most Popular Links are not Present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}
	

	/**
	 * Validate see most popular in mobile.
	 */
	public void validateSeeMostPopularInmobile() {
		testStepInfo("**************************** See Most Popular ***************************************");
		scrollBy(0, 200);
		try {
			boolean seeMostPopular = elementPresent(OR.txt_Mob_Reg_Home_Page_See_MostPopularLink);
			if (seeMostPopular == true) {
				this.scrollToElement(OR.txt_Mob_Reg_Home_Page_See_MostPopularLink);
				this.scrollBy(0, -60);
				clickOn(OR.txt_Mob_Reg_Home_Page_See_MostPopularLink);
				String title=driver.getTitle();
				//boolean title = elementPresent(OR.txt_Mob_Reg_Home_Page_See_MostPopular);
				if (!title.contains("404")) {
					testStepPassed("See Most Popular is Displayed");
					clickOnBackButton();
				}

			} else {
				getCurrentPageURL();
				testStepFailed("See Most Popular is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	/**
	 * Verify home page forbes brand voice.
	 */
	// 20 June 2016
	
	public void verifyHomePageForbesBrandVoice() {
		testStepInfo("************************************* Forbes BrandVoice********************************");
		try {
			//scrollBy(0, 100);
			//waitTime(4);
			boolean brandVoiceHeading = elementPresent(OR.img_Home_Page_Forbes_BrandVoice);
			if (brandVoiceHeading == true) {
				this.scrollToElement(OR.img_Home_Page_Forbes_BrandVoice);
				this.scrollBy(0, -60);
				//String getHeading = getText(OR.txt_Mob_Home_Page_Forbes_BrandVoice);
				testStepPassed("Forbes Brandvoice Label is displayed");
			} else {
				getCurrentPageURL();
				testStepFailed("Forbes BrandVoice Label is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	/**
	 * Verify forbes brand voice in mobile.
	 */
	public void verifyForbesBrandVoiceInMobile() {
		testStepInfo("****************************************** Forbes BrandVoice *****************************************");
		// scrollBy(0, 700);
		try {
			waitTime(5);
			this.scrollToElement(OR.txt_Mob_Reg_Home_Page_Forbes_BV_Name);
			this.scrollBy(0, -60);
			boolean brandVoice = elementPresent(OR.txt_Mob_Reg_Home_Page_Forbes_BV_Name);
			boolean brandVoiceLogo = elementPresent(OR.log_Mob_Reg_Home_Page_Forbes_BV_Logo);

			// scrollBy(0, 100);
			if (brandVoice == true && brandVoiceLogo == true) {
				String brandVoiceName = getText(OR.txt_Mob_Reg_Home_Page_Forbes_BV_Name);
				String getValue = driver.findElement(
						By.className("str-brand-header")).getAttribute("href");

				String[] brandVoiceValue = getValue.split("/");
				String getBrandVoiceValue = brandVoiceValue[4];
				testStepPassed(getBrandVoiceValue + "" + brandVoiceName);

				String bvName = brandVoiceName.replaceAll("\\s+", "");

				// String[] name=brandVoiceName.split(" ");
				// System.out.println("************************************************************"
				// + getBrandVoiceValue);

				if (bvName.equalsIgnoreCase(getBrandVoiceValue)) {
					testStepPassed(brandVoiceName + "-"
							+ "---Forbes Brand voice is matched---"
							+ getBrandVoiceValue);
					boolean forbesBVlink = elementPresent(OR.txt_Mob_Home_Page_Forbes_BrandVoice);
					if (forbesBVlink == true) {
						String firstLink = getText(OR.txt_Mob_Home_Page_Forbes_BrandVoice);
						testStepPassed("First Link of Forbes BrandVoice is-"
								+ firstLink);
					}

				} else {
					
					testStepFailed("Forbes Brand Voice is not matched");
				}

			} else {
				testStepFailed("Forbes Brandvoice Logo and Name is not displayed");
			}

		} catch (Exception e) {
			testStepInfo("WARNING:   Forbes BrandVoice is not displayed");
		}

	}
	
	public void validateForbesBVItemListsInMobile() {

		scrollBy(0, 100);
		try {
			//waitForElement(OR.txt_Reg_Home_Page_ForbesBV_Item_lists);
			boolean forbesBVItemList = elementPresent(OR.txt_Reg_Home_Page_ForbesBV_Item_lists);
			int count = getElementCount(OR.txt_Reg_Home_Page_ForbesBV_Item_lists);
			testStepPassed("Total Forbes BV Item Lists -" + count);
			if (forbesBVItemList == true) {

				for (int i = 1; i <=1; i++) {

					clickOn("Item Lists#xpath=//div[@class='str-mobile-fixed-unit']//a["+i+"]");
					validateHeadLineArticleInMobile();
					scrollBy(0, 50);
				}
				scrollBy(0, 30);
				boolean forbesBV=elementPresent("BV Links#xpath=//div[@id='str-brand-voice-item-list']/a");
				if (forbesBV==true) {
					int countBV=getElementCount("BV Links#xpath=//div[@id='str-brand-voice-item-list']/a");
					for (int i = 1; i <=1; i++) {
						clickOn("BV Links#xpath=//div[@id='str-brand-voice-item-list']/a["+i+"]");
						validateHeadLineArticleInMobile();
						scrollBy(0, 60);
					}
				}
				else
				{
					testStepFailed("BrandVoice Item lists are not displayed");
				}
				
				
			} else {
				testStepInfo("Forbes BrandVoice Item Lists are not Loaded ");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}
	

	/**
	 * Verify home page features.
	 */
	public void verifyHomePageFeatures() {
		testStepInfo("************************************* Features ********************************");

		try {
			scrollBy(0, 200);
			scrollBy(0, -100);
			boolean isfeature=elementPresent(OR.txt_Mob_Home_Page_Feature);
			if(isfeature==true)
			{
				waitForElement(OR.txt_Mob_Home_Page_Feature);
				String feature = getText(OR.txt_Mob_Home_Page_Feature);
				testStepPassed(feature);
				boolean featureLink = elementPresent(OR.txt_Mob_Home_Page_Features_Link);
				boolean featuredPromo = elementPresent(OR.img_Mob_Reg_Home_Page_Featured);
				if (featureLink == true && featuredPromo == true) {
					String featureLinks = getText(OR.txt_Mob_Home_Page_Features_Link);
					testStepPassed("Feature First Link is ---" + featureLinks);
					clickOn(OR.txt_Mob_Home_Page_Features_Link);
					String title = driver.getTitle();
					clickOnBackButton();

					/*scrollBy(0, 100);
					clickOn(OR.img_Mob_Reg_Home_Page_Featured);
					String title1 = driver.getTitle();
					clickOnBackButton();
					if (title.contains(title1)) {
						testStepPassed("Featured Promo is navigated to same page");
					}
					else
					{
						testStepFailed("Featured Promo Article is not displayed");
					}
					testStepPassed("Feature Link is displayed");*/

				} else {
					testStepFailed("Feature Link is not displayed");
				}
			}
			
			else
			{
				testStepFailed("Feature is not present");
			}

		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	

	/**
	 * Validate forbes videos in mobile.
	 */
	public void validateForbesVideosInMobile() {
		testStepInfo("****************************************** Forbes Videos *****************************************");

		try {
			boolean forbesVideo = elementPresent(OR.txt_Mob_Reg_Home_Page_Forbes_Videos);
			if (forbesVideo == true) {
				int countVideos = getElementCount(OR.txt_Mob_Reg_Home_Page_Forbes_Videos);
				testStepPassed("Total Number of Videos -" + countVideos);
				testStepPassed("Forbes Videos are Present");
			} else {
				testStepFailed("Forbes Videos are not Present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}
	
	/**
	 * Validate recommended in mobile.
	 */
	public void validateRecommendedInMobile() {
		testStepInfo("****************************************** Recommended *****************************************");
		try {
			scrollBy(0, 1000);
			boolean recom = elementPresent(OR.img_Mob_Reg_Home_Page_Recommended);
			if (recom == true) {
				testStepPassed("Recommended is present");
				
				boolean recommendedButtons=elementPresent(OR.btn_Video_Page_Recommended_Next);
				if(recommendedButtons==true)
				{
					int count=getElementCount(OR.btn_Video_Page_Recommended_Next);
					testStepPassed("Total numver od Slides---"+count);
					
					int countRecom=getElementCount("Recommended Articles#xpath=//div[@class='flex-viewport']//li[@class='flex-active-slide']//li//h3");
					testStepPassed(""+countRecom);
					
						for (int i = 1; i <=2; i++) {
							String recomArticles=getText("Recommended Articles#xpath=//div[@class='flex-viewport']//li[@class='flex-active-slide']//li["+i+"]//h3");
							testStepPassed(""+recomArticles);
						}
						boolean nextButton=elementPresent("Next button#xpath=//ol[@class='flex-control-nav flex-control-paging']//li[2]");
						if (nextButton==true) {
							this.scrollToElement("Next button#xpath=//ol[@class='flex-control-nav flex-control-paging']//li[2]");
							this.scrollBy(0, -60);
							clickOn("Next button#xpath=//ol[@class='flex-control-nav flex-control-paging']//li[2]");
							testStepPassed("Clicked on the Next button");
						}
						
						
					
					/*	for (int i =2; i <=3; i++) {
						this.scrollToElement("Next button#xpath=//ol[@class='flex-control-nav flex-control-paging']//li["+i+"]");
						this.scrollBy(0, -100);
						clickOn("Next button#xpath=//ol[@class='flex-control-nav flex-control-paging']//li["+i+"]");
						
							int countRecom=getElementCount("Recommended Blcok#xpath=//div[@class='flex-viewport']//ul//li[@class='flex-active-slide']//ul//li//h3");
							testStepPassed("Recommended---"+countRecom);
							for (int j =1; j <=countRecom; j++) {
								String getRecommended=getText("Recommended Blcok#xpath=//div[@class='flex-viewport']//ul//li[3]//ul//li["+j+"]//h3");
								testStepPassed(getRecommended);
							}
						
						
						//testStepPassed("Clicked on next button");
					}*/
				}
				else
				{
					testStepFailed("Recommended Next Button is not working ");
				}
				//swipeToLeft(1000, 50, 1000);
			} else {
				testStepInfo("Recommended is not present");
			}
			
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	/**
	 * Validate forbes lists in mobile.
	 */
	public void validateForbesListsInMobile() {
		testStepInfo("************************************* Forbes Lists ********************************");
		try {
			scrollBy(0, 300);

			boolean forbesListBill = elementPresent(OR.img_Mob_Reg_Home_Page_ForbesLists);
			if (forbesListBill == true) {

				testStepPassed("Forbes Lists billionaires is displayed");
			} else {
				testStepFailed("Forbes Lists billionaires is  not displayed");
			}
			scrollBy(0, 200);
			boolean forbesList = elementPresent(OR.txt_Mob_Home_Page_Forbes_Lists);
			if (forbesList == true) {
				String forbesListLink = getText(OR.txt_Mob_Home_Page_Forbes_Lists);
				testStepPassed("Forbes List First Link is--" + forbesListLink);
				this.scrollToElement(OR.txt_Mob_Home_Page_Forbes_Lists);
				this.scrollBy(0, -100);
				clickOn(OR.txt_Mob_Home_Page_Forbes_Lists);
				validateHeadLineArticleInMobile();
				
			}
			boolean gridBlock = elementPresent(OR.txt_Mob_Reg_Home_Page_ForbesLists_Grid);
			if (gridBlock == true) {
				int count = getElementCount(OR.txt_Mob_Reg_Home_Page_ForbesLists_Grid);
				testStepPassed("Total Forbes Lists Grid block links are -"
						+ count);
				for (int i =1; i <=1; i++) {
					this.scrollToElement("Forbes lists Grid#xpath=//ul[@class='gridBlock cf']//li["+i+"]");
					this.scrollBy(0, -60);
					clickOn("Forbes lists Grid#xpath=//ul[@class='gridBlock cf']//li["+i+"]");
					validateHeadLineArticleInMobile();
				}
			
			} else {
				testStepFailed("Forbes Lists Grid Block is not Displayed");
			}

			boolean videoBlock = elementPresent(OR.vid_Mob_Reg_Home_Page_ForbesLists_Video);
			if (videoBlock == true) {
				testStepPassed("Forbes Lists Video Section is Displayed");
			} else {
				testStepFailed("Forbes Lists Video Section is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}


	
	public void validateReadMoreInBV() 
	{
		try {
			boolean readMore=elementPresent(OR.txt_Reg_Home_Page_ForbesBV_Read_More);
			if(readMore==true)
			{
				openArticlesInNewWindow(OR.txt_Reg_Home_Page_ForbesBV_Read_More);
				/*this.scrollToElement(OR.txt_Reg_Home_Page_ForbesBV_Read_More);
				this.scrollBy(0, -60);
				clickOn(OR.txt_Reg_Home_Page_ForbesBV_Read_More);
				String pageTitle=driver.getTitle();
				boolean contributorName=elementPresent(OR.txt_Article_Page_contributor_Forbes_Staff_Name);
				if(contributorName==true || !pageTitle.contains("404"))
				{
					String contriName=getText(OR.txt_Article_Page_contributor_Forbes_Staff_Name);
					testStepPassed("Contributor Name ---->"+contriName);
					clickOnBackButton();
				}
				else
				{
					testStepFailed("Page is having error");
				}*/
			}
			else
			{
				testStepFailed("REad More option is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	/**
	 * Validate level up.
	 */
	
	public void validateSignUpInLevelUp()
	{
		testStepInfo("************************************ Level Up ************************************");
		try {
			boolean signupFor=elementPresent(OR.txt_Reg_Home_Page_SignUpfor);
			if(signupFor==true)
			{
				String signUpfor=getText(OR.txt_Reg_Home_Page_SignUpfor);
				testStepPassed("Sign Up For is Displayed-"+signUpfor);
			}
			else
			{
				testStepFailed("Sign Up For is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	
	

	


	
	/*public void validateGeography() {
		try {
			boolean geography = elementPresent(OR.txt_Reg_Home_Page_Geography);
			if (geography == true) {
				clickOn(OR.txt_Reg_Home_Page_Geography);

				clickOn(OR.txt_Reg_Home_Page_Eurepo);
				boolean topStories = elementPresent(OR.txt_Reg_Home_Page_TopStories);
				String url = driver.getCurrentUrl();
				if (topStories == true
						&& url.contains("http://www.forbes.com/home_europe/")) {
					testStepPassed("Europe zone is Displyed");
				} else {
					testStepFailed("Europe Zone is not Displayed");
				}

				clickOn(OR.txt_Reg_Home_Page_Geography);
				clickOn(OR.txt_Reg_Home_Page_Asia);
				boolean topStories1 = elementPresent(OR.txt_Reg_Home_Page_TopStories);
				String url1 = driver.getCurrentUrl();
				if (topStories1 == true
						&& url1.contains("http://www.forbes.com/home_asia/")) {
					testStepPassed("Asia zone is Displyed");
				} else {
					testStepFailed("Asia Zone is not Displayed");
				}

				clickOn(OR.txt_Reg_Home_Page_Geography);
				clickOn(OR.txt_Reg_Home_Page_Usa);
				boolean topStories2 = elementPresent(OR.txt_Reg_Home_Page_TopStories);
				String url2 = driver.getCurrentUrl();
				if (topStories2 == true
						&& url2.contains("http://www.forbes.com/home_usa/")) {
					testStepPassed("USA zone is Displyed");
				} else {
					testStepFailed("USA Zone is not Displayed");
				}
			} else {
				testStepFailed("Geography list is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
*/
	

	

	/**
	 * Validate top lists heading.
	 */
	public void validateTopListsHeading() {
		waitTime(3);
		boolean headLine = elementPresent(OR.txt_Reg_Home_Page_Top_Lists_Title);
		if (headLine == true) {
			String getTitle = driver.getTitle();
			String headLineArticle = getText(OR.txt_Reg_Home_Page_Top_Lists_Title);
			testStepPassed(getTitle + "---is the Title ---" + headLineArticle);
			clickOnBackButton();
		} else {
			testStepFailed("Failed to navigate to Lists ");
		}
	}



	/**
	 * Verifying first link of Top stories.
	 */
	public void verifyTopStory() {
		testStepInfo("************************************Top Stories ************************************");
		try {
			boolean topStories = elementPresent(OR.txt_Reg_Home_Page_Top_Stories);
			if (topStories == true) {
				int countTopstories = getElementCount(OR.txt_Reg_Home_Page_Top_Stories);
				testStepPassed("Total Top Stories -" + countTopstories);
				for (int i = 4; i <= 4; i++) {
					String stories = "Top Stories#xpath=//div[@id='list_headline_hp']//li["
							+ i + "]//h4//a";

					waitForElement(stories);
					//Get Text of Link
					String allTopStories = getText(stories);
					testStepPassed(allTopStories);
					
					String linkText=allTopStories.replaceAll("\\s+","");
					String repl=linkText.replaceAll("'", "");
					
					String low=repl.toLowerCase();
					String hyph=low.replaceAll("-","");
					testStepPassed(linkText);
					testStepPassed(repl);
					testStepPassed(low);
					testStepPassed(hyph);
					waitTime(2);
			
						
						clickOn(stories);
						String articleURL=driver.getCurrentUrl();
						testStepPassed(articleURL);
						
						String[] galleryLink=articleURL.split("/");
						String a1=galleryLink[0];
						String a2=galleryLink[1];
						String a3=galleryLink[2];
						String a4=galleryLink[3];
						String a5=galleryLink[4];
						String a6=galleryLink[5];
						String a7=galleryLink[6];
						String a8=galleryLink[8];
						testStepPassed(a1);
						testStepPassed(a2);
						testStepPassed(a3);
						
						testStepPassed(a4);
						testStepPassed(a5);
						testStepPassed(a6);
						testStepPassed(a7);
						testStepPassed(a8);
						String replaceStr=a8.replace("-", "");
						testStepPassed(replaceStr);
						if(hyph.contains(replaceStr))
						{
							testStepPassed("Passs");
						}
						else
				
						{
							testStepFailed("Failed");
						}
						/*String currentUrl=driver.getCurrentUrl();
						testStepPassed("Current URL is -"+currentUrl);
						String[] splitUrl=currentUrl.split("//");
						String s1=splitUrl[0];
						String s2=splitUrl[1];
						String s3=splitUrl[2];
						
						String[] s4=s3.split("&");
						String s5=s4[0];
						String s6=s4[1];
						testStepPassed(s1);
						testStepPassed(s2);
						testStepPassed(s3);
						testStepPassed(s5);
						testStepPassed(s6);*/
						validateHeadLineArticle();
						// clickOnBackButton();
					

				}

			} else {
				testStepFailed("Top Stories Links are not displayed");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	

	

	





	



	

	/**
	 * Validate video title.
	 */
	public void validateVideoTitle() {
		try {
			boolean videoBlock=elementPresent(OR.vid_Reg_Home_Page_Video_Section);
			if(videoBlock==true)
			{
				testStepPassed("Video Section is displayed");
				boolean videosTitle = elementPresent(OR.txt_Reg_Home_Page_Videos_Title);
				if (videosTitle == true) {
					String videoName = getText(OR.txt_Reg_Home_Page_Videos_Title);
					testStepPassed("Video title is displayed--" + videoName);
					clickOnBackButton();
				} else {
					testStepFailed("Video title is not displayed");
				}
			}
			else
			{
				testStepFailed("Video Section is not Displayed");
			}
			
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	


	

	

	



	/**
	 * Verify forbes list.
	 */
	
	public void verifyForbesList() {
		testStepInfo("****************************Forbes List********************************************");
		try {
			scrollBy(0, 2500);
			scrollBy(0, -500);
			//elementPresent(OR.arw_Home_Page_Forbes_List_Prev);
			boolean varForbesList = elementPresent(OR.txt_Home_Page_Forbes_List);
			if(varForbesList==true)
			{
			testStepPassed("Verified the Forbes list is displayed---" + varForbesList);
			scrollBy(0, -200);
			boolean preBtn=elementPresent(OR.arw_Home_Page_Forbes_List_Prev);
			if(preBtn==true)
			{
				clickOn(OR.arw_Home_Page_Forbes_List_Prev);
				int totalCnt=getElementCount(OR.txt_Home_Page_Forbes_Lists_Links);
			
				testStepPassed("Total List of Forbes lists is--" + totalCnt);
			}
			scrollBy(0, -100);
			boolean nextBtn=elementPresent(OR.arw_Home_Page_Forbes_List_Next);

			if(nextBtn==true)
			{
			clickOn(OR.arw_Home_Page_Forbes_List_Next);
			boolean forbesLists = elementPresent(OR.txt_Home_Page_Forbes_List_Name);
			if (forbesLists == true) {
				testStepPassed("Forbes Lists ticker is working");
			} else {
				testStepFailed("Forbes Lists ticker is not working");
			}
			}
			}
			else
			{
				testStepInfo("Forbes Lists is not loaded");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	/*public void verifyForbesList() {
		testStepInfo("****************************Forbes List********************************************");
		try {
			scrollBy(0, 600);
			boolean varForbesList = elementPresent(OR.txt_Home_Page_Forbes_List);
			if (varForbesList == true) {
				testStepPassed("Verified the Forbes list is displayed---"
						+ varForbesList);
				boolean preBtn = elementPresent(OR.arw_Home_Page_Forbes_List_Prev);
				boolean nextBtn = elementPresent(OR.arw_Home_Page_Forbes_List_Next);
				if (preBtn == true && nextBtn == true) {
					clickOn(OR.arw_Home_Page_Forbes_List_Prev);
					waitTime(3);
					clickOn(OR.arw_Home_Page_Forbes_List_Next);
					int totalCnt = getElementCount(OR.txt_Home_Page_Forbes_Lists_Links);

					testStepPassed("Total List of Forbes lists is--" + totalCnt);
					testStepPassed("Forbes Lists ticker is working");
				} else {
					testStepFailed("Forbes Lists ticker is not working");
				}

			} else {
				testStepInfo("Forbes Lists is not loaded");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}*/

	/**
	 * Validate promote stories.
	 */
	public void validatePromoteStories() {
		testStepInfo("****************************Promote Stories ********************************************");
		try {
			scrollBy(0, 300);
			boolean promoStory1 = elementPresent(OR.img_Reg_Home_Page_PromoStory1);
			boolean promoStories = elementPresent(OR.txt_Reg_Home_Page_PromoStories);

			if (promoStory1 == true && promoStories == true) {
				int promoStory = getElementCount(OR.txt_Reg_Home_Page_PromoStories);
				testStepPassed("Total Promo stories are " + promoStory);
				for (int i = 1; i <= promoStory; i++) {
					String getPromo = "Promo Stories#xpath=//div[@class='twofeatures']//li["
							+ i + "]//h4";
					String getStories = getText(getPromo);
					testStepPassed(getStories);
				}
				testStepPassed("Promo Story is present");
			} else {
				testStepFailed("Promo story is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	

	
	

	/**
	 * Verfiy login.
	 */
	public void verfiyLogin() {
		testStepInfo("*******************************Login************************************************");
		try {
			clickOn(OR.img_Home_Page_Login);

			boolean loginButton = elementPresent(OR.btn_Home_Page_Login_Button);
			if (loginButton == true) {
				testStepPassed("Login form is available");
			} else {
				testStepFailed("Login form is not available");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Verify logout.
	 */
	public void verifyLogout() {
		testStepInfo("*******************************Logout************************************************");
		clickOn(OR.btn_Home_Page_Logout);
		boolean logout = elementPresent(OR.btn_Home_Page_Login_Button);
		if (logout == true) {
			testStepPassed("Verified Logout Successfully");
		} else {
			testStepFailed("Failed  to Logout");
		}

	}

	

	/**
	 * Validate forbes bv item lists.
	 */
	public void validateForbesBVItemLists() {

		scrollBy(0, 100);
		try {
			waitForElement(OR.txt_Reg_Home_Page_ForbesBV_Item_lists);
			boolean forbesBVItemList = elementPresent(OR.txt_Reg_Home_Page_ForbesBV_Item_lists);
			int count = getElementCount(OR.txt_Reg_Home_Page_ForbesBV_Item_lists);
			testStepPassed("Total Forbes BV Item Lists -" + count);
			if (forbesBVItemList == true) {

				for (int i = 1; i <= 1; i++) {

					if(i<=4)
					{
						openArticlesInNewWindow("Item Lists#xpath=//div[@id='str-brand-voice-item-list']//a["
									+ i + "]");
					/*verifyArticleTextsInNewtab(
							"Item Lists#xpath=//div[@id='str-brand-voice-item-list']//a["
									+ i + "]",
							"Item Lists#xpath=//div[@id='str-brand-voice-item-list']//a["
									+ i + "]",
							OR.txt_Reg_Home_Page_HeadLine_Article);*/
					}
					else
					{
						validateReadMoreInBV();
					}

				}
			} else {
				testStepInfo("Forbes BrandVoice Item Lists are not Loaded ");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	




	/**
	 * Verify home page tabs.
	 */
	public void verifyHomePageTabs() {
		testStepInfo("************************************* Home Page Tabs ********************************");
		try {
			waitTime(3);
			clickOn(OR.tab_Mob_Home_Page_Home);
			boolean heading = elementPresent(OR.txt_Mob_Home_Page_Heading);
			if (heading == true) {
				String varHeading = getText(OR.txt_Mob_Home_Page_Heading);
				testStepPassed("Home Tab is working " + varHeading);

			} else {
				testStepFailed("Home Tab is not working ");
			}
			waitTime(5);
			waitForElement(OR.tab_Header_Navigation_New_Post);
			clickOn(OR.tab_Header_Navigation_New_Post);
			boolean newPostsHeading = elementPresent(OR.txt_Mob_Header_Navigation_New_Post);
			if (newPostsHeading == true) {

				String varNewPostsHeading = getText(OR.txt_Mob_Header_Navigation_New_Post);
				testStepPassed("New Posts Tab is working " + varNewPostsHeading);
			} else {
				testStepFailed("New Posts Tab is not working ");
			}
			waitTime(5);
			waitForElement(OR.tab_Mob_Header_Navigation_Most_Popular);
			clickOn(OR.tab_Mob_Header_Navigation_Most_Popular);
			boolean mostPopularHeading = elementPresent(OR.txt_Mob_Home_Page_Most_Popular_Heading);
			if (mostPopularHeading == true) {

				String varMostPopularHeading = getText(OR.txt_Mob_Home_Page_Most_Popular_Heading);
				testStepPassed("Most Popular Tab is working "
						+ varMostPopularHeading);
			} else {
				testStepFailed("Most Popular Tab is not working ");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify most popular see more stories.
	 */
	public void verifyMostPopularSeeMoreStories() {
		testStepInfo("************************************* Most Popular See More Stories********************************");
		try {
			// scrollBy(0, 200);
			waitTime(3);
			boolean seeMore = elementPresent(OR.txt_Mob_Home_Page_Most_Popular_See_More);

			if (seeMore == true) {

				testStepPassed("Most Popular See More Option is displayed");
			} else {
				testStepFailed("Most Popular See More Option is not displayed");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	


	
	/**
	 * Validate related topics.
	 */
	public void validateRelatedTopics() {
		testStepInfo("************************************* Related Topics ********************************");
		try {
			scrollToElement(OR.txt_Mob_Home_Page_Related_Topics);
			scrollBy(0, 800);
			waitForElement(OR.txt_Mob_Home_Page_Related_Topics);
			String relatedTopics = getText(OR.txt_Mob_Home_Page_Related_Topics);
			testStepPassed(relatedTopics);
			int relatedTopicsCount = 1;
			for (relatedTopicsCount = 1; relatedTopicsCount <= 4; relatedTopicsCount++) {
				String relatedTopic = "Related Topics#xpath=//div[@id='unit']//ul//li["
						+ relatedTopicsCount + "]";
				String topic = getText(relatedTopic);
				testStepPassed(topic);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Validate most read.
	 */
	public void validateMostReadInMobile() {
		testStepInfo("********************************* Most Read **************************************");

		try {
			waitForElement(OR.txt_Most_Popular_Page_Most_Read);
			scrollBy(0, 800);

			boolean mostRead = elementPresent(OR.txt_Most_Popular_Page_Most_Read);
			if (mostRead == true) {
				String mostReadLink = getText(OR.txt_Most_Popular_Page_Most_Read);
				testStepPassed(mostReadLink);
				testStepPassed("Most Read is displayed");
			} else {
				testStepFailed("Most Read is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Author : Shakira Created On : 28 June 2016.
	 */

	/**
	 * Verify US tab is clicking
	 */
	public void verifyUSUserZone() {
		testStepInfo("********************************* User Zone Tabs **************************************");
		try {
			boolean usTab = elementPresent(OR.txt_Home_User_Zone_US);

			if (usTab == true) {
				// clickOn(OR.txt_Home_User_Zone_US);
				testStepPassed("US tab is displayed");
			} else {
				testStepFailed("US tab is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Verify Europe tab is clicking.
	 */
	public void verifyEuropeUserZone() {

		try {
			boolean europeTab = elementPresent(OR.txt_Home_User_Zone_Europe);
			if (europeTab == true) {
				// clickOn(OR.txt_Home_User_Zone_Europe);
				testStepPassed("Europe tab is displayed");
			} else {
				testStepFailed("Europe tab is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Verify Asia tab is clicking.
	 */
	public void verifyAsiaUserZone() {

		try {
			boolean asiaTab = elementPresent(OR.txt_Home_User_Zone_Asia);
			if (asiaTab == true) {
				waitTime(3);
				// clickOn(OR.txt_Home_User_Zone_Asia);
				testStepPassed("Asia tab is displayed");
			} else {
				testStepFailed("Asia tab is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Verify follow forbes.
	 */

	public void verifyFollowForbes() {
		testStepInfo("********************************* Follow Forbes **************************************");
		try {
			int followAvatar = 1;
			for (followAvatar = 1; followAvatar <= 5; followAvatar++) {
				String followForbes = "Follow Forbes#xpath=//div[@class='follow_links']//ul//li["
						+ followAvatar + "]";
				getText(followForbes);
				boolean follow = elementPresent(followForbes);
				if (follow == true) {

					testStepPassed("Follow On Forbes Avataras are present--"
							+ followAvatar + "-");
				} else {
					testStepFailed("Follow On Forbes Avataras are not present");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}




	/**
	 * Verify Video is played.
	 */
	public void verifyVideoOnHomePageIniPad() {

		testStepInfo("****************************Top Video***************************************");
		try {

			testStepPassed("Before Video plays");
			takeAdScreenshot(OR.vidHomePageVideo, "Home Page Video");
			waitTime(3);
			boolean playButton = elementPresent(OR.vidHomePageVideo);
			if (playButton == true) {
				clickOn(OR.vidHomePageVideo);
				waitTime(6);
				testStepPassed("Video Played for 6 seconds");
				takeAdScreenshot(OR.vidHomePageVideo, "Home Page Video");
			} else {
				testStepFailed("Video Play button is not loaded");
			}

		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	



	
	
	
	
	
	
	
	
	
	
	
}