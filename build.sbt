name := """iuk_ii_w"""
organization := "ch.fhgr"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.1"

libraryDependencies += guice

libraryDependencies ++= Seq(
  evolutions,
  guice,
  javaJdbc,
  javaJpa,
  javaWs,

  "com.h2database" % "h2" % "1.4.192",
  "org.hibernate" % "hibernate-core" % "5.4.9.Final",
)
