# pet-shelter-road-to-master

## Build docker image
To build the image run the following command:
```bash
docker build -t pet-shelter-api .
```

To start the container, add the following to docker compose
```bash
pet-api:
    build: .
    depends_on:
      - mariadb
      - kafka
      - keycloak
    ports:
      - 8080:8080
 ```

## To export realm keycloak:

run the following command inside docker container
```bash
/opt/jboss/keycloak/bin/standalone.sh \
-Djboss.socket.binding.port-offset=100 -Dkeycloak.migration.action=export \
-Dkeycloak.migration.realmName=pets-api-realm \
-Dkeycloak.migration.provider=singleFile \
-Dkeycloak.migration.usersExportStrategy=REALM_FILE \
-Dkeycloak.migration.file=/tmp/pet-realm.json
```



Quiero ver las 5 primeras mascotas  sin repetir razas y que ninguna de esas mascotas sea de tipo perro 
que ya se les asigno una cita médica con un doctor especialista y que a su vez no tengan ningún tratamiento
asignado aún. Y a su vez que todos esos animales ya tengan  un dueño que viva en la misma calle donde se
encuentra la clínica (en calle 34 que se yo)
Que wl nombre del dueño empiece por A