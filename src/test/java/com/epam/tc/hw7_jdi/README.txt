GOAL: Add basic JDI support to a project

1. IN pom.xml, ADD

    <dependency>
        <groupId>com.epam.jdi</groupId>
        <artifactId>jdi-light-html</artifactId>
        <version>RELEASE</version>
    </dependency>

2. IN src/test/resources, ADD test.properties file
3. IN test.properties file, ADD

    driver=chrome
    #driver.version=2.23 | LATEST
    #timeout.wait.element=10
    #timeout.wait.page=30
    #page.load.strategy=normal | eager | none
    #browser.size=MAXIMIZE | 1024x762

------------


