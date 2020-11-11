FROM openjdk:8
ADD target/CitiSecurity-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java", "-jar", "myapp.jar"]
EXPOSE 9999
