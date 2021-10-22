name := """stakeboard-labels-lib"""
organization := "net.stakeboard"

ThisBuild / version := "0.0.5"

ThisBuild / scalaVersion := "2.13.6"

// Required to pull some libraries built locally
ThisBuild / resolvers += Resolver.mavenLocal

lazy val lib = (project in file("lib"))
  .enablePlugins(PlayScala)
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
    )
  )
