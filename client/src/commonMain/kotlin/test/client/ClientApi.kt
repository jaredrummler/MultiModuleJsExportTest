@file:JsExport

package test.client

import kotlinjs.models.TestData
import kotlin.js.JsExport

@JsExport
interface ClientApi {

  fun testFunc(data: TestData) {
    println("testFunc() called with: data = $data")
  }

  companion object : ClientApi
}
