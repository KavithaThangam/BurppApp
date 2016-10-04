package BurppLaunch;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignupUser {
	
	AndroidDriver dr;
	@BeforeClass
	public void deviceInfo() throws MalformedURLException, Exception{
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "MACHONE");
		capability.setCapability("platformName", "Android");
		capability.setCapability("platformVersion", "4.4.2");
		capability.setCapability("appPackage", "kot.burpp");
		capability.setCapability("appActivity", "kot.burpp.SplashScreenlogin");
		dr = new AndroidDriver(new URL("http://192.168.1.19:4723/wd/hub"),capability);
	}
	
	@BeforeMethod
	public void clickSignup() throws Exception{
	   WebDriverWait wait = new WebDriverWait(dr, 40);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/registerationlink")));
	   dr.findElement(By.id("kot.burpp:id/registerationlink")).click();
	   TimeUnit.SECONDS.sleep(20);
	   //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EMAIL ID:")));
	   scroll();
	   dr.findElement(By.id("New to Burpp? Register now. Its Free.")).click();
	}
	
	@Test
	public void signupUser(){
		WebDriverWait wait = new WebDriverWait(dr, 40);
		dr.findElement(By.id("FULL NAME:")).sendKeys("kavitha");
		dr.pressKeyCode(AndroidKeyCode.BACK);
		dr.findElement(By.id("MOBILE:")).sendKeys("232343453465");
		dr.pressKeyCode(AndroidKeyCode.BACK);
		dr.findElement(By.id("COUNTRY:")).sendKeys("india");
		dr.pressKeyCode(AndroidKeyCode.BACK);
		dr.findElement(By.id("POST CODE:")).sendKeys("600042");
		dr.pressKeyCode(AndroidKeyCode.BACK);
		dr.findElement(By.id("EMAIL:")).sendKeys("kavitha@arivuventures.com");
		dr.pressKeyCode(AndroidKeyCode.BACK);
		dr.findElement(By.id("CHOOSE PASSWORD:")).sendKeys("Password$1");
		dr.pressKeyCode(AndroidKeyCode.BACK);
		dr.findElement(By.id("CONFIRM PASSWORD:")).sendKeys("Password$1");
		dr.pressKeyCode(AndroidKeyCode.BACK);
		scroll();
		dr.findElement(By.id("I agree to terms and conditions ")).click();
		dr.findElement(By.id("I agree to terms and conditions ")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("                       ARIVU VENTURES PRIVATE LIMITED")));
		dr.pressKeyCode(AndroidKeyCode.BACK);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("I agree to terms and conditions ")));
		dr.findElement(By.className("android.widget.CheckBox")).click();
		dr.findElement(By.xpath("//android.widget.Button[@index='4']")).click();
	
	}
	
	public void scroll(){
		Dimension dimensions = dr.manage().window().getSize();
        Double screenHeightStart = dimensions.getHeight() * 0.5;
        int scrollStart = screenHeightStart.intValue();
        Double screenHeightEnd = dimensions.getHeight() * 0.01;
        int scrollEnd = screenHeightEnd.intValue();
        dr.swipe(0, scrollStart, 0, scrollEnd, 1000); 
	}

}
