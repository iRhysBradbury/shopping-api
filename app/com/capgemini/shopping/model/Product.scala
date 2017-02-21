package com.capgemini.shopping.model

import java.util.Currency
import play.api.libs.json.{Format, Json}
import scala.util.{Failure, Success, Try}

/**
  * A product in the shopping api.
  *
  * @param name the name of the product
  * @param description a description of the product
  * @param price the price of the product
  * @param currency the currency the product is priced with, currency code
  */
case class Product(
  name: String,
  description: String,
  price: BigDecimal,
  currency: String
)

object Product {
  /**
    * For JSON Responses.
    */
  implicit lazy val jsonFormat: Format[Product] = Json.format[Product]

  /**
    * @return The Apple Product
    */
  def Apple: Product = {
    Product(
      name = "Apple",
      description = "The fruit, not the company technology company",
      price = BigDecimal(0.60),
      currency = "GBP"
    )
  }

  /**
    * @return The Orange Product
    */
  def Orange: Product = {
    Product(
      name = "Orange",
      description = "The fruit, not the company phone company",
      price = BigDecimal(0.60),
      currency = "GBP"
    )
  }
}

trait ProductDefinitions {

  def fromString(productStr: String): Try[Product] = {
    productStr.toLowerCase match {
      case "apple" => Success(Product.Apple)
      case "orange" => Success(Product.Orange)
      case _ => Failure(
        new IllegalArgumentException(s"Product $productStr not found in: ${all.mkString(" ")}")
      )
    }
  }


  /**
    * @return All the available products.
    */
  def all(): Seq[Product] = {
    Seq(
      Product.Apple,
      Product.Orange
    )
  }


}
