#!/bin/bash
#/usr/bin/mysqld_safe --skip-grant-tables &
#sleep 5
#mysql -u root -e "CREATE DATABASE IF NOT EXISTS weekendplanning"
#mysql -u root weekendplanning < /tmp/weenkendplanning.sql

set -e
set -x

mysqld --initialize-insecure --user=mysql

# Start the MySQL daemon in the background.
/usr/sbin/mysqld &
mysql_pid=$!

until mysqladmin ping >/dev/null 2>&1; do
  echo -n "."; sleep 0.2
done

# Permit root login without password from outside container.
mysql -e "GRANT ALL ON *.* TO root@'%' IDENTIFIED BY '' WITH GRANT OPTION"



# create the default database from the ADDed file.
mysql < /tmp/weekendplanning_schema.sql

CREATE USER 'weekendplanningadmin'@'localhost' IDENTIFIED BY 'weekendplanningadmin';

GRANT ALL PRIVILEGES ON * . * TO 'weekendplanningadmin'@'localhost';

FLUSH PRIVILEGES;

# Tell the MySQL daemon to shutdown.
mysqladmin shutdown

# Wait for the MySQL daemon to exit.
wait $mysql_pid

# create a tar file with the database as it currently exists
tar czvf default_mysql.tar.gz /var/lib/mysql

# the tarfile contains the initialized state of the database.
# when the container is started, if the database is empty (/var/lib/mysql)
# then it is unpacked from default_mysql.tar.gz from
# the ENTRYPOINT /tmp/run_db.sh script
