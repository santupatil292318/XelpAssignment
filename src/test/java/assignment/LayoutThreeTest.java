package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LayoutThreeTest {

	@Test 
	public void layoutTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://trytestingthis.netlify.app/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//table
		String firstname="Monika";
		 List<WebElement> tabledata = driver.findElements(By.xpath("//table/tbody/tr[contains(.,'"+firstname+"')]/td"));
		 System.out.println("choosed employee details are : ");
		 for (WebElement data : tabledata) {
			String employdata = data.getText();
			System.out.print(employdata+" ");
		}
	}
}
