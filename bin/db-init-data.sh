#!/bin/bash

docker exec -i mysql13316 mysql -uroot -p123456 < database/init.sql