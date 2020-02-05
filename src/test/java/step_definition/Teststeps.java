package step_definition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Teststeps {
	
	WebDriver driver;
	
@Given("User is on Home Page")
public void user_is_on_Home_Page() {
		System.setProperty("webdriver.chrome.driver","C:\\New Folder\\Selenium\\Driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8083/TestMeApp/");
		driver.manage().window().maximize();		
	}

@When("User navigates to login page")
public void user_navigates_to_login_page() {
	driver.findElement(By.linkText("SignIn")).click();	
}

@When("User enters {string} and {string} as valid admin Credentials")
public void user_enters_and_as_valid_admin_Credentials(String username, String password) {
	driver.findElement(By.id("userName")).sendKeys(username);;
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.name("Login")).click();
}

@Then("Message displayed login Successfully")
public void message_displayed_login_Successfully() {
	Assert.assertTrue(driver.findElement(By.linkText("SignOut")).isDisplayed());
	//driver.quit();
}





@Given("User selects Add Category")
public void user_selects_Add_Category() {
	//driver.findElement(By.xpath("//button//h4[text() ='Add Category']")).click();
	//System.setProperty("webdriver.chrome.driver", "C:\\New Folder\\Selenium\\Driver\\chromedriver_win32\\chromedriver.exe");
	//driver  = new ChromeDriver();
	//driver.get("https://localhost:8083/TestMeApp/");
	//driver.manage().window().maximize();
	
}

@When("User adds Sports {string} as Category")
public void user_adds_Sports_as_Category(String category ){
	
	//driver.findElement(By.linkText("SignIn")).click();
	//driver.findElement(By.id("userName")).sendKeys("admin");
	//driver.findElement(By.id("password")).sendKeys("password456");
	//driver.findElement(By.name("Login")).click();
	
	
	driver.findElement(By.xpath("//div//button//h4[text() = 'Add Category']")).click();
	driver.findElement(By.id("catgName")).sendKeys(category);
	driver.findElement(By.id("catgDesc")).sendKeys();
	driver.findElement(By.xpath("//input[@value = 'Add']")).click();
	driver.findElement(By.linkText(" Home")).click();
}

@When("User adds {string} and {string}")
public void user_adds_and(String subcategory1, String subcategory2) {
	
	driver.findElement(By.xpath("//div//button//h4[text() = 'Add Sub Category']")).click();
	Select category12 = new Select(driver.findElement(By.id("subCatgId")));
	category12.selectByVisibleText("Sports");				
	driver.findElement(By.id("subCatgName")).sendKeys(subcategory1);
	driver.findElement(By.id("subCatgDesc")).sendKeys(subcategory1);		
	driver.findElement(By.xpath("//input[@value = 'Add']")).click();	
	category12.selectByVisibleText("Sports");			
	driver.findElement(By.id("subCatgName")).sendKeys(subcategory2);
	driver.findElement(By.id("subCatgDesc")).sendKeys(subcategory2);
	driver.findElement(By.xpath("//input[@value = 'Add']")).click();
	driver.findElement(By.linkText(" Home")).click();
	
}

@Then ("Add Category successful")
public void add_Category_successful(){	
	driver.findElement(By.linkText(" SignOut")).click();
}


	
	
	
	
}
