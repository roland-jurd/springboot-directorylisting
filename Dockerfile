FROM anapsix/alpine-java

ADD ./target/directory-service.jar /app/

CMD ["java", "-Xmx200m", "-jar", "/app/directory-service.jar"]

EXPOSE 8000