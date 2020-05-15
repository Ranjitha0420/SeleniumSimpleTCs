package com.training.pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ELearningAssignmentsPOM {
	private WebDriver driver; 
	
	public ELearningAssignmentsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[contains(text(),'My courses')]")
	private WebElement LinkMyCourses;
	
	@FindBy(xpath="//a[contains(text(),'Selenium with Java')]")
	private WebElement LinkCourseSeleniumwithJava; 
	
	@FindBy(xpath="//a[@id='istooldesc_19506']")
	private WebElement LinkAssignments;
	
	@FindBy(xpath="//a[contains(text(),'Assignment1')]")
	private WebElement LinkAssignment1;
	
	@FindBy(xpath="//a[@class='btn-toolbar']")
	private WebElement ButtonUploadmyAssignment; 
			
	@FindBy(xpath="//a[@id='tabs2']")
	private WebElement TabUploadSimple; 
	
	@FindBy(xpath="//input[@id='file_upload']")
	private WebElement TextTitle;
	
	@FindBy(xpath="//input[@id='form-work_file']")
	private WebElement ButtonChooseFile;
	
	//C:\Ranjitha\IBM Upskill LP B21\Lab\TestAssignment.docx
	
	@FindBy(xpath="//em[@class='fa fa-upload']/parent::button")
	private WebElement ButtonUpload;
	
	@FindBy(xpath="//div[@class='alert alert-info']")
	private WebElement SuccessMessage;
	
	@FindBy(xpath="//div[@class='work-title']")
	private WebElement Submittedassignment;
	
	
	
	public void clickLinkMyCourses() {	
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOf(this.LinkMyCourses));
		this.LinkMyCourses.click();
	}
	
	public void clickLinkCourseSeleniumwithJava() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.LinkCourseSeleniumwithJava));
		this.LinkCourseSeleniumwithJava.click();
	}
	
	public void clickLinkAssignments() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.LinkAssignments));
		this.LinkAssignments.click();
	}
	
	public void clickLinkAssignment1() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.LinkAssignment1));
		this.LinkAssignment1.click();
	}
	
	public void clickButtonUploadmyAssignment() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.ButtonUploadmyAssignment));
		this.ButtonUploadmyAssignment.click();
	}
	
	public void clickTabUploadSimple() {	
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.TabUploadSimple));
		this.TabUploadSimple.click();
	}
	
	public void enterTextTitle(String title) {	
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.TextTitle));
		this.TextTitle.sendKeys(title);
	}
	
	public void clickButtonChooseFile() {		
		this.ButtonChooseFile.click();
	}
	
	public void clickButtonUpload() {		
		this.ButtonUpload.click();
	}
	
	public boolean verifysuccessmessage(){
		boolean successmsg = this.SuccessMessage.isDisplayed();
		return successmsg;
	}

	public boolean verifysubmittedassignment(){
		boolean suubmitted = this.Submittedassignment.isDisplayed();
		return suubmitted;
	}
}
