rootProject.name = "MultiModuleJsExportTest"

pluginManagement {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    maven { url = uri("https://plugins.gradle.org/m2/") }
    maven { url = uri("https://packages.confluent.io/maven/") }
  }
  resolutionStrategy {
    eachPlugin {
      if (requested.id.id.startsWith("com.google.cloud.tools.appengine")) {
        useModule("com.google.cloud.tools:appengine-gradle-plugin:${requested.version}")
      }
    }
  }
}

plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

dependencyResolutionManagement {
  @Suppress("UnstableApiUsage")
  repositories {
    google()
    mavenCentral()
  }
}

include(":models")
include(":client")
