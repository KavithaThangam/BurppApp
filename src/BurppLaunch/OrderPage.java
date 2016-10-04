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

	public class OrderPage {
		
		AndroidDriver dr;
		@Test
		public void orderDetailPage() throws MalformedURLException, Exception{
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability("deviceName", "MACHONE");
			capability.setCapability("platformName", "Android");
			capability.setCapability("platformVersion", "4.4.2");
			capability.setCapability("appPackage", "kot.burpp");
			capability.setCapability("appActivity", "kot.burpp.SplashScreenlogin");
			
			dr = new AndroidDriver(new URL("http://192.168.1.28:4723/wd/hub"),capability);
			TimeUnit.SECONDS.sleep(10);
			
			//Book a table
			dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
			dr.findElement(By.id("kot.burpp:id/currentocc")).sendKeys("4");
			dr.findElement(By.id("android:id/button1")).click();
			TimeUnit.SECONDS.sleep(10);
			dr.findElement(By.id("kot.burpp:id/pink_icon")).click();
			
			//Click Back
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			TimeUnit.SECONDS.sleep(5);
			dr.findElement(By.id("kot.burpp:id/pink_icon")).click();
			dr.findElement(By.id("kot.burpp:id/bill")).click();
			dr.findElement(By.id("kot.burpp:id/print")).click();
			
			//order a item using search option
			dr.findElement(By.id("android:id/search_button")).click();
			dr.findElement(By.id("android:id/search_src_text")).sendKeys("Fish Fry");
			dr.findElement(By.xpath("//android.widget.TextView[@text='Category']")).click();
			dr.findElement(By.id("android:id/button1")).click();
			dr.findElement(By.id("android:id/search_close_btn")).click();
			dr.findElement(By.id("android:id/search_close_btn")).click();
			dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
			
			//Pax Edit
			List<WebElement> order = dr.findElements(By.xpath("//android.widget.LinearLayout"));
			order.get(0).click();
			dr.findElement(By.id("kot.burpp:id/currentocc")).clear();
			dr.findElement(By.id("kot.burpp:id/currentocc")).sendKeys("3");
			dr.findElement(By.id("android:id/button1")).click();
			TimeUnit.SECONDS.sleep(5);
			
			//Switch Table
			dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
			order.get(1).click();
			TimeUnit.SECONDS.sleep(2);
			dr.findElement(By.id("kot.burpp:id/availabletablelist")).click();
			TimeUnit.SECONDS.sleep(2);
			dr.scrollToExact("T11").click();
			dr.findElement(By.id("android:id/button1")).click();
			TimeUnit.SECONDS.sleep(5);
			dr.scrollToExact("T11").click();
			dr.findElement(By.id("kot.burpp:id/pink_icon")).click();
			
			//Reprint Order
			dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
			order.get(3).click();
			dr.findElement(By.id("android:id/button2")).click();
			
			//Cancel Order
			dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
			order.get(2).click();
			dr.findElement(By.id("android:id/button1")).click();
			TimeUnit.SECONDS.sleep(10);
			
			//Book a Table
			dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
			dr.findElement(By.id("kot.burpp:id/currentocc")).sendKeys("4");
			dr.findElement(By.id("android:id/button1")).click();
			TimeUnit.SECONDS.sleep(2);
			
			//Order Taking
			dr.findElement(By.xpath("//android.widget.TextView[@text='Gravies']")).click();
			TimeUnit.SECONDS.sleep(1);
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Chicken Korma']")).click();
		    dr.findElement(By.id("android:id/button1")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='South Indian']")).click();
		    TimeUnit.SECONDS.sleep(1);
		    dr.scrollToExact("Vada").click();
		    dr.findElement(By.id("android:id/button1")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Rice']")).click();
		    TimeUnit.SECONDS.sleep(1);
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Ghee Rice']")).click();
		    dr.findElement(By.id("android:id/button1")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Breads']")).click();
		    TimeUnit.SECONDS.sleep(1);
		    dr.scrollToExact("Roti").click();
		    dr.findElement(By.id("android:id/button1")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Desserts']")).click();
		    TimeUnit.SECONDS.sleep(1);
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Fruity Rasagulla']")).click();
		    dr.findElement(By.id("android:id/button1")).click();
		    
		    //Order view page
		    dr.findElement(By.id("kot.burpp:id/pink_icon")).click();
		    dr.scrollTo("Current order");
		    dr.findElement(By.id("kot.burpp:id/incrementqty")).click();
		    dr.findElement(By.id("kot.burpp:id/incrementqty")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Vada']")).click();
		    dr.findElement(By.id("kot.burpp:id/itemqtyinqtydialog")).click();
		    dr.scrollToExact("6").click();
		    dr.findElement(By.id("kot.burpp:id/priorityinqtydialog")).click();
		    dr.scrollToExact("P10").click();
		    dr.findElement(By.id("kot.burpp:id/setdescinquantitydialog")).sendKeys("later");
		    dr.pressKeyCode(AndroidKeyCode.BACK);
		    dr.findElement(By.id("android:id/button1")).click();
		    TimeUnit.SECONDS.sleep(2);
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Roti']")).click();
		    dr.findElement(By.id("android:id/button2")).click();
		    TimeUnit.SECONDS.sleep(2);
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Roti']")).click();
		    dr.findElement(By.id("android:id/button1")).click();
		    TimeUnit.SECONDS.sleep(2);
		    dr.findElement(By.id("kot.burpp:id/incrementqty")).click();
		    dr.findElement(By.id("kot.burpp:id/minus")).click();
		    
		    //Place Order
		    dr.findElement(By.id("kot.burpp:id/print")).click();
		    TimeUnit.SECONDS.sleep(5);
		    dr.findElement(By.id("kot.burpp:id/printconfirm")).click();
		    TimeUnit.SECONDS.sleep(10);
		    
		    //Reprint Order 
		    dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Breads']")).click();
		    TimeUnit.SECONDS.sleep(1);
		    dr.scrollToExact("Roti").click();
		    dr.findElement(By.id("android:id/button1")).click();
		    dr.findElement(By.id("kot.burpp:id/pink_icon")).click();
		    dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
		    List<WebElement> orders = dr.findElements(By.xpath("//android.widget.LinearLayout"));
		    orders.get(3).click();
		    TimeUnit.SECONDS.sleep(5);
		    dr.findElement(By.id("kot.burpp:id/availableorderlist")).click();
		    dr.scrollToExact("Order -1").click();
		    dr.findElement(By.id("android:id/button1")).click();
		    TimeUnit.SECONDS.sleep(5);
		    
		    //Bill order
		    dr.findElement(By.id("kot.burpp:id/bill")).click();
		    dr.findElement(By.id("android:id/button2")).click();
		    dr.findElement(By.id("kot.burpp:id/bill")).click();
		    dr.findElement(By.id("android:id/button1")).click();
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			
		}

	}

