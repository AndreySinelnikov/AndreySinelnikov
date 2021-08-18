GOAL: Add Allure report functionality to the project

1. ADD allure-testng dependency to pom.xml (for junit4 it would have been allure-junit4 etc.)
2. IN build/surefire plugin configuration section: ADD argLine tag with path to aspectj weaver jar,
   ADD allure results directory systemProperty.
   IN build/surefire plugin dependency section: ADD aspectjweaver dependency.
3. After running tests ('mvn clean test') run 'mvn allure:serve' to get a report.