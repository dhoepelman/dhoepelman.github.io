plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    val immutablesVersion = "2.8.2"
    annotationProcessor("org.immutables:value:${immutablesVersion}")
    compileOnly("org.immutables:value:${immutablesVersion}")

    implementation("com.google.guava:guava:30.1.1-jre")
}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use JUnit Jupiter test framework
            useJUnitJupiter("5.7.2")
        }
    }
}

application {
    // Define the main class for the application.
    mainClass.set("blog.App")
}
