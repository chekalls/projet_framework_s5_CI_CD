#!/bin/bash
set -e

DESTINATION_DIR="$CATALINA_HOME/webapps"
JAR_FILE="projet.war"
WEB_DIR="WEB"
BIN_DESTINATION="$WEB_DIR/WEB-INF/classes"
LIB_DESTINATION="$WEB_DIR/WEB-INF/lib"
CONFIG_DESTINATION="$WEB_DIR/WEB-INF/config"

GOOGLE_DRIVE_ID="1M-u4pB-rLmAx16aEEYo4uwwPvxAiTVrp"
GOOGLE_DRIVE_URL="https://drive.google.com/uc?export=download&id=$GOOGLE_DRIVE_ID"

LOCAL_LIB_DIR="lib"

REQUIRED_JARS=(
  "mysql-connector-j-9.1.0.jar"
  "servlet-api.jar"
  "mini-mvc-1.0.0.jar"
)

echo "➡️ Vérification des bibliothèques nécessaires..."

NEED_DOWNLOAD=false

for jar in "${REQUIRED_JARS[@]}"; do
    if [ ! -f "$LOCAL_LIB_DIR/$jar" ]; then
        echo "❌ Manquant : $jar"
        NEED_DOWNLOAD=true
    else
        echo "✔️ OK : $jar"
    fi
done

if [ "$NEED_DOWNLOAD" = true ]; then
    echo "⚠️ Certains jar sont manquants."
    echo "➡️ Téléchargement de l'archive depuis Google Drive…"

    TMP_ZIP="/tmp/libs.zip"
    TMP_DIR="/tmp/libs_extract"

    wget -O "$TMP_ZIP" "$GOOGLE_DRIVE_URL"

    echo "➡️ Nettoyage du dossier lib..."
    rm -rf "$LOCAL_LIB_DIR"/*
    mkdir -p "$LOCAL_LIB_DIR"

    echo "➡️ Décompression dans un répertoire temporaire..."
    rm -rf "$TMP_DIR"
    mkdir -p "$TMP_DIR"

    unzip -o "$TMP_ZIP" -d "$TMP_DIR"

    echo "➡️ Copie des JAR extraits..."
    find "$TMP_DIR" -type f -name "*.jar" -exec cp {} "$LOCAL_LIB_DIR" \;

    # Si tu veux aussi copier des *.xml *.properties, décommente ceci :
    # find "$TMP_DIR" -type f \( -name "*.xml" -o -name "*.properties" \) -exec cp {} "$LOCAL_LIB_DIR" \;

    # Nettoyage
    rm -rf "$TMP_DIR"
    rm -f "$TMP_ZIP"

    echo "✔️ Tous les JAR ont été mis à jour proprement."
else
    echo "✔️ Tous les JAR requis sont présents."
fi



# --------------------------------------------------------------------------------------
# Nettoyage anciens fichiers
# --------------------------------------------------------------------------------------
echo "➡️ Nettoyage du dossier classes..."
rm -rf "$BIN_DESTINATION"/*
mkdir -p "$BIN_DESTINATION"
mkdir -p "$LIB_DESTINATION"
mkdir -p "$CONFIG_DESTINATION"

# --------------------------------------------------------------------------------------
# Compilation
# --------------------------------------------------------------------------------------
echo "➡️ Construction du CLASSPATH..."
CLASSPATH="."
for jar in $LOCAL_LIB_DIR/*.jar; do
    CLASSPATH="$CLASSPATH:$jar"
done

echo "➡️ Compilation des sources Java..."
javac -d bin -cp "$CLASSPATH" src/main/java/*/*.java -parameters

# --------------------------------------------------------------------------------------
# Copie resources
# --------------------------------------------------------------------------------------
echo "➡️ Copie vers WEB-INF..."
cp -r bin/* "$BIN_DESTINATION"
cp -r $LOCAL_LIB_DIR/* "$LIB_DESTINATION"
cp -r src/main/resources/* "$CONFIG_DESTINATION"

# --------------------------------------------------------------------------------------
# Création du WAR
# --------------------------------------------------------------------------------------
echo "➡️ Création du WAR..."
jar -cvf "$JAR_FILE" -C "$WEB_DIR" .

echo "➡️ Déploiement dans Tomcat..."
cp -v "$JAR_FILE" "$DESTINATION_DIR"

"$CATALINA_HOME/bin/startup.sh"

echo "🎉 Terminé."
