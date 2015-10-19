package ToolsQA;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class photographypage {
	public static int totalimages=0;
	ArrayList<String> imagenames = new ArrayList<String>();
	public int gettotalpagesanddownloadimages(WebDriver driver) throws AWTException, InterruptedException{
	List <WebElement> links = driver.findElements(By.className("paginate_click"));
	int totallinks = links.size();
	 for(int x = 1; x <= totallinks; x = x+1) {
    	String linkclass = driver.findElement(By.partialLinkText(""+x+"")).getAttribute("class");
    		if (linkclass.equals("paginate_click active")){
			Thread.sleep(4000);
			List<WebElement> images1 = driver.findElements(By.className("imgthumb"));
			totalimages = totalimages + images1.size();
			System.out.println("Total Images"+totalimages);
			for (int i = 1; i<= images1.size();i++){
	 	       	driver.findElement(By.xpath("html/body/div[4]/div[4]/div/div[2]/div/div/div[1]/div[4]/div/div["+i+"]/img")).click();
			   	Thread.sleep(1000);
	 	    	String name1 = driver.findElement(By.xpath("html/body/div[4]/div[4]/div/div[2]/div/div/div[2]/h5")).getText();
	 			imagenames.add(name1);
	 			driver.findElement(By.className("stylePE")).click();	 
	 	 	    driver.findElement(By.partialLinkText("resolution")).click();
	 	 	    Thread.sleep(4000);
	 	 	    Robot rb =new Robot();
	 	 	    rb.keyPress(KeyEvent.VK_DOWN);
	 	 	    Thread.sleep(2000);
	 	 	    rb.keyRelease(KeyEvent.VK_DOWN);
	 	 	    rb.keyPress(KeyEvent.VK_ENTER);
	 	 	    Thread.sleep(2000);
	 	 	    rb.keyRelease(KeyEvent.VK_ENTER);
	 	    }
			}else {
			driver.findElement(By.partialLinkText(""+x+"")).click();
			Thread.sleep(4000);
			List<WebElement> images1 = driver.findElements(By.className("imgthumb"));
			totalimages = totalimages + images1.size();
			System.out.println("Total Images"+totalimages);
			for (int i = 1; i<= images1.size();i++){
	 	       	driver.findElement(By.xpath("html/body/div[4]/div[4]/div/div[2]/div/div/div[1]/div[4]/div/div["+i+"]/img")).click();
			   	Thread.sleep(1000);
	 	    	String name1 = driver.findElement(By.xpath("html/body/div[4]/div[4]/div/div[2]/div/div/div[2]/h5")).getText();
	 			imagenames.add(name1);
	 			driver.findElement(By.className("stylePE")).click();	 
	 	 	    driver.findElement(By.partialLinkText("resolution")).click();
	 	 	    Thread.sleep(4000);
	 	 	    Robot rb =new Robot();
	 	 	    rb.keyPress(KeyEvent.VK_DOWN);
	 	 	    rb.keyRelease(KeyEvent.VK_DOWN);
	 	 	    rb.keyPress(KeyEvent.VK_ENTER);
	 	 	    rb.keyRelease(KeyEvent.VK_ENTER);
	 	    }
			}
    		}
		
        return totalimages;

}
}
