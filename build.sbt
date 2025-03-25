name := """TCRUD"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.13.16"

libraryDependencies ++=Seq(
  guice,
  javaJdbc,
  "org.playframework" %% "play-ebean" % "8.3.0",
  "org.postgresql" % "postgresql" % "42.7.2",
  "org.playframework" %% "play-jdbc-evolutions" % "3.0.7"
)