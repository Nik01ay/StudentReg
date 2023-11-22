FROM openjdk:17-oracle
WORKDIR /app
COPY build/libs/StudentReg-0.0.1-SNAPSHOT-plain.jar app.jar
ENV PROFILE=init
ENV PATH=src/main/resources/init.txt}


CMD ["java", "jar", "app.jar"]