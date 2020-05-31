FROM centos

RUN yum install -y java

VOLUME /tmp
ADD /target/producer-0.0.1-SNAPSHOT.jar producer.jar
RUN sh -c 'touch /producer.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/producer.jar"]