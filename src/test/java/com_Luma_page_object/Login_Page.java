package com_Luma_page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	public WebDriver driver;
	
	public Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (id="email")
	WebElement Luma_Email;
	
	@FindBy (id="pass")
	WebElement Luma_Passaword;
	
	@FindBy (id="send2")
	WebElement Sign_In_btn;
	
	
	public void EnterEmail(String email) {
		Luma_Email.sendKeys(email);
	}
	
	public void EnterPassword(String password) {
		Luma_Passaword.sendKeys(password);
	}
	
	public void ClickOnSignIn() {
		Sign_In_btn.click();
	}

}
