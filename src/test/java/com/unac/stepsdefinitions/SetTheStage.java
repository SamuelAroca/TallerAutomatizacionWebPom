package com.unac.stepsdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;

public class SetTheStage {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new Cast());
    }
}
