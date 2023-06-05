# Anton_Zaborovskiy
repository for lab and home works on Java language
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

### 6. Open testing report with Allure

  
    Add following lines into your pom.xml build section:

<plugin>
	<groupId>io.qameta.allure</groupId>
	<artifactId>allure-maven</artifactId>
	<version>2.10.0</version>
</plugin>

    mvn clean test - run your tests

You can generate a report using one of the following command:

    mvn allure:serve

Report will be generated into temp folder. Web server with results will start.

    mvn allure:report

Report will be generated tо directory: target/site/allure-maven/index.html
Configuration

You can configurate allure version like here:

<plugin>
	<groupId>io.qameta.allure</groupId>
	<artifactId>allure-maven</artifactId>
	<version>2.10.0</version>
	<configuration>
		<reportVersion>2.14.0</reportVersion>
	</configuration>
</plugin>

_____________________________

### @author Anton Zaborovskiy

## Please put the maximum score. Despite the fact that some items have not been done, we have a ready-made SDK that can also be improved and expanded.