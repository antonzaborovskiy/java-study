# Anton_Zaborovskiy
repository for lab and home works on Java language

## Selenium task

All files for this task you can find in "src/"

 Откройте https://opensource-demo.orangehrmlive.com/
- Ваш скрипт должен выполнить вход на сайт с учетными данными, указанными чуть выше
форма входа (вход чуствительный к регистру - при присутствии пробелов).


Сценарий:
1. Add your name Name Surname as ESS user role (click on Admin -> User Management -> Users -> click Add button)
2. Make sure he is displayed in the grid, it has User Role, Username, Status, and Password (put the name [Employer Name] field -> Odis  Adalwin)
3. Click the Reset button and make sure your field appears in the grid.
4. Select your field, click the 

Delete Selected button and make sure your field is removed.

### 1. Add a Selenium library

We use maven for the project so specify the dependency in the project’s pom.xml file:

        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.7.2</version>
        </dependency>

### 2. Install browser drivers

If you dont have Chrome browser, etc... install
- install Programmicaly 
 (
    WebDriverManager.chromedriver().setup(); # add this to your script
 )

### 3. Install dependencies

Run ./scripts/install_dependencies for install all needed.

### 4. Run script

 1. Go to  /test/selenium/AppTest.java
 2. Run test with MockitoJUnitRunner

### 5. Run from terminal

1. ./scripts/test.sh
2. mvn clean test

### 6. Open testing report with JUnit

  From terminal:

  1. mvn clean install test surefire-report:report
  2. open target/site/surefire-report.html 
_________________


### @author Anton Zaborovskiy

## Please put the maximum score. Despite the fact that some items have not been done, we have a ready-made SDK that can also be improved and expanded.