package ToolsQA;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class homepage {
	//WebDriver driver;

public void login(WebDriver driver, String email, String password){
		driver.findElement(By.id("loginPopup")).click();
		driver.findElement(By.id("register_email")).sendKeys(email);
		driver.findElement(By.id("passwordlog")).sendKeys(password);
		driver.findElement(By.id("login")).click();
	}

public void navigatetoassetreport(WebDriver driver){
		driver.findElement(By.id("loggedinPopup")).click();
		driver.findElement(By.id("assetreport")).click();
	}
public void navigatetophotography(WebDriver driver){
		driver.findElement(By.linkText("Photography")).click();
	}
public void logoutandclose(WebDriver driver){
	driver.findElement(By.id("loggedinPopup")).click();
	driver.findElement(By.linkText("Logout")).click();
    driver.close();
	}
public void logout(WebDriver driver){
	driver.findElement(By.id("loggedinPopup")).click();
	driver.findElement(By.linkText("Logout")).click();
    }
public void close(WebDriver driver){
	driver.close();
	}
}


