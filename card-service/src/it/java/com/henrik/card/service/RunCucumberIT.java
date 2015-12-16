package com.henrik.card.service;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty", "html:target/cucumber"}, glue = {"cucumber.api.spring", "classpath:com.henrik.card.service"})
public class RunCucumberIT {
}
