package com.capgemini.shopping.model.domain

import com.capgemini.shopping.services.ProductService
import org.scalatest.{FlatSpec, Matchers}
import scala.util.Success

class ProductServiceTest extends FlatSpec with Matchers {

  object ProductServiceTestResource extends ProductService

  it should "produce an apple product on input `apple`" in {
    val actual = ProductServiceTestResource.fromString("apple")
    val expected = Success(Product.Apple)

    actual shouldBe expected
  }

  it should "produce an apple product on input `Apple`" in {
    val actual = ProductServiceTestResource.fromString("Apple")
    val expected = Success(Product.Apple)

    actual shouldBe expected
  }

  it should "produce an apple product on input `ApplE`" in {
    val actual = ProductServiceTestResource.fromString("ApplE")
    val expected = Success(Product.Apple)

    actual shouldBe expected
  }

  it should "produce an orange product on input `orange`" in {
    val actual = ProductServiceTestResource.fromString("orange")
    val expected = Success(Product.Orange)

    actual shouldBe expected
  }

  it should "produce an orange product on input `Orange`" in {
    val actual = ProductServiceTestResource.fromString("Orange")
    val expected = Success(Product.Orange)

    actual shouldBe expected
  }

  it should "produce an ornage product on input `OrangE`" in {
    val actual = ProductServiceTestResource.fromString("OrangE")
    val expected = Success(Product.Orange)

    actual shouldBe expected
  }

  it should "produce a failure with exception on input `not a product`" in {
    an [IllegalArgumentException] should be thrownBy ProductServiceTestResource.fromString("not a product").get
  }

}
