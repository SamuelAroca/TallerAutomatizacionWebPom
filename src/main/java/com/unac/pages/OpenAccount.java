package com.unac.pages;

import com.unac.actions.Action;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://parabank.parasoft.com/parabank/openaccount.htm")
public class OpenAccount extends PageObject {
    By openAccountLink = By.linkText("Open New Account");
    By openAccountButton = By.cssSelector("input[value='Open New Account']");
    By accountTypeDropdown = By.id("type");
    By openNewAccountButton = By.xpath("//input[@value='Open New Account']");
    By newAccountNumber = By.id("newAccountId");
    By openAccountOverviewLink = By.linkText("Accounts Overview");

    public void clickOpenAccountLink() {
        Action.clickElement(getDriver(), openAccountLink);
    }

    public void clickOpenAccountButton() {
        Action.clickElement(getDriver(), openAccountButton);
    }

    public void selectAccountType(String accountType) {
        Action.sendData(getDriver(), accountTypeDropdown, accountType);
    }

    public void clickOpenNewAccountButton() {
        Action.clickElement(getDriver(), openNewAccountButton);
    }

    public String getNewAccountNumber() {
        return getDriver().findElement(newAccountNumber).getText();
    }

    public void clickOpenAccountOverviewLink() {
        Action.clickElement(getDriver(), openAccountOverviewLink);
    }
}
