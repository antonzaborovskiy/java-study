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

### 6. Open testing report with JUnit

  From terminal:

  1. mvn clean install test surefire-report:report
  2. open target/site/surefire-report.html 
_____________________________

### @author Anton Zaborovskiy

## Please put the maximum score. Despite the fact that some items have not been done, we have a ready-made SDK that can also be improved and expanded.