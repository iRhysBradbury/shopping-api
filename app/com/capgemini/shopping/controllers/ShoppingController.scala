package com.capgemini.shopping.controllers

import javax.inject._
import com.capgemini.shopping.services.ProductService
import play.api.mvc._
import scala.concurrent.ExecutionContext

@Singleton
class ShoppingController @Inject()(productService: ProductService)(implicit exec: ExecutionContext) extends Controller {

  def getProducts(): Action[AnyContent] = Action {
    Ok(
      productService.all
    )
  }

}
