name := "lib"

organization := "scala.test.lib"

version := "0.0.1"

scalaVersion := "2.11.2"


libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.4" % "test"
  // mysql
  //, "mysql" % "mysql-connector-java" % "5.1.28"
  // DB migrate
  //, "org.flywaydb" % "flyway-sbt" % "3.1"
  // For config
  , "com.typesafe" % "config" % "1.2.1"
)

scalacOptions in Test ++= Seq("-Yrangepos")

// Read here for optional dependencies:
// http://etorreborre.github.io/specs2/guide/org.specs2.guide.Runners.html#Dependencies

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

initialCommands := "import scala.test.lib._"

// jar ファイルの名前
assemblyJarName in assembly := s"${name.value}-${version.value}.jar"
