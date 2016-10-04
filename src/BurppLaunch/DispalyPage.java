package BurppLaunch;

	import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

	import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

	import com.google.common.collect.Table.Cell;

	import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

	public class DispalyPage {
		
		AndroidDriver dr;
		private String ip;
		private String display;
		
		@BeforeClass
		public void BurppDisplay() throws MalformedURLException, Exception{
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability("deviceName", "MACHONE");
			capability.setCapability("platformName", "Android");
			capability.setCapability("platformVersion", "4.4.2");
			capability.setCapability("appPackage", "kot.burpp");
			capability.setCapability("appActivity", "kot.burpp.SplashScreenlogin");
			dr = new AndroidDriver(new URL("http://192.168.1.13:4723/wd/hub"), capability);
		}
			
		@Test
		public void displayPageVerify() throws IOException{
			WebDriverWait wait = new WebDriverWait(dr, 40);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/nexttologin")));
			File src = new File("C:\\ExcelRead\\Read.xlsx");
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			/*XSSFSheet sheet1 = wb.getSheet("Sheet1");
			//ip address validation
		    int rowcount = sheet1.getLastRowNum();
	        System.out.println("rowcount"+rowcount);
	        for (int i=0;i<rowcount+1;i++)
	        {
	        	dr.findElement(By.id("kot.burpp:id/infoip")).click();
	        	int type;
	        	type = sheet1.getRow(i).getCell(0).getCellType();
	        	System.out.println(i+"="+type);
	        	 switch (type)
	            {
	            case 0: //Cell.CELL_TYPE_NUMERIC
	             ip =  String.valueOf(sheet1.getRow(i).getCell(0).getNumericCellValue());
	                break;
	            case 1: //CELL_TYPE_STRING:
	             ip = sheet1.getRow(i).getCell(0).getStringCellValue();
	                break;
	            case 2: //true condition:
	                 i=rowcount+2;
	                break;
	            }
	            dr.findElement(By.id("kot.burpp:id/currentip")).sendKeys(ip);
	            dr.findElement(By.id("android:id/button1")).click();
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/message")));
	            dr.findElement(By.id("android:id/button1")).click();
	        	 }
	        dr.findElement(By.id("kot.burpp:id/infoip")).click();
	        dr.findElement(By.id("kot.burpp:id/currentip")).clear();
	        dr.findElement(By.id("android:id/button2")).click();
	        dr.findElement(By.id("kot.burpp:id/currentip")).clear();
	        dr.findElement(By.id("android:id/button1")).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/message")));
	        dr.findElement(By.id("android:id/button1")).click();*/
	      
	        //Display name validation
	        dr.findElement(By.id("kot.burpp:id/displayname")).clear();
	        dr.findElement(By.id("kot.burpp:id/nexttologin")).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/nexttologin")));
			XSSFSheet sheet2 = wb.getSheet("Sheet2");
			int rowcount2 = sheet2.getLastRowNum();
	        System.out.println("rowcount"+rowcount2);
	        for (int i=0;i<rowcount2+1;i++)
	        {
	        	int type;
	        	type = sheet2.getRow(i).getCell(0).getCellType();
	        	System.out.println(i+"="+type);
				switch (type)
	            {
	            case 0: //Cell.CELL_TYPE_NUMERIC
	             display =  String.valueOf(sheet2.getRow(i).getCell(0).getNumericCellValue());
	                break;
	            case 1: //CELL_TYPE_STRING:
	             display = sheet2.getRow(i).getCell(0).getStringCellValue();
	                break;
	            case 2: //true condition:
	            	i=rowcount2+2;
	            	break;
	            	}	
	        dr.findElement(By.id("kot.burpp:id/displayname")).sendKeys(display);
			dr.findElement(By.id("kot.burpp:id/nexttologin")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/nexttologin")));
		 }
		 
			dr.findElement(By.id("kot.burpp:id/displayname")).sendKeys("Staging");
			dr.findElement(By.id("kot.burpp:id/nexttologin")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/username")));
	        dr.findElement(By.id("kot.burpp:id/username")).sendKeys("kavitha");
	        dr.pressKeyCode(AndroidKeyCode.BACK);
	        dr.pressKeyCode(AndroidKeyCode.BACK);
	        
	        //Display help icon
	        dr.findElement(By.id("kot.burpp:id/displayhelp")).click();
	        dr.findElement(By.id("android:id/button1")).click();
	        
	        //Validating Sign up process
	        dr.findElement(By.id("kot.burpp:id/registerbg")).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='Canvas Logo']")));
	        dr.pressKeyCode(AndroidKeyCode.BACK);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/nexttologin")));
	        
	        /*dr.findElement(By.xpath("android:id/text1[@text='Chrome']")).click();
	        TimeUnit.SECONDS.sleep(20);
	        dr.pressKeyCode(AndroidKeyCode.BACK);
	        dr.findElement(By.id("kot.burpp:id/registerbg")).click();
	        TimeUnit.SECONDS.sleep(2);
	        dr.findElement(By.xpath("android:id/text1[@text='UC Browser']")).click();
	        dr.findElement(By.id("android:id/button_once")).click();
	        TimeUnit.SECONDS.sleep(10);
	        dr.pressKeyCode(AndroidKeyCode.BACK);
	        dr.findElement(By.xpath("//android.widget.Button[@text='Cancel']"));
	        TimeUnit.SECONDS.sleep(2);
	        dr.pressKeyCode(AndroidKeyCode.BACK);
	        dr.findElement(By.xpath("//android.widget.Button[@text='Exit']"));
	        TimeUnit.SECONDS.sleep(2);
	        
	        //validation for App minimize 
	        dr.pressKeyCode(AndroidKeyCode.HOME);
	        TimeUnit.SECONDS.sleep(2);
	        dr.pressKeyCode(AndroidKeyCode.HOME);
	        TimeUnit.SECONDS.sleep(2);
	        dr.context("NATIVE_APP"); 
	        Dimension size = dr.manage().window().getSize(); 
	        int startx = (int) (size.width * 0.8); 
	        int endx = (int) (size.width * 0.20); 
	        int starty = size.height / 2; 
	        dr.swipe(startx, starty, endx, starty, 2000);
	        dr.swipe(startx, starty, endx, starty, 2000);
	        TimeUnit.SECONDS.sleep(2);
	        List<WebElement> content = dr.findElements(By.xpath("//android.widget.TextView[@package='com.lenovo.xlauncher' and @text='Burpp']"));
	        content.get(6).click();
	        //dr.findElement(By.xpath("android.widget.TextView[@index='14']")).click();*/
		}
		
		@AfterClass
		public void closeApp(){
	        //Validate exit process
	        dr.pressKeyCode(AndroidKeyCode.BACK);
	        dr.findElement(By.id("android:id/button2")).click();
	        dr.pressKeyCode(AndroidKeyCode.BACK);
	        dr.findElement(By.id("android:id/button1")).click();
			}

	}
