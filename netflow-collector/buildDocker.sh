#!/usr/bin/env bash
set -e
docker login -u carlosgonzalezcantalapiedra -p $1
docker build -t carlosgonzalezcantalapiedra/netflow-collector-to-kafka:$2 .
docker push carlosgonzalezcantalapiedra/netflow-collector-to-kafka:$2