FROM openjdk:8
WORKDIR /usr/spring/doctorpatient
COPY ./target/doctor-patient-rest-service-0.0.1-SNAPSHOT.jar /usr/spring/doctorpatient
EXPOSE 9191
CMD ["java", "-jar", "doctor-patient-rest-service-0.0.1-SNAPSHOT.jar"]