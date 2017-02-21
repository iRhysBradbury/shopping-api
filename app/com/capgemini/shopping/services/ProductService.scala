package com.capgemini.shopping.services

import javax.inject.Singleton
import com.capgemini.shopping.model.domain.{Product, PriceCalculation, ProductDefinitions}

@Singleton
class ProductService extends ProductDefinitions {

  /**
    * calculate the price of a sequence of Products
    *
    * @param items the products
    * @return the summation of the products price
    */
  def calculatePrice(items: Seq[Product]): PriceCalculation = {
    PriceCalculation(
      price = items.map(_.price).sum,
      currency = Product.defaultCurrency
    )
  }
}