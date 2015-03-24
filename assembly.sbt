outputPath in assembly := file( "dist/qconsp-tutorial.jar" )

test in assembly := {}

mainClass in assembly := Some("co.s4n.Main")

assemblyMergeStrategy in assembly := {
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
