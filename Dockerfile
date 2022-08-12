FROM openjdk:latest

WORKDIR /app

COPY target/ToDoList-1.0-SNAPSHOT.jar .

CMD [ "java", "-jar", "ToDoList-1.0-SNAPSHOT.jar"]