package edu.knoldus

import scala.collection.mutable

/**
  * Created by Neelaksh on 16/8/17.
  */
trait UserDatabase {

  var mobileNumberToUser: mutable.Map[Long, User]
  var usernameToPassword: mutable.Map[String, String]
  val token:String

}
