package automategithub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Verify_Commit_Id {
	

	@FindBy(css = "a[class='commit-tease-sha']")
	private static WebElement commit_id;
	
	@FindBy(css = "span[class='sha-block']:nth-child(2)")
	WebElement id;
	
	WebDriver driver;
	
	public Verify_Commit_Id(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public String verify_ui() throws InterruptedException
	{
		commit_id.click();
		Thread.sleep(4000);
		System.out.println(id.isDisplayed());
		String id_from_ui = id.getText().trim();
		id_from_ui = id_from_ui.substring(7);
		System.out.println(id_from_ui);
		return id_from_ui;
	}
	
	
	public String idFromFileId() throws IOException, InterruptedException {
		
		String sCurrentLine;
        String id="";
		try (BufferedReader br = new BufferedReader(new FileReader("/home/tarashankargupta/workspace/automategithub/created-by-ui/.git/logs/HEAD")))
        {
            while ((sCurrentLine = br.readLine()) != null) {
                id = sCurrentLine.substring(41, 81);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } 
		driver.get("https://github.com/tarashankar/created-by-ui/");
		Thread.sleep(3000);
		return id;
	}
	
	
	
	
}