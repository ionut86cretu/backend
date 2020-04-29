package com.endava.school4it.runners;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import configuration.AppConfiguration;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        monochrome = true,
        features = "src/test/resources/features/backend/",
        tags = {"not @ignore"},
        glue = "com.endava.school4it.steps"
)
@ContextConfiguration(classes = AppConfiguration.class)
public class RunTests {

}
/*-DappConfig="AppConfigCloudUAT.properties" -Dcucumber.options="--tags @debug src/test/resources/features"*/
