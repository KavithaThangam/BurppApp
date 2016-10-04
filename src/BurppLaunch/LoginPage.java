package BurppLaunch;

	import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

	import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

	import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

	public class LoginPage {
		
		AndroidDriver dr;
		private int i;
		private String login1;
		private XSSFComment cellcount;
		private int columncount;
		private String log;
		private String log1;
		
		@BeforeClass
		public void BurppLogin() throws MalformedURLException, Exception {
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability("deviceName", "MACHONE");
			capability.setCapability("PlatformName", "Android");
			capability.setCapability("platformVersion", "4.4.2");
			capability.setCapability("appPackage", "kot.burpp");
			capability.setCapability("appActivity", "kot.burpp.SplashScreenlogin");
			dr = new AndroidDriver(new URL ("http://192.168.1.19:4723/wd/hub"),capability);
		}
		
		@BeforeMethod
		public void displayPage(){
			WebDriverWait wait = new WebDriverWait(dr, 40);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/infoip")));
			dr.findElement(By.id("kot.burpp:id/displayname")).sendKeys("Staging");
			dr.findElement(By.id("kot.burpp:id/nexttologin")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/loginhelp")));
		}
		
		@Test
		public void loginProcess() throws IOException{
			File src = new File("C:\\ExcelRead\\Read.xlsx");
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet login = wb.getSheet("sheet3");
			
			 //Login validation
			 int rowcount = login.getLastRowNum();
			 System.out.println("rowcount"+rowcount);
			 int noOfColumns = login.getRow(i).getPhysicalNumberOfCells();
	         Iterator rowIterator = login.rowIterator();
	        
	         if (rowIterator.hasNext())
	         {
	             Row headerRow = (Row) rowIterator.next();
	             //get the number of cells in the header row
	             noOfColumns = headerRow.getPhysicalNumberOfCells();
	         }
	         System.out.println("number of cells "+noOfColumns);

			for (int i=0;i<rowcount+1;i++)
			{
				for(int j=0;j<noOfColumns;j++)    		
		        {
		        	int type;
		        	type = login.getRow(i).getCell(0).getCellType();
		        	//System.out.println(i+"="+type);
		        	//System.out.println(j+"="+type);
		        	{
		        		int type1;
		        		type1 = login.getRow(i).getCell(1).getCellType();
			        	//System.out.println(i+"="+type);
			        	//System.out.println(j+"="+type);
		        	 switch (type)
		            {
		            case 0: //Cell.CELL_TYPE_NUMERIC
		             log =  String.valueOf(login.getRow(i).getCell(0).getNumericCellValue());
		             break;
		            case 1: //CELL_TYPE_STRING
		             log = login.getRow(i).getCell(0).getStringCellValue();
		             break;
		            case 2: //XSSFCell.CELL_TYPE_BLANK:
		             log="";
		             break;
		            case 3: //true condition:
		                 i=rowcount+2;
		                 j=noOfColumns;
		                break;
		                
		            }
		       
		        	 switch (type1)
		        	 {
		        	 case 0: //Cell.CELL_TYPE_NUMERIC
			             log1 =  String.valueOf(login.getRow(i).getCell(1).getNumericCellValue());
			             break;
		        	 case 1: //CELL_TYPE_STRING
			             log1 = login.getRow(i).getCell(1).getStringCellValue();
			             break;
		        	 case 2: //XSSFCell.CELL_TYPE_BLANK:
			             log1="";
			                break;
		        	 case 3: //true condition:
		                 i=rowcount+2;
		                 j=noOfColumns;
		                break;
		        	 }
					System.out.println("i values :"+i + " j values :"+j);
		        }
		        }
				     WebDriverWait wait = new WebDriverWait(dr, 40);
		        	 dr.findElement(By.id("kot.burpp:id/username")).sendKeys(log);
		        	 dr.findElement(By.id("kot.burpp:id/password")).sendKeys(log1);
		        	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/loginhelp")));
		        	 dr.findElement(By.id("kot.burpp:id/loginthru")).click();
		        	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/loginhelp")));
			}
			WebDriverWait wait = new WebDriverWait(dr, 40);
			dr.findElement(By.id("kot.burpp:id/username")).clear();
	   	    dr.findElement(By.id("kot.burpp:id/password")).clear();
	   	    dr.findElement(By.id("kot.burpp:id/loginthru")).click();
	   	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/loginhelp")));
	   	    
	   	    dr.findElement(By.id("kot.burpp:id/password")).sendKeys("password");
	   	    dr.findElement(By.id("kot.burpp:id/loginthru")).click();
	   	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/loginhelp")));
	   	    
	   	    /*dr.findElement(By.id("kot.burpp:id/username")).sendKeys("waiter1@burpp.com");
	   	    dr.findElement(By.id("kot.burpp:id/password")).clear();
	   	    dr.findElement(By.id("kot.burpp:id/loginthru")).click();
	   	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/loginhelp")));*/
	   	    
	   	    dr.findElement(By.id("kot.burpp:id/loginhelp")).click();
	   	    dr.findElement(By.id("android:id/button1")).click();
	   	    dr.pressKeyCode(AndroidKeyCode.BACK);
	   	    dr.findElement(By.id("kot.burpp:id/backtodisplay")).click();
	   	    dr.findElement(By.id("kot.burpp:id/nexttologin")).click();
	   	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/loginhelp"))); 
			dr.pressKeyCode(AndroidKeyCode.BACK);
			dr.findElement(By.id("kot.burpp:id/nexttologin")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kot.burpp:id/loginhelp")));
	   	    
	   	    dr.findElement(By.id("kot.burpp:id/username")).sendKeys("waiter1@burpp.com");
		    dr.findElement(By.id("kot.burpp:id/password")).sendKeys("password");
		    dr.findElement(By.id("kot.burpp:id/loginthru")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='More options']")));
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
		private void CELL_TYPE_BLANK() {
			// TODO Auto-generated method stub
			System.out.println("");
		}
			

		
	}

