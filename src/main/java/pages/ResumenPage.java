package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResumenPage {

	WebDriver driver;
	
	public ResumenPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By tituloListaDePasajeros = By.xpath("//div[contains(text(),'Lista de pasajeros')]");
	private By tituloDatosDeContacto = By.xpath("//div[contains(text(),'Datos de contacto')]");
	
	
	public Boolean validoTituloDePasajeros() {
		return driver.findElement(tituloListaDePasajeros).isDisplayed();
	}
	
	public Boolean validoTituloDeDatosDeContacto() {
		return driver.findElement(tituloDatosDeContacto).isDisplayed();
	}
	
}
