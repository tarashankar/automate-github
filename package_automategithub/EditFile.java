package automategithub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditFile {
	
	WebDriver driver;
	
	@FindBy(css = "a[href*='readme2.txt']")
	WebElement clickname;
	
	@FindBy(css = "button[data-hotkey='e']")
	WebElement editbtn;
	
	@FindBy(css = "textarea[class='ace_text-input']")
	WebElement text;
	
	@FindBy(css = "#submit-file")
	WebElement submit;

	public EditFile(WebDriver driver) {
		this.driver=driver;
	}
	
	public void editFile() throws InterruptedException {
		Thread.sleep(3000);
		clickname.click();
		Thread.sleep(3000);
		editbtn.click();
		Thread.sleep(3000);
		text.sendKeys("This is edited from ui automation");
		submit.click();
		Thread.sleep(4000);
		
		
	}

}
