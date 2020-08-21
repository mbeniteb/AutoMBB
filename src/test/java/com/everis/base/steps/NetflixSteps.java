package com.everis.base.steps;

import com.everis.base.models.Book;
import com.everis.base.models.Data;
//import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.thucydides.core.annotations.Step;
//import org.apache.commons.io.IOUtils;
import org.hamcrest.CoreMatchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.core.io.ClassPathResource;

//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//import java.util.regex.Pattern;

import static net.serenitybdd.rest.SerenityRest.*;
//import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class NetflixSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(NetflixSteps.class);
    static private final String BASE_URL = "https://reqres.in/api/";

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    private Response response;
    private RequestSpecBuilder builder;
    private RequestSpecification requestSpecification;
    private String bodyPost;

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

    @Step("obtiene lista de usuarios")
    public void listUser(int page) {

        given().
                log().all().
                spec(requestSpec).
                queryParam("page", page).
         when().
                get("users").
         then().
                spec(responseSpec).
         and().
                log().all();
    }



    @Step("obtiene un Usuario")
    public void getUser(int user) {

        given()
                .log().all()
                .spec(requestSpec)
                .pathParams("id", user).
         when()
                .get("users/{id}").
         then().
            and().
                log().all();
    }

    @Step("obtiene lista de usuarios con Objeto Java")
    public void listUserObject(int page) {

        Book book =
                given().
                        log().all().
                        spec(requestSpec).
                        queryParam("page", page).
            when().
                        get("users").
                        as(Book.class);

        LOGGER.info("Realizo la consulta de Usuarios: ");
        book.getData().forEach(x -> LOGGER.info(x.toString()));

        LOGGER.info("Realizo el filtro de un Usuario: ");
        Data data = book.getData().stream().filter(x -> x.getEmail().equals("emma.wong@reqres.in")).findAny().orElse(null);
        assert data != null;
        LOGGER.info(data.toString());
    }

    public void validateStatusCode(int i) {
        assertThat(lastResponse().statusCode(), is(i));
    }

    public void validateBodyContent(String var) {
        assertThat(lastResponse().getBody().path("data.email"), equalTo(var));
    }

    public void validarApellido(String apellido) {
        assertThat(lastResponse().getBody().path("data.last_name"), equalTo(apellido));
    }

    public void validarNombre(String nombre) {
        assertThat(lastResponse().getBody().path("data.first_name"), equalTo(nombre));
    }

    public void validaTrabajo(String trabajo) {
        assertThat(lastResponse().getBody().path("data.job"), equalTo(trabajo));
    }

    public void insertUsuario(String nombre, String trabajo) {

        JsonObject parametros = new JsonObject();
        parametros.addProperty("name", nombre);
        parametros.addProperty("job", trabajo);

        bodyPost = parametros.toString();

        builder.setBody(bodyPost);
    }

    @Step("set Service Name")
    public void inicializoParametrosRequestPost() {
        RestAssured.baseURI = BASE_URL;
        builder = new RequestSpecBuilder();
        requestSpecification = builder.build();
    }

    @Step("set Header")
    public void setHeader(String k, String v) {
        builder.addHeader(k, v);
    }

    public void sendPostRequest(String api) {
        response = given().spec(requestSpecification).when().post(api);
    }

    @Step("verifica el contenido de la RESPUESTA")
    public void checkDataResponse(String k, String v) {
            assertThat(response.body().path(k), CoreMatchers.equalTo(v));
    }

}
