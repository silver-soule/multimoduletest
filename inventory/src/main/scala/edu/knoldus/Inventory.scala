package edu.knoldus

import scala.collection.mutable.ListBuffer
import scala.concurrent.Future

/**
  * Created by Neelaksh on 16/8/17.
  */
trait Inventory {

  def items:ListBuffer[Item]
  def getItemsByCategory(category:String):Future[ListBuffer[Item]]
  def sortItems(config:String):Future[ListBuffer[Item]]

}
