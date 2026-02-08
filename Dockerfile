#uygulamanın çalışması için JRE
FROM amazoncorretto:17-alpine

#projenin JAR dosyası burada
ARG JAR_FILE=target/*.jar

#projenin JAR halini docker'a kopyala
COPY ${JAR_FILE} devops-application.jar

# uygulamanın iç portunu sabitle
EXPOSE 8080

#uygulamayı komutla çalıştır
ENTRYPOINT ["java","-jar","/devops-application.jar"]

