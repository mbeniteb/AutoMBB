package com.everis.base.pageobject;

/**
 * @author jovallep
 */

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.mercadolibre.com.pe/")
public class MercadoLibrePage extends PageObject {

    @FindBy(xpath = "/html/body/header/div/div[1]/nav[2]/a[1]")
    public WebElementFacade btnCrearCuenta;

    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div/form/div[1]/div[1]/label")
    public WebElementFacade textoNombre;

    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div/form/div[1]/div[2]/label")
    public WebElementFacade textoApellido;

    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div/form/div[1]/div[3]/div[1]/div/label")
    public WebElementFacade textoCorreo;

    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div/form/div[1]/div[3]/div[2]/label")
    public WebElementFacade textoClave;

}
