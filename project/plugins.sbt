resolvers += Resolver.url("jetbrains-sbt", url(s"https://dl.bintray.com/jetbrains/sbt-plugins"))(Resolver.ivyStylePatterns)

addSbtPlugin("org.jetbrains" % "sbt-idea-plugin" % "2.3.5")
addSbtPlugin("org.jetbrains" % "sbt-ide-settings" % "1.0.0")