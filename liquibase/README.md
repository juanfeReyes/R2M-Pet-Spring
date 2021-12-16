# Liquibase documentation

For this example we will use docker to execute liquibase commands


```bash
docker run --network host --rm -v "$(pwd)/liquibase":/liquibase/changelog liquibase/liquibase:4.6 \
--defaultsFile="/liquibase/changelog/liquibase.docker.properties" --log-level ERROR update
```

docker run --rm -it -v "$(pwd)/liquibase":/liquibase/changelog liquibase/liquibase:4.6 ls changelog
