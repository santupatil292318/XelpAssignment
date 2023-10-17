package xelp.assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LayoutTwopage {

	
	//firstname
	@FindBy(id = "fname") private WebElement firstnametxt;
	//lastname
	@FindBy(id = "lname") private WebElement lastnametxt;
	
	//gender
	@FindBy(id = "male") private WebElement maleradio;
	
	//select one option
	@FindBy(id = "option") private WebElement singleoption;
	public LayoutTwopage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//firstname
	public WebElement getfirstName()
	{
		return firstnametxt;
	}
	
	//lastname
	public WebElement getlastname()
	{
		return lastnametxt;
	}
	
	//gender
	public WebElement getmaleradiobtn()
	{
		return maleradio;
	}
	
	//select one option
	public WebElement getselectoneOption()
	{
		return singleoption;
	}
}
