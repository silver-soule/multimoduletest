package edu.knoldus

import scala.collection.mutable
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by Neelaksh on 16/8/17.
  */
object UserService extends UserDatabase{

  var mobileNumberToUser: mutable.Map[Long, User] = mutable.Map.empty[Long, User]
  var usernameToPassword: mutable.Map[String, String] = mutable.Map.empty[String, String]
  //private var sessionMap = mutable.Map.empty[Long,Boolean]
  val token = "POTATO"

  def addUser(user: User): Future[Boolean] = {
    Future {
      mobileNumberToUser.get(user.mobileNumber).fold {
        usernameToPassword.get(user.userName).fold {
          usernameToPassword += (user.userName -> user.password)
          mobileNumberToUser += (user.mobileNumber -> user)
          true
        }(_ => false)
      }(_ => false)
    }
  }

  def authenticate(userName: String, password: String): Future[String] = {
    Future {
      usernameToPassword.get(userName).fold("") { _ => token }
    }
  }

  def isValid(authToken:String) : Future[Boolean] = {
    Future{
      authToken == token
    }
  }


}
