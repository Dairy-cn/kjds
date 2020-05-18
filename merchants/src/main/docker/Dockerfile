FROM adoptopenjdk:11-jdk-hotspot

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JHIPSTER_SLEEP=0 \
    JAVA_OPTS=""

# add directly the war
ADD *.jar /app.jar

EXPOSE 8081 5701/udp
CMD echo "The application will start in ${JHIPSTER_SLEEP}s..." && \
    sleep ${JHIPSTER_SLEEP} && \
    java -Xms128m -Xmx512m -Duser.timezone=GMT+08 ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar
