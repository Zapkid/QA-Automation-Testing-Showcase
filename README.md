# QA Automation Testing Showcase
#### This project utilizes a 'smart' automation infrastructure for multi-platform quality assurance automated testing to demonstrate my knowledge & capabilities in QA Automation.

---

### About

This project is built to serve as an automation infrastructure with a TestNG framework and a Page-Object-Model for testing applications on multiple platforms.
The infrastructure provides an easy, simple and quick way to add new tests, and is easily expandable & maintained.

Jenkins is used to schedule executions of the Test Suites profiles for each platform (more profiles can be easily added to create different test scenarios) linked into a pipeline.

Allure Report system is used as the main reporting system.



### Overview

This project performs automated testing of various applications:
* Web based application
* Web API
* Mobile application
* Electron application
* Desktop application

#### Infrastructure includes:

* Layers (utilities, extensions, workflows...)
* Page object model design pattern
* External files Support
* Failure mechanisms
* Electron driver
* Reporting system (including video recordings & screenshots)
* Support for different client browsers
* API support
* Visual testing
* Database support
* CI & CD support

#### Applications tested:

* [Grafana](https://grafana.com/grafana/) - Web based application tested with WebDriver
* Grafana API - Web API tested with REST Assuard
* [UK Mortgage Calculator](https://play.google.com/store/apps/details?id=uk.co.jamesgrimwood.mortgageadvisor&hl=en_GB&gl=US) - Mobile application tested with Appium
* [TodoList](https://github.com/blaadje/Todolist) Desktop application tested with ElectronDriver
* Windows Calculator - Desktop application tested with WinAppDriver


#### Tools & Frameworks:

* [TestNG](https://testng.org/) Framework
* Listenrs interface for Logs & Customizable TestNG Reports
* [Monte Screen Recorder](https://github.com/sbtqa/monte-media/blob/master/src/main/ru/sbtqa/monte/screenrecorder/ScreenRecorder.java) for Video Recordings
* [Selenium](https://www.selenium.dev/) Java & API
* [REST Assured](https://rest-assured.io/) for API Testing
* [SikuliX API](http://sikulix.com/) for Visual Testing
* [Appium Studio](https://digital.ai/continuous-testing/eclipse-intellij-plugins) & Java-Appium for Mobile Testing
* [MySQL Database](https://remotemysql.com/) to store Login Credentials
* [OpenCSV](http://opencsv.sourceforge.net/) for CSV file parsing
* [Jenkins](https://www.jenkins.io/) for Automating Test executions & Test Pipelines
* [Allure Reports](http://allure.qatools.ru/) - Reporting System

Please note: Configuration file & DB credentials have been redacted. 

---

### Tests Overview

#### Grafana: Web & API Testing with Selenium WebDriver - [Grafana Web Tests Video](https://drive.google.com/file/d/1yubF4IKtwFYXZvSW8g9FfKCWxKsCSmH2/view?usp=sharing)

##### Web - Login to Grafana with credentials pulled from an external Database
Verify login was successful 
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/Grafana_Login.gif "Grafana Login")

##### Web - View Grafana users
Verify expected amount of current users
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/GrafanaCheckUser.gif "Grafana Users")

##### Web - Create a new Grafana user
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/GrafanaAddUser.gif "Grafana Add NEW User")
```java
WebFlows.addNewUser("John Doe", "JD@localhost", "JDTester", "123abc999");
```

##### Web - Delete a Grafana user by Username
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/GrafanaDeleteUser.gif "Grafana Delete User")

##### Web - Verify an element is located on screen by Visual lookup 
Verify this image:  ![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/GrafanaAvatar.png "Grafana Visual Search") is located on screen by searching for it by looking at pixels colors

##### Web - Check if a user is found - Data Driven Testing using a data provider for multiple users & expected results
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/GrafanaSearchUsers.gif "Grafana DDT")
```java
WebFlows.searchAndVerifyUser(username, shouldBeFound);
```

##### API - Verify HTTP response property (GET), Add new Team (POST), Update property (PUT), Delete Team by team ID (DELETE)
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/APIprints.gif "Grafana API")
```java
ApiFlows.getTeamProperty("teams[0].name"), "Kuku Group");

ApiFlows.postTeam("YoniTeam", "yoni@team.com");

ApiFlows.updateTeam("YoniTeam", "yoni@atid.com", id);

ApiFlows.deleteTeam(id);
```
---

#### UK Mortgage Calculator: Mobile Testing with Appium Studio & Appium Driver

##### Calculate mortgage
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/Mobile2.gif "Mobile - Calculate mortgage")

---

#### Todolist: Testing with Electron Driver

##### Add new Todo items, mark item as completed, delete an item, add new items with a color tag, mark all as completed
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/Electron_gif.gif "Electron Driver Testing")
```java
ElectronFlows.createTodo("Learn Quality Assurance");

ElectronFlows.createTodo("Learn Automation");

ElectronFlows.completeTodoByName("Learn Quality Assurance");

ElectronFlows.deleteTodoByName("Learn Quality Assurance");

ElectronFlows.createTodoWithColorTag("I have a green color tag", "background: rgb(114, 204, 87);");

ElectronFlows.createTodoWithColorTag("Learn Electron Driver", "background: rgb(87, 185, 244);");

ElectronFlows.completeAllTodos();
```

---

#### Windows Calculator: Testing with WinAppDriver

##### Simple Calculation - Based on pre-built methods
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/CalcDivByZero.gif "Windows Calculator Testing - Division by Zero")
Each operation is defined separately, allowing combinations for complex calculations & QA for smaller 'units'.
```java
DesktopFlows.division(calcMain.btn_8, calcMain.btn_0);
```

##### Complex Operations - Based on button assignment
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/CalcComplex.gif "Windows Calculator Testing - Complex Operations")
The button assignment allows multiple operations to be implemented in the code using only 1 line of code & 1 String as an input
```java
DesktopFlows.enterEquation("1+2*(3^4)=%14=!l=/p=");
```
In this example, the symbols: '^' was assigned to the Power button, '%' was assigned to the mod button, '!' was assigned to the Factorial button, 'l' was assigned to the log button, 'p' was assigned to the Pi button. The common chars were assigned respectively.

---

### Jenkins & Allure Reports

##### Jenkins Basic & Blue Ocean Dashboards
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/JenkinsDashboards.gif "Jenkins - Dashboard")

##### Jenkins Sanity Test Suites
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/SanitySuccess.gif "Jenkins - Sanity Testing")

##### Jenkins Pipelines
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/pipelines.PNG "Jenkins - Pipelines")

##### Allure Reports
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/AllureReports.gif "Allure Reports")
The reports show the 'steps' in each test, with info such as: description, duration, history, parameters & values,  verification values, screenshots and more.




