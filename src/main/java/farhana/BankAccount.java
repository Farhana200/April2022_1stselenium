package farhana;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BankAccount {

	static WebDriver driver;

	@Before
	public void initAccount() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=dashboard/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test
	public void positiveTest() throws InterruptedException  {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();

//		Bank accout test.
		driver.findElement(By.linkText("Bank & Cash")).click();
		driver.findElement(By.linkText("New Account")).click();
		driver.findElement(By.id("account")).sendKeys("farhana");
		driver.findElement(By.id("description")).sendKeys("annual");
		driver.findElement(By.id("balance")).sendKeys("$ 100.00");
		driver.findElement(By.id("account_number")).sendKeys("GD!@#$%^&");
		driver.findElement(By.id("contact_person")).sendKeys("Me");
		driver.findElement(By.id("contact_phone")).sendKeys("32176543");
//		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/form/button"));
		Thread.sleep(2000);
//		driver.findElement(By.id("contact_phone")).submit();
		driver.findElement(By.cssSelector("#page-wrapper > div.wrapper.wrapper-content.animated.zoomIn > div.row > div > div > div.ibox-content > form > button"));

	}

	@Test
	public void negiTest() {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc12356");
		driver.findElement(By.name("login")).click();

	}

	@After
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
