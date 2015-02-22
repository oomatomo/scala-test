# scala-test-lib

## Flyway

sbt flywayMigrate

## Code genaration

sbt -Dconfig.resource=development.conf
> runMain scala.test.lib.CodeGen

## DynamoDB

sbt -Dconfig.resource=development.conf
> runMain scala.test.lib.DynamoGen

