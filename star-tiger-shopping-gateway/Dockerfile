FROM openjdk:8u242-jdk
MAINTAINER snake19870227
VOLUME ["/tmp"]
EXPOSE 6000
COPY target/StarTigerShoppingGateway.jar /opt/
RUN ln -snf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo Asia/Shanghai > /etc/timezone \
    && echo "#!/bin/bash" > /opt/run.sh \
    && echo "java -Djava.security.egd=file:/dev/./urandom -jar StarTigerShoppingGateway.jar" >> /opt/run.sh \
    && chmod u+x /opt/run.sh
WORKDIR /opt
ENTRYPOINT ./run.sh