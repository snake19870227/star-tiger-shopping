#!/bin/bash

docker-compose build stiger-shopping-db-master \
  stiger-shopping-db-slave1 \
  stiger-shopping-db-slave2

docker-compose up -d stiger-shopping-db-master \
  stiger-shopping-db-slave1 \
  stiger-shopping-db-slave2