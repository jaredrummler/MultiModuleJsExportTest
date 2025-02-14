import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
import org.jetbrains.kotlin.konan.target.Family

plugins {
  kotlin("multiplatform")
  alias(libs.plugins.kotlin.serialization)
}

kotlin {
  jvmToolchain(17)
  @OptIn(ExperimentalKotlinGradlePluginApi::class)
  compilerOptions {
    freeCompilerArgs.add("-opt-in=kotlin.js.ExperimentalJsExport")
  }

  jvm()
  js(IR) {
    browser()
    useEsModules()
    generateTypeScriptDefinitions()
    binaries.library()
  }

  sourceSets {
    commonMain.dependencies {
      api(project(":models"))
      implementation(kotlin("reflect"))
      implementation(libs.ktor.client.core)
      implementation(libs.ktor.client.json)
      implementation(libs.ktor.client.content.negotiation)
      implementation(libs.ktor.serialization.kotlinx.json)
      implementation(libs.kotlinx.serialization.json)
      implementation(libs.kotlinx.datetime)
      implementation(libs.coroutines)
    }
    commonTest.dependencies {
      implementation(kotlin("test"))
      implementation(libs.kotlinx.coroutines.test)
    }
    jsMain.dependencies {
      implementation(libs.ktor.client.js)
      api(project(":models"))
    }
    jvmMain.dependencies {
      implementation(libs.ktor.client.cio)
    }
  }
}
