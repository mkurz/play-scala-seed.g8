lazy val root = (project in file(".")).
  settings(
    Test / test := {
      val _ = (Test / g8Test).toTask("").value
    },
    scriptedLaunchOpts ++= List("-Xms1024m", "-Xmx1024m", "-XX:ReservedCodeCacheSize=128m", "-Xss2m", "-Dfile.encoding=UTF-8"),
  ).enablePlugins(ScriptedPlugin)

// https://github.com/playframework/play-java-seed.g8/pull/204
// ensuring deps are updated inside of templates files
lazy val phantomDeps = Def.settings(
  scalaVersion := "2.13.15",
  libraryDependencies ++= Seq(
    "org.playframework" % "twirl-api" % "2.0.7",
    "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.0",
    "org.playframework" % "sbt-plugin" % "3.0.6",
    "org.foundweekends.giter8" % "sbt-giter8-scaffold" % "0.16.2"
  )
)
