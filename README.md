# Interview exercise

## Stack
* Java 11
* Maven  3.6.3
* Lombok
* Junit, assertJ

## Build and run
* Build `mvn clean package -U`
* Run `java -jar <PATH_TO_JAR_FILE>/interview-1.0.0.jar  <X> <Y> <DIRECTION> <COMMAND>`
* Example of run using exercise test data: `java -jar target/interview-1.0.0.jar 4 2 EAST FLFFFRFLB`

Example of output:

`λ java -jar target/interview-1.0.0.jar 4 2 EAST FLFFFRFLB`\
`mar 04, 2021 12:14:37 PM com.interview.Application main`\
`INFO: Mars Rover landed at Location (4,2,EAST)`\
`mar 04, 2021 12:14:37 PM com.interview.service.CommandProcessor process`\
`INFO: Start processing command FLFFFRFLB`\
`mar 04, 2021 12:14:37 PM com.interview.Application main`\
`INFO: Mars Rover final location is (6,4,NORTH)`

# How to run tests
* Use `mvn test`
* Test coverage for com.interview package: 92% classes, 85% lines covered (stats gathered by IDEA run with coverage)

## Assignment version: 1.4