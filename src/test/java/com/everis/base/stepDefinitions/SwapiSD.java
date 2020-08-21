package com.everis.base.stepDefinitions;

import com.everis.base.steps.SwapiSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SwapiSD {
    @Steps
    SwapiSteps swapiSteps;

    @Given("el api esta operativo")
    public void elApiEstaOperativo() {
    }


    @When("obtiene la lista de personajes")
    public void obtieneLaListaDePersonajes() {
        swapiSteps.obtieneLaListaDePersonajes();
    }

    @And("valido que el nombre del elemento {int} de tipo {string} es {string}")
    public void validoQueElNombreDelElementoDeTipoEs(int elemento, String tipo, String valor) {
        swapiSteps.validoNombreElemento(elemento,tipo,valor);
    }

    @Then("valido que la respuesta final obtenida es {int}")
    public void validoQueLaRespuestaFinalObtenidaEs(int respuesta) {
        swapiSteps.validoQueLaRespuestaFinalObtenidaEs(respuesta);
    }
}
