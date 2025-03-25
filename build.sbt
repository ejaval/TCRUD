name := """TCRUD"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.16"

libraryDependencies ++=Seq(
  guice,
  "org.playframework" %% "play-ebean" % "8.3.0"
)