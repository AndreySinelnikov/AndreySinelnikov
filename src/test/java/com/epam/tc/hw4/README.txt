GOAL: Add Allure report functionality to the project

1. ADD allure-testng dependency to pom.xml (for junit4 it would have been allure-junit4 etc.)
2. IN build/surefire plugin configuration section: ADD argLine tag with path to aspectj weaver jar,
   ADD allure results directory systemProperty.
   IN build/surefire plugin dependency section: ADD aspectjweaver dependency.
   IN reporting section: ADD allure-maven artifact with <excludeDefaults> set to true. (UNCLEAR)
3. ADD allure.properties file to test/resources; allure properties like report directory are listed there.
4. After running tests ('mvn clean test') run 'mvn allure:serve' to get a report.
__________

GOAL: Rework tests into Allure-compliant step sequences

1. ADD classes for steps (here broken into Action and Assertion steps, each Step class contains all steps
   that belong to a given category). Test (Exercise) classes get two Step attributes, actions and assertions
   are made through these attributes. Main test method may include several actions/assertions.
   Step description goes into @Step value parameter, with angle brackets {} able to capture method arguments.

----------

GOAL: Add Listener that has access to test context

1. ADD Listener class implementing ITestListener to project. Override one of the methods -- like onTestFailure -- with
   relevant actions.
2. When your listener has to access test-specific attributes (i.e. test webdriver so the listener
   can take screenshots):
   IN @Before method for the test, ADD ITestContext context as a parameter.
   IN @Before method for the test, ADD context.setAttribute(name, object).
   IN the listener with ITestResult parameter, use iTestResult.getTestContext().getAttribute(name) to access set attribute.
3. IN the test class that has to be monitored by listener, ADD @Listeners({ ListenerName.class })

__________

NOTE: Relevant waits example

WebdriverWait wait = new WebDriverWait(driver, 10L);

public void sendKeysToSearchInputField(String text) {
        wait.until(visibilityOf(searchInputField)).sendKeys(text);
    }

    public void clickToSearchButton() {
        wait.until(elementToBeClickable(searchButton)).click();
    }

----------