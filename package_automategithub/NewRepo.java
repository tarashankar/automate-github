package automategithub;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewRepo extends TestClass{
	
	WebDriver driver;
	@FindBy(css = "a[data-ga-click*='header new repo button']")
	WebElement newrepobutton ;
	@FindBy(id = "repository_name")
	WebElement reponame;
	@FindBy(id = "repository_auto_init")
	WebElement addreadme;
	@FindBy(css = "button[data-disable-with*='Creating repository']")
	WebElement createrepo;

	
	public NewRepo(WebDriver driver) {
        this.driver = driver;
   }
	
	
	public String createRepo(String name_of_repo) throws IOException {
		newrepobutton.click();
		reponame.sendKeys(repo_name);
		addreadme.click();
		createrepo.click();
		String name_created = repo_name;
		return name_created;
		
		
	}

}
