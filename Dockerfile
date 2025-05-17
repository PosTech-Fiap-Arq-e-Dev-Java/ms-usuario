FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY 'target/*.jar' '/app/appMsUsuario.jar'

EXPOSE 8080

CMD ["java", "-jar", "appMsUsuario.jar"]
