package ToolsQA;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class brandSiteV1 {
	
	static int individualdownload = 0;
	static int gettotalimages = 0;
	WebDriver driver = new FirefoxDriver();
	commonfunctions commonf = new commonfunctions();
	homepage  homep = new homepage();
	assetdownloadreport assetreportdownloadp = new assetdownloadreport();
	photographypage photographyp = new photographypage();
	String baseURL = "http://brand.english.com";
	
	@Test
	public void test() throws InterruptedException, BiffException, IOException, AWTException {
	commonf.navigateurl(driver,baseURL);
	
	//Check the total images before downloading
	homep.login(driver,"hitesh.dewangan@pearson.com","pearsonenglish");
	Thread.sleep(4000);
	homep.navigatetoassetreport(driver);
	int currrentimages = assetreportdownloadp.viewdownloadhistoryfor(driver, "ramkumarsam@gmail.com");
	int availableimages =  currrentimages;
	System.out.println("Images count before downloading :"+currrentimages);
	commonf.closewindow(driver, "vDownloadClose");
	homep.logout(driver);
		
	// download images from photography page
	Workbook wb = Workbook.getWorkbook(new File("d:\\seleniumdata\\Book1.xls"));
	Sheet sh = wb.getSheet(0);
	int totalNoOfRows = sh.getRows();
	String susername;
	String spassword;
	for (int c = 1; c < totalNoOfRows; c++) {
		susername =  sh.getCell(0,c).getContents();
		System.out.println("username "+susername);
		spassword =  sh.getCell(1,c).getContents();
		System.out.println("password "+spassword);
		Thread.sleep(4000);
		homep.login(driver, susername, spassword);
		Thread.sleep(9000);
		homep.navigatetophotography(driver);
		int totalimages = photographyp.gettotalpagesanddownloadimages(driver);
		System.out.println("Total Images downloaded by the user "+ susername +" is :"+totalimages);
		gettotalimages = totalimages;
		System.out.println("Total Downloaded Images :"+totalimages);
		individualdownload = (gettotalimages / (totalNoOfRows - 1));
		homep.logout(driver);
		}
	Thread.sleep(4000);
	//Check the total images after downloading
	homep.login(driver,"hitesh.dewangan@pearson.com","pearsonenglish");
	Thread.sleep(4000);
	homep.navigatetoassetreport(driver);
	currrentimages = assetreportdownloadp.viewdownloadhistoryfor(driver, "ramkumarsam@gmail.com");
	System.out.println("Images count after downloading :"+currrentimages);
	int calculatedimages = individualdownload + availableimages;
	System.out.println("Manual calculation :"+ calculatedimages);
	commonf.closewindow(driver, "vDownloadClose");
	try{
	Assert.assertEquals(calculatedimages, currrentimages);
	}catch(Throwable e){
		System.out.println("error");
	}
	homep.logout(driver);
	homep.close(driver);	
	}
}
