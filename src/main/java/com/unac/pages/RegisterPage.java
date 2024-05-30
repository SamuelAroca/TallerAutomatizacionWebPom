package com.unac.pages;

import com.unac.actions.Action;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://parabank.parasoft.com/parabank/index.htm")
public class RegisterPage extends PageObject {
    By firstName = By.name("customer.firstName");
    By lastName = By.name("customer.lastName");
    By address = By.name("customer.address.street");
    By city = By.name("customer.address.city");
    By state = By.name("customer.address.state");
    By zipCode = By.name("customer.address.zipCode");
    By phoneNumber = By.name("customer.phoneNumber");
    By ssn = By.name("customer.ssn");
    By username = By.name("customer.username");
    By password = By.name("customer.password");
    By confirmPassword = By.name("repeatedPassword");
    By registerButton = By.xpath("//input[@value='Register']");

    public void register(String strFirstName, String strLastName, String strAddress, String strCity, String strState, String strZipCode, String strPhoneNumber, String strSSN, String strUsername, String strPassword, String strConfirmPassword) {
        Action.sendData(getDriver(), firstName, strFirstName);
        Action.sendData(getDriver(), lastName, strLastName);
        Action.sendData(getDriver(), address, strAddress);
        Action.sendData(getDriver(), city, strCity);
        Action.sendData(getDriver(), state, strState);
        Action.sendData(getDriver(), zipCode, strZipCode);
        Action.sendData(getDriver(), phoneNumber, strPhoneNumber);
        Action.sendData(getDriver(), ssn, strSSN);

        String uniqueUsername = Action.generateUniqueUsername(strUsername);
        Action.sendData(getDriver(), username, uniqueUsername);
        Action.sendData(getDriver(), password, strPassword);
        Action.sendData(getDriver(), confirmPassword, strConfirmPassword);
        Action.clickElement(getDriver(), registerButton);
    }
}
