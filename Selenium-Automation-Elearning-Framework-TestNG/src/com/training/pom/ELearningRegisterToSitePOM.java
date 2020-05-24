package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ELearningRegisterToSitePOM {
	private WebDriver driver; 
	
	public ELearningRegisterToSitePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath="//a[contains(text(),'Sign up!')]")
	private WebElement LinkSignup; 
	
	@FindBy(xpath="//input[@value='1']")
	private WebElement OptionTeacher;
	
	@FindBy(xpath="//input[@id='registration_firstname']")
	private WebElement TextFirstName;
	
	@FindBy(xpath="//input[@id='registration_lastname']")
	private WebElement TextLastName; 
	
	@FindBy(xpath="//input[@id='registration_email']")
	private WebElement TextEmail; 
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement TextUserName; 
	
	@FindBy(xpath="//input[@id='pass1']")
	private WebElement TextPassword; 
	
	@FindBy(xpath="//input[@id='pass2']")
	private WebElement TextConfPassword; 
	
	@FindBy(xpath="//input[@id='registration_phone']")
	private WebElement TextPhone; 
	
	@FindBy(xpath="//select[@id='registration_language']")
	private WebElement SelectLanguage; 
	
	@FindBy(xpath="//button[@id='registration_submit']")
	private WebElement BtnRegister;
	
	@FindBy(xpath="//div[@class='alert alert-warning']")
	private WebElement warningMessage;
	
	public void clickLinkSignup() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.LinkSignup));
		this.LinkSignup.click();
	}
	
	public void clickOptionTeacher() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(this.OptionTeacher));
		this.OptionTeacher.click();
	}
	
	public void setTextFirstName(String fname) {
		this.TextFirstName.sendKeys(fname);
	}
	
	public void setTextLastName(String lname) {
		this.TextLastName.sendKeys(lname);
	}
	
	public void setTextEmail(String email) {
		this.TextEmail.sendKeys(email);
	}
	
	public void setTextUserName(String username) {
		this.TextUserName.sendKeys(username);
	}
	
	public void setTextPassword(String pwd) {
		this.TextPassword.sendKeys(pwd);
	}
	
	public void setTextConfPassword(String cpwd) {
		this.TextConfPassword.sendKeys(cpwd);
	}
	
	public void setTextPhone(String phone) {
		this.TextPhone.sendKeys(phone);
	}
	
	public void selectLanguage(String lang){
		Select sel = new Select(this.SelectLanguage);
		sel.selectByVisibleText(lang);		
	}
	
	public void clickBtnRegister() {
		this.BtnRegister.click();
	}
	
	public void verifywarningMessage(){
		this.warningMessage.isDisplayed();
	}
	
}
