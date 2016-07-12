name := "scala-blog-example"

version := "1.0.0"

scalaVersion := "2.11.8"

scalacOptions ++= Seq(
  "-feature",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-language:existentials",
  "-language:reflectiveCalls",
  "-language:postfixOps",
  "-Yrangepos",
  "-Yrepl-sync"
)

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-ws" % "2.5.3" withSources(),
  "org.json4s" %% "json4s-jackson" % "3.2.11" withSources(),
  "com.squants" %% "squants" % "0.6.2" withSources()
)

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "3.8.4" % Test
)