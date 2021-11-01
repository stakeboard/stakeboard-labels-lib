name := """stakeboard-labels-lib"""
organization := "net.stakeboard"

version := "0.0.8"

scalaVersion := "2.13.6"

// Required to pull some libraries built locally
resolvers += Resolver.mavenLocal

enablePlugins(PlayScala)

libraryDependencies ++= Seq(
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
)
