package miniProject;


import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {
	
	static WebDriver driver;
	static String url="https://demo.automationtesting.in/Alerts.html";
	
	public static WebDriver getWebDriver(int ch)  {
		 
		
		if(ch==1) {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			
		}
		
		
		else if(ch==2) {
		WebDriverManager.edgedriver().setup();
	     driver=new EdgeDriver();
		
		}

		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		
		
		return driver;
		
	}

}
