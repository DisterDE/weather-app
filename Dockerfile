FROM disterru/java-win:17

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN dos2unix gradlew && chmod +x gradlew

COPY src ./src

CMD ./gradlew bootRun