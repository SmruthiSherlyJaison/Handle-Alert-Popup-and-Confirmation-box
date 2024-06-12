package miniProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	public static void takeScreenshot(WebDriver driver,String name) throws IOException {

		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\2332888\\eclipse-workspace\\SeleniumProject\\ScreenShots\\"+name);
	    FileUtils.copyFile(src, trg);;
		
		
	}

}
