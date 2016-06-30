package shell;
import java.io.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExecuteShell {
	@FindBy(linkText = "readme2.txt added by script")
	WebElement commit_name;
	WebDriver driver;
	public ExecuteShell(WebDriver driver) {
        this.driver = driver;
        
   }
	 
	public void exeshell() throws IOException, InterruptedException{
	       File file=new File("/home/tarashankargupta/workspace/automategithub");
	       ProcessBuilder processBuilder = new ProcessBuilder("./shfile.sh");
	       processBuilder.directory(file);

	        Process process=processBuilder.start();    
	        
	       InputStream is = process.getInputStream();
	       InputStreamReader isr = new InputStreamReader(is);
	       BufferedReader br = new BufferedReader(isr);

	       String line;

	      // System.out.printf("Output of running %s is:", Arrays.toString(args));

	       while ((line = br.readLine()) != null) {
	         System.out.println(line);
	       }
	       Thread.sleep(2000);
	       driver.navigate().refresh();
	       

	}
}


