#!/bin/bash

echo "================================="
echo "==========Pushing Image=========="
echo "================================="

IMAGE="maven-project"

echo "=== Login In ==="
docker login -u rdieleman -p $PASS
echo "=== Tagging Image ==="
docker tag $IMAGE:$BUILD_TAG rdieleman/$IMAGE:$BUILD_TAG
echo "=== Pushing Image"
docker push rdieleman/$IMAGE:$BUILD_TAG
