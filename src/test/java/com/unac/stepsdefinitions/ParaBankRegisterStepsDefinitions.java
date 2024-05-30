package com.unac.stepsdefinitions;

import com.unac.pages.HomePage;
import com.unac.pages.OpenAccount;
import com.unac.pages.RegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ParaBankRegisterStepsDefinitions {

    HomePage homePage;
    RegisterPage registerPage;
    OpenAccount openAccount;

    static String accountNumber;

    @Given("Deseo abrir la pagina parabank {string}")
    public void deseo_abrir_la_pagina_parabank(String url) {
        homePage.navigateTo(url);
    }

    @When("ingreso a la opcion de Register")
    public void ingreso_a_la_opcion_de_register() {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickRegister();
    }

    @When("ingreso los siguientes datos para mi registro: First Name: {string}, Last Name: {string}, Address: {string}, City: {string}, State: {string}, Zip Code: {string}, Phone: {string}, SSN: {string}, Username: {string}, Password: {string}, Confirm: {string}")
    public void ingreso_los_siguientes_datos_para_mi_registro_first_name_last_name_address_city_state_zip_code_phone_ssn_username_password_confirm(String strFirstName, String strLastName, String strAddress, String strCity, String strState, String strZipCode, String strPhoneNumber, String strSSN, String strUsername, String strPassword, String strConfirmPassword) {
        // Write code here that turns the phrase above into concrete actions
        registerPage.register(strFirstName, strLastName, strAddress, strCity, strState, strZipCode, strPhoneNumber, strSSN, strUsername, strPassword, strConfirmPassword);
    }

    @When("presiono el boton Open New Account y en el select escogemos {string}")
    public void presiono_el_boton_open_new_account(String accountType) {
        openAccount.clickOpenAccountLink();
        openAccount.clickOpenAccountButton();
        openAccount.selectAccountType(accountType);
    }

    @When("luego presiono el boton Open New Account")
    public void luego_presiono_el_boton_open_new_account() {
        openAccount.clickOpenNewAccountButton();
        waitUntilAccountNumberIsAvailable();
    }

    @When("guardo el numero Your new account number")
    public void guardo_el_numero_your_new_account_number() {
        accountNumber = openAccount.getNewAccountNumber();
    }

    @Then("valido que la cuenta exista en la opcion de Accounts Overview")
    public void valido_que_la_cuenta_exista_en_la_opcion_de_accounts_overview() {
        openAccount.clickOpenAccountOverviewLink();

        WebElement accountNumberElement = openAccount.getDriver().findElement(By.linkText(accountNumber));
        if (accountNumberElement.isDisplayed()) {
            System.out.println("El numero de cuenta " + accountNumber + " esta presente en la pagina Accounts Overview.");
        } else {
            System.out.println("El numero de cuenta " + accountNumber + " no se encuentra en la página Accounts Overview.");
            fail("La cuenta no esta presente en la pagina Accounts Overview.");
        }
    }

    @After
    public static void closeBrowser() {
        System.out.println("Account Number: " + accountNumber);
        WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();
        if (driver != null) {
            driver.quit();
        }
    }

    private void waitUntilAccountNumberIsAvailable() {
        // Espera 5 segundos para dar tiempo a que se genere el número de cuenta
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void fail(String message) {
        Assert.fail(message);
    }
}
