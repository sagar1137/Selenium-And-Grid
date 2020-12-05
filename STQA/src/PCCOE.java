
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PCCOE {
	
	static WebDriver driver;
	String user="Test123";
	String pass="Pass123";
	
	String TODOTile="Selenium Project";
	String TODODesp="Todo Application for selenium";
	
	// Initializing the required Variables
	PCCOE(){
		// Driver File for chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sagar Patil\\Desktop\\stqa\\chromedriver.exe");

		driver=new ChromeDriver();
		
		// Maximizing the windows
		driver.manage().window().maximize();
		
	}
	
	void getWebsite()
	{
		
		// Navigating to Required Website
		driver.get("http://localhost:8080/todo-application-jsp-servlet-jdbc-mysql-master/");
		
		
	}
	
	 void verifyTitle()
	{
		// Verifying Title of webpage
		String Title="TODO APP";
		
		String ActualTitle=driver.getTitle();
		
		// Please Check Output on Console For this.
		if(Title.equals(ActualTitle))
		{
			System.out.print("Title Verified");
		}
		else
		{
			System.out.print("Title Verification Failed");

		}
		
		driver.findElement(By.linkText("Signup")).click();
	}
	
	 void Login() throws Exception
	{
		// Elements which we want to locate
		WebElement UserBox;
		WebElement PassBox;
				
		// Acutal location of elements
		UserBox=driver.findElement(By.name("username"));
		PassBox=driver.findElement(By.name("password"));
				
		UserBox.sendKeys(user);
		PassBox.sendKeys(pass);
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
		
	}
	 
	 void signUp() throws InterruptedException
	 {
		 String First="Abc";
		 String last="xyz";
		 
		 
		
		 WebElement FirstName,LastName,UserName,Pass;
		 WebElement Button;
		 FirstName=driver.findElement(By.name("firstName"));;
		 LastName=driver.findElement(By.name("lastName"));
		 UserName=driver.findElement(By.name("username"));
		 Pass=driver.findElement(By.name("password"));
		 
		 FirstName.sendKeys(First);
		 LastName.sendKeys(last);
		 UserName.sendKeys(user);
		 Pass.sendKeys(pass);
		 
		 Button=driver.findElement(By.tagName("button"));
		 
		 Button.click();
		 
		 driver.findElement(By.linkText("Login")).click();
		 Thread.sleep(1000);
	 }
	
	 void AddTodo() throws InterruptedException  
	{
		
		driver.findElement(By.linkText("Add Todo")).click();
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/form[1]/fieldset[1]/input[1]")).sendKeys(TODOTile);
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/form[1]/fieldset[2]/input[1]")).sendKeys(TODODesp);
		
		Select select=new Select(driver.findElement(By.name("isDone")));
		select.selectByVisibleText("Complete");
		
		WebElement date=driver.findElement(By.name("targetDate"));
		date.sendKeys("09122020");
		
		driver.findElement(By.tagName("button")).click();
		
		// This gives page enough time to load and then closes the windows
		Thread.sleep(1000);
	}
	
	 void edit() throws InterruptedException
	 {
		 driver.findElement(By.linkText("Edit")).click();
		 Select select=new Select(driver.findElement(By.name("isDone")));
		select.selectByVisibleText("In Progress");
			
		WebElement date=driver.findElement(By.name("targetDate"));
		date.sendKeys("301220");
			
		driver.findElement(By.tagName("button")).click();
		 
		Thread.sleep(1000); 
	 }
	 
	 void delete() throws InterruptedException
	 {
		 driver.findElement(By.linkText("Delete")).click();
		 driver.navigate().refresh();
		 Thread.sleep(1000);
	 }
	 
	void logout() throws Exception
	{	
		
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(1000);
	}
	
	  
	protected void finalize() throws Throwable
	{
		// Close the Browser
		driver.close();
		super.finalize();
	}
	
	
	public static void main(String [] args)  throws Throwable
	{
		
		PCCOE p=new PCCOE();
		
		p.getWebsite();
		p.verifyTitle();
		p.signUp();
		p.Login();
		p.AddTodo();
		p.edit();
		p.delete();
		p.logout();
		p.finalize();		
		
		
		
	}

}
