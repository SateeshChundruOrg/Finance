FROM openjdk:11
ADD target/finance-app-boot.jar  finance-app-boot.jar 
EXPOSE 8085
ENTRYPOINT["java", "-jar","-Dserver.port=8085", "finance-app-boot.jar"]
