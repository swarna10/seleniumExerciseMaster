package com.selenium.assignments;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Test1 {

  private WebDriver driver;
  private String driverpath;
  private String test1url = "https://www.freecrm.com/register/";
  private String testcase2url = "";
  
  @BeforeMethod
  public void browserlaunch() {
	  driverpath = System.getProperty("user.dir")+"/lib/geckodriver";
	  System.setProperty("webdriver.gecko.driver", driverpath);
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
  }

  @AfterMethod
  public void browserclose() { 
	 driver.close();
  }
  
  @Test(enabled=false)
  public void testcase1() throws InterruptedException {
	  driver.get(test1url);  
	  
	  Select s=new Select(driver.findElement(By.id("payment_plan_id")));
	  s.selectByValue("1");
	  WebElement first_name = driver.findElement(By.name("first_name"));
	  first_name.sendKeys("Monika");
	 WebElement surname = driver.findElement(By.name("surname"));
	 surname.sendKeys("Dotasara");
	 WebElement email = driver.findElement(By.name("email"));
	 email.sendKeys("monadotasara@gmail.com");
	 WebElement email_confirm = driver.findElement(By.name("email_confirm"));
	 email_confirm.sendKeys("monadotasara@gmail.com");
	 WebElement username = driver.findElement(By.name("username"));
	 username.sendKeys("Monadotasara"); 
	 WebElement password = driver.findElement(By.name("password"));
	 password.sendKeys("password"); 
	 WebElement passwordconfirm = driver.findElement(By.name("passwordconfirm"));
	 passwordconfirm.sendKeys("password"); 
	 WebElement input = driver.findElement(By.xpath("//*[@type='checkbox']"));
	 input.click();
	 WebElement submit = driver.findElement(By.id("submitButton"));
	 submit.click();
	 Thread.sleep(10000);
	 WebElement company_name = driver.findElement(By.name("company_name"));
	 company_name.sendKeys("NA");
	 WebElement phone = driver.findElement(By.name("phone"));
	 phone.sendKeys("9999999999");
	 WebElement fax = driver.findElement(By.name("fax"));
	 fax.sendKeys("9999999999");
	 WebElement website = driver.findElement(By.name("website"));
	 website.sendKeys("www.google.com");
	 WebElement company_email = driver.findElement(By.name("company_email"));
	 company_email.sendKeys("monadotasara@wipro.com");
	 WebElement service = driver.findElement(By.name("service"));
	 service.sendKeys("NA");
	 WebElement address = driver.findElement(By.name("address"));
	 address.sendKeys("NA");
	 WebElement city = driver.findElement(By.name("city"));
	 city.sendKeys("NA");
	 WebElement state = driver.findElement(By.name("state"));
	 state.sendKeys("NA");
	 WebElement postcode = driver.findElement(By.name("postcode"));
	 postcode.sendKeys("NA");
	 
	 Select s2=new Select(driver.findElement(By.name("country")));
	  s2.selectByValue("India");
	 
	  WebElement input2 = driver.findElement(By.xpath("//*[@type='checkbox']"));
		 input2.click();
		 
		
		 WebElement submit2 = driver.findElement(By.name("btnSubmit"));
		 submit2.click();
	 
		 Thread.sleep(10000);
		 WebElement  finish= driver.findElement(By.name("finish"));
		 finish.click();
		 
		 Thread.sleep(10000);	  
	  
  }
  
  @Test(enabled=true)
  public void testcase2() throws InterruptedException{
	  
	  driver.navigate().to("https://www.freecrm.com/index.html");
	  
	  WebElement username = driver.findElement(By.name("username"));
	  username.sendKeys("Monadotasara");
	  
	  WebElement password = driver.findElement(By.name("password"));
	  password.sendKeys("password");
	  
	  WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
	  submit.click();
	  
	  driver.switchTo().frame("mainpanel");
	  WebElement calender_s = driver.findElement(By.linkText("Calendar"));
	  calender_s.click();
	
	  Thread.sleep(3000);
	  WebElement calender_c = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[5]"));
	  calender_c.click();
	  Thread.sleep(3000);
	  WebElement home = driver.findElement(By.linkText("Home"));
	  home.click();
	  WebElement cts = driver.findElement(By.linkText("Contacts"));
	  
	  Actions action = new Actions(driver);
	  
      action.moveToElement(cts).build().perform();
      
	  WebElement contact = driver.findElement(By.linkText("New Contact"));
	  contact.click();
	Thread.sleep(3000);
	WebElement name = driver.findElement(By.id("first_name"));
	  name.sendKeys("SSSSSSS");
	  
	  WebElement sur = driver.findElement(By.id("surname"));
	  sur.sendKeys("HYD");
	  WebElement submit2 = driver.findElement(By.xpath("//*[@type='submit']"));
	  submit2.click();
	  
	  WebElement logout = driver.findElement(By.linkText("Logout"));
	  logout.click();	  
  
  }
  
  @Test(enabled=false)
  public void synctest() throws InterruptedException{
	  
	  driver.findElement(By.id("txtUsername")).sendKeys("admin");
	  driver.findElement(By.id("txtPassword")).sendKeys("admin");
	  driver.findElement(By.id("btnLogin")).click();

	  WebDriverWait waitwelcome = new WebDriverWait(driver, 10);
	  waitwelcome.until(ExpectedConditions.presenceOfElementLocated(By.id("welcome")));
	  driver.findElement(By.id("welcome")).click();

	  WebDriverWait waitlogout = new WebDriverWait(driver, 10);
	  waitlogout.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Log")));
	  driver.findElement(By.partialLinkText("Log")).click();
	  
  }
  
}
