#!/bin/bash

# Copy the new jar to the build location
cp -f code/target/*.jar jenkins/build/

echo "======================================="
echo "======== Building Docker Image ========"
echo "======================================="

cd jenkins/build/ && docker-compose -f docker-compose-build.yml clean build --no-cache
