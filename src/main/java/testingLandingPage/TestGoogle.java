package testingLandingPage;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestGoogle {

	@Test
	public void Teste() {
		//System.setProperty("webdriver.gecko.driver", "D:/Projetos/Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:/Projetos/Drivers/chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
		
		driver.quit();
	}
}
