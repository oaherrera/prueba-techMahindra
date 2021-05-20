package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleccionVuelosPage {
	
	private WebDriver driver;
	
	public SeleccionVuelosPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By seleccionarVuelo = By.xpath("((//div[@class='display-container'])[3]//button)[3]");
	private By tarifaEjecutivaPreferencial = By.xpath("(//button[@class='ff-price-container'])[1]");
	private By botonContinuar = By.xpath("//button[@id='continue-btn-footer']");
	
	
	public void clicSeleccionarVuelo() {
		driver.findElement(seleccionarVuelo).click();
	}
	
	public void clicTarifaPreferencial() {
		
		WebElement element = driver.findElement(tarifaEjecutivaPreferencial);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		//driver.findElement(tarifaEjecutivaPreferencial);
	}
	
	public void clicBotonContinuar() {
		driver.findElement(botonContinuar).click();
	}

}
