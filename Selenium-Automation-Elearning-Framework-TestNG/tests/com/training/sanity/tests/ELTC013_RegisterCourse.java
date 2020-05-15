package com.training.sanity.tests;

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
import com.training.pom.ELearningRegisterToCoursePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC013_RegisterCourse {

	private WebDriver driver;
	private String baseUrl;
	private ELearningLoginPOM eLearningLoginPOM;
	private ELearningRegisterToCoursePOM eLearningRegisterToCoursePOM;
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
		eLearningRegisterToCoursePOM = new ELearningRegisterToCoursePOM(driver);
		eLearningMyCoursesPOM = new ELearningMyCoursesPOM(driver);
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
		eLearningLoginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("ELTC013_RegisterCourse_1_First");
	
	}
	
	@Test(priority=3)
	public void validRegisterCourseTest() {
		
		eLearningRegisterToCoursePOM.clickCourseCatalog();
		eLearningRegisterToCoursePOM.setSearchTerm("selenium");
		screenShot.captureScreenShot("ELTC013_RegisterCourse_2_Second");
		eLearningRegisterToCoursePOM.clickFirstResult();		
		eLearningRegisterToCoursePOM.verifySuccessMessage();
		String msg =  eLearningRegisterToCoursePOM.getsuccessMessage(); 
		
		Assert.assertTrue(msg.contains("User reva321 reva321 (reva321) has been registered to course"));
		screenShot.captureScreenShot("ELTC013_RegisterCourse_3_Third");
		
	}
	
	
	
	@AfterClass
	public void tearDown() throws Exception {
		eLearningMyCoursesPOM.clickMyAccountMenu();
		eLearningMyCoursesPOM.clickLogoutLink();
		Thread.sleep(1000);
		driver.quit();
	}
}
