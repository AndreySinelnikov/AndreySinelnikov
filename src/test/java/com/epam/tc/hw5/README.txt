GOAL: Add Cucumber support to a project

1. IN pom.xml ADD Cucumber: Java dependency from Maven central repo.
2. IN pom.xml ADD Cucumber: TestNG dependency from Maven central repo with 'test' in scope tag.

----------

GOAL: Add Cucumber feature file to a project

1. IN test/resources ADD directory for Cucumber features. It is recommended to name the directory
   after the corresponding test directory, i.e. 'com/epam/tc/hw5/cucumber' for Homework 5.
2. IN the Cucumber feature directory ADD a file with .feature extension.
3. IN the feature file ADD 'Feature: {feature_name}'.
   IN the feature file ADD 'Scenario: {scenario_name}'. Fill out Given/When/Then steps.

-----------

GOAL: Make Cucumber test runnable (for TestNG)

1. IN the test directory corresponding to feature directory ADD a class that extends
   AbstractTestNGCucumberTest (for Homework 5 it's RunAcceptanceTest class).
   OPTIONALLY Customize with @CucumberOptions annotation
   (path to feature file: 'features' parameter, Allure report plugin: 'plugin').
2. ADD TestNG suite XML file that points to the test directory corresponding to feature directory.

-----------

GOAL: Link a Cucumber Given/When/Then step to an actual method

1. IN a Step class ADD a method annotated with @Given/@When/@Then with a parameter that matches a Given/When/Then step
   in a Cucumber feature file. Annotation name and step name don't have to match, only the parameter string.

   OPTIONALLY parameterized values for a step can be specified in {} brackets (with a Cucumber Expression type, i.e {int})
   within the annotation parameter string, to be mapped onto method arguments. For more complex parameterization
   refer to BDD lecture, 1h30m mark.

------------

GOAL: Add a setup/teardown method to a Cucumber scenario

1. ADD a CucumberHook class.
2. IN CucumberHook, ADD a method annotated with @Before/@After (annotation must belong to the Cucumber library!)

------------

GOAL: Pass objects and values between steps via test context

1. ADD a singleton TestContext class.
2. IN this class, ADD a map attribute to store values to be passed.
3. IN a @Given/@When/@Then method, call TestContext.getInstance().addObjectToMap(key, object) to pass an object.
   OPTIONALLY TestContext can be utilized by CucumberHook setup/teardown methods.

------------
