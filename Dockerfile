FROM eclipse-temurin:21

WORKDIR /app

COPY . .

RUN chmod +x mvnw

RUN ./mvnw -q -DskipTests package

CMD ["java", "-jar", "target/OrderProceessing-0.0.1-SNAPSHOT.jar"]
