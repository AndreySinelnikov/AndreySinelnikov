GOAL: Add Allure report functionality to the project

1. ADD allure-testng dependency to pom.xml (for junit4 it would have been allure-junit4 etc.)
2. IN build/surefire plugin configuration section: ADD argLine tag with path to aspectj weaver jar,
   ADD allure results directory systemProperty.
   IN build/surefire plugin dependency section: ADD aspectjweaver dependency.
3. After running tests ('mvn clean test') run 'mvn allure:serve' to get a report.
__________

GOAL: Rework tests into Allure-compliant step sequences

1. ADD classes for steps (here broken into Action and Assertion steps, each Step class contains all steps
   that belong to a given category). Test (Exercise) classes get two Step attributes, actions and assertions
   are made through these attributes. Main test method may include several actions/assertions.
   Step description goes into @Step value parameter, with angle brackets {} able to capture method arguments.

----------

NOTE: Relevant waits example

WebdriverWait wait = new WebDriverWait(driver, 10L);

public void sendKeysToSearchInputField(String text) {
        wait.until(visibilityOf(searchInputField)).sendKeys(text);
    }

    public void clickToSearchButton() {
        wait.until(elementToBeClickable(searchButton)).click();
    }

----------