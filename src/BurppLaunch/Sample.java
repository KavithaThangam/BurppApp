package BurppLaunch;

	import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

	import io.appium.java_client.android.AndroidDriver;

	import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

	public class Sample {
		
		AndroidDriver dr;
		@Test
		
		public void BurppLogin() throws MalformedURLException, Exception {
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability("deviceName", "MACHONE");
			capability.setCapability("PlatformName", "Android");
			capability.setCapability("platformVersion", "4.4.2");
			capability.setCapability("appPackage", "kot.burpp");
			capability.setCapability("appActivity", "kot.burpp.ItemHandling");
			
			dr = new AndroidDriver(new URL ("http://192.168.1.13:4723/wd/hub"),capability);
			
			/*ArrayList<String> view_pager = new ArrayList<String>();
			view_pager.add("com.gentaycom.nanu:id/view_pager");
			for(String mess: view_pager){
				if(mess.equals("Appa")){
					dr.findElement(By.xpath("//android.support.v4.view.ViewPager[@text='Appa']")).click();
				}
			}*/
			//dr.scrollToExact("Appa").click();
			//TimeUnit.SECONDS.sleep(2);
			//dr.findElement(By.xpath("//android.widget.LinearLayout[@index='2']")).click();
			//List<WebElement> contact = dr.findElements(By.xpath("//android.widget.FrameLayout[@index='1']"));
			//contact.get(2).click();
			//dr.findElement(By.xpath("//android.widget.LinearLayout[@text=''] and [@index='1']")).click();
			
			/*ArrayList<String> contents = new ArrayList<String>();
			contents.add("android.widget.FrameLayout");
			dr.scrollToExact("IM-IRCTCi").click();
			for(String mess: contents){
				if(mess.equals("IM-IRCTCi")){
					dr.findElement(By.xpath("//android.widget.TextView[@text='IM-IRCTCi']")).click();
				}
			}*/
			//dr.scrollToExact("M-Pesa").click();
	      }
	     
		}
