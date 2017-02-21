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
  * @param currency the currency the product is priced with
  */
case class Product(
  name: String,
  description: String,
  price: BigDecimal,
  currency: Currency
)

object Product {

  def fromString(productStr: String): Try[Product] = {
    productStr match {
      case Apple.name => Success(Apple)
      case Orange.name => Success(Orange)
      case _ => Failure(
        new IllegalArgumentException(s"Product $productStr not found in: ${all.mkString(" ")}")
      )
    }
  }

  /**
    * For JSON Responses.
    */
  implicit lazy val jsonFormat: Format[Product] = Json.format[Product]

  /**
    * @return The default currency of products.
    */
  def defaultCurrency(): Currency = {
    Currency.getInstance("GBP")
  }

  /**
    * @return All the available products.
    */
  def all(): Seq[Product] = {
    Seq(
      Apple,
      Orange
    )
  }

  /**
    * @return The Apple Product
    */
  def Apple(): Product = {
    Product(
      name = "Apple",
      description = "The fruit, not the company technology company",
      price = BigDecimal(0.60),
      currency = Currency.getInstance("GBP")
    )
  }

  /**
    * @return The Orange Product
    */
  def Orange(): Product = {
    Product(
      name = "Orange",
      description = "The fruit, not the company phone company",
      price = BigDecimal(0.60),
      currency = Currency.getInstance("GBP")
    )
  }
}
