package com_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com_Luma_page_object.Luma_Registration_Page;

public class Tc_001_Luma_Registration_Page extends Luma_BaseClass {
	
//	public Luma_Registration_Page lr;
	@Test
//	public void LumaRegistration(String FName, String LName, String EmailAdd, String Password, String CPassword) {
	public void LumaRegistration() {
		Luma_Registration_Page lr = new Luma_Registration_Page(driver);
	/*	lr.ClickCreateAnAccount();
		lr.EnterFirstName();
		lr.EnterLastName();
		lr.EnterEmailAddress();
		lr.EnterPassword();
		lr.EnterCPassword();
		lr.ClickCreateAnAccountbtn();
	*/
		
		
		lr.ClickCreateAnAccount();
		Log.info("Opened the Register Page");
	//	lr.EnterFirstName(RB.getString("FName"));
		lr.EnterFirstName(FName);
		Log.info("Entered FirstName");
	//	lr.EnterLastName(RB.getString("LName"));
		lr.EnterLastName(LName);
		Log.info("Entered LastName");
	//	lr.EnterEmailAddress(RB.getString("EmailAdd"));
		lr.EnterEmailAddress(EmailAdd);
		Log.info("Entered EmailAddress");
	//	lr.EnterPassword(RB.getString("Password"));
		lr.EnterPassword(Password);
		Log.info("Entered Encripted_Password");
	//	lr.EnterCPassword(RB.getString("CPassword"));
		lr.EnterCPassword(CPassword);
		Log.info("Entered Encripted_ConformPassword");
		lr.ClickCreateAnAccountbtn();
		Log.info("Click on the Button to Register");
		
		//Hard assertion
				String Act_title= driver.getTitle();
				String Exp_tittle="My Account";
				
				if(Act_title.equals(Exp_tittle)) {
					
					Assert.assertTrue(true);
					System.out.println("Test case is pass");
				}
				else {
				     
					System.out.println("Test case failed");
					Assert.assertTrue(false);
					
				}
}
}	

