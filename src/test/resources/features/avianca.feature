
Feature: compra vuelo avianca
 yo como usuario quiero poder ingresar a la pagina de Avianca para realizar la compra de un vuelo

  Scenario Outline: comprar vuelo en la pagina de avianca
    Given ingreso a la pagina de Avianca
    When ingreso a buscar vuelos
    And selecciono el vuelo 
    And diligencio los datos requeridos que estan en la hoja de excel "<nombreHoja>" y en la linea <numeroLinea> 
    Then el sistema debe mostrar que el vuelo ha sido seleccionado correctamente
    Examples:
    |nombreHoja|numeroLinea|
    |Datos|0|
    |Datos|1|


