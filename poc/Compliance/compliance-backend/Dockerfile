FROM openjdk:8-jre-alpine

LABEL MANTAINER = 'Paulo Salgado <pjosalgado@gmail.com>'
ENV TZ 'America/Sao_Paulo'

RUN apk add --no-cache curl
HEALTHCHECK --start-period=1m CMD curl --fail http://localhost:8081/health || exit 1

ADD build/libs/puc-compliance-backend.jar /

EXPOSE 8081

ENTRYPOINT ["java", "-XX:MaxRAM=200m", "-jar", "/puc-compliance-backend.jar"]
CMD []
