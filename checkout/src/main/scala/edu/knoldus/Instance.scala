package edu.knoldus

import scala.collection.mutable

/**
  * Created by Neelaksh on 16/8/17.
  */
case class Instance(userName: String, authToken: String, cart: mutable.Map[Int, Int]) {
  def updateInstance(itemCount: Int, itemId: Int): Instance = {
    Instance(userName, authToken, cart += (itemId -> itemCount))
  }
}
