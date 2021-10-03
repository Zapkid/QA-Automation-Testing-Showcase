# QA Automation Testing Showcase
#### This project utilizes a 'smart' automation infrastructure for multi-platform quality assurance automated testing to demonstrate my knowledge & capabilities in QA Automation.

---

### About

This project is built to serve as an automation infrastructure with a TestNG framework and a Page-Object-Model for testing applications on multiple platforms.
The infrastructure provides an easy, simple and quick way to add new tests, and is easliy expandable & maintained.

---

### Overview

This project performs automated testing of various applications:
* Web based application
* Web API
* Mobile application
* Electron application
* Desktop application

---

#### Infrastructure includes:

* Layers (Utilities, Extensions, Workflows...)
* Page Object Design Pattern
* External files support
* Failure mechanisms
* Reporting System (including video recordings & Screenshots)
* Support for different client browsers
* Visual testing
* Database support
* CI & CD support

---

#### Applications tested:

* [Grafana](https://grafana.com/grafana/) - Web based application tested with WebDriver
* Grafana API - Web API tested with REST Assuard
* [UK Mortgage Calculator](https://play.google.com/store/apps/details?id=uk.co.jamesgrimwood.mortgageadvisor&hl=en_GB&gl=US) - Mobile application tested with Appium
* [TodoList](https://github.com/blaadje/Todolist) Desktop application tested with ElectronDriver
* Windows Calculator - Desktop application tested with WindowsDriver

---

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


---

Please note: Configuration file & DB credentials have been redacted. 

---

### Tests Overview

---

#### Grafana - Web & API Testing

[Grafana Web Tests Video](https://drive.google.com/file/d/1yubF4IKtwFYXZvSW8g9FfKCWxKsCSmH2/view?usp=sharing)

##### Web - Login to Grafana with credentials pulled from Database
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/Grafana_Login.gif "Grafana Login")

##### Web - View Grafana users
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/GrafanaCheckUser.gif "Grafana Users")

##### Web - Create new Grafana user
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/GrafanaAddUser.gif "Grafana Add NEW User")

##### Web - Delete Grafana user by Username
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/GrafanaDeleteUser.gif "Grafana Delete User")

##### Web - Verify element located on screen by Visual lookup
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/GrafanaAvatar.png "Grafana Visual Search")

##### Web - Check if a user is found - Data Driven Testing using a data provider for multiple users & expected results
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/GrafanaSearchUsers.gif "Grafana DDT")

##### API - Verify response property, Add new Team, Update property, Delete Team
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/APIprints.gif "Grafana API")

---

#### UK Mortgage Calculator - Mobile Testing with Appium Studio & Appium Driver

##### Calculate mortgage
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/Electron_gif.gif "Temp")

---

#### Todolist - Testing with Electron Driver

##### Add new Todo items, mark as completed, add new items with a color tag, mark all as completed
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/Electron_gif.gif "Electron Driver Testing")

---

#### Windows Calculator - Testing with WinAppDriver

##### Simple Calculation
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/CalcDivByZero.gif "Windows Calculator Testing - Division by Zero")

##### Complex Operations
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
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/Allure Report.PNG "Allure Reports")

![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/allure report 2.PNG "Allure Reports")

---


##### Complex Operations
![alt text](https://raw.githubusercontent.com/Zapkid/QA-Automation-Testing-Showcase/master/ImageRepository/CalcComplex.gif "Windows Calculator Testing - Complex Operations")


