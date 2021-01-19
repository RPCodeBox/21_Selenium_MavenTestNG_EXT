package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PracticeLoginPage {
	// Define Sign-in Button
	@FindBy(how = How.LINK_TEXT, using = "Sign in")
	public WebElement SignIn;

	// Define User name Field
	@FindBy(how = How.NAME, using = "email") 
	public WebElement email;

	// Define Password Field
	@FindBy(how = How.NAME, using = "passwd") 
	public WebElement passwd;

	// Define Login Button
	@FindBy(how = How.NAME, using = "SubmitLogin") 
	public WebElement SubmitLogin;
	
	// Define Sign-off Button
	@FindBy(how = How.LINK_TEXT, using = "Sign out") 
	public WebElement SignOut;

	// Define User name Enter Method
	public void EnterUserName(String usernametext) {
		email.sendKeys(usernametext);
	}
	// Define Password Enter Method
	public void EnterPassword(String passwordtext) {
		passwd.sendKeys(passwordtext);
	}
	// Define Login Button Click Method
	public void ClickLoginButton() {
		SubmitLogin.click();
	}
}
