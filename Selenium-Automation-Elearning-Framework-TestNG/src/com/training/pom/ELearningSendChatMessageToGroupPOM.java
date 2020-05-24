package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ELearningSendChatMessageToGroupPOM {
private WebDriver driver; 
private String firstWinHandle;
	
	public ELearningSendChatMessageToGroupPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[contains(text(),'My courses')]")
	private WebElement LinkMyCourses;
	
	@FindBy(xpath="//a[contains(text(),'Selenium with Java')]")
	private WebElement LinkCourseSeleniumwithJava; 
	
	@FindBy(xpath="//a[text()='Groups']")
	private WebElement LinkGroups;
	
	@FindBy(xpath="//table[starts-with(@id,'group_category')]//descendant::a[3]")
	private WebElement LinkGroupname;	
	
	@FindBy(xpath="//img[@title='Chat']//parent::a")
	private WebElement imgChat;	
	
	@FindBy(xpath="//button[@title='Leave a message']")
	private WebElement  linkLeavemsg;
	
	@FindBy(xpath="//a[contains(text(),'TeachSelenium1')]")
	private WebElement  tabCourseName;
	
	@FindBy(xpath="//textarea[@id='chat-writer']//following-sibling::div")
	private WebElement  textareawritemessage;
	
	@FindBy(xpath="//button[@id='chat-send-message']")
	private WebElement  btnSendMessage;
	
	@FindBy(xpath="//div[@class='chat-message-block-content']/p[1]")
	private WebElement  sentMessage;
	
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
	
	public void clickLinkGroups() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.LinkGroups));
		this.LinkGroups.click();
	}
	
	public void clickLinkGroupname() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.LinkGroupname));
		this.LinkGroupname.click();
	}
	
	public void clickimgChat(){		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.imgChat));
		firstWinHandle = driver.getWindowHandle();
		driver.switchTo().window(firstWinHandle);
		this.imgChat.click();
	}	
	
	public void clicklinkLeavemsg(){	
		String secondWinHandle="";
		Set<String> win=driver.getWindowHandles();
				
		for (String winHandle: win){
			if (winHandle!=firstWinHandle){
				secondWinHandle = winHandle;
				System.out.println("Second window is"+secondWinHandle);
			}
		}
		driver.switchTo().window(secondWinHandle);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.linkLeavemsg));
		this.linkLeavemsg.click();
	}
	
	public void sendchatmessage(){
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.tabCourseName));
		wait.until(ExpectedConditions.visibilityOf(this.textareawritemessage));
		this.textareawritemessage.sendKeys("Hi , Please help with xpath");
		this.btnSendMessage.click();
				
	}
	
	public void viewsentMessage(){
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.sentMessage));
		this.sentMessage.isDisplayed();
		driver.close();
		driver.switchTo().window(firstWinHandle);
	}
	
}
