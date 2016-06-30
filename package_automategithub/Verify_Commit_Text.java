package automategithub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Verify_Commit_Text {

	WebDriver driver;

	
	@FindBy(css = ".message .message")
	List<WebElement> list_commit;

	public Verify_Commit_Text(WebDriver driver) {
		this.driver = driver;
	}

	public boolean nameConfirmation() throws IOException {
		String fromfile = textFromFileCommit();
		boolean flag = false;
		System.out.println(fromfile);
		for (WebElement element : list_commit ) {
			System.out.println("list value  "+element.getText());
			if (element.getText().trim().equals(fromfile.trim()))
			{	flag = true;
				break;
			}
		}
		return flag;
	}

	public static String textFromFileCommit() throws IOException {

		String sCurrentLine;
		String commit_from_file = "";
		try (BufferedReader br = new BufferedReader(
				new FileReader("/home/tarashankargupta/workspace/automategithub/created-by-ui/.git/logs/HEAD"))) {
			while ((sCurrentLine = br.readLine()) != null) {
				String[] info2 = sCurrentLine.split(":");
				commit_from_file = info2[1];
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println("commit from file="+commit_from_file);
		return commit_from_file;
	}

}
