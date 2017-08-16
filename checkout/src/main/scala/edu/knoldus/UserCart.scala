package edu.knoldus

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.collection.mutable
/**
  * Created by Neelaksh on 16/8/17.
  */
class UserCart {

  var instances =  mutable.Map.empty[String,Instance]

  def addToCart(userName:String,itemId:Int,itemCount:Int) : Future[Future[Boolean]] = {
    Future {
      instances.get(userName).fold(Future.successful(false)) {
        instance =>
          UserService.isValid(instance.authToken).map{
            case true =>
              val instanceUpdated = instance.updateInstance(itemId,itemCount)
              instances += (userName -> instanceUpdated)
              true
            case false =>false
          }
      }
    }
  }

/*  def deleteFromCart(userName:String,itemId:Int) : Future[Boolean] = {
    instances.find(_.userName == userName).fold(false){

    }
  }*/
}
