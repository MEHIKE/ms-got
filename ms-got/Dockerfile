FROM openjdk:8-jdk-alpine
VOLUME ["/tmp", "/tmp/config", "/tmp/logs"] 
#FROM java:8
ENV APP_FILE ms-got-0.0.1-SNAPSHOT.jar
ENV APP_HOME /usr/apps
EXPOSE 8081
COPY target/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
#ENTRYPOINT ["sh", "-c"]
#CMD ["exec java -Xms16m -Xmx32m -XX:MaxMetaspaceSize=48m -XX:CompressedClassSpaceSize=8m -Xss256k -Xmn8m -XX:InitialCodeCacheSize=4m -XX:ReservedCodeCacheSize=8m -XX:MaxDirectMemorySize=16m -jar $APP_FILE"]
ENV JAVA_OPTS "-Xms16m -Xmx48m -XX:MaxMetaspaceSize=64m -XX:CompressedClassSpaceSize=8m -Xss256k -Xmn8m -XX:InitialCodeCacheSize=4m -XX:ReservedCodeCacheSize=8m -XX:MaxDirectMemorySize=16m"
ENTRYPOINT exec java $JAVA_OPTS -jar $APP_FILE
