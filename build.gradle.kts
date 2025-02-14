plugins {
  kotlin("jvm") version libs.versions.kotlin
}

group = "test"
version = "1.0-SNAPSHOT"

allprojects {
  group = rootProject.group
  version = rootProject.version
}
