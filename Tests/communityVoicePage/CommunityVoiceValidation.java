package communityVoicePage;

import objectsRepository.OR;
import iSAFE.ApplicationKeywords;
import baseClass.BaseClass;


	public class CommunityVoiceValidation extends ApplicationKeywords {

		// //////////////////////////////////////////////////////////////////////////////
		// Function Name :Community Voice Validation
		// Created by :Shakira
		// Created on :6 June 2016

		// ///////////////////////////////////////////////////////////////////////////////
		/** The obj. */
		BaseClass obj;

		
		public CommunityVoiceValidation(BaseClass obj) {
			// TODO Auto-generated constructor stub
			super(obj);
			this.obj = obj;
		}

		public CommunityVoiceValidation() {

		}
		
		public void validateCommunityVoicePage()
		{
			if (currentExecutionMachineName.equalsIgnoreCase("Cont_BV"))
			{
			
			driver.get("http://www.forbes.com/sites/yec/");
			verifyAuthorName();
			validateSocialnetworks(OR.img_Reg_contributor_Page_SocialShares);
			validateVoiceLogo(OR.txt_Community_Voice_Page_Forbes_CommunityVoice_Logo,OR.txt_Community_Voice_Page_CommunityVoice_Logo,"Community Voice");
			validateTagLine(OR.txt_community_Voice_Page_CommunityVoiceTag);
			//verifyFullBio();
			
			verifyFollowInDeskyop(OR.btn_Contributor_Page_Follow);
			validateNetworkShares(OR.img_Reg_Contributor_Page_NetworkShares);
			validateOurWriters();
			validateWritersHomePage();
			validateTopAds(OR.ads_Reg_Contributor_Page_TopAds);
			validateRecAds(OR.ads_Reg_Contributor_Page_RecAds);
			validateRecAds(OR.ads_Reg_Contributor_Page_RecAds2);
			validateTopxAds(OR.ads_Reg_Contributor_Page_TopxAds);
			validatePromoVideoBlock();
			scrollBy(0, -1000);
			validateArchiveContributor();
			//validateLatestPostsImages();
			clickingAllLatestPosts();
			
			validateMostPopularArticles();
			}
			else
			{
				driver.get("http://www.forbes.com/sites/yec/");
				verifyAuthorNameInMobile();
				validateContributorImage(OR.img_Reg_Contributor_Page_Image);
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
					testStepFailed("Share Button is not displayed");
				}
				
				verifyFollowInDeskyop(OR.btn_Contributor_Page_Follow);
				validateNetworkShares(OR.img_Reg_Contributor_Page_NetworkShares);
				validateTopAds(OR.ads_Welcome_Page_Ads);
				validateArchiveContributor();
				validateLatestPostsInMobile();
				validateRecAds(OR.ads_Podcasts_Page_TopAds);
				validateMostPopularArticlesInMobile();
				validateOurWriters();
				validateWritersHomePage();
				
				
				
			}
		}
		
		
}
