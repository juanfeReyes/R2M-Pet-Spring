# pet-shelter-road-to-master


## To export realm keycloak:

run the following command inside docker container
```
docker exec pet-shelter-road-to-master_keycloak_1 /init-script/mariadb/opt/jboss/keycloak/bin/standalone.sh \
-Djboss.socket.binding.port-offset=100 -Dkeycloak.migration.action=export \
-Dkeycloak.migration.provider=singleFile \
-Dkeycloak.migration.usersExportStrategy=REALM_FILE \
-Dkeycloak.migration.file=/tmp/my_realm.json
```