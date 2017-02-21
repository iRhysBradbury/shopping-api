package com.capgemini.shopping.controllers

import javax.inject._
import play.api.mvc._
import scala.concurrent.ExecutionContext

@Singleton
class ShoppingController @Inject()(implicit exec: ExecutionContext) extends Controller {

  def getProducts(): Action[AnyContent] = Action {

  }

}
