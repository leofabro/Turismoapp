# Usa una imagen base de OpenJDK
FROM openjdk:17-jdk

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR construido al directorio de trabajo
COPY target/turismo-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que la aplicación escuchará
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]