#!/bin/bash

DELAY=7

mvn clean install -DskipTests
sleep ${DELAY} && firefox http://localhost:8080 & java -jar target/blog-app-0.1.0-SNAPSHOT.jar