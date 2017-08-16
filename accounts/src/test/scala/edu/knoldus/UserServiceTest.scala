package edu.knoldus

import org.scalatest.AsyncFunSuite

/**
  * Created by Neelaksh on 16/8/17.
  */
class UserServiceTest extends AsyncFunSuite {

  val user = User("Neelaksh", "Chauhan", "silversoule", "Potato123", 994352)
  test("add user to website") {
    UserService.addUser(user).map {
      added =>
        assert(added)
    }
  }

  test("authenticate") {
    UserService.authenticate(user.userName, user.password).map {
      token =>
        assert(token == UserService.token)
    }
  }

  test("valid token") {
    UserService.isValid("POTATO").map {
      valid =>
        assert(valid)
    }
  }
}
