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
import com.training.pom.ELearningLoginPOM;
import com.training.pom.ELearningMyCoursesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_043_UploadAssignment {
	private WebDriver driver;
	private String baseUrl;
	private ELearningLoginPOM eLearningLoginPOM;
	private ELearningMyCoursesPOM eLearningMyCoursesPOM;
	private ELearningAssignmentsPOM eLearningAssignmentsPOM;
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
		eLearningAssignmentsPOM = new ELearningAssignmentsPOM(driver);
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
		screenShot.captureScreenShot("ELTC_043_UploadAssignment_1_First");
		eLearningLoginPOM.clickLoginBtn(); 
		
	}
	
	@Test(priority=3)
	public void uploadAssignmentTest() {

		try{
			
		Thread.sleep(5000);
		eLearningAssignmentsPOM.clickLinkMyCourses();
		screenShot.captureScreenShot("ELTC_043_UploadAssignment_2_Second");
		Thread.sleep(5000);
		eLearningAssignmentsPOM.clickLinkCourseSeleniumwithJava();
		screenShot.captureScreenShot("ELTC_043_UploadAssignment_3_Third");
		Thread.sleep(5000);
		eLearningAssignmentsPOM.clickLinkAssignments();
		screenShot.captureScreenShot("ELTC_043_UploadAssignment_4_Fourth");
		Thread.sleep(5000);
		eLearningAssignmentsPOM.clickLinkAssignment1();
		screenShot.captureScreenShot("ELTC_043_UploadAssignment_5_Fifth");
		Thread.sleep(6000);
		eLearningAssignmentsPOM.clickButtonUploadmyAssignment();
		screenShot.captureScreenShot("ELTC_043_UploadAssignment_6_Sixth");
		Thread.sleep(5000);
		eLearningAssignmentsPOM.clickTabUploadSimple();
		screenShot.captureScreenShot("ELTC_043_UploadAssignment_7_Seventh");
		Thread.sleep(5000);
		eLearningAssignmentsPOM.enterTextTitle("Assignment1");
		screenShot.captureScreenShot("ELTC_043_UploadAssignment_8_Eighth");
		Thread.sleep(5000);
		//eLearningAssignmentsPOM.clickButtonChooseFile();
		//Thread.sleep(5000);
		screenShot.captureScreenShot("ELTC_043_UploadAssignment_9_Ninth");
		String text = "C:\\Ranjitha\\IBM Upskill LP B21\\Lab\\TestAssignment.docx";
		StringSelection stringSelection = new StringSelection(text);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);;
		// Clipboard c = tol.getSystemClipboard();
		
		
		
		Robot robot = new Robot();
		 Thread.sleep(2000);
		      
		robot.keyPress(KeyEvent.VK_TAB);	 
		 robot.keyRelease(KeyEvent.VK_TAB);
		 
		 Thread.sleep(2000);
		 robot.keyPress(KeyEvent.VK_TAB);	 
		 robot.keyRelease(KeyEvent.VK_TAB);
		 Thread.sleep(2000);
		 
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 Thread.sleep(2000);
		  // Press CTRL+V
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		 
		// Release CTRL+V
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_V);
		 Thread.sleep(2000);
		
		
		Thread.sleep(5000);
//		robot.keyPress(KeyEvent.VK_TAB);	 
//		robot.keyRelease(KeyEvent.VK_TAB);
//		
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_END);	 
		robot.keyRelease(KeyEvent.VK_END);
		Thread.sleep(5000);
		
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		 
		 
		 Thread.sleep(5000);
		 eLearningAssignmentsPOM.clickButtonUpload();
		 Thread.sleep(5000);
		 screenShot.captureScreenShot("ELTC_043_UploadAssignment_10_Tenth");
		
		 boolean msg= eLearningAssignmentsPOM.verifysuccessmessage();
		 Assert.assertTrue(msg);
		 
		 
		 boolean assignmentsubmitted= eLearningAssignmentsPOM.verifysubmittedassignment();
		 Assert.assertTrue(assignmentsubmitted);
		 screenShot.captureScreenShot("ELTC_043_UploadAssignment_11_Eleventh");
		}catch(Exception e){
		e.printStackTrace();	
		}
		
	}
	
	@Test(priority=4)
	public void validLogoutTest() {		
		
		eLearningMyCoursesPOM.clickMyAccountMenu();
		
		boolean logoutVisibility = eLearningMyCoursesPOM.verifyLogoutVisibility();
		Assert.assertTrue(logoutVisibility);
		screenShot.captureScreenShot("ELTC_043_UploadAssignment_12_Twelfth");
		
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
