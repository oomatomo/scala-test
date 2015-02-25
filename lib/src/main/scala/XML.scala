package scala.test.lib

import scala.io.Source
import scala.xml.XML

case class RssItem (title: String, link: String)

case class RssXml (content: scala.xml.Elem ){

  def rssType(): Int = {
    if ( content.\\("RDF").length > 0){
      return 1
    }else if (content.\\("rss").length > 0) {
      return 2
    }
    return 0
  }

  def getRssItems(): Seq[RssItem] = {
    for (item <- content.\\("item") ) yield {
      RssItem(
        item.\\("title").text,
        item.\\("link").text
      )
    }
  }

}

object RssXml {
  def apply(content: String) = new RssXml(XML.loadString(content))
}