package farhana;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class logintestj {

	WebDriver driver;
	
	@BeforeClass
	public  static void beforeClass () {
		System.out.println("before class");
	}
	@AfterClass
	public  static  void afterClass () {
		System.out.println("after class");
	}
	

	@Before
	public void init() {
		System.out.println("Init method");
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=dashboard/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void logintest() {
		System.out.println("Login test");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
	}

	@Test
	public void neglogintest() {
		System.out.println("Neg test");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123444");
		driver.findElement(By.name("login")).click();
	}

	@After
	public void teardown() {
		System.out.println("tear down method");
		driver.close();
		driver.quit();
	}

}
