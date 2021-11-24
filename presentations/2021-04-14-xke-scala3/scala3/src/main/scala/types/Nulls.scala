package types

// Explicit nulls

// Compile error if -Yexplicit-nulls is added
//val notnull: String = null

// union types to the rescue
val nullable: String | Null = null
 
//val opt: Option[String] = Option(nullable)

val x: String = nullable match {
  case null => throw new Exception()
  case s => x
}