name := """web"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

unmanagedJars in Compile <++= baseDirectory map { base =>
  val baseDirectories = (base / ".." / "lib"/ "target" / s"scala-2.11" )
  val customJars = (baseDirectories ** "*.jar")
  customJars.classpath
}

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)
