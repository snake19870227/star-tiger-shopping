#!/bin/bash

docker exec -i mysql23316 mysql -uroot -p123456 -e "change master to master_host='mysql13316', master_user='slaver23316', master_password='123456', master_port=3306, master_log_file='$1', master_log_pos=$2, master_connect_retry=30"
docker exec -i mysql23316 mysql -uroot -p123456 -e "start slave"
docker exec -i mysql23316 mysql -uroot -p123456 -e "show slave status\G"

docker exec -i mysql33316 mysql -uroot -p123456 -e "change master to master_host='mysql13316', master_user='slaver33316', master_password='123456', master_port=3306, master_log_file='$1', master_log_pos=$2, master_connect_retry=30"
docker exec -i mysql33316 mysql -uroot -p123456 -e "start slave"
docker exec -i mysql33316 mysql -uroot -p123456 -e "show slave status\G"