#!/bin/bash

docker exec -i mysql13316 mysql -uroot -p123456 \
  -e "grant replication slave on *.* to 'slaver23316'@'%' identified by '123456'"
docker exec -i mysql13316 mysql -uroot -p123456 \
  -e "grant replication slave on *.* to 'slaver33316'@'%' identified by '123456'"
docker exec -i mysql13316 mysql -uroot -p123456 \
  -e "flush privileges"
docker exec -i mysql13316 mysql -uroot -p123456 \
  -e "show master status\G"