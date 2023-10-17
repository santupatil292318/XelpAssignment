package xelp.assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LayoutOnePage {
	//sample alert
	@FindBy(xpath = "//button[@onclick='alertfunction()']") private WebElement samplealertbtn;
	@FindBy(xpath = "//div[@class='pop-up-alert']//descendant::p[@id='demo']") private WebElement samplealertxt;
	
	//ToolTip
	@FindBy(xpath = "//div[@class='tooltip']") private WebElement toolTip;
	@FindBy(xpath = "//div[@class='tooltip']") private WebElement toolTiptxt;
	
	//sample image
	@FindBy(xpath = "//div[@class='fakeimg']") private WebElement image;
	
	//sample doubleclick
	@FindBy(xpath = "//button[@ondblclick='myFunction()']") private WebElement doubleclick;
	
	//drag and drop
	@FindBy(xpath = "//img[@id='drag1']") private WebElement dragimage;
	@FindBy(xpath = "//div[@id='div1']") private WebElement dropimage;
	
	//sample login
	@FindBy(id = "uname") private WebElement usernametxt;
	@FindBy(id = "pwd") private WebElement passwordtxt;
	@FindBy(xpath = "//input[@type='submit']") private WebElement loginbtn;
	
	public LayoutOnePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//sample alert
	public WebElement getsamplealertbtn()
	{
		return samplealertbtn;
	}
	public WebElement getsamplealerttxt()
	{
		return samplealertxt;
	}
	
	//ToolTip
	public WebElement getTooltip()
	{
		return toolTip;
	}
	public WebElement getTooltiptxt()
	{
		return toolTiptxt;
	}
	
	//sample image
	public WebElement getimage()
	{
		return image;
	}
	
	//sample doubleclick
	public WebElement getdoubleclick()
	{
		return doubleclick;
	}
	
	//drag and drop
	public WebElement getdragimage()
	{
		return dragimage;
	}
	public WebElement getdropimage()
	{
		return dropimage;
	}
	
	//sample login
	public WebElement getusername()
	{
		return usernametxt;
	}
	public WebElement getpassword()
	{
		return passwordtxt;
	}
	public WebElement getloginbtn()
	{
		return loginbtn;
	}
	
}
