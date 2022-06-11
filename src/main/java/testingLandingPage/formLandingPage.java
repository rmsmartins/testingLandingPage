package testingLandingPage;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
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
	
	
	@Test
	public void testVerifySelectValues() {
		//System.setProperty("webdriver.gecko.driver", "D:/Projetos/Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:/Projetos/Drivers/chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/rmsma/eclipse-workspace/Landing-Page/index.html");

		WebElement element =  driver.findElement(By.id("formElements:escolaridade"));
		Select combo = new Select(element);
		
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		for(WebElement option: options){
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);
		driver.quit();
	}
	
	
	@Test
	public void testVerifySelectMultiple() {
		//System.setProperty("webdriver.gecko.driver", "D:/Projetos/Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:/Projetos/Drivers/chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/rmsma/eclipse-workspace/Landing-Page/index.html");

		WebElement element =  driver.findElement(By.id("formElements:desportos"));
		Select combo = new Select(element);
		
		combo.selectByVisibleText("Futebol");
		combo.selectByVisibleText("Atletismo");
		combo.selectByVisibleText("Ginástica");
		
		List<WebElement> allSelectedOption = combo.getAllSelectedOptions();
		
		Assert.assertEquals(3, allSelectedOption.size());
		
		driver.quit();
	}
	
	
	@Test
	public void testButton() {
		//System.setProperty("webdriver.gecko.driver", "D:/Projetos/Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:/Projetos/Drivers/chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/rmsma/eclipse-workspace/Landing-Page/index.html");

		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		
		Assert.assertEquals("Clicado", botao.getAttribute("value"));
		
		driver.quit();
	}
	
	
	@Test 
	public void testLink() {
		//System.setProperty("webdriver.gecko.driver", "D:/Projetos/Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:/Projetos/Drivers/chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/rmsma/eclipse-workspace/Landing-Page/index.html");

		driver.findElement(By.linkText("Voltar")).click();
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
		
		driver.quit();
	}
	
	
	@Test
	public void testSearchTextInPage() {
		//System.setProperty("webdriver.gecko.driver", "D:/Projetos/Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:/Projetos/Drivers/chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/rmsma/eclipse-workspace/Landing-Page/index.html");

		//System.out.println(driver.findElement(By.tagName("body")).getText());
		//Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Comunidade Rmsmartins"));
		
		Assert.assertEquals("Rmsmartins Bot", driver.findElement(By.tagName("h1")).getText());
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
		
		driver.quit();
	}
	
	
}
