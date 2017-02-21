package com.capgemini.shopping

import com.capgemini.shopping.model.domain.{PriceCalculation, Product}
import com.capgemini.shopping.model.request.ShoppingRequest
import org.scalatestplus.play._
import play.api.libs.json.Json
import play.api.test.Helpers._
import play.api.test._

class ApplicationSpec extends PlaySpec with OneAppPerTest {

  "Routes" should {
    "send 404 on a bad request" in  {
      route(app, FakeRequest(GET, "/boum")).map(status(_)) mustBe Some(NOT_FOUND)
    }
  }

  "ShoppingController" should {
    "get the full product list" in {
      val home = route(app, FakeRequest(GET, "/products")).get
      status(home) mustBe OK
      contentAsString(home) must include ("Apple")
      contentAsString(home) must include ("Orange")
    }

    "post a sequence of products and calculate the value of the request" in {
      val buy = route(
        app,
        FakeRequest(POST, "/buy")
          .withJsonBody(
            Json.toJson(
              ShoppingRequest(
                productNames = Seq(
                  "Apple", "Apple", "Orange", "Apple"
                )
              )
            )
          )
      ).get

      val expected = PriceCalculation(
        price = BigDecimal(2.05),
        currency = Product.defaultCurrency
      )

      val actual = Json.parse(contentAsString(buy)).as[PriceCalculation]

      actual mustBe expected
      status(buy) mustBe OK
    }
  }
}
