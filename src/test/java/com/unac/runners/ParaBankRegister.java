package com.unac.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = "com.unac.stepsdefinitions",
        features = "src/test/resources/com/unac/features/parabank-register.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class ParaBankRegister {
}
