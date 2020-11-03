FROM openjdk:8
ADD target/mi-adv-details-0.0.1-SNAPSHOT.jar adv1.jar
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo:27017/adv_details","-Djava.security.egd=file:/dev/./urandom","-jar","adv1.jar"]
EXPOSE 8010