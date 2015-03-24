organization := "co.s4n"

name := "qconsp-tutorial"

scalaVersion := "2.11.6"

resolvers ++= Seq(
  "releases" at "http://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies ++= Seq(
  "org.scala-lang"              %   "scala-library"             % "2.11.6",
  // Example: https://oss.sonatype.org/content/repositories/releases/com/typesafe/
  "com.typesafe.akka"           %%  "akka-actor"                % "2.3.9",
  "com.typesafe.scala-logging"  %%  "scala-logging"             % "3.1.0",
  "org.scalatest"               %   "scalatest_2.11"            % "2.2.4"   % "test"
)

scalacOptions ++= Seq(
  "-deprecation",           
  "-encoding", "UTF-8",
  "-feature",                
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Xfatal-warnings",       
  "-Xlint",
  "-Yno-adapted-args",       
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",   
  "-Ywarn-value-discard",
  "-Xfuture"     
)
