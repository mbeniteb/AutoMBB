package com.everis.base.steps;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.*;
//import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SwapiSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(SwapiSteps.class);
    static private final String BASE_URL = "https://swapi.dev/api/";
    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;
    private Response response;

    @Before
    public void init() {

        LOGGER.info(" Inicializa el constructor request ");
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .build();

        LOGGER.info(" Inicializa el constructor response ");
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }


    public void obtieneLaListaDePersonajes() {
        response = given().log().all().spec(requestSpec).when().get("people").then()
                .contentType(ContentType.JSON).extract().response();
    }

    public void validoNombreElemento(int elemento, String tipo, String valor) {
        List<Map<String,String>> personajes = response.jsonPath().getList("results");
        assertThat(personajes.get(elemento).get(tipo), is(valor));
    }

    public void validoQueLaRespuestaFinalObtenidaEs(int respuesta) {
        assertThat(lastResponse().statusCode(), is(respuesta));
    }
}