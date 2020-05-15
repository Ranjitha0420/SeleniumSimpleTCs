package com.training.pom;

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
	
	@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement  txtThreadText;
	
	@FindBy(xpath="//button[@id='thread_SubmitPost']")
	private WebElement  btnCreateThread;
	
	
	@FindBy(xpath="//a[@id='reply-to-post-91']")
	private WebElement  btnReplytoPost;
	
	@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement  txtThreadReply;
	
	
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
	
	public void entertxtThreadTitle(String title) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.txtThreadTitle));
		this.txtThreadTitle.click();
		this.txtThreadTitle.sendKeys(title);
	}
	
	public void entertxtThreadText(String text) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.txtThreadText));
		driver.switchTo().frame(txtThreadText);
		this.txtThreadText.click();
		this.txtThreadTitle.sendKeys(text);
		driver.switchTo().parentFrame();
		
	}
	
	public void clickbtnCreateThread() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.btnCreateThread));
		this.btnCreateThread.click();
	}
	
	public void clickbtnReplytoPost() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.btnReplytoPost));
		this.btnReplytoPost.click();
	}
	
	public void entertxtThreadReply(String reply) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.txtThreadReply));
		driver.switchTo().frame(txtThreadReply);
		this.txtThreadReply.click();
		this.txtThreadReply.sendKeys(reply);
		driver.switchTo().parentFrame();
	}
		
	public void clickbtnSubmitReply() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.btnSubmitReply));
		this.btnSubmitReply.click();
	}
	
}
