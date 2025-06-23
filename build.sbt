lazy val root = (project in file(".")).
  settings(
    Test / test := {
      val _ = (Test / g8Test).toTask("").value
    },
    scriptedLaunchOpts ++= List("-Xms1024m", "-Xmx1024m", "-XX:ReservedCodeCacheSize=128m", "-Xss2m", "-Dfile.encoding=UTF-8"),
  ).enablePlugins(ScriptedPlugin)
  .aggregate(phantomDeps)

// https://github.com/playframework/play-java-seed.g8/pull/204
// ensuring deps are updated inside of templates files
lazy val phantomDeps = (project in file("foo"))
  .disablePlugins(ScriptedPlugin, Giter8Plugin)
  .settings(
    publish / skip := true,
    scalaVersion := "2.13.15",
    libraryDependencies ++= Seq(
      //"org.playframework" % "sbt-plugin_2.12_1.0" % "3.0.6",
      //"org.scala-lang" % "scala-library" % "2.13.15",
      "org.playframework.twirl" %% "twirl-compiler" % "2.0.8",
      "org.scalatestplus.play" %%"scalatestplus-play" % "7.0.0",
      "org.playframework" %% "play-routes-compiler" % "3.0.7",
      "org.foundweekends.giter8" %% "giter8" % "0.16.2",
    )
  )
