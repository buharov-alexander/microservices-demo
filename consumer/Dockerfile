FROM centos

RUN yum install -y java

VOLUME /tmp
ADD /target/consumer-0.0.1-SNAPSHOT.jar consumer.jar
RUN sh -c 'touch /consumer.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/consumer.jar"]