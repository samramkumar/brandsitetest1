package ToolsQA;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class commonfunctions {
	
	public void navigateurl(WebDriver driver, String url) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
	}
	public void closewindow(WebDriver driver, String closeid) {
		driver.findElement(By.id(closeid)).click();
	}
}

