package assignment;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;
import io.github.bonigarcia.wdm.WebDriverManager;
import xelp.assignment.LayoutOnePage;
import xelp.assignment.LayoutTwopage;

public class LayoutTwoTest {

	@Test
	
	public void layouttwoScript() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://trytestingthis.netlify.app/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LayoutTwopage layout = new LayoutTwopage(driver);
		
		//sample form
		//firstname
		WebElement firstname = layout.getfirstName();
		if (firstname.isEnabled()) {
			firstname.sendKeys("santosh");
		}
		
		//lastname
		WebElement lastname = layout.getlastname();
		if (lastname.isEnabled()) {
			lastname.sendKeys("patil");
		}
		
		//gender
		WebElement maleradio = layout.getmaleradiobtn();
		maleradio.click();
		if (maleradio.isSelected()) {
			System.out.println("male radio button selected");
		}
		
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,350)", "");
//		jse.executeScript(null, null)
		
		//select one option
		WebElement element = layout.getselectoneOption();
		Select select = new Select(element);
		select.selectByValue("option 1");
		
		//appliacable options
		int i;
		List<WebElement> multiselect = driver.findElements(By.xpath("//label[text()='Choose applicable options:']/following-sibling::input[@type='checkbox']"));
		for ( i = 0; i < multiselect.size(); i++) {
			multiselect.get(i).click();
			if (multiselect.get(i).isSelected()) {
				if (i>=1) {
					i++;
				}
			}
		}
		if (i>=1) {
			System.out.println("Applicable Options are MultiSelect");
		}
		
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)", "");
		
		//Start typing and it till automatically guess answer:
		driver.findElement(By.xpath("//input[@list='datalists']")).sendKeys("a");
		List<WebElement> autosuggest = driver.findElements(By.xpath("//datalist/option"));
		for (WebElement ele : autosuggest) {
			System.out.println(ele.getAttribute("value"));
		}
		
	
		//Scroll to see a range value:
		WebElement slider =	driver.findElement(By.xpath("//input[@id='a']"));
		Actions action = new Actions(driver);
		//Thread.sleep(3000);
		action.dragAndDropBy(slider, 50, 90).perform();
		
		//file
		driver.findElement(By.id("myfile")).sendKeys("C:\\Users\\Lenovo\\OneDrive\\Desktop\\abc.txt");
		
		//Select a quantity from a range
		driver.findElement(By.id("quantity")).sendKeys("2");
		//Thread.sleep(5000);
		
		//Long Message:
		WebElement textarea = driver.findElement(By.xpath("//textarea[@name='message']"));
		if (textarea.isEnabled()) {
			for (int j = 0; j <10; j++) {
				
				textarea.sendKeys("hi good morning");
			}
		}
		
		//Clicking the submit button will take you to a new tab
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Set<String> wids = driver.getWindowHandles();
		Iterator<String> window = wids.iterator();
		while (window.hasNext()) {
			String windoid = window.next();
			driver.switchTo().window(windoid);
			String title = driver.getTitle();
			if (title.equalsIgnoreCase("Google")) {
				System.out.println("user has been navigated to new tab");
			}
			
		}
		
		
		
	}
}
