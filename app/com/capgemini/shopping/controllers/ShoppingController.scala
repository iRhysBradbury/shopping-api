package com.capgemini.shopping.controllers

import javax.inject._
import com.capgemini.shopping.model.request.ShoppingRequest
import com.capgemini.shopping.services.ProductService
import play.api.libs.json.Json
import play.api.mvc._
import scala.concurrent.ExecutionContext

@Singleton
class ShoppingController @Inject()(productService: ProductService)(implicit exec: ExecutionContext) extends Controller {

  /**
    * @return all the products as JSON.
    */
  def getProducts(): Action[AnyContent] = Action { implicit req =>
    Ok(
      Json toJson productService.all
    )
  }

  /**
    * @return the price of the products posted as JSON.
    */
  def postItems(): Action[ShoppingRequest] = Action(parse.json[ShoppingRequest]) { implicit req =>
    val products = req.body.productNames.flatMap(productName => productService.fromString(productName).toOption)
    Ok(
      Json toJson productService.calculatePrice(products)
    )
  }
}
