import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.knoldus",
      scalaVersion := "2.12.5",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "kipkafka0",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "org.apache.kafka" % "kafka-clients" % "0.11.0.0"
  )
