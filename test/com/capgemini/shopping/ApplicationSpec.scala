package com.capgemini.shopping

import org.scalatestplus.play._
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
  }
}
