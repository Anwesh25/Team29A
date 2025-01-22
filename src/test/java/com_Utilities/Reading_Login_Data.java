package com_Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Reading_Login_Data {
	
	Properties pro;
	public Reading_Login_Data() {
		File lpd = new File("C:\\Users\\Personal\\Desktop\\LMS\\LMS_Backend\\LMS_backend_code\\Hybrid_Framework_01\\Configuration\\properties_For_Loigin");
		
		try {
			FileInputStream fis = new FileInputStream(lpd);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
		public String getEmail() {
			String LoginEmail = pro.getProperty("EmailProperty");
			return LoginEmail;
		}
		
		public String getPassword() {
			String LoginPassword = pro.getProperty("PasswordProperty");
			return LoginPassword;
		}
	

}
