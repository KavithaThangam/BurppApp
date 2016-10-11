package BurppLaunch;

	import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.AndroidKeyCode;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.testng.annotations.Test;

	public class CategorySelection {
		
		AndroidDriver dr;
		@Test
		public void Category() throws MalformedURLException, Exception{
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability("deviceName", "MACHONE");
			capability.setCapability("platformName", "Android");
			capability.setCapability("platformVersion", "4.4.2");
			capability.setCapability("appPackage", "kot.burpp");
			capability.setCapability("appActivity", "kot.burpp.ItemHandling");
			
			dr = new AndroidDriver(new URL("http://192.168.1.11:4722/wd/hub"),capability);
			TimeUnit.SECONDS.sleep(2);
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			TimeUnit.SECONDS.sleep(10);
			dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
			TimeUnit.SECONDS.sleep(5);
			dr.findElement(By.id("android:id/search_button")).click();
			dr.findElement(By.id("android:id/search_src_text")).sendKeys("Chana Masala");
			dr.findElement(By.xpath("//android.widget.TextView[@index='0']")).click();
			dr.findElement(By.id("kot.burpp:id/itemqtyinqtydialog")).click();
			dr.scrollToExact("10").click();
			dr.findElement(By.id("kot.burpp:id/setdescinquantitydialog")).sendKeys("something");
			dr.pressKeyCode(AndroidKeyCode.BACK);
			dr.findElement(By.id("android:id/button1")).click();
			dr.findElement(By.xpath("//android.widget.TextView[@text='Starters']")).click();
			dr.scrollToExact("Tangri Kebab").click();
			dr.findElement(By.id("android:id/button1")).click();
			dr.findElement(By.xpath("//android.widget.TextView[@text='Gravies']")).click();
			dr.scrollToExact("Mushroom Masala").click();
			dr.findElement(By.id("android:id/button1")).click();
			dr.findElement(By.xpath("//android.widget.TextView[@text='Rice']")).click();
			dr.scrollToExact("Veg Pulao").click();
			dr.findElement(By.id("android:id/button1")).click();
			dr.findElement(By.xpath("//android.widget.TextView[@text='South Indian']")).click();
			dr.scrollToExact("Idly").click();
			dr.findElement(By.id("android:id/button1")).click();
			dr.findElement(By.xpath("//android.widget.TextView[@text='Desserts']")).click();
			dr.scrollToExact("Gulab Jamun").click();
			dr.findElement(By.id("kot.burpp:id/priorityinqtydialog")).click();
			dr.scrollToExact("P10").click();
			dr.findElement(By.id("android:id/button1")).click();
			dr.findElement(By.xpath("//android.widget.TextView[@text='Breads']")).click();
			dr.scrollToExact("Paratha");
			dr.scrollToExact("Chi Burger");
			dr.findElement(By.xpath("//android.widget.TextView[@text='Category']")).click();
			dr.findElement(By.xpath("//android.widget.TextView[@text='Items']")).click();
			dr.scrollToExact("Tandoori Chicken").click();
			dr.findElement(By.id("android:id/button1")).click();
			dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
			dr.findElement(By.xpath("//android.widget.LinearLayout[@index='0']")).click();
			dr.findElement(By.id("android:id/button2")).click();
			dr.findElement(By.id("kot.burpp:id/pink_icon")).click();
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			dr.pressKeyCode(AndroidKeyCode.BACK);
		}

	}

