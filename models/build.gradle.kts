import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
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
      api(libs.kotlinx.serialization.json)
      api(libs.kotlinx.datetime)
      implementation(kotlin("reflect"))
    }
    commonTest.dependencies {
      implementation(kotlin("test"))
    }
  }
}
