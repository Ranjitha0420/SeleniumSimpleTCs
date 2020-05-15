package com.training.pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELearningMyCoursesPOM {
	private WebDriver driver; 
	
	public ELearningMyCoursesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//section[@id='cm-content']//p[1]")
	private WebElement welcomeMessage; 
	
	@FindBy(xpath="//li[@class='list-group-item inbox-message-social']")
	private WebElement LinkInbox;
	
	@FindBy(xpath="//a[contains(text(),'My certificates')]")
	private WebElement LinkMyCertificates;
	
	@FindBy(xpath="//a[contains(text(),'My courses')]")
	private WebElement LinkMyCourses;
	
	@FindBy(xpath=" //a[@class='dropdown-toggle']//img[@class='img-circle']")
	private WebElement MenuMyAccount; 
	
	@FindBy(id="logout_button")
	private WebElement LinkLogout;
	
	public String getWelcomeMessage() {
		String wlcmessage= this.welcomeMessage.getText();
		return wlcmessage;
	}
	
	public boolean verifyInboxVisiblity() {
		boolean inboxvisible = this.LinkInbox.isDisplayed();
		return inboxvisible;
	}
	
	public boolean verifyMyCertificatesVisibility() {
		boolean mycertVisibility = this.LinkMyCertificates.isDisplayed();
		return mycertVisibility;
	}
	
	public void clickMyAccountMenu() {
		this.MenuMyAccount.click();
	}
	
	public void clickLinkMyCourses() {
		this.LinkMyCourses.click();
	}
	
	public boolean verifyLogoutVisibility() {
		boolean logoutVisibility = this.LinkLogout.isDisplayed();
		return logoutVisibility;
	}
	
	public void clickLogoutLink() {		
		this.LinkLogout.click();
	}
	
	
	

}
