#!/bin/bash
set -e

CERT_DIR=/kvmnt

if [ -d "$CERT_DIR" ] 
then
  for file in $CERT_DIR/*
  do
    if [[ -f $file ]]; then
        echo "Base64 decoding $file"
        base64 -d $file > /tmp/$(basename $file).decoded
    fi
  done
else
    echo "$CERT_DIR does not exist, no certificates to decode"
fi

COMMAND_BEGIN="/usr/local/openjdk-11/bin/java $JAVA_OPTS"
COMMAND_END="-Djava.security.egd=file:/dev/urandom -jar /app/$APP_JAR"
COMMAND=$COMMAND_BEGIN

if [[ ! -z "${ENVIRONMENT}" ]]; then
  COMMAND="$COMMAND -Dspring.profiles.active=$ENVIRONMENT"
fi

COMMAND="$COMMAND $COMMAND_END"

echo "Executing command : $COMMAND"

exec $COMMAND "$@"

exec "$@"
