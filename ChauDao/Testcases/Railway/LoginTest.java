package Railway;

import Common.Utilities;
import Constant.Constant;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.*;

public class LoginTest {
		
	@BeforeMethod
	public void beforeMethod() {
		
		System.out.println("Pre-condition");
		System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();		
		}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}
	
	@Test
	//TC01-Verify user can login with valid username and pw
	public void TC01()
	{
		System.out.println("TC01 - Verify user can login with valid username and pw");
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
		
		String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
		String expectedMsg = "Welcome " + Constant.USERNAME;
		
		Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
	}
	
	@Test
	//TC02 - User can't login with blank "Username" textbox
	public void TC02()
	{
		System.out.println("TC01 - Verify user can login with valid username and pw");
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
		
		String actualMsg = loginPage.login(Constant.USERNAME, Constant.INVALID_PW).getLblErrorMessage();
		String expectedMsg = "Invalid username or password. Please try again.";
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
	}
}
