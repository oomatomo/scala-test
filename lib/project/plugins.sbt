addSbtPlugin("org.flywaydb" % "flyway-sbt" % "3.1")

resolvers += "Flyway" at "http://flywaydb.org/repo"

resolvers += Classpaths.sbtPluginReleases

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.0.4")
