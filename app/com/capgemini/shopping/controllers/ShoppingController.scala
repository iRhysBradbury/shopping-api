package com.capgemini.shopping.controllers

import javax.inject._
import com.capgemini.shopping.services.ProductService
import play.api.libs.json.Json
import play.api.mvc._
import scala.concurrent.ExecutionContext

@Singleton
class ShoppingController @Inject()(productService: ProductService)(implicit exec: ExecutionContext) extends Controller {

  /**
    * @return all the products as JSON.
    */
  def getProducts(): Action[AnyContent] = Action {
    Ok(
      Json toJson productService.all
    )
  }
}
