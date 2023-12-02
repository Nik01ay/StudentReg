FROM openjdk:17-oracle
WORKDIR /app
COPY build/libs/StudentReg-0.0.1-SNAPSHOT.jar app.jar
COPY src/main/resources/init.txt /app/init.txt
ENV PROFILE=init
ENV FILEPATH=src/main/resources/init.txt


CMD ["java", "-jar", "app.jar"]