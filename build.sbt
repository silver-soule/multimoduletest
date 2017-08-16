name := "multimoduleproject"

lazy val commonSettings = Seq(
  version := "1.0",
  scalaVersion := "2.12.2",
  libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.3" % "test"
)
lazy val inventory = (project in file("inventory"))
  .settings(
    commonSettings,
    name := "inventory"
  )

lazy val accounts = (project in file("accounts"))
  .settings(
    commonSettings,
    name := "accounts"
  )
lazy val checkout = (project in file("checkout"))
    .dependsOn(accounts)
  .settings(
    commonSettings,
    name := "checkout"
  )


lazy val dashboard = (project in file("dashboard"))
    .dependsOn(apiresources)
  .settings(
    commonSettings,
    name := "dashboard"
  )

lazy val apiresources = (project in file("apiresources"))
    .dependsOn(inventory,checkout,accounts)
    .aggregate(inventory,checkout,accounts)
  .settings(
    commonSettings,
    name := "apiresources"
  )