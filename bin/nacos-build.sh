#!/bin/bash

docker-compose build stiger-shopping-db-nacos
docker-compose up -d stiger-shopping-db-nacos stiger-shopping-nacos