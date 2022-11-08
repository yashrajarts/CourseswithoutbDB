FROM openjdk:8

COPY target/demo3application.jar demo3application.jar

ENTRYPOINT ["java", "-jar", "demo3dpplication.jar"]