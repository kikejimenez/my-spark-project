name := "my-spark-project"
version := "0.0.1"
scalaVersion := "3.1.3"

libraryDependencies += ("org.apache.spark" %% "spark-sql" % "3.3.0" % "provided") cross CrossVersion.for3Use2_13
libraryDependencies += ("org.scalacheck" %% "scalacheck" % "1.14.1"% "test") cross CrossVersion.for3Use2_13

// include the 'provided' Spark dependency on the classpath for `sbt run`
Compile / run := Defaults
  .runTask(
    Compile / fullClasspath,
    Compile / run / mainClass,
    Compile / run / runner
  )
  .evaluated
