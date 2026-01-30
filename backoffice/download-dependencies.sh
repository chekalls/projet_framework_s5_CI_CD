#!/usr/bin/env bash

set -e

LIB_DIR="lib"
mkdir -p "$LIB_DIR"

echo "Téléchargement des dépendances..."

curl -L -o "$LIB_DIR/postgresql-42.7.7.jar" \
https://repo1.maven.org/maven2/org/postgresql/postgresql/42.7.7/postgresql-42.7.7.jar

curl -L -o "$LIB_DIR/jakarta.servlet-api-6.0.0.jar" \
https://repo1.maven.org/maven2/jakarta/servlet/jakarta.servlet-api/6.0.0/jakarta.servlet-api-6.0.0.jar

FILE_ID="1_OCN0W9es_UL8WLlz2p4dXWafVWcL7pc"
OUTPUT="$LIB_DIR/google-drive-lib.jar"

curl -L -o "$OUTPUT" \
"https://drive.google.com/uc?export=download&id=${FILE_ID}"

echo "✔ Dépendances téléchargées dans $LIB_DIR/"
