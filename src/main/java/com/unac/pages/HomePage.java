package com.unac.pages;

import com.unac.actions.Action;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://parabank.parasoft.com/parabank/index.htm")
public class HomePage extends PageObject {
    By btnRegister = By.xpath("//a[text()='Register']");

    public void navigateTo(String url) {
        Action.navigateUrl(getDriver(), url);
    }

    public void clickRegister() {
        Action.clickElement(getDriver(), btnRegister);
    }
}
