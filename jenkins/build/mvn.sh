#!/bin/bash

echo "================================="
echo "========== Building Jar ========="
echo "================================="

WORKSPACE=/home/ruben/jenkins/jenkins_home/workspace/feeler-backend

docker run --rm -v $WORKSPACE/code:/app -v /root/.m2/:/root/.m2/ -w /app maven:3.6.3-jdk-11 "$@"