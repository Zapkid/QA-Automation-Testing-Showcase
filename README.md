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
* [MySQL Database](https://remotemysql.com/) to stores Login Credentials
* [OpenCSV](http://opencsv.sourceforge.net/) for CSV file parsing
* [Jenkins](https://www.jenkins.io/) for Automating Test executions & Test Pipelines
* [Allure Reports](http://allure.qatools.ru/) - Reporting System

Please note: Configuration file & DB credentials have been redacted. 

---

### Tests Overview

#### Grafana: Web & API Testing with Selenium WebDriver - [Grafana Web Tests Video](https://drive.google.com/file/d/1yubF4IKtwFYXZvSW8g9FfKCWxKsCSmH2/view?usp=sharing)

##### Web - Login to Grafana with credentials pulled from Database
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/Grafana_Login.gif "Grafana Login")

##### Web - View Grafana users
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/GrafanaCheckUser.gif "Grafana Users")

##### Web - Create new Grafana user
```WebFlows.addNewUser("John Doe", "JD@localhost", "JDTester", "123abc999");```
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/GrafanaAddUser.gif "Grafana Add NEW User")

##### Web - Delete Grafana user by Username
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/GrafanaDeleteUser.gif "Grafana Delete User")

##### Web - Verify element located on screen by Visual lookup ![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/GrafanaAvatar.png "Grafana Visual Search")

##### Web - Check if a user is found - Data Driven Testing using a data provider for multiple users & expected results
```WebFlows.searchAndVerifyUser(username, shouldBeFound);```
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/GrafanaSearchUsers.gif "Grafana DDT")

##### API - Verify response property, Add new Team, Update property, Delete Team via HTTP requests
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/APIprints.gif "Grafana API")

---

#### UK Mortgage Calculator: Mobile Testing with Appium Studio & Appium Driver

##### Calculate mortgage
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/Mobile2.gif "Mobile - Calculate mortgage")

---

#### Todolist: Testing with Electron Driver

##### Add new Todo items, mark item as completed, delete an item, add new items with a color tag, mark all as completed
```
ElectronFlows.createTodo("Learn Quality Assurance");

ElectronFlows.createTodo("Learn Automation");

ElectronFlows.completeTodoByName("Learn Quality Assurance");

ElectronFlows.deleteTodoByName("Learn Quality Assurance");

ElectronFlows.createTodoWithColorTag("I have a green color tag", "background: rgb(114, 204, 87);");

ElectronFlows.createTodoWithColorTag("Learn Electron Driver", "background: rgb(87, 185, 244);");

ElectronFlows.completeAllTodos();
```
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/Electron_gif.gif "Electron Driver Testing")

---

#### Windows Calculator: Testing with WinAppDriver

##### Simple Calculation - Based on pre-built methods, for example: ```DesktopFlows.division(calcMain.btn_8, calcMain.btn_0);```
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/CalcDivByZero.gif "Windows Calculator Testing - Division by Zero")

##### Complex Operations - Based on button assignment, for example: ```DesktopFlows.enterEquation("1+2*(3^4)=%14=!l=/p=");```
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/CalcComplex.gif "Windows Calculator Testing - Complex Operations")

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




