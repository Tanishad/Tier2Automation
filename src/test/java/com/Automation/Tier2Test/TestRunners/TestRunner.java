package com.Automation.Tier2Test.TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        //dryRun = true, // no actual execution, only to identify unimplemented scenarios exists.
        features = {"src/test/resources/com.Automation.Tier2Test/Features"},
        glue = {"classpath:com.Automation.Tier2Test.StepDefs"},
        tags= "@testui",
        plugin = {"pretty", "html:target/cucumber-original/cucumber.html",
                "json:target/cucumber-json-reports/ui_cucumber-report.json",
                "rerun:target/ui/rerun.txt"
        }
        ,publish=true
)
public class TestRunner {
}
