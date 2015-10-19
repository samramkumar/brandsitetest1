package ToolsQA;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class assetdownloadreport {

	public int viewdownloadhistoryfor(WebDriver driver, String cemailid){
		 List<WebElement> totalcnt=driver.findElements(By.className("assetRow"));
		 Integer totalrows = totalcnt.size();
		    
		    for(int i = 1; i <= totalrows; i = i+1) {
		     String emailid = driver.findElement(By.xpath(".//*[@id='reportContentRow']/div/div[1]/div[2]/div["+i+"]/div[2]/span")).getText();
		     String userid = driver.findElement(By.xpath("html/body/div[4]/div[4]/div[1]/div[2]/div/div[1]/div/div[2]/div/div/div[1]/div[2]/div["+i+"]/div[4]/span/a")).getAttribute("id");
		     System.out.println(emailid);
		     System.out.println(userid);
		      if (emailid.equals(cemailid)) {
		      driver.findElement(By.xpath(".//*[@id='"+userid+"']")).click();
		      break;
		      }
		      }
		      List<WebElement> totalimagesdownload = driver.findElements(By.className("downloadRow"));
		      int currentimagescount = totalimagesdownload.size();
		      return (currentimagescount);
	}
}
