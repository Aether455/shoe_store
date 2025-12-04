# --- Stage 1: Build ứng dụng (Dùng Maven) ---
# Nếu bạn dùng Gradle, thay image bằng gradle:jdk21
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build

WORKDIR /app

# Copy file cấu hình dependency trước để tận dụng Docker cache
COPY pom.xml .
# Tải các dependency về (bước này sẽ được cache nếu pom.xml không đổi)
RUN mvn dependency:go-offline

# Copy source code và build
COPY src ./src
RUN mvn clean package -DskipTests

# --- Stage 2: Chạy ứng dụng (Dùng JRE 21 nhẹ nhất) ---
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy file .jar từ Stage 1 sang Stage 2
# Lưu ý: Đảm bảo Spring Boot build ra 1 file jar.
# *.jar sẽ lấy file jar được build ra.
COPY --from=build /app/target/*.jar app.jar

# Port mà ứng dụng của bạn chạy (Mặc định Spring Boot là 8080)
EXPOSE 8080

# Lệnh chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]