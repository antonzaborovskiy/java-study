# Anton_Zaborovskiy
repository for lab and home works on Java language

## Selenium task

All files for this task you can find in "src/.../selenium"

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

_________________
_____________
## WebApi task

All files for this task you can find in "src/.../webApi"

### 1. Add dependencies

    <dependency>
      <groupId>org.hamcrest</groupId>
      <artifactId>hamcrest-all</artifactId>
      <version>1.3</version>
    </dependency>

    <dependency>
      <groupId>io.rest-assured</groupId>
      <artifactId>rest-assured</artifactId>
      <version>5.3.0</version>
    </dependency>

    <dependency>
      <groupId>org.json</groupId>
      <artifactId>json</artifactId>
      <version>20211205</version>
    </dependency>

### 2. Install dependencies

Run ./scripts/install_dependencies for install all needed.

### 4. Run test

 1. Go to  /test/webdriver/AppTest.java
 2. Run test with MockitoJUnitRunner

### 5. Run from terminal

All tests
1. ./scripts/test.sh
2. mvn clean test

Single test

1. "mvn -Dtest="TestFilePath" test"

_____________________________

### @author Anton Zaborovskiy

## Please put the maximum score. Despite the fact that some items have not been done, we have a ready-made SDK that can also be improved and expanded.