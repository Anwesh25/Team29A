package com_Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Reading_Luma_Data {
	
	Properties pro;
	public Reading_Luma_Data() {
		
		File fle = new File("C:\\Users\\Personal\\Desktop\\LMS\\LMS_Backend\\LMS_backend_code\\Hybrid_Framework_01\\Configuration\\ElementProperties_forRegistrationPage");
		
		try {
			FileInputStream fis = new FileInputStream(fle);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getFirstName() {
		String FName = pro.getProperty("FirstName");
		return FName;
	}
	
	public String getLastName() {
		String LName = pro.getProperty("LastName");
		return LName;
	}
	
	public String getEmailAddress() {
		String EmailAdd = pro.getProperty("Email");
		return EmailAdd;
	}
	
	public String getPassword() {
		String Password = pro.getProperty("Password");
		return Password;
	}
	
	public String getCPassword() {
		String CPassword = pro.getProperty("ConformPassword");
		return CPassword;
	}

}
