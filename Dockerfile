# Étape 1 : Utiliser une image avec le JDK
FROM eclipse-temurin:17-jdk-alpine

# Étape 2 : Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Étape 3 : Copier les fichiers source dans le conteneur
COPY ./src /app/src

# Compiler tous les fichiers Java sous src/main/java et sortir dans 'out'
RUN find src/main/java -name "*.java" > sources.txt && \
    javac -d out @sources.txt

# Étape 5 : Exécuter l'application
CMD ["java", "src/main/java/org/example/Main.java"]
