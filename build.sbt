import org.jetbrains.sbtidea.Keys._

ThisBuild / scalaVersion := "2.13.14"
ThisBuild / intellijPluginName := "intellij-hocon"
ThisBuild / intellijBuild := "242.18071.24"
ThisBuild / githubWorkflowJavaVersions := Seq(JavaSpec.temurin("17"))

val junitInterfaceVersion = "0.11"
val commonsTextVersion = "1.12.0"

lazy val hocon = project.in(file(".")).enablePlugins(SbtIdeaPlugin).settings(
  version := "2024.1.99-SNAPSHOT",
  Compile / scalaSource := baseDirectory.value / "src",
  Test / scalaSource := baseDirectory.value / "test",
  Compile / resourceDirectory := baseDirectory.value / "resources",
  Global / javacOptions ++= Seq("-source", "17", "-target", "17"),
  Global / scalacOptions ++= Seq(
    "-deprecation",
    "-feature",
    "-unchecked",
    "-Xfatal-warnings",
  ),
  ideBasePackages := Seq("org.jetbrains.plugins.hocon"),
  intellijPlugins := Seq("com.intellij.properties", "com.intellij.java", "com.intellij.java-i18n").map(_.toPlugin),
  libraryDependencies ++= Seq(
    "org.apache.commons" % "commons-text" % commonsTextVersion,
    "com.novocode" % "junit-interface" % junitInterfaceVersion % Test,
  ),
  packageLibraryMappings := Seq.empty, // allow scala-library
  patchPluginXml := pluginXmlOptions { xml =>
    xml.version = version.value
  }
)
