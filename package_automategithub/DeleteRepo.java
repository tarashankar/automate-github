package automategithub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteRepo extends TestClass {
	WebDriver driver;
	@FindBy(css = "a[data-selected-links*='repo_branch_settings hooks']")
	WebElement setting_button;
	@FindBy(css = "button[data-facebox*='delete_repo_confirm']")
	WebElement delete_button;
	@FindBy(xpath = "(//input[@name='verify'])[3]")
	WebElement confirm_name;
	@FindBy(xpath = "(//button[@data-disable-invalid=\"\"])[4]")
	WebElement click_to_confirm;

	
	public DeleteRepo(WebDriver driver) {
        this.driver = driver;
        
   }
	public void deleteRepo() throws InterruptedException {
		Thread.sleep(2000);
		setting_button.click();
		Thread.sleep(2000);
		delete_button.click();
		Thread.sleep(4000);
		String todel = repo_name.replaceAll(" ", "-");
		System.out.println(todel);
		confirm_name.sendKeys(todel);
		Thread.sleep(4000);
		click_to_confirm.click();
		driver.navigate().refresh();
	}

}
