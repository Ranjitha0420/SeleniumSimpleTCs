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
import com.training.pom.ELearningLoginPOM;
import com.training.pom.ELearningMyCoursesPOM;
import com.training.pom.ELearningSendChatMessageToGroupPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_045_SendChatMessage {
	private WebDriver driver;
	private String baseUrl;
	private ELearningLoginPOM eLearningLoginPOM;
	private ELearningMyCoursesPOM eLearningMyCoursesPOM;
	private ELearningSendChatMessageToGroupPOM eLearningSendChatMessageToGroupPOM;
	
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
		eLearningSendChatMessageToGroupPOM = new ELearningSendChatMessageToGroupPOM(driver);
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
		screenShot.captureScreenShot("ELTC_045_SendChatMessage_1_First");
		eLearningLoginPOM.clickLoginBtn(); 
		
	}
	
	@Test(priority=3)
	public void sendChatMessageTest() {

		eLearningSendChatMessageToGroupPOM.clickLinkMyCourses();
		screenShot.captureScreenShot("ELTC_045_SendChatMessage_2_Second");

		eLearningSendChatMessageToGroupPOM.clickLinkCourseSeleniumwithJava();
		screenShot.captureScreenShot("ELTC_045_SendChatMessage_3_Third");
		
		eLearningSendChatMessageToGroupPOM.clickLinkGroups();
		screenShot.captureScreenShot("ELTC_045_SendChatMessage_4_Fourth");

		eLearningSendChatMessageToGroupPOM.clickLinkGroupname();
		screenShot.captureScreenShot("ELTC_045_SendChatMessage_5_Fifth");
		
		eLearningSendChatMessageToGroupPOM.clickimgChat();
		screenShot.captureScreenShot("ELTC_045_SendChatMessage_6_Sixth");
		
		eLearningSendChatMessageToGroupPOM.clicklinkLeavemsg();
		screenShot.captureScreenShot("ELTC_045_SendChatMessage_7_Seventh");
		
		eLearningSendChatMessageToGroupPOM.sendchatmessage();
		screenShot.captureScreenShot("ELTC_045_SendChatMessage_8_Eigth");
		
		eLearningSendChatMessageToGroupPOM.viewsentMessage();
		screenShot.captureScreenShot("ELTC_045_SendChatMessage_9_Ninth");
		
	}
	
	public void validLogoutTest() {		
		
		eLearningMyCoursesPOM.clickMyAccountMenu();
		
		boolean logoutVisibility = eLearningMyCoursesPOM.verifyLogoutVisibility();
		Assert.assertTrue(logoutVisibility);
		screenShot.captureScreenShot("ELTC_045_SendChatMessage_13_Thirteenth");
		
		eLearningMyCoursesPOM.clickLogoutLink();

		}
	//keep assert in the test 
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
