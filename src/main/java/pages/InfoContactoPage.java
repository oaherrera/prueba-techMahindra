package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InfoContactoPage {
	
	private WebDriver driver;

	public InfoContactoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By nombre = By.xpath("(//div[@class='mat-form-field-wrapper']//following::input)[1]");
	private By apellido = By.xpath("(//div[@class='mat-form-field-wrapper']//following::input)[2]");
	private By botonInfoContacto = By.xpath("//button[contains(text(),'Información de Contacto')]");
	private By correo = By.xpath("(//div[@class='mat-form-field-infix']//input[contains(@placeholder,'Correo')])[1]");
	private By numeroTelefono = By.xpath("(//div[@class='mat-form-field-infix']//input[contains(@placeholder,'Número de teléfono')])[1]");
	private By aceptoTerminos = By.xpath("(//div[@class='mat-form-field-infix']//input[contains(@placeholder,'Número de teléfono')])[1]");
	private By botonGuardarYContinuar = By.xpath("(//button[contains(text(),'Guardar y continuar')])[1]");
	private By botonResumenViaje = By.xpath("//button[contains(@class,'trip-summary-button ng-star-inserted')]");
	
	
	
	public void escribirNombre(String nom) {
		driver.findElement(nombre).sendKeys(nom);
	}
	
	public void escribirApellido(String ape) {
		driver.findElement(apellido).sendKeys(ape);
	}
	
	public void clicEnBotonInfoContacto() {
		WebElement element = driver.findElement(botonInfoContacto);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		//driver.findElement(botonInfoContacto).click();
	}
	
	public void ingresoCorreo(String email) {
		driver.findElement(correo).sendKeys(email);
	}
	
	public void ingresoTelefono(String tel) {
		driver.findElement(numeroTelefono).sendKeys(tel);
		
	}
	
	public void aceptarTerminos() {
		driver.findElement(aceptoTerminos).click();
	}
	
	public void clicEnGuardarYContinuar() {
		WebElement element = driver.findElement(botonGuardarYContinuar);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		//driver.findElement(botonGuardarYContinuar).click();
	}
	
	public void clicParaVerResumenDelViaje() {
		driver.findElement(botonResumenViaje).click();
	}

}


