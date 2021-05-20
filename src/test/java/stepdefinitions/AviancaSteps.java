package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.InfoContactoPage;
import pages.ResumenPage;
import pages.SeleccionVuelosPage;

public class AviancaSteps {

	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private SeleccionVuelosPage seleccionVuelosPage = new SeleccionVuelosPage(DriverFactory.getDriver());
	private InfoContactoPage infoContactoPage = new InfoContactoPage(DriverFactory.getDriver());
	private ResumenPage resumenPage = new ResumenPage(DriverFactory.getDriver());

	@Given("^ingreso a la pagina de Avianca$")
	public void ingreso_a_la_pagina_de_Avianca() throws InterruptedException {

		DriverFactory.getDriver().get("https://www.avianca.com/co/es/");

	}

	@When("^ingreso a buscar vuelos$")
	public void ingreso_a_buscar_vuelos() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0,100)");
		homePage.seleccionarTipoViaje();
		homePage.ingresarDestino("Mede");
		//homePage.clicEnCiudadDestino();
		Thread.sleep(2000);
		homePage.clicFechaViaje();
		Thread.sleep(2000);
		homePage.escogerFechaInicio("22");
		Thread.sleep(2000);
		homePage.clicEnBotonBuscarVuelos();

	}

	@When("^selecciono el vuelo$")
	public void selecciono_el_vuelo() throws InterruptedException {
		seleccionVuelosPage.clicSeleccionarVuelo();
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("window.scrollBy(0,500)");
		seleccionVuelosPage.clicTarifaPreferencial();
		Thread.sleep(2000);
		seleccionVuelosPage.clicBotonContinuar();
		Thread.sleep(2000);
	}

	@When("diligencio los datos requeridos que estan en la hoja de excel {string} y en la linea {int}")
	public void diligencio_los_datos_requeridos(String nombreHoja, int numeroLinea) throws InterruptedException, InvalidFormatException, IOException {
		
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData = reader.getData("src/test/resources/data/datos.xlsx", nombreHoja);
		String nombre = testData.get(numeroLinea).get("nombre");
		String apellido = testData.get(numeroLinea).get("apellido");
		String correo = testData.get(numeroLinea).get("correo");
		String telefono = testData.get(numeroLinea).get("telefono");
		
		
		infoContactoPage.escribirNombre(nombre);
		infoContactoPage.escribirApellido(apellido);
		infoContactoPage.clicEnBotonInfoContacto();
		infoContactoPage.ingresoCorreo(correo);
		infoContactoPage.ingresoTelefono(telefono);
		infoContactoPage.aceptarTerminos();
		infoContactoPage.clicEnGuardarYContinuar();
		infoContactoPage.clicParaVerResumenDelViaje();
		Thread.sleep(5000);
		

	}

	@Then("^el sistema debe mostrar que el vuelo ha sido seleccionado correctamente$")
	public void el_sistema_debe_mostrar_que_el_vuelo_ha_sido_seleccionado_correctamente() {
	resumenPage.validoTituloDePasajeros();
	resumenPage.validoTituloDeDatosDeContacto();
		

	}

}
