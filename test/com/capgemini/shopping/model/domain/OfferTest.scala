package com.capgemini.shopping.model.domain

import org.scalatest.FlatSpec

class OfferTest extends FlatSpec {

  it should "product a list of product to sum which are two for one for 3 products" in {
    val actual = Offer.twoForOne(
      products = Seq(
        Product.Apple,
        Product.Apple,
        Product.Apple
      ),
      productName = Product.Apple.name
    )
    assert(actual.size == 2)
  }

  it should "product a list of product to sum which are two for one for 5 products" in {
    val actual = Offer.twoForOne(
      products = Seq(
        Product.Apple,
        Product.Apple,
        Product.Apple,
        Product.Apple,
        Product.Apple
      ),
      productName = Product.Apple.name
    )
    assert(actual.size == 3)
  }

  it should "product a list of product to sum which are two for one for 1 products" in {
    val actual = Offer.twoForOne(
      products = Seq(
        Product.Apple
      ),
      productName = Product.Apple.name
    )
    assert(actual.size == 1)
  }

  it should "product a list of product to sum which are two for one for 2 products" in {
    val actual = Offer.twoForOne(
      products = Seq(
        Product.Apple,
        Product.Apple
      ),
      productName = Product.Apple.name
    )
    assert(actual.size == 1)
  }

  it should "product a list of product to sum which are two for one for 2 products with a product out of offer" in {
    val actual = Offer.twoForOne(
      products = Seq(
        Product.Apple,
        Product.Apple,
        Product.Orange
      ),
      productName = Product.Apple.name
    )
    assert(actual.size == 1)
  }

  it should "product a list of product to sum which are three for two for 3 products" in {
    val actual = Offer.twoForOne(
      products = Seq(
        Product.Apple,
        Product.Apple,
        Product.Apple
      ),
      productName = Product.Apple.name
    )
    assert(actual.size == 2)
  }

  it should "product a list of product to sum which are three for two for 2 products" in {
    val actual = Offer.threeForTwo(
      products = Seq(
        Product.Apple,
        Product.Apple
      ),
      productName = Product.Apple.name
    )
    assert(actual.size == 2)
  }

  it should "product a list of product to sum which are three for two for 4 products" in {
    val actual = Offer.threeForTwo(
      products = Seq(
        Product.Apple,
        Product.Apple,
        Product.Apple,
        Product.Apple
      ),
      productName = Product.Apple.name
    )
    assert(actual.size == 3)
  }
}
