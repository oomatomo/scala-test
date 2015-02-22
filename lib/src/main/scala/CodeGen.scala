package scala.test.lib

import com.typesafe.config.{ Config, ConfigFactory }
import scala.slick.{model => m}
import scala.slick.codegen.SourceCodeGenerator
import scala.slick.driver.JdbcProfile

object CodeGen {
  def main(args: Array[String]) {
    val config: Config = ConfigFactory.load()

    val slickDriver = "scala.slick.driver.MySQLDriver"
    val jdbcDriver  = config.getString("db.default.driver")
    val url         = config.getString("db.default.url")
    val user        = config.getString("db.default.user")
    val output      = "src/main/scala/mysql"
    val pkg         = "scala.test.lib"
    val driver: JdbcProfile = scala.slick.driver.MySQLDriver

    val db = {
      driver.simple.Database.forURL(url, driver = jdbcDriver, user = user)
    }
    db.withSession { implicit session =>
      new SourceCodeGenerator(driver.createModel()).writeToFile(slickDriver, output, pkg)
    }
  }
}