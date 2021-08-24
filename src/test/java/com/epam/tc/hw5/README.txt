GOAL: Add Cucumber support to a project

1. IN pom.xml ADD Cucumber: Java dependency from Maven central repo.
2. IN pom.xml ADD Cucumber: TestNG dependency from Maven central repo with 'test' in scope tag.

----------

GOAL: Add Cucumber feature file to a project

1. IN test/resources ADD directory for Cucumber features. It is recommended to name the directory
   after the corresponding test directory, i.e. 'com/epam/tc/hw5/cucumber' for Homework 5. (UNCLEAR)
2. IN the Cucumber feature directory ADD a file with .feature extension.
3. IN the feature file ADD 'Feature: {feature_name}'.
   IN the feature file ADD 'Scenario: {scenario_name}'. Fill out Given/When/Then steps.

-----------

GOAL: Make Cucumber test runnable (for TestNG)

1. IN the test directory corresponding to feature directory ADD a class that extends
   AbstractTestNGCucumberTest (for Homework 5 it's RunAcceptanceTest class).
   Customize with @CucumberOptions annotation (path to feature file: 'features' parameter, Allure report plugin: 'plugin').