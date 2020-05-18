package com.training.sanity.tests;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ELearningAssignmentsPOM;
import com.training.pom.ELearningForumPOM;
import com.training.pom.ELearningLoginPOM;
import com.training.pom.ELearningMyCoursesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_044_DiscussinForum {
	private WebDriver driver;
	private String baseUrl;
	private ELearningLoginPOM eLearningLoginPOM;
	private ELearningMyCoursesPOM eLearningMyCoursesPOM;
	private ELearningForumPOM eLearningForumPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@Test(priority=1)
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		eLearningLoginPOM = new ELearningLoginPOM(driver); 
		eLearningMyCoursesPOM = new ELearningMyCoursesPOM(driver);
		eLearningForumPOM = new ELearningForumPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test(priority=2)
	public void validLoginTest() {
		eLearningLoginPOM.sendUserName("reva321");
		eLearningLoginPOM.sendPassword("Pa55word");
		screenShot.captureScreenShot("ELTC_044_DiscussinForum_1_First");
		eLearningLoginPOM.clickLoginBtn(); 
		
	}
	
	@Test(priority=3)
	public void validCreateReplyThread() {

		try{
			
		Thread.sleep(5000);
		eLearningForumPOM.clickLinkMyCourses();
		
		screenShot.captureScreenShot("ELTC_044_DiscussinForum_2_Second");
		Thread.sleep(5000);
		eLearningForumPOM.clickLinkCourseSeleniumwithJava();
		screenShot.captureScreenShot("ELTC_044_DiscussinForum_3_Third");
		Thread.sleep(5000);
		eLearningForumPOM.clickLinkForum();
		screenShot.captureScreenShot("ELTC_044_DiscussinForum_4_Fourth");
		Thread.sleep(5000);
		
		eLearningForumPOM.clickLinkGroup();
		screenShot.captureScreenShot("ELTC_044_DiscussinForum_5_Fifth");
		Thread.sleep(5000);
		
		eLearningForumPOM.clickimgCreateThread();
		screenShot.captureScreenShot("ELTC_044_DiscussinForum_6_Sixth");
		Thread.sleep(5000);
		
		
		eLearningForumPOM.entertxtThreadTitle("Discussion on xpath");
		screenShot.captureScreenShot("ELTC_044_DiscussinForum_7_Seventh");
		Thread.sleep(10000);
		
		eLearningForumPOM.entertxtThreadText("Discussion on xpath initiated");
		screenShot.captureScreenShot("ELTC_044_DiscussinForum_8_Eigth");
		Thread.sleep(5000);
		
		eLearningForumPOM.clickbtnCreateThread();
		screenShot.captureScreenShot("ELTC_044_DiscussinForum_9_Ninth");
		Thread.sleep(5000);
		
		boolean msgdisplayed = eLearningForumPOM.verifysuccessmessage();
		Assert.assertEquals(true, msgdisplayed);
		
		eLearningForumPOM.clickbtnReplytoPost();
		screenShot.captureScreenShot("ELTC_044_DiscussinForum_10_Tenth");
		Thread.sleep(10000);
		
		eLearningForumPOM.entertxtThreadText("Replying to thread");
		screenShot.captureScreenShot("ELTC_044_DiscussinForum_11_Eleventh");
		Thread.sleep(5000);
		
		eLearningForumPOM.clickbtnSubmitReply();
		screenShot.captureScreenShot("ELTC_043_UploadAssignment_12_Twelfth");
		Thread.sleep(5000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=4)
	public void validLogoutTest() {		
		
		eLearningMyCoursesPOM.clickMyAccountMenu();
		
		boolean logoutVisibility = eLearningMyCoursesPOM.verifyLogoutVisibility();
		Assert.assertTrue(logoutVisibility);
		screenShot.captureScreenShot("ELTC_043_UploadAssignment_13_Thirteenth");
		
		eLearningMyCoursesPOM.clickLogoutLink();

		
		Assert.assertTrue("Hey Ho, let's go".contains("Hey"));
		
	}
	//keep assert in the test 
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
