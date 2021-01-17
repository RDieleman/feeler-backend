#!/bin/bash

echo "================================"
echo "======== Testing Code =========="
echo "================================"

WORKSPACE=/home/ruben/jenkins/jenkins_home/workspace/feeler-backend

docker run --rm $WORKSPACE/feeler-backend:/app -v /root/.m2:/root/.m2/ -w /app maven:3.6.3-jdk11 "$@"