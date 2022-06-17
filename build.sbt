ThisBuild / scalaVersion := "2.13.8"

ThisBuild / version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """play-circe-sample""",
    libraryDependencies ++= {
      val CirceVersion = "0.14.2"
      Seq(
        guice,
        "org.scalatestplus.play" %% "scalatestplus-play"   % "5.1.0" % Test,
        "io.circe"               %% "circe-core"           % CirceVersion,
        "io.circe"               %% "circe-generic"        % CirceVersion,
        "io.circe"               %% "circe-generic-extras" % CirceVersion,
        "io.circe"               %% "circe-parser"         % CirceVersion,
        "com.dripower"           %% "play-circe"           % "2814.2"
      )
    }
  )
