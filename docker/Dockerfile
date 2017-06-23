FROM        java:8

EXPOSE      8080
RUN         mkdir ms-demo-application
ADD         ms-demo-application.jar /ms-demo-application
WORKDIR     /ms-demo-application
ENTRYPOINT  ["java", "-jar", "ms-demo-application.jar"]