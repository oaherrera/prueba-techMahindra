package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// By Locators

	private By botonBuscarVuelos = By.xpath("(//button[@title='Buscar vuelos'])[4]");
	private By inputDestino = By.xpath("//input[contains(@name,'pbDestino_2')]");
	private By seleccionCiudad = By.xpath("(//div[@class='bs-list-countries']/ul/li)[1]");
	private By inputFecha = By.xpath("(//input[@name='pbFechaIda'])[2]");
	private By diasDelMes = By.xpath("(//div[@class='number-days'])[4]//tr//td");
	private By tipoViaje = By.xpath("//a[contains(text(),'Solo ida')]");

	public void seleccionarTipoViaje() {
		driver.findElement(tipoViaje).click();
	}

	public void ingresarDestino(String ciudad) {
		driver.findElement(inputDestino).click();
		driver.findElement(inputDestino).sendKeys(ciudad);
		driver.findElement(seleccionCiudad).click();

	}

	public void clicFechaViaje() {
		driver.findElement(inputFecha).click();
	}

	public void escogerFechaInicio(String dia) {

		List<WebElement> fecha = driver.findElements(diasDelMes);
		for (WebElement e : fecha) {
			if (e.getText().equals(dia)) {
				e.click();
				break;
			}

		}

	}

	public void clicEnBotonBuscarVuelos() {
		driver.findElement(botonBuscarVuelos).click();
	}

}
