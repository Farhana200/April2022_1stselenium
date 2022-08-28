package farhana;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase {
	
	static WebDriver driver ;
      
	public static void main(String[] args) {
//		lunch brower.
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\frash\\selenium22\\1stselenium\\driver\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		
		init();
		logintest();
		teardown();
		
		init();
		neglogintest();
		teardown();
		
	}
	    public static void init() {
	    	System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		    driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
		    driver.get("https://techfios.com/billing/?ng=dashboard/");
			driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
		public static void logintest() {
			driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
	        driver.findElement(By.id("password")).sendKeys("abc123");
			driver.findElement(By.name("login")).click();
    }
		
		public static void teardown() {
			driver.close();
			driver.quit();
	}
		
		public static void neglogintest() {
            driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
	        driver.findElement(By.id("password")).sendKeys("abc123444");
			driver.findElement(By.name("login")).click();
    }
	
	
	
    }
