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



public class Test3 {

  private WebDriver driver;
  private String driverpath;
  private String test1url = "https://paytm.com";
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
	 driver.quit();
  }
  
  @Test(enabled=true)
  public void testcase1() throws InterruptedException {
	  driver.get(test1url);  
	  
	  WebElement username = driver.findElement(By.className("_3ac-"));
	  username.click();
	  driver.switchTo().frame(0);
	  WebElement sign = driver.findElement(By.className("selected ng-binding"));
	  sign.click();
	  driver.switchTo().defaultContent();
	  WebElement abt=driver.findElement(By.linkText("About Us"));
	  abt.click();
	  Thread.sleep(5000);
  }
    
}
