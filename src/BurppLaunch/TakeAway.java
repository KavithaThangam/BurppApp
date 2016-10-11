package BurppLaunch;

	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.AndroidKeyCode;

	import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.testng.annotations.Test;

	public class TakeAway {

		AndroidDriver dr;
		@Test
		public void takeAwayProcess() throws MalformedURLException, Exception{
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability("deviceName", "MACHONE");
			capability.setCapability("platformName", "Android");
			capability.setCapability("platformVersion", "4.4.2");
			capability.setCapability("appPackage", "kot.burpp");
			capability.setCapability("appActivity", "kot.burpp.SplashScreenlogin");
			
			dr = new AndroidDriver(new URL("http://192.168.1.5:4723/wd/hub"),capability);
			TimeUnit.SECONDS.sleep(10);
			dr.findElement(By.id("kot.burpp:id/parcelintableview")).click();
			TimeUnit.SECONDS.sleep(2);
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			TimeUnit.SECONDS.sleep(10);
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			TimeUnit.SECONDS.sleep(2);
			dr.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index='3']")).click();
			dr.findElement(By.id("android:id/search_button")).click();
			dr.findElement(By.id("android:id/search_src_text")).sendKeys("Mughlai Chicken Masala");
			dr.findElement(By.xpath("//android.widget.TextView[@index='0']")).click();
			dr.findElement(By.id("android:id/button1")).click();
			dr.findElement(By.id("android:id/search_close_btn")).click();
			TimeUnit.SECONDS.sleep(2);
			dr.findElement(By.id("android:id/search_close_btn")).click();
	        dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
			List<WebElement> order = dr.findElements(By.xpath("//android.widget.LinearLayout"));
		    order.get(0).click();
			dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
			order.get(1).click();
			dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
			order.get(2).click();
			dr.findElement(By.id("android:id/button1")).click();
			TimeUnit.SECONDS.sleep(10);
			dr.findElement(By.id("kot.burpp:id/parcelintableview")).click();
			TimeUnit.SECONDS.sleep(2);
			dr.findElement(By.xpath("//android.widget.TextView[@text='Gravies']")).click();
			dr.scrollToExact("Mushroom Masala").click();
			dr.findElement(By.id("android:id/button1")).click();
			dr.findElement(By.id("kot.burpp:id/pink_icon")).click();
			dr.findElement(By.id("kot.burpp:id/print")).click();
			dr.findElement(By.id("kot.burpp:id/printconfirm")).click();
			TimeUnit.SECONDS.sleep(10);
			dr.pressKeyCode(AndroidKeyCode.BACK);
			TimeUnit.SECONDS.sleep(5);
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			TimeUnit.SECONDS.sleep(2);
			dr.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index='3']")).click();
			dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
			order.get(3).click();
			TimeUnit.SECONDS.sleep(2);
			dr.findElement(By.id("kot.burpp:id/availableorderlist")).click();
			dr.findElement(By.xpath("//android.widget.CheckedTextView[@text='Order -1']")).click();
			dr.findElement(By.id("android:id/button1")).click();
			TimeUnit.SECONDS.sleep(2);
			dr.findElement(By.id("kot.burpp:id/pink_icon")).click();
			dr.findElement(By.id("kot.burpp:id/bill")).click();
			dr.findElement(By.id("android:id/button1")).click();
			dr.findElement(By.id("kot.burpp:id/billconfirm")).click();
			
		}
	}

