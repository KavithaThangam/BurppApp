package BurppLaunch;

	import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

	import javax.swing.text.View;

	import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

	import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

	public class ItemDetailPage {
		
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
		public void ItemDetails() throws Exception{
			WebDriverWait wait = new WebDriverWait(dr, 40);
			dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
			dr.findElement(By.id("kot.burpp:id/currentocc")).sendKeys("4");
			dr.findElement(By.id("android:id/button1")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			TouchAction action = new TouchAction(dr);
			dr.findElement(By.xpath("//android.widget.TextView[@text='Items']")).click();
			scroll();
			List<WebElement> Items1 = dr.findElementsByXPath("//android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout");
			System.out.println(Items1);
			int size = 0;
			size = size+Items1.size();
			for (int i=0;i<size;i++){
				action.longPress(Items1.get(i)).perform().release();
				{
					itemFunction();
				}
			}
			scroll();
			action.longPress(dr.findElement(By.xpath("//android.widget.TextView[@text='Kulcha']"))).perform().release();
			itemFunction();
		}
		public void itemFunction() throws Exception{
			WebDriverWait wait = new WebDriverWait(dr, 40);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/link")));
			scroll();
			WebElement link = dr.findElement(By.id("kot.burpp:id/link"));
			if(link.isDisplayed())
			{
				link.click();
				TimeUnit.SECONDS.sleep(20);
				dr.pressKeyCode(AndroidKeyCode.BACK);
			}
			else
			{
				System.out.println("No Link for this item");
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));	
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));	
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));	
			dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));	
			dr.findElement(By.xpath("//android.widget.TextView[@text='Items']")).click();
			TimeUnit.SECONDS.sleep(10);
			scroll();
		}
		
		public void scroll(){
			Dimension dimensions = dr.manage().window().getSize();
	        Double screenHeightStart = dimensions.getHeight() * 0.5;
	        int scrollStart = screenHeightStart.intValue();
	        Double screenHeightEnd = dimensions.getHeight() * 0.01;
	        int scrollEnd = screenHeightEnd.intValue();
	        dr.swipe(0, scrollStart, 0, scrollEnd, 1000); 
		}
		
		@AfterMethod
		public void signout(){
			WebDriverWait wait = new WebDriverWait(dr, 40);
			dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
			dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
			dr.findElement(By.xpath("//android.widget.LinearLayout[@index='2']")).click();
			dr.findElement(By.id("android:id/button1")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
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

