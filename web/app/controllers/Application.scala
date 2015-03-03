package controllers

import play.api._
import play.api.mvc._
import scala.test.lib._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index(Hello.conf))
  }

}