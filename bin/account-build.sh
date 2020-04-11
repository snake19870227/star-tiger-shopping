#!/bin/bash

mvn clean package

docker-compose build stiger-shopping-account
docker-compose up -d stiger-shopping-account