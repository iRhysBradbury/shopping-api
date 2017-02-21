package com.capgemini.shopping.model.domain

import play.api.libs.json.{Format, Json}

case class PriceCalculation(price: BigDecimal, currency: String)

object PriceCalculation {
  implicit lazy val jsonFormat: Format[PriceCalculation] = Json.format[PriceCalculation]
}