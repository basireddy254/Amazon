package com.experitest.auto;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class AmazonTest extends BaseTest {
	protected AndroidDriver<AndroidElement> driver = null;
	
	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android'") String deviceQuery) throws Exception{
		init(deviceQuery);
		// Init application / device capabilities
		
		dc.setCapability(MobileCapabilityType.APP, "cloud:com.amazon.mShop.android.shopping/com.amazon.mShop.appgrade.ui.AppgradeKillSwitchActivity");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.amazon.mShop.android.shopping");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.amazon.mShop.appgrade.ui.AppgradeKillSwitchActivity");
		dc.setCapability("appVersion", "18.14.0.100");
		dc.setCapability("instrumentApp", true);
		
		dc.setCapability("testName", "AmazonTest");
		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) + "/wd/hub"), dc);
	}
	
	@Test
	public void test(){
		
		// Amazon App Open And Select country  AUS
		driver.findElement(in.Repo.obj("AmazonAppClick.Amazon_Shopping")).click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(in.Repo.obj("permition.confirm"))).click();
		driver.findElement(in.Repo.obj("CountrySelect.Input")).click();
		driver.findElement(in.Repo.obj("Country.AUS")).click();
		driver.findElement(in.Repo.obj("AUS.Done")).click();
		
		//Signin Application
		driver.findElement(in.Repo.obj("Signin.BUTTON")).click();
		driver.findElement(in.Repo.obj("User.Name")).sendKeys("XXXXXX");
		driver.findElement(in.Repo.obj("User.password")).sendKeys("XXXXXX");
		driver.findElement(in.Repo.obj("User.signInSubmit")).click();
		
		
		//in Search field enter and Search for 65" TV
		WebElement Search= driver.findElement(in.Repo.obj("SearchField.Search"));
		Search.clear();
		Search.click();
		Search.sendKeys("65 inch TV");
		driver.findElement(in.Repo.obj("Search.DropdownSelect")).click();
		
		//Scroll up to Device and Select
		WebElement TV65 =driver.findElement(in.Repo.obj("SearchField.Search"));
		TouchActions action = new TouchActions(driver);
		action.scroll(TV65, 375, 945);
		action.perform();
		TV65.click();
		
		//Scroll upto addcart button and Click
		WebElement Addcart = driver.findElement(in.Repo.obj("Add.cartbutton")); 
		action.scroll(Addcart, 45, 1578);
		action.perform();
		Addcart.click();
		
		//Open Cart
		driver.findElement(in.Repo.obj("Click.oncart")).click();
		
		
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
