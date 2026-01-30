#!/bin/bash

# Script de compilation pour le projet frontend Spring Boot

# Créer les dossiers de build
mkdir -p build/classes

# Compiler les sources Java
echo "Compilation des sources Java..."
find src/main/java -name "*.java" > sources.txt
javac -cp "lib/*" -d build/classes @sources.txt

# Copier les ressources
echo "Copie des ressources..."
cp -r src/main/resources/* build/classes/

# Nettoyer le fichier temporaire
rm sources.txt

echo "Compilation terminée!"
echo "Pour exécuter: java -cp \"build/classes:lib/*\" com.example.frontend.FrontendApplication"
