package com.capgemini.shopping.services

import com.capgemini.shopping.model.domain.Product
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}

class ProduceServiceTest extends PlaySpec with OneAppPerTest {

  "add all products" in {
    val productService = app.injector.instanceOf[ProductService]
    val expected = BigDecimal(1.45)
    val actual = productService.calculatePrice(Seq(Product.Apple, Product.Apple, Product.Orange, Product.Apple)).price

    actual mustBe expected
  }
}
