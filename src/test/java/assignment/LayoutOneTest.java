package assignment;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import xelp.assignment.LayoutOnePage;

public class LayoutOneTest {
	@Test
	
	public void layoutoneScript()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://trytestingthis.netlify.app/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LayoutOnePage onelayout = new LayoutOnePage(driver);
		
		//samplealert
		onelayout.getsamplealertbtn().click();	
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("alert Text="+alertText);
		alert.accept();
		String validationText = onelayout.getsamplealerttxt().getText();
		System.out.println("validationText= "+validationText);
		
		
		//ToolTip
		WebElement tooltip = onelayout.getTooltip();
		Actions action = new Actions(driver);
		action.moveToElement(tooltip).perform();
		System.out.println(onelayout.getTooltiptxt().getText());
		
		//sample image
		 WebElement image = onelayout.getimage();
		if (image.isDisplayed()) {
			System.out.println("image text ="+image.getText());
		}
		
		
		//sample doubleclick
		WebElement doubleclick = onelayout.getdoubleclick();
		action.doubleClick(doubleclick);
		
		//drag and drop
		
		WebElement dragimage = onelayout.getdragimage();
		WebElement dropimage = onelayout.getdropimage();
		action.dragAndDrop(dragimage, dropimage);
		
		//sample login
		 onelayout.getusername().sendKeys("test");
		 onelayout.getpassword().sendKeys("test");
		 onelayout.getloginbtn().click();
		 
		 Set<String> windowids = driver.getWindowHandles();
		 Iterator<String> windows = windowids.iterator();
		 while (windows.hasNext()) {
			String id = windows.next();
			driver.switchTo().window(id);
			String expectedTitle="Login Success";
			String title = driver.getTitle();
			System.out.println("login Title ="+title);
			if (title.equals(expectedTitle)) {
				System.out.println("login succesfull");
			}else {
				System.out.println("login unsuccesfull");
				
			}
			
		}
	}

}
