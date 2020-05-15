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
import com.training.pom.ELearningMyCoursesDetailsPOM;
import com.training.pom.ELearningMyCoursesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC014_ViewRegisteredCourses {

	private WebDriver driver;
	private String baseUrl;
	private ELearningLoginPOM eLearningLoginPOM;
	private ELearningMyCoursesPOM eLearningMyCoursesPOM;
	private ELearningMyCoursesDetailsPOM eLearningMyCoursesDetailsPOM;
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
		eLearningMyCoursesDetailsPOM = new ELearningMyCoursesDetailsPOM(driver);
		
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=2)
	public void validLoginTest() {
		eLearningLoginPOM.sendUserName("reva321");
		eLearningLoginPOM.sendPassword("Pa55word");
		screenShot.captureScreenShot("ELTC014_RegisteredCourseTest_1_First");
		eLearningLoginPOM.clickLoginBtn(); 	
	}
	
	@Test(priority=3)
	public void validRegisteredCoursesTest() {
		
		eLearningMyCoursesPOM.clickLinkMyCourses();
		
		screenShot.captureScreenShot("ELTC014_RegisteredCourseTest_2_Second");
		
		boolean firstcoursevisible = eLearningMyCoursesDetailsPOM.verifyLinkFirstCourse();
		Assert.assertTrue(firstcoursevisible);
		
		boolean secondcoursevisible = eLearningMyCoursesDetailsPOM.verifyLinkSecondCourse();
		Assert.assertTrue(secondcoursevisible);
		
		eLearningMyCoursesDetailsPOM.clickLinkSecondCourse();
		
		screenShot.captureScreenShot("ELTC014_RegisteredCourseTest_3_Third");
		
		eLearningMyCoursesDetailsPOM.clickLinkSecondCourseDesc();
		
		boolean secondcoursedescvisible = eLearningMyCoursesDetailsPOM.verifyLinkSecondCourseDescription();
		Assert.assertTrue(secondcoursedescvisible);
		
		screenShot.captureScreenShot("ELTC014_RegisteredCourseTest_4_Fourth");
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		eLearningMyCoursesPOM.clickMyAccountMenu();
		eLearningMyCoursesPOM.clickLogoutLink();		
		Thread.sleep(1000);
		driver.quit();
	}
}
