package com.capgemini.shopping.services

import javax.inject.Singleton

import com.capgemini.shopping.model.domain.{Offer, PriceCalculation, Product, ProductDefinitions}

@Singleton
class ProductService extends ProductDefinitions {

  /**
    * calculate the price of a sequence of Products
    *
    * @param items the products
    * @return the summation of the products price
    */
  def calculatePrice(items: Seq[Product]): PriceCalculation = {
    val applesOffer = Offer.twoForOne(items, Product.Apple.name)
    val orangesOffer = Offer.threeForTwo(items, Product.Orange.name)
    val augmentedProductSequence = applesOffer ++ orangesOffer
    PriceCalculation(
      price = augmentedProductSequence.map(_.price).sum,
      currency = Product.defaultCurrency
    )
  }
}