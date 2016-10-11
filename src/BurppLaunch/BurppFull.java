package BurppLaunch;

	import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

	import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

	public class BurppFull {

		
		AndroidDriver dr;
		@BeforeClass
		public void burppFramework() throws MalformedURLException, Exception{
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability("deviceName", "HUAWEI Y541-U02");
			capability.setCapability("platformName", "Android");
			capability.setCapability("platformVersion", "4.4.2");
			capability.setCapability("appPackage", "kot.burpp");
			capability.setCapability("appActivity", "kot.burpp.SplashScreenlogin");
			dr = new AndroidDriver(new URL("http://192.168.1.6:4723/wd/hub"),capability);
			
		}
			
			@BeforeMethod
			public void displayLogin(){
			WebDriverWait wait = new WebDriverWait(dr, 40);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/infoip")));
			//Display page
			dr.findElement(By.id("kot.burpp:id/infoip")).click();
			dr.findElement(By.id("android:id/button2")).click();
			dr.findElement(By.id("kot.burpp:id/registerbg")).click();
			dr.navigate().back();
			dr.findElement(By.id("kot.burpp:id/displayhelp")).click();
			dr.findElement(By.id("android:id/button1")).click();
			dr.findElement(By.id("kot.burpp:id/displayname")).sendKeys("staging");
			dr.pressKeyCode(AndroidKeyCode.BACK);
			dr.findElement(By.id("kot.burpp:id/nexttologin")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/loginhelp")));
			
			//Login page
			dr.findElement(By.id("kot.burpp:id/loginhelp")).click();
			dr.findElement(By.id("android:id/button1")).click();
			dr.findElement(By.id("kot.burpp:id/backtodisplay")).click();
			dr.findElement(By.id("kot.burpp:id/nexttologin")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/username")));
			dr.findElement(By.id("kot.burpp:id/username")).sendKeys("waiter1@burpp.com");
			dr.findElement(By.id("kot.burpp:id/password")).sendKeys("password");
			dr.findElement(By.id("kot.burpp:id/loginthru")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='More options']")));
			}
			
			@Test
			public void tableProcess() throws Exception{
			//Tables page
				WebDriverWait wait = new WebDriverWait(dr, 40);
			/*dr.findElement(By.xpath("//android.widget.ImageView[@content-desc='More options']")).click();
			dr.findElement(By.xpath("//android.widget.TextView[@text='Feedback']")).click();
			dr.findElement(By.id("kot.burpp:id/feedbackspinner")).click();
			dr.findElement(By.xpath("//android.widget.TextView[@text='Request a New Feature']")).click();
			dr.findElement(By.id("kot.burpp:id/feedbackcontent")).sendKeys("hello");
			dr.pressKeyCode(AndroidKeyCode.BACK);
			dr.findElement(By.id("kot.burpp:id/submit")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='More options']")));
			dr.findElement(By.xpath("//android.widget.ImageView[@content-desc='More options']")).click();
			dr.findElement(By.xpath("//android.widget.TextView[@text='Reserve']")).click();
			dr.findElement(By.id("kot.burpp:id/reservetablelist")).click();
			dr.scrollToExact("T11").click();
			dr.findElement(By.id("kot.burpp:id/currentocc")).sendKeys("6");
			dr.findElement(By.id("kot.burpp:id/in_date")).sendKeys("08.08.2016");
			dr.findElement(By.id("kot.burpp:id/in_time")).sendKeys("09.00 PM");
			dr.findElement(By.id("android:id/button1")).click();
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			dr.scrollTo("Take away");
			dr.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
			dr.findElement(By.id("kot.burpp:id/parcelintableview")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='T2']")));
			*/
			//Split, Block, Release
			TouchAction action = new TouchAction(dr);
			dr.findElement(By.xpath("//android.widget.TextView[@text='T2']")).click();
			dr.findElement(By.id("kot.burpp:id/currentocc")).sendKeys("4");
			dr.findElement(By.id("android:id/button1")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    action.longPress(dr.findElement(By.xpath("//android.widget.TextView[@text='T2']"))).perform();
			dr.findElement(By.id("kot.burpp:id/splittableoption")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='T2']")));
			
			TouchAction action1 = new TouchAction(dr);
			action1.longPress(dr.findElement(By.xpath("//android.widget.TextView[@text='T4']"))).perform();
			dr.findElement(By.id("kot.burpp:id/blackoption")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='T2']")));
			
			TouchAction action2 = new TouchAction(dr);
			action2.longPress(dr.findElement(By.xpath("//android.widget.TextView[@text='T4']"))).perform();
			dr.findElement(By.id("kot.burpp:id/releaseoption")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='T2']")));
			
			//order table
			dr.findElement(By.xpath("//android.widget.TextView[@text='T4']")).click();
			dr.findElement(By.id("kot.burpp:id/currentocc")).sendKeys("4");
			dr.findElement(By.id("android:id/button1")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			dr.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			dr.findElement(By.xpath("//android.widget.TextView[@text='T4']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			//Edit, Switch, cancel, Reprint
			dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
	        List<WebElement> content = dr.findElements(By.xpath("//android.widget.LinearLayout"));
			content.get(0).click();
			dr.findElement(By.id("kot.burpp:id/currentocc")).clear();
			dr.findElement(By.id("kot.burpp:id/currentocc")).sendKeys("3");
			dr.findElement(By.id("android:id/button1")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
			content.get(1).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/availabletablelist")));
			dr.findElement(By.id("kot.burpp:id/availabletablelist")).click();
			dr.scrollToExact("T7").click();
			dr.findElement(By.id("android:id/button1")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			dr.findElement(By.xpath("//android.widget.TextView[@text='T7']")).click();
			dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
			content.get(2).click();
			dr.findElement(By.id("android:id/button1")).click();
			//Order a item
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			dr.findElement(By.xpath("//android.widget.TextView[@text='T4']")).click();
			dr.findElement(By.id("kot.burpp:id/currentocc")).sendKeys("4");
			dr.findElement(By.id("android:id/button1")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			dr.findElement(By.id("android:id/search_button")).click();
			dr.findElement(By.id("android:id/search_src_text")).sendKeys("Chi Burger");
			dr.findElement(By.xpath("//android.widget.TextView[@index='0']")).click();
			dr.findElement(By.id("kot.burpp:id/itemqtyinqtydialog")).click();
			dr.scrollToExact("10").click();
			dr.findElement(By.id("kot.burpp:id/priorityinqtydialog")).click();
			dr.scrollToExact("P1").click();
			dr.findElement(By.id("android:id/button1")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			dr.findElement(By.xpath("//android.widget.TextView[@text='Starters1']")).click();
			dr.findElement(By.id("kot.burpp:id/veginitemdisplay")).click();
			TimeUnit.SECONDS.sleep(5);
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Potato Bites']")).click();
		    dr.findElement(By.id("android:id/button1")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Items']")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Jeera Aloo']")).click();
		    dr.findElement(By.id("android:id/button1")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
			//Place Order
		    dr.findElement(By.id("kot.burpp:id/pink_icon")).click();
		    dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
		    dr.navigate().back();
		    dr.findElement(By.id("kot.burpp:id/incrementqty")).click();
		    dr.findElement(By.id("kot.burpp:id/incrementqty")).click();
		    dr.findElement(By.id("kot.burpp:id/minus")).click();
		    dr.findElement(By.id("kot.burpp:id/bill")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    dr.findElement(By.id("kot.burpp:id/print")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    dr.findElement(By.id("kot.burpp:id/printconfirm")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='BTprinter8045']")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    //Bill order
		    dr.findElement(By.xpath("//android.widget.TextView[@text='T4']")).click();
		    dr.findElement(By.id("kot.burpp:id/pink_icon")).click();
		    dr.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
	        List<WebElement> contents = dr.findElements(By.xpath("//android.widget.LinearLayout"));
			contents.get(3).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/availableorderlist")));
			dr.findElement(By.id("kot.burpp:id/availableorderlist")).click();
			dr.findElement(By.xpath("//android.widget.CheckedTextView[@text='Order -1']")).click();
			dr.findElement(By.id("android:id/button1")).click();
			dr.findElement(By.xpath("//android.widget.TextView[@text='BTprinter8045']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    dr.findElement(By.id("kot.burpp:id/bill")).click();
		    dr.findElement(By.id("android:id/button1")).click();
		    dr.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Additional Charges']")).click();
		    dr.findElement(By.id("kot.burpp:id/setadditionalchargedesc")).sendKeys("water");
		    dr.findElement(By.id("kot.burpp:id/setadditionalcharge")).sendKeys("2");
		    dr.findElement(By.id("kot.burpp:id/setadditionalpercent")).sendKeys("50");
		    dr.findElement(By.id("android:id/button1")).click();
		    dr.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='Discount']")).click();
		    dr.findElement(By.id("kot.burpp:id/setadditionalchargedesc")).sendKeys("regular customer");
		    dr.findElement(By.id("kot.burpp:id/setadditionalpercent")).sendKeys("30");
		    dr.findElement(By.id("android:id/button1")).click();
		    dr.scrollTo("BILL PAID");
		    dr.findElement(By.id("kot.burpp:id/billconfirm")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='BTprinter8045']")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
		    
		    //Bill release
		    dr.findElement(By.xpath("//android.widget.TextView[@text='T4']")).click();
		    dr.scrollTo("BILL PAID");
		    dr.findElement(By.id("kot.burpp:id/billreprint")).click();
		    dr.findElement(By.xpath("//android.widget.TextView[@text='BTprinter8045']")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='0']")));
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

