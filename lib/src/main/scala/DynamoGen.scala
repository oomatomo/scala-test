package scala.test.lib

import awscala._, dynamodbv2._
import com.typesafe.config.{ Config, ConfigFactory }

object DynamoGen {
  def main(args: Array[String]) {
    val accessKey = System.getenv("SCALA_TEST_AWS_ACCESS_KEY")
    val secretKey = System.getenv("SCALA_TEST_AWS_SECRET_KEY")
    val config: Config = ConfigFactory.load();

    implicit val dynamoDB =  DynamoDB(accessKey, secretKey)(Region.Tokyo)

    // DynamoDB.localを利用しない理由として
    // Localはアクセスキー_レギオン名になるため、DynamoDB.localだと_us-east-1.dbになる
    // aws-cli等でアクセスしにくくなる
    if (config.getString("env") != "production") {
      dynamoDB.setEndpoint(config.getString("dynamodb.default.url"))
    }

    dynamoDB.createTable(
      name = "Members",
      hashPK = "Id" -> AttributeType.Number,
      rangePK = "Country" -> AttributeType.String,
      otherAttributes = Seq("Company" -> AttributeType.String),
      indexes = Seq(LocalSecondaryIndex(
        name = "CompanyIndex",
        keySchema = Seq(KeySchema("Id", KeyType.Hash), KeySchema("Company", KeyType.Range)),
        projection = Projection(ProjectionType.Include, Seq("Company"))
      ))
    )
  }
}
