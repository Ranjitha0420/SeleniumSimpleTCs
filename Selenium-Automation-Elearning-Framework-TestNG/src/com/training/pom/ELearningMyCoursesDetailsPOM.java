package com.training.pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ELearningMyCoursesDetailsPOM {
	private WebDriver driver; 
	
	public ELearningMyCoursesDetailsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//h4[@class='course-items-title'])[1]/a")
	private WebElement LinkFirstCourse;
	
	@FindBy(xpath="(//h4[@class='course-items-title'])[2]/a")
	private WebElement LinkSecondCourse;	
	
	@FindBy(xpath="//a[contains(text(),'Course description')]")
	private WebElement LinkSecondCourseDesc;
	
	@FindBy(xpath="//div[@class='panel-heading']")
	private WebElement LinkSecondCourseDescription;

	
	public boolean verifyLinkFirstCourse() {
		boolean FirstCourse= this.LinkFirstCourse.isDisplayed();
		return FirstCourse;
	}
	
	public boolean verifyLinkSecondCourse() {
		boolean SecondCourse= this.LinkSecondCourse.isDisplayed();
		return SecondCourse;
	}	
	
	public void clickLinkSecondCourse(){
		this.LinkSecondCourse.click();
	}
	
	public void clickLinkSecondCourseDesc(){
		this.LinkSecondCourseDesc.click();

	}
	
	public boolean verifyLinkSecondCourseDescription() {
		boolean SecondCourseDesc= this.LinkSecondCourseDescription.isDisplayed();
		return SecondCourseDesc;
	}
	
	
	

}
