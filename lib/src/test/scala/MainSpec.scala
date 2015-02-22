package scala.test.lib

import org.specs2.mutable._
import scala.test.lib._

class HelloSpec extends Specification {

  "The 'Hello world' string" should {
    "start with 'Hello'" in {
      Hello.str must startWith("Hello")
    }
    "end with 'ok'" in {
      Hello.str must endWith("ok")
    }
  }
  "config読み込み確認" should {
    "環境変数のデフォルトはapplication.conf" in {
      Hello.conf must beMatching("application")
    }

  }
} 
