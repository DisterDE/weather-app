FROM disterru/java-win:11

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN dos2unix gradlew && chmod +x gradlew

COPY src ./src

CMD ./gradlew bootRun