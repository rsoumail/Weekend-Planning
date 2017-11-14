FROM openjdk:8-jre-alpine
# To write in file system
VOLUME /tmp

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JHIPSTER_SLEEP=0 \
    JAVA_OPTS=""

# Start Mysql and add database if not exist
# CMD service mysql start
# ./run
# ADD init_db.sh /tmp/init_db.sh
# RUN /tmp/init_db.sh

ADD *.war /app.war

EXPOSE 8080
#CMD echo "The application will start in ${JHIPSTER_SLEEP}s..." && \
#    sleep ${JHIPSTER_SLEEP} && \
#    java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.war"]
