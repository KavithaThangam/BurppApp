package BurppLaunch;

	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.AndroidKeyCode;

	import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Point;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.testng.annotations.Test;

	public class ItemSelection {

		AndroidDriver dr;
		private Object found;
		private Object name;
		@Test
		public void Item() throws MalformedURLException, Exception{
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability("deviceName", "Lenovo A6000");
			capability.setCapability("platformName", "Android");
			capability.setCapability("platformVersion", "4.4.4");
			capability.setCapability("appPackage", "kot.burpp");
			capability.setCapability("appActivity", "kot.burpp.ItemHandling");
			
			dr = new AndroidDriver(new URL("http://192.168.1.10:4722/wd/hub"),capability);
			TimeUnit.SECONDS.sleep(2);
			//Items page
			dr.findElement(By.xpath("//android.widget.TextView[@text='Items']")).click();
			TimeUnit.SECONDS.sleep(2);
			//Back button to tables page
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			TimeUnit.SECONDS.sleep(10);
			//click T2 table
			dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
			TimeUnit.SECONDS.sleep(5);
			dr.findElement(By.xpath("//android.widget.TextView[@text='Items']")).click();
			//Search an Item
			dr.findElement(By.id("android:id/search_button")).click();
			dr.findElement(By.id("android:id/search_src_text")).sendKeys("Fruity Rasagulla");
			dr.findElement(By.xpath("//android.widget.TextView[@index='0']")).click();
			dr.findElement(By.id("kot.burpp:id/itemqtyinqtydialog")).click();
			dr.scrollToExact("16").click();
			dr.findElement(By.id("kot.burpp:id/priorityinqtydialog")).click();
			dr.scrollToExact("P10").click();
			dr.findElement(By.id("android:id/button1")).click();
			TimeUnit.SECONDS.sleep(2);
			dr.findElement(By.xpath("//android.widget.TextView[@text='Items']")).click();
			//Items page menu popup
			dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
			dr.findElement(By.xpath("//android.widget.LinearLayout[@index='0']")).click();
			dr.findElement(By.id("android:id/button2")).click();
	        //Nonveg Item selection
			dr.findElement(By.xpath("//android.widget.TextView[@text='Category']")).click();
			TimeUnit.SECONDS.sleep(2);
			dr.findElement(By.xpath("//android.widget.TextView[@text='Starters']")).click();
			dr.findElement(By.id("kot.burpp:id/veginitemdisplay")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Fish Fry']")).click();
		    dr.findElement(By.id("android:id/button1")).click();
		    //Veg Item selection
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Gravies']")).click();
		    dr.findElement(By.id("kot.burpp:id/veginitemdisplay")).click();
		    dr.findElement(By.id("kot.burpp:id/nonveginitemdisplay")).click();
		    dr.scrollTo("Mushroom Masala").click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Mushroom Masala']")).click();
		    dr.findElement(By.id("android:id/button1")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Items']")).click();
		    //Alphabet filter app crashing
		    //dr.findElement(By.xpath("//kot.burpp:id/side_list_item[@text='I']")).click();
		    //Click icon
		    dr.findElement(By.id("kot.burpp:id/pink_icon")).click();
		    dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
		    dr.findElement(By.id("kot.burpp:id/pink_icon")).click();
		    TimeUnit.SECONDS.sleep(2);
		    dr.pressKeyCode(AndroidKeyCode.BACK);
		    TimeUnit.SECONDS.sleep(2);
		    dr.pressKeyCode(AndroidKeyCode.BACK);  
		}
	} 

