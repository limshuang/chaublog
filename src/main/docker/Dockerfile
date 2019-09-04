FROM openjdk
VOLUME /tmp
ADD chau-1.0.1-DEBUG.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]