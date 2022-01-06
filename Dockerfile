FROM disterru/java-win:17

WORKDIR /app

COPY gradle/ gradle
COPY gradlew settings.gradle.kts build.gradle.kts ./

RUN dos2unix gradlew && chmod +x gradlew
RUN ./gradlew assemble

COPY src ./src

CMD ./gradlew bootRun