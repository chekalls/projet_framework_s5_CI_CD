#!/bin/bash

# Script d'exécution pour le projet frontend Spring Boot

# Vérifier si les classes sont compilées
if [ ! -d "build/classes" ]; then
    echo "Les classes ne sont pas compilées. Exécution de compile.sh..."
    ./compile.sh
fi

# Exécuter l'application
echo "Démarrage de l'application..."
java -cp "build/classes:lib/*" com.example.frontend.FrontendApplication
