
package podcastsPage;



import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;
import baseClass.BaseClass;

public class PodCastsPageValidation extends ApplicationKeywords {
	
	/** The obj. */
	BaseClass obj;

	public PodCastsPageValidation(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	
	public PodCastsPageValidation() {

	}

	public void verifyPodcastsPage() {
		
		if (currentExecutionMachineName.equalsIgnoreCase("NP_MP_Gallery"))
		{
			
			validatePodcastsHeading();
			validateSocialnetworks(OR.img_Podcasts_Page_Social_Share);
			//validateCarouselLayout();
			validatePodcatsAds(OR.ads_Podcasts_Page_TopAds);
			scrollBy(0, 300);
			validateCSFGrid();
		/*	validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section5, 5);
			validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section6, 6);
			validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section7,7);
			validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section8,8);*/
	
		}
		else
		{
			
			validatePodcastsHeading();
			validateSocialNetworks();
			//validateCarouselLayout();
			validatePodcatsAds(OR.ads_Mob_Podcasts_TopAds);
			validateCSFGrid();
			/*validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section5, 5);
			validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section6, 6);
			validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section7,7);
			validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section8,8);*/
		}

	}

	

	public void validateCSFGrid()
	{
		boolean csfGrid=elementPresent("CSF Grid#xpath=//div[@id='csf-main-content']//section//li[@class='csf-column article-grid fs-layout-one']//div[@class='article-block ng-scope']");
		if(csfGrid==true)
		{
			int countGrid=getElementCount("CSF Grid#xpath=//div[@id='csf-main-content']//section//li[@class='csf-column article-grid fs-layout-one']//div[@class='article-block ng-scope']");
			testStepPassed("Total Number of CSF Article Grid--->"+countGrid);
			
			
			/*validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section5, 5);
			validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section6, 6);
			validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section7,7);
			validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section8,8);*/
		
		
		}
		else
		{
			testStepFailed("CSF Article Grid is  not displayed");
		}
	
	}
	public void openPodcastsInNewtab(String strPropertykey) throws InterruptedException{
		
	try{
		String podcastsName = getText(strPropertykey);
		testStepPassed("Carousel Link is -"+podcastsName);
		if (this.driver.findElements(By.xpath((String) this.locator)) != null) {
			this.waitForElement(strPropertykey);
			WebElement link = this.driver.findElement(By.xpath((String) this.locator));
			Actions newTab = new Actions(driver);
			newTab.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
			waitTime(5);
			testStepPassed("Openend the article in a new tab");
			//handle windows change
			String base = driver.getWindowHandle();
			Set<String> set = driver.getWindowHandles();
			 
			set.remove(base);
			assert set.size() == 1;
			driver.switchTo().window((String) set.toArray()[0]);
			
			/*String podcastsTitle = getText(strPropertykey);
			testStepPassed("Carousel Link is -"+podcastsTitle);*/
			String title=driver.getTitle();
			testStepPassed("Title of the page "+title);
			if(podcastsName.equalsIgnoreCase(title)||!title.equals("404"))
			{
				testStepPassed("Navigated to correct Podcasts Page");
			}
			else
			{
				testStepFailed("Failed to navigate Podcasts Page");
			}
			boolean ads=elementPresent(OR.ads_Podcasts_Page_PodcastsAds);
			if(ads==true)
			{
				testStepPassed("Podcasts Ads is present");
			}
			else
			{
				testStepFailed("Podcasts Ads is not present");
			}
			waitTime(3);
			
			//close the window
			driver.close();
			driver.switchTo().window(base);
			testStepInfo("Closed the tab");
			// handle windows change and switch back to the main window
			Thread.sleep(2500);
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
					}
		}
	else {
		getCurrentPageURL();
		testStepFailed("No web element found");
		}
	}catch (Exception e) {
		ApplicationKeywords.writeToLogFile((String) "ERROR",
				(String) ("Exception: " + e.toString()));
		}
	
	}

