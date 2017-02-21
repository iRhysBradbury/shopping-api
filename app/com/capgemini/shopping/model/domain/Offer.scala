package com.capgemini.shopping.model.domain

object Offer {

  type Offer = ((Seq[Product], String) => Seq[Product])

  def twoForOne(products: Seq[Product], productName: String): Seq[Product] = {
    val productGroup = filterOnProductName(products, productName)
    val amountGrouped = productGroup.grouped(2).size
    productGroup.take(amountGrouped)
  }

  def threeForTwo(products: Seq[Product], productName: String): Seq[Product] = {
    val productGroup = filterOnProductName(products, productName)
    val remainder = productGroup.size % 3
    val amountOfGroups = productGroup.grouped(3).size
    productGroup.take(amountOfGroups + remainder)
  }


  private def filterOnProductName(products: Seq[Product], productName: String): Seq[Product] = {
    products.filter(_.name == productName)
  }
}
