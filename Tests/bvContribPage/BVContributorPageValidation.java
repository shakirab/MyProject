package bvContribPage;

import iSAFE.ApplicationKeywords;


import objectsRepository.OR;


import baseClass.BaseClass;

public class BVContributorPageValidation extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	public BVContributorPageValidation(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public BVContributorPageValidation() {

	}

	
	public void validateBVContributorPage() {
		testStepInfo("************************************************** BrandVoice Contributor Page ****************************************************");
		if (currentExecutionMachineName.equalsIgnoreCase("Cont_BV"))
		{
			
			verifyAuthorName();
			validatecontributorDetails(OR.img_Reg_Contributor_Page_Image,OR.txt_Reg_BrandVoice_Contrib_Type,"BV ");
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
		else
		{
		
			verifyAuthorNameInMobile();
			validatecontributorDetails(OR.img_Reg_Contributor_Page_Image,OR.txt_Reg_BrandVoice_Contrib_Type,"BV");
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
		
	}
}