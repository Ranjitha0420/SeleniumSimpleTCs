package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ELearningLoginPOM;
import com.training.pom.ELearningMyCoursesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC015_LogoutTest {

	private WebDriver driver;
	private String baseUrl;
	private ELearningLoginPOM eLearningLoginPOM;
	private ELearningMyCoursesPOM eLearningMyCoursesPOM;
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
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test(priority=2)
	public void validLoginTest() {
		eLearningLoginPOM.sendUserName("reva3210");
		eLearningLoginPOM.sendPassword("Pa55word");
		screenShot.captureScreenShot("ELTC015_LogoutTest_1_First");
		eLearningLoginPOM.clickLoginBtn(); 
		
	}
	
	@Test(priority=3)
	public void validPostLoginTest() {
		String wlcmsg = eLearningMyCoursesPOM.getWelcomeMessage();
		Assert.assertEquals(wlcmsg, "Hello reva321 reva321 and welcome,");
		
		boolean inboxvisible = eLearningMyCoursesPOM.verifyInboxVisiblity();
		Assert.assertTrue(inboxvisible);

		boolean mycertVisibility = eLearningMyCoursesPOM.verifyMyCertificatesVisibility();
		Assert.assertTrue(mycertVisibility);
		screenShot.captureScreenShot("ELTC015_LogoutTest_2_Second");
		
	}
	@Test(priority=4)
	public void validLogoutTest() {		
		
		eLearningMyCoursesPOM.clickMyAccountMenu();
		
		boolean logoutVisibility = eLearningMyCoursesPOM.verifyLogoutVisibility();
		Assert.assertTrue(logoutVisibility);
		screenShot.captureScreenShot("ELTC015_LogoutTest_3_Third");
		
		eLearningMyCoursesPOM.clickLogoutLink();
		screenShot.captureScreenShot("ELTC015_LogoutTest_4_Fourth");
		
		Assert.assertTrue("Hey Ho, let's go".contains("Hey"));
		
	}
	//keep assert in the test 
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}
