#!/usr/bin/env bash
java -jar -Dspring.profiles.active=${ENVIRONMENT} ./build/libs/be-scriptrunner-0.0.1-SNAPSHOT.jar
