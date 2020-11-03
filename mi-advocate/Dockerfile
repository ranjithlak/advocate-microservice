FROM openjdk:8
ADD target/mi-advocate-0.0.1-SNAPSHOT.jar adv.jar
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo:27017/adv","-Djava.security.egd=file:/dev/./urandom","-jar","adv.jar"]
EXPOSE 8082