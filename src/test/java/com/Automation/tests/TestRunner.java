package com.Automation.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\com\\Automation\\features\\",
        glue = "com.Automation.tests",
        monochrome = true)
public class TestRunner {
}
