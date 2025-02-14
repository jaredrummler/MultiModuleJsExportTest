package kotlinjs.models

import kotlin.js.JsExport

@JsExport
data class TestData(
  val data: String = "Multi-Module JsExport Test"
)
