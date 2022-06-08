package testingLandingPage;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class formLandingPage {
	
	@Test
	public void testTextField() {
		//System.setProperty("webdriver.gecko.driver", "D:/Projetos/Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:/Projetos/Drivers/chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/rmsma/eclipse-workspace/Landing-Page/index.html");
		
		driver.findElement(By.id("formElements:nome")).sendKeys("Rui");
		Assert.assertEquals("Rui", driver.findElement(By.id("formElements:nome")).getAttribute("value"));
		
		driver.quit();
	}

	@Test
	public void testTextArea() {
		//System.setProperty("webdriver.gecko.driver", "D:/Projetos/Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:/Projetos/Drivers/chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/rmsma/eclipse-workspace/Landing-Page/index.html");

		driver.findElement(By.id("formElements:sugestoes")).sendKeys("teste\n\ne isto é outra linha\n última linha");
		Assert.assertEquals("teste\n\ne isto é outra linha\n última linha",driver.findElement(By.id("formElements:sugestoes")).getAttribute("value"));
		
		driver.quit();
	}
	
	
	@Test
	public void testRadioButton() {
		//System.setProperty("webdriver.gecko.driver", "D:/Projetos/Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:/Projetos/Drivers/chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/rmsma/eclipse-workspace/Landing-Page/index.html");
		
		driver.findElement(By.id("formElements:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("formElements:sexo:0")).isSelected());
		
		driver.quit();
	}
	
	
	@Test
	public void testCheckBox() {
		//System.setProperty("webdriver.gecko.driver", "D:/Projetos/Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:/Projetos/Drivers/chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/rmsma/eclipse-workspace/Landing-Page/index.html");

		driver.findElement(By.id("formElements:linguagemPreferida:0")).click();
		Assert.assertTrue(driver.findElement(By.id("formElements:linguagemPreferida:0")).isSelected());
		
		driver.quit();
	}
	
	
	@Test
	public void testSelect() {
		//System.setProperty("webdriver.gecko.driver", "D:/Projetos/Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:/Projetos/Drivers/chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/rmsma/eclipse-workspace/Landing-Page/index.html");

		WebElement element =  driver.findElement(By.id("formElements:escolaridade"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Superior");
		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
		
		driver.quit();
	}
}
