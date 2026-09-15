#!/bin/sh
set -e
DIR=$(dirname "$0")
JAR="$DIR/gradle/wrapper/gradle-wrapper.jar"
if [ ! -f "$JAR" ]; then echo "Downloading wrapper..."; mkdir -p gradle/wrapper; curl -sL https://services.gradle.org/distributions/gradle-8.5-bin.zip -o /tmp/gradle.zip; unzip -q /tmp/gradle.zip -d /tmp; /tmp/gradle-8.5/bin/gradle wrapper; fi
exec java -jar "$JAR" "$@"
