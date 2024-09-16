# UI automation test-cases for the [Habr's website](https://habr.com/ru/feed/)
## Manual test-cases are stored [HERE](https://docs.google.com/spreadsheets/d/1GqsZUgXX6EPVYYF3NSU-DH49bra7FbUVGdvwuo4XFVw/edit?usp=sharing)

These test-cases checks the Main page, the PopSci page, Admin page and Sign up page.
There are twenty tests in this project.

The project uses 21 Java version.

In order to run the ALL tests is necessary input a command into the terminal:
- **./mvnw clean test**  OR **mvn clean test**

In order to run one of the test's class(such tests for the pages as the Main page, the PopSci page, Admin page and Sign up page) is necessary input a command into the terminal:
- **./mvnw clean test -Dtest=<Input the name of the test's class>** 

  For instance: **./mvnw clean test -Dtest=PopSciTest**

In order to run Allure is necessary input a command into the terminal:
- **./mvnw allure:serve** OR **mvn allure:serve**
  

