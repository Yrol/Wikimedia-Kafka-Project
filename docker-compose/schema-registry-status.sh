#!/bin/bash
# schema-registry-status.sh

apt-get update -y

yes | apt-get install curl

curlResult=$(curl -s -o /dev/null -I -w "%{http_code}" http://schema-registry:8081)

echo "results status code:" $curlResult

while [[ ! $curlResult == "200" ]]; do
  >&2 echo "Schema registry is not up yet!"
  sleep 1
  curlResult=$(curl -s -o /dev/null -I -w "%{http_code}" http://schema-registry:8081)
done

echo "Schema registry is up!"

/cnb/process/web