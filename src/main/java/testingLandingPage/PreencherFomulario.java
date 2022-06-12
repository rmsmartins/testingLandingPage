package testingLandingPage;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class PreencherFomulario {

	
	@Test
	public void preencherFormulario() {
		//System.setProperty("webdriver.gecko.driver", "D:/Projetos/Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:/Projetos/Drivers/chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/rmsma/eclipse-workspace/Landing-Page/index.html");
		
		driver.findElement(By.id("formElements:nome")).sendKeys("Rui");
		driver.findElement(By.id("formElements:sobrenome")).sendKeys("Martins");
		driver.findElement(By.id("formElements:sexo:0")).click();
		driver.findElement(By.id("formElements:linguagemPreferida:0")).click();
		//driver.findElement(By.id("formElements:linguagemPreferida:1")).click();
		/*
		WebElement element = driver.findElement(By.id("formElements:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		boolean encontrou = false;
		for(WebElement option : options) {
			if(option.getText().equals("Especializacao")) {
				encontrou = true;
				combo.selectByVisibleText("Especializacao");
			}
		}
		*/
		new Select(driver.findElement(By.id("formElements:escolaridade"))).selectByVisibleText("Especializacao");
		/*
		element = driver.findElement(By.id("formElements:desportos"));
		combo = new Select(element);
		combo.selectByVisibleText("Futebol");
		*/
		new Select(driver.findElement(By.id("formElements:desportos"))).selectByVisibleText("Futebol");
		
		driver.findElement(By.id("formElemts:adicionar")).click();
		
		//Assert.assertEquals("Cadastrado!", driver.findElement(By.id("resultado")).getText());
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith(("Rui")));
		Assert.assertTrue(driver.findElement(By.id("descSobrenome")).getText().endsWith(("Martins")));
		Assert.assertTrue(driver.findElement(By.id("descSexo")).getText().endsWith(("Masculino")));
		Assert.assertTrue(driver.findElement(By.id("descLinguagem")).getText().endsWith(("Java")));
		Assert.assertTrue(driver.findElement(By.id("descEscolaridade")).getText().endsWith(("especializacao")));
		Assert.assertTrue(driver.findElement(By.id("descdesportos")).getText().endsWith(("Futebol")));
		
		
	}
}
