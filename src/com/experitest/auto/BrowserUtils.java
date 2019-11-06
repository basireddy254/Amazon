package com.experitest.auto;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils; 
import org.openqa.selenium.OutputType; 
import org.openqa.selenium.TakesScreenshot; 
import org.openqa.selenium.WebDriver;

public class BrowserUtils extends BaseTest {
	static TakesScreenshot ts;
	static File image; 
	 
	public static void captureScreenshot(WebDriver ob,String imageName) throws IOException {
		ts = (TakesScreenshot)ob;
		image= ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(image, new File("screenshots\\"+imageName+".jpg"));
	}

}
