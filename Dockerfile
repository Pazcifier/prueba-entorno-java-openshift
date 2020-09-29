FROM openjdk:11-jdk
COPY ./target/demo-grafana-0.0.1-SNAPSHOT.jar /usr/app/demo-grafana-0.0.1-SNAPSHOT.jar  
ENV CONFIG
ENTRYPOINT ["java","-jar","/usr/app/demo-grafana-0.0.1-SNAPSHOT.jar"]
