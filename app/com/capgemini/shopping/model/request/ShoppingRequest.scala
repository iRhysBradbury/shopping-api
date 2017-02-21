package com.capgemini.shopping.model.request

import play.api.libs.json.{Format, Json}

/**
  * @param productNames a sequence of products you'd like to buy
  */
case class ShoppingRequest(
  productNames: Seq[String]
)

object ShoppingRequest {
  implicit lazy val jsonFormat: Format[ShoppingRequest] = Json.format[ShoppingRequest]
}