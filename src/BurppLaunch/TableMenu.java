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

	public class TableMenu {
		
		AndroidDriver dr;
		private int i;
		@Test
		
		public void Tablemenu() throws MalformedURLException, Exception {
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability("deviceName", "LenovoA6000");
			capability.setCapability("platformName", "Android");
			capability.setCapability("platformVersion", "4.4.4");
			capability.setCapability("appPackage", "kot.burpp");
			capability.setCapability("appActivity","kot.burpp.SplashScreenlogin");
		
			dr = new AndroidDriver(new URL("http://192.168.1.17:4723/wd/hub"),capability);
			TimeUnit.SECONDS.sleep(10);
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			TimeUnit.SECONDS.sleep(2);
			dr.findElement(By.id("kot.burpp:id/logoutnav")).click();
			dr.findElement(By.id("android:id/button2")).click();
			TimeUnit.SECONDS.sleep(2);
			dr.findElement(By.xpath("//android.widget.TextView[@text='T4']")).click();
			dr.findElement(By.id("kot.burpp:id/parcelintableview")).click();
			TimeUnit.SECONDS.sleep(2);
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			TimeUnit.SECONDS.sleep(10);
			dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
			dr.findElement(By.id("kot.burpp:id/currentocc")).sendKeys("4");
			dr.findElement(By.id("android:id/button1")).click();
			TimeUnit.SECONDS.sleep(5);
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			TimeUnit.SECONDS.sleep(10);
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			TimeUnit.SECONDS.sleep(2);
			List layoutindex = dr.findElementsByXPath("//android.support.v7.widget.RecyclerView");
			for (int i=0;i<=layoutindex.size()-1;i++)
	        {
	        dr.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index='1']").click();
	        }
			dr.findElement(By.xpath("//android.widget.TextView[@text='Starters1']")).click();
			TimeUnit.SECONDS.sleep(2);
			dr.findElement(By.xpath("//android.widget.TextView[@text='Aloo Gobi Fry']")).click();
			dr.findElement(By.id("android:id/button1")).click();
		    dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
		    TimeUnit.SECONDS.sleep(10);
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			TimeUnit.SECONDS.sleep(2);
	        {
	        dr.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[@index='3']").click();
	        }
			dr.findElement(By.id("android:id/search_button")).click();
			dr.findElement(By.id("android:id/search_src_text")).sendKeys("Fruity Rasagulla");
			dr.findElement(By.xpath("//android.widget.TextView[@index='0']")).click();
			dr.findElement(By.id("android:id/button1")).click();
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			TimeUnit.SECONDS.sleep(10);
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			dr.findElement(By.id("kot.burpp:id/logoutnav")).click();
			dr.findElement(By.id("android:id/button1")).click();
			TimeUnit.SECONDS.sleep(5);
			dr.pressKeyCode(AndroidKeyCode.BACK);
			dr.pressKeyCode(AndroidKeyCode.BACK);
			dr.findElement(By.id("android:id/button1")).click();
		}
	}

