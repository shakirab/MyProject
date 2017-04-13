package bvArticlePage;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class BVArticlePageValidation extends ApplicationKeywords{
	/** The obj. */
	BaseClass obj;

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :
	// Purpose :
	// Parameters :
	// Return Value :
	// Created by :
	// Created on :
	// Remarks :
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Instantiates  BV Article Page Functions
	 *
	 * @param obj
	 *            the obj
	 */
	public BVArticlePageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates BV Article Page Functions.
	 */
	public BVArticlePageValidation() {

		// TODO Auto-generated constructor st ub
	}
	
	public void verifyBVArticlepageContents(){
		testStepInfo("*********************************BV Article Page validation**********************************");
		waitTime(5);
		if (currentExecutionMachineName.equalsIgnoreCase("Cont_BV")) {

			verifyBVArticlePageContentsOnDesktop();

		} else {
			verifyBVArticlePageContentsOnMobile();
		}
	}
	
	public void verifyBVArticlePageContentsOnDesktop(){
		try{
			waitForElement(OR.txt_Reg_BrandVoice_PromoSection);
			clickOn(OR.txt_Reg_BrandVoice_PromoSection);
			waitTime(3);
			//validateArticleTopAds();
			verifyAdsInArticle();
			verifyWhatisthisOnDesktop();
			checkArticleTimeStampandViews();
			validateLeftRailArticleNavigation(OR.txt_Reg_Home_Page_HeadLine_Article, OR.txt_Reg_Article_Page_LeftRail_Article_Heading);
			validateAuthorDetailsForDesktop();
			validateSocialnetworks(OR.img_Reg_Article_Page_Social_Shares);
			validateFullBio();
			validateRecommended();
			validatePrintBar();
			scrollBy(0, 3000);
			scrollBy(0, -300);
			validateLoadMoreNextArticle();

		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	
	public void verifyBVArticlePageContentsOnMobile(){
		boolean promoBlock=elementPresent(OR.txt_Reg_Brandvoice_Article_Page_Promo);
		if(promoBlock==true)
		{
			clickOn(OR.txt_Reg_Brandvoice_Article_Page_Promo);
			
			
			validateAuthorDetailsForMobile();
			//verifyeFullBioInArticlePage();
			validateAuthorName(OR.txt_Reg_BrandVoice_Article_Page_AuthorName);
			
			validateSocialShare();
			validateFullBio();
			scrollBy(0, 400);
			clickOn(OR.btn_Mob_Article_Page_Full_Bio);
			verifyAdsInMobileArticle();
			validateRecommendedLabel();
			scrollBy(0, 2000);
			waitTime(3);
			scrollBy(0, 700);
			validatePrintBar();
			validateAdStream();
			
		}
		else
		{
			testStepFailed("Promo Block is not displayed");
		}
		
	}

}
