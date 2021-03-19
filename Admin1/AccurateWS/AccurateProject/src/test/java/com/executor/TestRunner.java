package com.executor;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
				glue="com.stepDefinition",
//				tags="@boxExampleScenario_part1 or @boxExampleScenario_part2 or @boxExampleScenario_part3",
				tags="@boxindexBox",
				plugin ={"pretty",
						"html:reports/htmlreports/report.html",
						"json:reports/report.json",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"summary",
						"junit:reports/Cucumber.xml"},
				monochrome=true,
				snippets=SnippetType.CAMELCASE,
				strict = true,
				dryRun=false
				)
public class TestRunner {

}



