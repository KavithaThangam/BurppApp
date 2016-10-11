package BurppLaunch;

	import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

	import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

	public class BillOrder {
		
		AndroidDriver dr;
		@BeforeClass
		public void billOrderPage() throws MalformedURLException, Exception{
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability("deviceName", "HUAWEI Y541-U02");
			capability.setCapability("platformName", "Android");
			capability.setCapability("platformVersion", "4.4.2");
			capability.setCapability("appPackage", "kot.burpp");
			capability.setCapability("appActivity", "kot.burpp.SplashScreenlogin");
			dr = new AndroidDriver(new URL("http://192.168.1.13:4723/wd/hub"),capability);
		}
		
		@BeforeMethod
		public void loginUser(){
			WebDriverWait wait = new WebDriverWait(dr, 40);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/infoip")));
			dr.findElement(By.id("kot.burpp:id/displayname")).sendKeys("staging");
			dr.pressKeyCode(AndroidKeyCode.BACK);
			dr.findElement(By.id("kot.burpp:id/nexttologin")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/loginhelp")));
			dr.findElement(By.id("kot.burpp:id/username")).sendKeys("waiter1@burpp.com");
			dr.findElement(By.id("kot.burpp:id/password")).sendKeys("password");
			dr.findElement(By.id("kot.burpp:id/loginthru")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='More options']")));
		}
		
		@Test
		public void BillOrder(){
			WebDriverWait wait = new WebDriverWait(dr, 40);
			dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
			dr.findElement(By.id("kot.burpp:id/currentocc")).sendKeys("4");
			dr.findElement(By.id("android:id/button1")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			dr.findElement(By.id("kot.burpp:id/pink_icon")).click();
			dr.findElement(By.id("kot.burpp:id/bill")).click();
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			
			dr.findElement(By.xpath("//android.widget.TextView[@text='Starters1']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    dr.scrollToExact("Paneer Tikka1").click();
		    dr.findElement(By.id("android:id/button1")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    dr.findElement(By.id("kot.burpp:id/pink_icon")).click();
		    dr.findElement(By.id("kot.burpp:id/bill")).click();
		    dr.findElement(By.id("kot.burpp:id/print")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    dr.findElement(By.id("kot.burpp:id/printconfirm")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='BTprinter8045']")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
		    dr.findElement(By.id("kot.burpp:id/pink_icon")).click();
		    dr.findElement(By.id("kot.burpp:id/bill")).click();
		    dr.findElement(By.id("android:id/button1")).click();
		    dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
		    dr.findElement(By.id("kot.burpp:id/pink_icon")).click();
		    dr.findElement(By.id("kot.burpp:id/bill")).click();
		    dr.findElement(By.id("android:id/button1")).click();
		    
		    //Additional and discount charges
		    dr.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Additional Charges']")).click();
		    dr.findElement(By.id("android:id/button2")).click();
		    dr.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Additional Charges']")).click();
		    dr.findElement(By.id("android:id/button1")).click();
		    dr.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Additional Charges']")).click();
		    dr.findElement(By.id("kot.burpp:id/setadditionalchargedesc")).sendKeys("water packet");
		    dr.findElement(By.id("kot.burpp:id/setadditionalcharge")).sendKeys("2");
		    dr.findElement(By.id("android:id/button1")).click();
		    dr.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
		    
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Discount']")).click();
		    dr.findElement(By.id("android:id/button2")).click();
		    dr.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Discount']")).click();
		    dr.findElement(By.id("kot.burpp:id/setadditionalchargedesc")).sendKeys("water packet");
		    dr.findElement(By.id("kot.burpp:id/setadditionalpercent")).sendKeys("20");
		    dr.findElement(By.id("android:id/button1")).click();
		    dr.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Discount']")).click();
		    dr.findElement(By.id("kot.burpp:id/setadditionalcharge")).sendKeys("5");
		    dr.findElement(By.id("kot.burpp:id/setadditionalpercent")).sendKeys("40");
		    dr.findElement(By.id("android:id/button1")).click();
		    dr.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Discount']")).click();
		    dr.findElement(By.id("kot.burpp:id/setadditionalcharge")).sendKeys("6");
		    dr.findElement(By.id("android:id/button1")).click();
		    dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
		    
		    //Place multiple orders
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Breads']")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Naan']")).click();
		    dr.findElement(By.id("android:id/button1")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Desserts']")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    dr.scrollToExact("Gulab Jamun").click();
		    dr.findElement(By.id("android:id/button1")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Starters1']")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Mushroom Pep Fry']")).click();
		    dr.findElement(By.id("android:id/button1")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		   
		    dr.findElement(By.id("kot.burpp:id/pink_icon")).click();
		    dr.findElement(By.id("kot.burpp:id/print")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    dr.findElement(By.id("kot.burpp:id/printconfirm")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='BTprinter8045']")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
		    
		    dr.findElement(By.id("kot.burpp:id/pink_icon")).click();
		    dr.findElement(By.id("kot.burpp:id/bill")).click();
		    dr.findElement(By.id("android:id/button2")).click();
		    dr.findElement(By.id("kot.burpp:id/bill")).click();
		    dr.findElement(By.id("android:id/button1")).click();
	        dr.scrollTo("BILL PAID");
	        dr.findElement(By.id("kot.burpp:id/billconfirm")).click();
	        dr.findElement(By.xpath("//android.widget.TextView[@text='BTprinter8045']")).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
	        /*dr.findElement(By.id("kot.burpp:id/bill")).click();
	        dr.findElement(By.xpath("//android.widget.TextView[@text='BTprinter8045']")).click();*/
	        
	        dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
	        dr.scrollTo("BILL REPRINT");
	        dr.findElement(By.id("kot.burpp:id/billreprint")).click();
	        dr.findElement(By.xpath("//android.widget.TextView[@text='BTprinter8045']")).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
	        dr.findElement(By.id("kot.burpp:id/billconfirm")).click();
	        dr.findElement(By.id("android:id/button2")).click();
	        dr.findElement(By.id("kot.burpp:id/billconfirm")).click();
	        dr.findElement(By.id("android:id/button1")).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		}
		
		@AfterMethod
		public void signout(){
			WebDriverWait wait = new WebDriverWait(dr, 40);
		    dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
		    dr.findElement(By.id("kot.burpp:id/logoutnav")).click();
		    dr.findElement(By.id("android:id/button1")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/username")));
		}
			
		@AfterClass
		public void closeApp(){
			dr.navigate().back();
		    dr.navigate().back();
		    dr.findElement(By.id("android:id/button1")).click();
		}

	}


