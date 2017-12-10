# Framework design
Tools:
  - Selenium java
  - Cucumber bdd framework

Framework structure:
  - [/src/test/resources/features] cucumber feature files
  - [src/test/java/steps] cucumber steps
  - [src/test/java/pageObjects] page objects for each page
  - [src/test/java/pageObjects/BasePage.java] base page object class extended by all other page objects
  - [src/test/java/hooks/SetupDriverHook.java] setup hook. Also can be used for sharing data between steps in cucumber
  - [src/test/java/models] all configuration models and test data models. There are no test data models in current case, but I find it useful to define test data structure here and kepp test data in json files
  - [src/test/resources/configs] json configs for running test on different environments
  - [src/test/java/utils] any helpers and utils
  - [src/test/java/SanityTest.java] test runner class

# Setup and run
Requirements:
Maven installed

To run:
this version configured only for running tests locally.
To run test locally:
- Go to https://sites.google.com/a/chromium.org/chromedriver/downloads and download chrome driver that matches your OS and chrome version
- Open src/test/resources/configs/localConfig.json and pust path to your chromedriver instead of "/Users/vitalygryaznov/chalange/web_exercise/src/test/java/drivers/chromedriver"
- run in terminal $: mvn -Dtest=SanityTest clean test -DargLine="configFile=localConfig"

# Where to see reports after running tests

- [target/cucumber-html-report/index.html] human readable html reports
- [target/surefire-reports/TEST-SanityTest.xml] surfire test report
- [target/cucumber.json], [target/cucumber-results.xml] -for jenkins plugin
- [target/cucumber-pretty.txt] logs

# What wasn done because of the time frame
- Swiping left is hardcoded in page object. it should be placed in utils, helpers or common steps
- Implemented verification that card is the 3rd, but it's better to use conditional wait in this case. test passed 5/5 but it could fail in bad performance conditions
- Used only dots on the card to verify it's the third. It's better to add assertion that it was the third before screen resizing
- Very simple configuration
- All test verified only on chrome
- Some duplicated code (openItWithDirectLink method for example)