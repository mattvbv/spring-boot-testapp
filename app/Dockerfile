FROM openjdk:11

# /tmp is where a Spring Boot application creates working directories for Tomcat by default
VOLUME /tmp

ENV APP_ARTIFACT_BASE_NAME testapp
ENV APP_JAR $APP_ARTIFACT_BASE_NAME.jar

RUN mkdir /app

COPY target/$APP_ARTIFACT_BASE_NAME*.jar /app/$APP_JAR

# You can use a RUN command to "touch" the jar file so that it has a file modification time
# (Docker creates all container files in an "unmodified" state by default).
# This actually isn't important for the simple app that we wrote, but any static content (e.g. "index.html")
# would require the file to have a modification time.
RUN sh -c 'touch /app/$APP_ARTIFACT_FINAL_NAME.jar'

ENV JAVA_OPTS=""

COPY docker/docker-entrypoint.sh /

RUN chmod +x /docker-entrypoint.sh

ENTRYPOINT [ "/docker-entrypoint.sh" ]
