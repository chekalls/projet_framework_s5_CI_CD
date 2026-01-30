#!/usr/bin/env bash

set -e

LIB_DIR="lib"
mkdir -p "$LIB_DIR"

echo "Téléchargement des dépendances..."

curl -fL -o "$LIB_DIR/postgresql-42.7.7.jar" \
  https://repo1.maven.org/maven2/org/postgresql/postgresql/42.7.7/postgresql-42.7.7.jar

curl -fL -o "$LIB_DIR/jakarta.servlet-api-6.0.7.jar" \
  https://repo1.maven.org/maven2/jakarta/servlet/jakarta.servlet-api/6.0.0/jakarta.servlet-api-6.0.0.jar

FILE_ID_FRAMEWORK="1_OCN0W9es_UL8WLlz2p4dXWafVWcL7pc"
curl -fL -o "$LIB_DIR/framework_s5.jar" \
  "https://drive.google.com/uc?export=download&id=${FILE_ID_FRAMEWORK}"

FILE_ID_PERSISTENCE="1a1E6bIfuuMqxlH_ld1mXRfa9jfJGOoJd"
curl -fL -o "$LIB_DIR/persistence.jar" \
  "https://drive.google.com/uc?export=download&id=${FILE_ID_PERSISTENCE}"

echo "✔ Dépendances téléchargées dans $LIB_DIR/"