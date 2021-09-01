GOAL: Launch Selenium Grid hub

1. IN terminal, pwd contains selenium-server-standalone jar TYPE java -jar {path_to_sss.jar} -role hub

(DEFAULT url for nodes to register is http://192.168.1.109:4444/grid/register/)
(DEFAULT url for clients/remote webdriver is http://192.168.1.109:4444/wd/hub)

---------

GOAL: Launch Selenium Grid node

1. IN terminal, pwd contains selenium-server-standalone jar
   TYPE java {%WEBDRIVER%=path_to_driver} [EXAMPLE -Dwebdriver.chrome.driver="C:\Drivers\Selenium\chromedriver.exe"]
   -jar {path_to_sss.jar} -role node
   -hub {hub_URL} [DEFAULT http://192.168.1.109:4444/grid/register/]
   -browser {browser_properties} [EXAMPLE "browserName=chrome,maxInstances=3"]

---------

GOAL: Launch tests via Selenium Grid server

1. Launch Selenium Grid hub
2. Launch Selenium node for a corresponding browser
3. Launch tests via maven, passing browser-related parameters via -D [EXAMPLE mvn -Ddriver.type=remote -Dbrowser.name=firefox clean test]

---------

GOAL: Add Lombok support to a project

1. IN pom.xml ADD dependency
    <dependency>
       <groupId>org.projectlombok</groupId>
       <artifactId>lombok</artifactId>
       <version>${lombok.version}</version>
       <scope>provided</scope>
    </dependency>
    ('provided' scope dependency is required to compile your source code,
     but does not need to be present when running/testing/jarring/otherwise
     deploying your code.)

----------


