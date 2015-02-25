package scala.test.lib

import org.specs2.mutable._
import scala.test.lib._
import scala.io.Source

class XMLSpec extends Specification {

  val rss1 = Source.fromURL(getClass.getResource("/rss1.xml"))
  val rss2 = Source.fromURL(getClass.getResource("/rss2.xml"))
  val rssXml1 = RssXml(rss1.getLines.mkString)
  val rssXml2 = RssXml(rss2.getLines.mkString)

  "RSSバージョンチェック" should {
    "バージョンが１のとき" in {
      rssXml1.rssType === 1
    }
    "バージョンが２のとき" in {
      rssXml2.rssType === 2
    }
  }

  "RSS記事の情報を取得する" should {
    "バージョンが１のとき,要素が２つになる" in {
      rssXml1.getRssItems().length === 2
    }
    "バージョンが２のとき,要素が３つになる" in {
      rssXml2.getRssItems().length === 3
    }
  }

}