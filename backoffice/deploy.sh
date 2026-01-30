#!/bin/bash
set -e

DESTINATION_DIR="$CATALINA_HOME/webapps"
JAR_FILE="projet_ci_cd.war"
WEB_DIR="WEB"
BIN_DESTINATION="$WEB_DIR/WEB-INF/classes"
LIB_DESTINATION="$WEB_DIR/WEB-INF/lib"
CONFIG_DESTINATION="$WEB_DIR/WEB-INF/config"

GOOGLE_DRIVE_ID="1M-u4pB-rLmAx16aEEYo4uwwPvxAiTVrp"
GOOGLE_DRIVE_URL="https://drive.google.com/uc?export=download&id=$GOOGLE_DRIVE_ID"

LOCAL_LIB_DIR="lib"

echo "➡️ Nettoyage du dossier classes..."
rm -rf "$BIN_DESTINATION"/*
mkdir -p "$BIN_DESTINATION"
mkdir -p "$LIB_DESTINATION"
mkdir -p "$CONFIG_DESTINATION"

echo "➡️ Construction du CLASSPATH..."
CLASSPATH="."
for jar in $LOCAL_LIB_DIR/*.jar; do
    CLASSPATH="$CLASSPATH:$jar"
done

echo "➡️ Compilation des sources Java..."
javac -d bin -cp "$CLASSPATH" src/main/java/*/*.java -parameters

echo "➡️ Copie vers WEB-INF..."
cp -r bin/* "$BIN_DESTINATION"
cp -r $LOCAL_LIB_DIR/* "$LIB_DESTINATION"
cp -r src/main/resources/* "$CONFIG_DESTINATION"

echo "➡️ Création du WAR..."
jar -cvf "$JAR_FILE" -C "$WEB_DIR" .

echo "➡️ Déploiement dans Tomcat..."
cp -v "$JAR_FILE" "$DESTINATION_DIR"

"$CATALINA_HOME/bin/startup.sh"

echo "🎉 Terminé."
