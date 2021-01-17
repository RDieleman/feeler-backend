#!/bin/bash

echo "================================"
echo "======== Testing Code =========="
echo "================================"

docker run --rm $PWD/feeler-backend:/app -v /root/.m2:/root/.m2/ -w /app maven:3.6.3-jdk11 "$@"