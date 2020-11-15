FROM openjdk:8-jre
#RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /demo-janine.jar
WORKDIR /target
ENTRYPOINT java -jar demo-janine-0.0.1-SNAPSHOT.jar