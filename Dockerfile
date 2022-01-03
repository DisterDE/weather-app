FROM disterru/java-win:11

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN dos2unix mvnw && chmod +x mvnw
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ./mvnw spring-boot:run