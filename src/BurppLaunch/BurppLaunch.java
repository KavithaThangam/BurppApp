package BurppLaunch;

	import io.appium.java_client.android.AndroidDriver;

	import java.io.File;
	import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.testng.annotations.Test;

	public class BurppLaunch {
		
		AndroidDriver dr;
		
		@Test
		public void BurppApp() throws MalformedURLException{
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setCapability("deviceName", "Ice Cube");
			capability.setCapability("platformName", "Android");
			capability.setCapability("platformVersion", "4.2.2");
			
			File file = new File("C:\\Users\\Arivu\\workspaceBurpp\\BurppApplication\\Burppapk\\app-debug.apk");
			capability.setCapability("app", file.getAbsolutePath());
			
			dr = new AndroidDriver(new URL("http://192.168.1.7:4723/wd/hub"), capability);
			
		}
	}

