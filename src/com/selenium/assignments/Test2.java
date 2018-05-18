package com.selenium.assignments;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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



public class Test2 {

  private WebDriver driver;
  private String driverpath;
  private String test1url = "http://opensource.demo.orangehrmlive.com/index.php/dashboard#";
  private String testcase2url = "http://demos.jquerymobile.com/1.4.5/popup/#&ui-state=dialog&ui-state=dialog";
  private String testcase3url="https://jqueryui.com/droppable/";
  private String testcase4url="https://www.xul.fr/javascript/alert.php";
  private String testcase5url="https://www.google.co.in/";
  
  
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
	  driver.quit();
  }
  
  @Test(enabled=false)
  public void testcase1() throws InterruptedException {
	  driver.get(test1url);  
	
	  
	  WebElement username = driver.findElement(By.id("txtUsername"));
	  username.sendKeys("Admin");
	  
	  WebElement pass = driver.findElement(By.id("txtPassword"));
	  pass.sendKeys("admin");
	  
	  WebElement login=driver.findElement(By.id("btnLogin"));
	  login.click();
	  Thread.sleep(5000);
	  WebElement welcome=driver.findElement(By.id("welcome"));
	  welcome.click();
	  WebElement abt=driver.findElement(By.id("aboutDisplayLink"));
	  abt.click();
	  WebElement cls=driver.findElement(By.className("close"));
	  cls.click();
	  WebElement logout=driver.findElement(By.linkText("Logout"));
	  logout.click();
	  WebElement link=driver.findElement(By.linkText("OrangeHRM, Inc"));
	  link.click();
	 String c=driver.getWindowHandle();
	  	
	   for (String handle : driver.getWindowHandles()) {
	   
	      driver.switchTo().window(handle);}
	   Thread.sleep(5000);
	   driver.switchTo().window(c);
	 
  }
  
  
  
  
  @Test(enabled=false)
  public void testcase2() throws InterruptedException {
	  driver.get(testcase2url);  
	
	  
	 WebElement username = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/p/a"));
	  username.click();
	  
	  
  }
  
  @Test(enabled=false)
  public void testcase3() throws InterruptedException {
	  driver.get(testcase3url);  
	
	  Actions builder=new Actions(driver);
	  
	 WebElement frame = driver.findElement(By.className("demo-frame"));
	  driver.switchTo().frame(frame);
	  WebElement drag = driver.findElement(By.id("draggable"));
	  
	  WebElement drop=driver.findElement(By.id("droppable"));
	  
	  builder.dragAndDrop(drag, drop).build().perform();
	  Thread.sleep(2000);
  }
  
  @Test(enabled=false)
  public void testcase4() throws InterruptedException {
	  driver.get(testcase4url);  
	 	  WebElement submit = driver.findElement(By.xpath("/html/body/div[5]/form[1]/input[2]"));
	  submit.click();
	
	  Alert alert= driver.switchTo().alert();
	  alert.accept();
	  
	  WebElement a2 = driver.findElement(By.xpath("/html/body/div[5]/form[2]/input[2]"));
	  a2.click();
	  Alert alert2= driver.switchTo().alert();
	  alert2.accept();
	  
	  WebElement a3 = driver.findElement(By.xpath("/html/body/div[5]/form[3]/input[2]"));
	  a2.sendKeys("1");
	  WebElement a4 = driver.findElement(By.xpath("/html/body/div[5]/form[3]/input[3]"));
	  a2.click();
	  Alert alert3= driver.switchTo().alert();
	  alert3.accept(); 
  }
  
  @Test(enabled=true)
  public void testcase5() throws InterruptedException {
	  driver.get(testcase5url);  
	 	  WebElement gmail = driver.findElement(By.linkText("Gmail"));
	  gmail.click(); 	 
  }

    
}
