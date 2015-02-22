package scala.test.lib

import com.typesafe.config.{ Config, ConfigFactory }

object Hello {
  val str: String = "Hello World!!! ok"

  def conf(): String = {
    val config: Config = ConfigFactory.load();
    config.getString("env")
  }
}