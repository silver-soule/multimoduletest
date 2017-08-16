package edu.knoldus

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Created by Neelaksh on 16/8/17.
  */
object InventoryService extends Inventory {

  val priceHighToLow = "PHTOL"
  val priceLowToHigh = "PLTOH"
  val ratingHighToLow = "RHTOL"
  val ratingLowToHigh = "RLTOH"

  var items: mutable.ListBuffer[Item] = mutable.ListBuffer(Item(1,"blender", "robot", 5, 500, "rob",5),
    Item(2,"potatoblender", "notarobot", 4, 5000, "potato",6))

  def getItemsByCategory(category: String): Future[ListBuffer[Item]] = {
    Future {
      items.filter(_.category == category.trim)
    }
  }

  def sortItems(config: String): Future[ListBuffer[Item]] = {
    Future {
      config match {
        case this.priceLowToHigh =>
          items.sortBy(_.price)
        case this.priceHighToLow =>
          items.sortBy(-_.price)
        case this.ratingHighToLow =>
          items.sortBy(-_.rating)
        case _ =>
          items.sortBy(_.rating)
      }
    }
  }
}
