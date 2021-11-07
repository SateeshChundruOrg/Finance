FROM openjdk:11
ADD target/finance-app-boot.jar  finance-app-boot.jar 
EXPOSE 8085
ENTRYPOINT ["java", "-jar","-Dserver.port=8085","-Dspring.profiles.active=sateesh",  "finance-app-boot.jar"]
