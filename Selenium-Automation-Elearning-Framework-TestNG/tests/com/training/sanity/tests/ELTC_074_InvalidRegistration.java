package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.ELearningForumPOM;
import com.training.pom.ELearningLoginPOM;
import com.training.pom.ELearningMyCoursesPOM;
import com.training.pom.ELearningRegisterToSitePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_074_InvalidRegistration {
	private WebDriver driver;
	private String baseUrl;
	private ELearningRegisterToSitePOM eLearningRegisterToSitePOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

	}
	
	
	
	@Test(dataProvider="excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void testingexcelinput(String firstName, String	lastName, String eMail, String userName, String password,
			String confirmPass, String phone, String language) throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		eLearningRegisterToSitePOM = new ELearningRegisterToSitePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		screenShot.captureScreenShot("ELTC074_InvalidReg_1_First");
		eLearningRegisterToSitePOM.clickLinkSignup();
		screenShot.captureScreenShot("ELTC074_InvalidReg_2_Second");
		eLearningRegisterToSitePOM.clickOptionTeacher();
		eLearningRegisterToSitePOM.setTextFirstName(firstName);
		eLearningRegisterToSitePOM.setTextLastName(lastName);
		eLearningRegisterToSitePOM.setTextEmail(eMail);
		screenShot.captureScreenShot("ELTC074_InvalidReg_3_Thirs");
		eLearningRegisterToSitePOM.setTextUserName(userName);
		eLearningRegisterToSitePOM.setTextPassword(password);
		eLearningRegisterToSitePOM.setTextConfPassword(confirmPass);
		eLearningRegisterToSitePOM.setTextPhone(phone);
		eLearningRegisterToSitePOM.selectLanguage(language);
		screenShot.captureScreenShot("ELTC074_InvalidReg_4_Fourth");
		eLearningRegisterToSitePOM.clickBtnRegister();
		eLearningRegisterToSitePOM.verifywarningMessage();
		screenShot.captureScreenShot("ELTC074_InvalidReg_5_Fifth");
				
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}
