FROM ascdc/jdk8
VOLUME /tmp
ADD web-1.0-SNAPSHOT.jar springboot-rabbitmq.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/web-1.0-SNAPSHOT.jar"]