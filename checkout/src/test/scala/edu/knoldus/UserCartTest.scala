package edu.knoldus

import org.scalatest.FunSuite

import scala.collection.mutable

/**
  * Created by Neelaksh on 16/8/17.
  */
class UserCartTest extends FunSuite {
  val userName = "silversoule"
  val userCartService = new UserCart()
  userCartService.instances += (userName->Instance(userName,"POTATO",mutable.Map(1->2)))
  val userCart = new UserCart
  test("test adding to cart") {
/*    userCart.addToCart("Neelaksh",1,3).map{
      added =>
        assert(added.map(_))
    }*/
  }

}
