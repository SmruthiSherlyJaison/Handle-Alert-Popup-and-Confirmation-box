package miniProject;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		// Choose Browser
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Choice of Browser:\n1=Chrome\n2=Edge");
		int ch=sc.nextInt();
		sc.close();
		//Launch the browser
		
		WebDriver driver=DriverSetup.getWebDriver(ch);
		
		
		String file=System.getProperty("user.dir")+"\\Testdata\\AlertBox.xlsx";
		String name=ExcelUtils.getCellData(file,"Input", 1, 0);
		
		
		
		//Hover the mouse over “SwitchTo” menu
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.linkText("SwitchTo"));
		
		act.moveToElement(ele).perform();
		
		
		
		Screenshots.takeScreenshot(driver, "p1.png");
		//Click on Alerts
		
		driver.findElement(By.linkText("Alerts")).click();
		
		
		//Click on the link “Alert with OK”" and click on “click the button to display an alert box:”
		
	    driver.findElement(By.cssSelector("a[href='#OKTab']")).click();
		driver.findElement(By.cssSelector(".btn.btn-danger")).click();
		
		
		
		//Check whether alert pop up appears or not.
		
		
		Alert alert=driver.switchTo().alert();
		
		
		//Click on “OK”
		if(!(alert.getText().isEmpty()))
		{
		ExcelUtils.setCellData(file, "Output", 0, 0,"ALERT BOX 1 DISPLAYED");
		alert.accept();
		
		}
		
		Screenshots.takeScreenshot(driver, "p2.png");
		
		//Click the Link "Alert with OK & Cancel" in the left menu option.
		
		driver.findElement(By.partialLinkText("Alert with OK &")).click();
		
		
		//Click the link "click the button to display a confirm box.
		
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		
		
		//Check whether confirm box pop up appears or not.
		
		Alert alert1=driver.switchTo().alert();
		
		//Click on “Cancel” and check the respective message displayed
		if(!(alert1.getText().isEmpty())) {
		
		ExcelUtils.setCellData(file, "Output", 0, 1,"ALERT BOX 2 DISPLAYED");
		alert1.dismiss();
		
		}
		
		
		Screenshots.takeScreenshot(driver, "p3.png");
		
		WebElement msgDisplayed=driver.findElement(By.id("demo"));
		//System.out.println(msgDisplayed.getText());
		String op1=msgDisplayed.getText();
		String tf1=String.valueOf(msgDisplayed.isDisplayed());
		
		
		//Click the Link "Alert with Textbox".
		
		driver.findElement(By.linkText("Alert with Textbox")).click();
		
		
		//Click the link "click the button to demonstrate the prompt box.
		
		driver.findElement(By.cssSelector("button[class='btn btn-info']")).click();
		
		
		//Check whether prompt box pop up appears or not.
		
		Alert alert2=driver.switchTo().alert();
		
		
		if(!(alert.getText().isEmpty())) {
			ExcelUtils.setCellData(file, "Output", 0, 2,"ALERT BOX 3 DISPLAYED");
			//Enter your name in the textbox and click on “OK”
		    alert2.sendKeys(name);
		    alert2.accept();
		
		}
		Screenshots.takeScreenshot(driver, "p4.png");
		
		//Check if the message Hello <your name> How are you today” is displayed
		WebElement popmsg=driver.findElement(By.id("demo1"));
		//System.out.println(popmsg.getText());
		String op2=popmsg.getText();
		String tf2=String.valueOf(popmsg.getText().equals("Hello Smruthi How are you today"));
		
		
		
		//Writing Data into excel Sheet
		
		ExcelUtils.setCellData(file, "Output", 2, 1,op1);
		ExcelUtils.setCellData(file, "Output", 2, 2,tf1);
		ExcelUtils.setCellData(file, "Output", 3, 1,op2);
		ExcelUtils.setCellData(file, "Output", 3, 2,tf2);
		
		if(tf1.equalsIgnoreCase("True")) {
			ExcelUtils.fillGreenColor(file, "Output", 2, 2);
		}
		else if(tf1.equalsIgnoreCase("False")) {
			ExcelUtils.fillRedColor(file, "Output", 2, 2);
		}
		
		
		if(tf2.equalsIgnoreCase("True")) {
			ExcelUtils.fillGreenColor(file, "Output", 3, 2);
		}
		else if(tf2.equalsIgnoreCase("False")) {
			ExcelUtils.fillRedColor(file, "Output", 3, 2);
		}
		
		
		//Close the browser
		
		
		driver.quit();
		
	}

}
