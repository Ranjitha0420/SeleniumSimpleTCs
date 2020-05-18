package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ELearningForumPOM {
private WebDriver driver; 
	
	public ELearningForumPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[contains(text(),'My courses')]")
	private WebElement LinkMyCourses;
	
	@FindBy(xpath="//a[contains(text(),'Selenium with Java')]")
	private WebElement LinkCourseSeleniumwithJava; 
	
	@FindBy(xpath="//a[text()='Forums']")
	private WebElement LinkForum;
	
	@FindBy(xpath="//a[@title='Group 0001']")
	private WebElement LinkGroup;
	
	
	@FindBy(xpath="//img[@title='Create thread']")
	private WebElement imgCreateThread;
	
	
	@FindBy(xpath="//input[@id='thread_post_title']")
	private WebElement  txtThreadTitle;
	
	@FindBy(xpath="//iframe")
	private WebElement  txtThreadText;
	
	@FindBy(xpath="//button[@id='thread_SubmitPost']")
	private WebElement  btnCreateThread;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement  successmessage;
	
	@FindBy(xpath="//a[@title='Reply to this message']")
	private WebElement  btnReplytoPost;
	
	
	@FindBy(xpath="//button[@id='thread_SubmitPost']")
	private WebElement  btnSubmitReply;
	
	public void clickLinkMyCourses() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.LinkMyCourses));
		this.LinkMyCourses.click();
	}
	
	public void clickLinkCourseSeleniumwithJava() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.LinkCourseSeleniumwithJava));
		this.LinkCourseSeleniumwithJava.click();
	}
	
	public void clickLinkForum() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.LinkForum));
		this.LinkForum.click();
	}
	
	public void clickLinkGroup() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.LinkGroup));
		this.LinkGroup.click();
	}
	
	public void clickimgCreateThread(){		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.imgCreateThread));
		this.imgCreateThread.click();
	}
	
	public void entertxtThreadTitle(String title) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.txtThreadTitle));
		this.txtThreadTitle.click();
		this.txtThreadTitle.sendKeys(title);
		
	}
	
	public void entertxtThreadText(String text1) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.txtThreadText));
		//driver.switchTo().frame(0);
		
		//int size = driver.findElements(By.tagName("iframe")).size();
		
		driver.findElement(By.xpath("(//iframe)[1]")).click();		
		
		String text = text1;
		StringSelection stringSelection = new StringSelection(text);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);;
		
		try {
			Robot robot;
			robot = new Robot();
			 
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 robot.keyPress(KeyEvent.VK_V);
			 
			// Release CTRL+V
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 robot.keyRelease(KeyEvent.VK_V);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.findElement(By.tagName("iframe")).sendKeys(text);
		//System.out.println("Size"+size);
		driver.switchTo().defaultContent();
		
	}
	
	public void clickbtnCreateThread() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.btnCreateThread));
		this.btnCreateThread.click();
		

	}
	
	public boolean verifysuccessmessage(){
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.successmessage));
		boolean verification = this.successmessage.isDisplayed();
		return verification;
	}
	
	public void clickbtnReplytoPost() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.btnReplytoPost));
		this.btnReplytoPost.click();
	}
	
	public void entertxtThreadReply(String reply) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.txtThreadText));
		driver.switchTo().frame(txtThreadText);
		this.txtThreadText.click();
		this.txtThreadText.sendKeys(reply);
		driver.switchTo().defaultContent();
	}
		
	public void clickbtnSubmitReply() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.btnSubmitReply));
		this.btnSubmitReply.click();
	}
	
}
