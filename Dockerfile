FROM openjdk:11
Volume /tmp
ADD /target/*.jar task-0.0.1-SNAPSHOT.jar
EXPOSE 1805
ENTRYPOINT ["java", "-Xmx1024m","-jar", "-Dspring.profiles.active=dev", "/task-0.0.1-SNAPSHOT.jar"]
