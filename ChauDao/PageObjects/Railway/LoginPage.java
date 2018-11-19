package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class LoginPage extends GeneralPage  {
	//Locators
	private final By _txtUsername = By.id("username");
	private final By _txtPassword = By.id("password");
	private final By _btnLogin = By.xpath("//input[@type='submit']");
	private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
	
	//Elements
	public WebElement getTxtUsername()
	{
		return Constant.WEBDRIVER.findElement(_txtUsername);
	}
	
	public WebElement getTxtPassword()
	{
		return Constant.WEBDRIVER.findElement(_txtPassword);		
	}
	
	public WebElement getBtnLogin()
	{
		return Constant.WEBDRIVER.findElement(_btnLogin);		
	}
	
	public WebElement getLblLoginErrorMsg()
	{
		return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);		
	}
	
	//Methods
	public HomePage login(String username, String password)
	{
		this.getTxtUsername().sendKeys(username);
		this.getTxtPassword().sendKeys(password);
		this.getBtnLogin().click();
		
		return new HomePage();
	}
}
