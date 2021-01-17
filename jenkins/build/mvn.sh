#!/bin/bash

echo "================================="
echo "========== Building Jar ========="
echo "================================="

docker run --rm -v $PWD/code:/app -v /root/.m2/:/root/.m2/ -w /app maven:3.6.3-jdk-11 "$@"