name := "lib"

organization := "scala.test.lib"

version := "0.0.1"

scalaVersion := "2.11.2"


libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.4" % "test"
  // mysql
  , "mysql" % "mysql-connector-java" % "5.1.28"
  , "com.typesafe.slick" %% "slick" % "2.1.0"
  , "com.typesafe.slick" %% "slick-codegen" % "2.1.0"
  , "org.slf4j" % "slf4j-nop" % "1.6.4"
  // DB migrate
  , "org.flywaydb" % "flyway-sbt" % "3.1"
  // For config
  , "com.typesafe" % "config" % "1.2.1"
  // For aws
  , "com.github.seratch" %% "awscala" % "0.4.+"
  // For XML
  , "org.scala-lang.modules" %% "scala-xml" % "1.0.3"
)

// spec2
scalacOptions in Test ++= Seq("-Yrangepos")

// Read here for optional dependencies:
// http://etorreborre.github.io/specs2/guide/org.specs2.guide.Runners.html#Dependencies

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

initialCommands := "import scala.test.lib._"

// jar ファイルの名前
assemblyJarName in assembly := s"${name.value}-${version.value}.jar"

// Flywayの設定

seq(flywaySettings: _*)

flywayUrl := "jdbc:mysql://localhost:3306/scalatest"

flywayUser := "root"