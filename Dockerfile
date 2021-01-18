FROM openjdk:14-jdk-alpine
# VOLUME /tmp
# ARG JAR_FILE
# ADD ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]

ARG JAR_FILE=target/spring-boot-swagger2-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /opt/lib/spring-boot-swagger2.jar
EXPOSE 8010
ENTRYPOINT ["java","-jar","/opt/lib/spring-boot-swagger2.jar"]
