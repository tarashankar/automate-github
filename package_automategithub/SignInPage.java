package automategithub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends TestClass{
	
	WebDriver driver;
	
	@FindBy(id = "login_field")
	public WebElement loginput;
	@FindBy(id = "password")
	public WebElement pass;
	@FindBy(className = "btn")
	public WebElement submit;
	
	public SignInPage(WebDriver driver) {
         this.driver = driver;
         
    }
	
	public void signIn(String username ,String password) throws InterruptedException {
		Thread.sleep(5000);
		loginput.sendKeys(username);
		pass.sendKeys(password);
		submit.click();
	}
	
	
}