	public void openPodcastsLinksInWindow(String strPropertykey) throws InterruptedException{
		
		try{
			String podcastsName = getText(strPropertykey);
			testStepPassed("Carousel Link is -"+podcastsName);
			
			
			if (this.driver.findElements(By.xpath((String) this.locator)) != null) {
				this.waitForElement(strPropertykey);
				WebElement link = this.driver.findElement(By.xpath((String) this.locator));
				Actions newTab = new Actions(driver);
				newTab.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
				waitTime(5);
				testStepPassed("Openend the article in a new tab");
				//handle windows change
				String base = driver.getWindowHandle();
				Set<String> set = driver.getWindowHandles();
				 
				set.remove(base);
				assert set.size() == 1;
				driver.switchTo().window((String) set.toArray()[0]);
				
				
				String title=driver.getTitle();
				testStepPassed("Title of the page "+title);
				
				boolean ads=elementPresent(OR.ads_Podcasts_Page_PodcastsAds);
				if(ads==true)
				{
					testStepPassed("Podcasts Ads is present");
				}
				else
				{
					testStepFailed("Podcasts Ads is not present");
				}
				waitTime(3);
				
				//close the window
				driver.close();
				driver.switchTo().window(base);
				testStepInfo("Closed the tab");
				// handle windows change and switch back to the main window
				Thread.sleep(2500);
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
						}
			}
		else {
			getCurrentPageURL();
			testStepFailed("No web element found");
			}
		}catch (Exception e) {
			ApplicationKeywords.writeToLogFile((String) "ERROR",
					(String) ("Exception: " + e.toString()));
			}
		
		}
	
	public void validateCarouselLayout()
	{
		try {
			boolean carouselLayout=elementPresent(OR.txt_AngularGalleryCheck_ImagesBox);
			
			if(carouselLayout==true)
			{
				String slideContent=getText(OR.txt_podcasts_Page_Name);
				testStepPassed(slideContent);
				openPodcastsInNewtab(OR.txt_podcasts_Page_Name);
				int countSlide=getElementCount(OR.txt_Article_Page_contributor_Forbes_Staff_Name);
				testStepPassed("Total Number of Slides -"+countSlide);
				testStepPassed("Carousel Layout is present");
				boolean previousButton=elementPresent(OR.btn_Contributor_Page_Prev);
				boolean nextButton=elementPresent(OR.btn_Contributor_Page_Next);
				if(previousButton==true ||nextButton==true)
				{
					for (int i = 2; i <=countSlide; i++) {
						
							clickOn(OR.btn_Contributor_Page_Next);
							//waitTime(5);
							openPodcastsInNewtab(OR.txt_podcasts_Page_Name);
						
					}
				}
				else
				{
					testStepFailed("Previous and next Buttons are displayed");
				}
			}
			else
			{
				testStepFailed("Carousel Layout is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
		
		
	}
	
	public void validateCarousel()
	{
		try {
			int countSlide=getElementCount(OR.txt_Article_Page_contributor_Forbes_Staff_Name);
			testStepPassed("Total Number of Slides -"+countSlide);
			testStepPassed("Carousel Layout is present");
			boolean previousButton=elementPresent(OR.btn_Contributor_Page_Prev);
			boolean nextButton=elementPresent(OR.btn_Contributor_Page_Next);
			if(previousButton==true ||nextButton==true)
			{
				for (int i = 1; i <=countSlide; i++) {
					
						clickOn(OR.btn_Contributor_Page_Next);
						//waitTime(5);
						openPodcastsInNewtab(OR.txt_podcasts_Page_Name);
					
				}
			}
			else
			{
				testStepFailed("Previous and next Buttons are displayed");
			}
			
		} catch (InterruptedException e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateForbesPodcastsSection(String forbesPodcasts,int sectionId)
	{
		testStepInfo("************************************** Validating Forbes Podcasts Section-"+sectionId);
		try {
			
			boolean forbespodcasts5=elementPresent(forbesPodcasts);
			if(forbespodcasts5==true)
			{
				int count=getElementCount(forbesPodcasts);
				testStepPassed("Total CSF blocks are -"+count);
				for (int i = 1; i <=count; i++) {
					openPodcastsLinksInWindow("Section#xpath=//section["+sectionId+"]/div/ul/li/div/div["+i+"]//a//h3");
					/*String section5="Section#xpath=//section["+sectionId+"]//ul//li//div//div["+i+"]//a//h3";
					String getCSF=getText(section5);
					testStepPassed("CSF Heading is - "+getCSF);*/
				}
			}
			else
			{
				testStepInfo("CSF blocks are not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	

	
	public void validatePodcatsAds(String ads)
	{
		testStepInfo("********************************************** Validate Ads ***********************************************");
		
		try {
			boolean topAds=elementPresent(ads);
			if(topAds==true)
			{
				testStepPassed("Podcasts Top ads is displayed");
			}
			else
			{
				testStepFailed("Podcasts Top ads is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validatePodcastsHeading()
	{
		testStepInfo("********************************************** Validate Heading ***********************************************");
		try {
			
				boolean heading=elementPresent(OR.img_Podcasts_Page_Heading);
				if(heading==true)
				{
					testStepPassed("Podcasts heading is displayed");
				}
				else
				{
					testStepFailed("Podcasts heading is not displayed");
				}
			
			
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateSocialNetworks()
	{
		testStepInfo("********************************************** Social Shares ***********************************************");
		try {
			boolean socialShare=elementPresent(OR.img_Podcasts_Page_Social_Share);
			if(socialShare==true)
			{
				clickOn(OR.img_Podcasts_Page_Social_Share);
				int countSocialShares=getElementCount(OR.img_Podcasts_Page_Social_Share);
				testStepPassed("Podcasts Social shares are present----"+countSocialShares);
				clickOn("Close#xpath=//button[@class='button']");
			}
			else
			{
				testStepFailed("Podcasts Social shares are not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
}
