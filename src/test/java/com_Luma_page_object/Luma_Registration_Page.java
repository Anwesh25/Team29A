package com_Luma_page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Luma_Registration_Page {
	
	public WebDriver driver;
	// Constructor
	public Luma_Registration_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	// Identifing Element
	
	@FindBy (xpath = "(//a[text()='Create an Account'])[1]")
	WebElement LinkCreateAnAccount;
	
	@FindBy (id="firstname")
	WebElement txtFirstName;
	
	@FindBy (id="lastname")
	WebElement txtLastName;
	
	@FindBy (id = "email_address")
	WebElement txtEmailAddress;
	
	@FindBy (id = "password")
	WebElement txtPassword;
	
	@FindBy (id = "password-confirmation")
	WebElement txtCPassword;
	
	@FindBy (xpath = "//button[@class = 'action submit primary']")
	WebElement btnClick;
	
	
	public void ClickCreateAnAccount() {
		LinkCreateAnAccount.click();
	}
	
	public void EnterFirstName(String FName) {
		txtFirstName.sendKeys(FName);
	}
	
	public void EnterLastName(String LName) {
		txtLastName.sendKeys(LName);
	}
	
	public void EnterEmailAddress(String Email) {
		txtEmailAddress.sendKeys(Email);
	}
	
	public void EnterPassword(String Password) {
		txtPassword.sendKeys(Password);
	}
	
	public void EnterCPassword(String CPassword) {
		txtCPassword.sendKeys(CPassword);
	}
	
	public void ClickCreateAnAccountbtn() {
		btnClick.click();
	}
	
	

}
