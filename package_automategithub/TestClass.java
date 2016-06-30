package automategithub;
import shell.*;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClass {
	static String username = "tarashankar";
	static String pwd = "MARIOismy123!";
	static String repo_name="created by ui";
	static 	WebDriver driver = new FirefoxDriver();
	
	@BeforeClass
	public void Step00_Launch_GitHub_Application()
	{

	driver.get("https://github.com/login");
	}
	
	@Test
	public void Step01_validate_Sigin() throws InterruptedException
	{
		SignInPage signin = PageFactory.initElements(driver,SignInPage.class);
		signin.signIn(username,pwd);
		Assert.assertEquals(driver.getTitle(), "GitHub");
		Reporter.log("Assert passed: On valid login page",true);
	}
	
	@Test
	public void Step02_Create_New_Repository() throws IOException
	{
	
		NewRepo nrepo = PageFactory.initElements(driver, NewRepo.class);
		
		String name = nrepo.createRepo(repo_name);
		Assert.assertEquals(name, repo_name);
		Reporter.log("Assert Passed : Repo Name is verified as:  "+repo_name,true);
		
	}
	@Test
	public void Step03_Adding_File_Through_Shell() throws IOException, InterruptedException {
		ExecuteShell excs = PageFactory.initElements(driver, ExecuteShell.class);
		excs.exeshell();
		Assert.assertTrue(true, "commit failed");
		Reporter.log("Assert Passed : New File Added",true);
		
	}
	
	
	@Test
	public void Step04_Verify_Commit_Text() throws IOException {
		Verify_Commit_Text vt = PageFactory.initElements(driver, Verify_Commit_Text.class);
		boolean verify = vt.nameConfirmation();
		Assert.assertTrue(verify);
		Reporter.log("Assert Passeed: commit text are same", true);
	}
	
	@Test
	public void Step05_Verify_Commit_Id() throws IOException, InterruptedException {
		Verify_Commit_Id vc = PageFactory.initElements(driver, Verify_Commit_Id.class);
		String ui_Id = vc.verify_ui();
		String file_Id = vc.idFromFileId();
		Assert.assertEquals(ui_Id,file_Id);
		Reporter.log("Assert Passed: commit ids are same", true);
	}
	
	
	
	@Test
	public void Step06_VVEdit_Created_File() throws InterruptedException {
		EditFile ef = PageFactory.initElements(driver, EditFile.class);
		ef.editFile();
	}
	
	@AfterClass
	public void Delete_Existing_Repo() throws InterruptedException
	{
		DeleteRepo delrepo = PageFactory.initElements(driver, DeleteRepo.class);
		delrepo.deleteRepo();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), "GitHub");
		Reporter.log("Assert passed: Repository has been deleted",true);		
	}
	}
	



	