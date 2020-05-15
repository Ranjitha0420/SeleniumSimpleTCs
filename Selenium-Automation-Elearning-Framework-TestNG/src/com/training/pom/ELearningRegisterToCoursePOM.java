package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELearningRegisterToCoursePOM {
	private WebDriver driver; 
	
	public ELearningRegisterToCoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath="//li[@class='list-group-item list-course']//a[contains(text(),'Course catalog')]")
	private WebElement CourseCatalog; 
	
	@FindBy(xpath="//input[@name='search_term']")
	private WebElement SearchTerm;
	
	@FindBy(xpath="(//a[@title='Subscribe'])[1]")
	private WebElement FirstResult;
	
	@FindBy(xpath="//div[@class='alert alert-info']")
	private WebElement SuccessMessage; 
	
	//User reva321 reva321 (reva321) has been registered to course Automation
	
	public void clickCourseCatalog() {
		this.CourseCatalog.click();
	}
	
	public void setSearchTerm(String sterm) {
		try{
			Thread.sleep(3000);
		this.SearchTerm.clear();
		this.SearchTerm.sendKeys(sterm);
		Thread.sleep(3000);
		this.SearchTerm.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void clickFirstResult() {
		this.FirstResult.click();
	}
	
	public boolean verifySuccessMessage() {
		boolean successMessagedisplayed = this.SuccessMessage.isDisplayed();
		return successMessagedisplayed;
	}
	
	public String getsuccessMessage() {		
		String successMessaged = this.SuccessMessage.getText();
		return successMessaged;
	}
}
