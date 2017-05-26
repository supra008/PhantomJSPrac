package phantomPckg;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenShot {
	public WebDriver screenshot(WebDriver pjd) throws IOException 
	{
		File srcfile = ((TakesScreenshot)pjd).getScreenshotAs(OutputType.FILE);
	
	
		FileUtils.copyFile(srcfile, new File("D:/Practice/ScreenShots/"+pjd.getTitle()+"_"+System.currentTimeMillis()+".jpg"),true);
		System.out.println("ScreenShot Taken");
		return pjd;
		
	}

}
