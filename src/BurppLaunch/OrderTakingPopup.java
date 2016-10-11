package BurppLaunch;

	import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import io.appium.java_client.android.AndroidDriver;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.testng.annotations.Test;

	public class OrderTakingPopup {
		
		AndroidDriver dr;
		@Test
		public void Popup() throws MalformedURLException, Exception{
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability("deviceName", "LenovoA6000");
			capability.setCapability("platformName", "Android");
			capability.setCapability("platformVersion", "4.4.4");
			capability.setCapability("appPackage", "kot.burpp");
			capability.setCapability("appActivity", "kot.burpp.ItemHandling");
			
			dr = new AndroidDriver(new URL("http://192.168.1.5:4723/wd/hub"),capability);
			dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
			
			List<WebElement> content = dr.findElements(By.xpath("//android.widget.LinearLayout"));
			
			content.get(0).click();
			dr.findElement(By.id("kot.burpp:id/currentocc")).sendKeys("3");
			dr.findElement(By.id("android:id/button1")).click();
			TimeUnit.SECONDS.sleep(5);
			
			dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
			content.get(1).click();
			dr.findElement(By.id("kot.burpp:id/availabletablelist")).click();
			dr.scrollToExact("T11").click();
			dr.findElement(By.id("android:id/button2")).click();
			dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
			content.get(1).click();
			dr.findElement(By.id("kot.burpp:id/availabletablelist")).click();
			dr.scrollToExact("T8").click();
			dr.findElement(By.id("android:id/button1")).click();
			TimeUnit.SECONDS.sleep(10);
			dr.findElement(By.xpath("//android.widget.TextView[@text='T8']")).click();
			
			dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
			content.get(2).click();
			dr.findElement(By.id("kot.burpp:id/cancelorderreason")).sendKeys("123cancel!@#");
			dr.findElement(By.id("android:id/button2")).click();
			dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
			content.get(2).click();
			dr.findElement(By.id("kot.burpp:id/cancelorderreason")).sendKeys("have to go out");
			dr.findElement(By.id("android:id/button1")).click();
			TimeUnit.SECONDS.sleep(5);
			
			dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
			dr.findElement(By.xpath("//android.widget.TextView[@text='Starters']")).click();
			TimeUnit.SECONDS.sleep(2);
			dr.findElement(By.xpath("//android.widget.TextView[@text='Aloo Gobi Fry']")).click();
			dr.findElement(By.id("android:id/button1")).click();
			dr.findElement(By.id("kot.burpp:id/pink_icon")).click();
			dr.findElement(By.id("kot.burpp:id/print")).click();
			TimeUnit.SECONDS.sleep(2);
			dr.findElement(By.id("kot.burpp:id/printconfirm")).click();
			TimeUnit.SECONDS.sleep(10);
			dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
			dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
			content.get(3).click();
	        dr.findElement(By.id("kot.burpp:id/availableorderlist")).click();
	        dr.scrollToExact("Order -1").click();
	        dr.findElement(By.id("android:id/button2")).click();
	        dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
			content.get(3).click();
	        dr.findElement(By.id("kot.burpp:id/availableorderlist")).click();
	        dr.scrollToExact("Order -1").click();
	        dr.findElement(By.id("android:id/button1")).click();
		}

	}

