Here's the **README** for **MultiModuleJsExportTest**, rewritten with clear issue details and structured formatting.

---

# **MultiModuleJsExportTest**

## **Overview**
This project demonstrates an issue in **Kotlin Multiplatform (KMP)** where a **client module does not make a dependent module's exports available in its JavaScript distribution**.

### **Modules**
1. **`models`** – A Kotlin Multiplatform module containing shared data models.
2. **`client`** – A Kotlin Multiplatform module that depends on `models`.
3. **`webapp`** – A Next.js module that imports and tests the `client` library in `webapp/app/page.tsx`.

## **Issue Description**
The **`client` module depends on the `models` module using `api(project(":models"))`**, expecting that the **generated JavaScript package for `client` would allow direct access to the `TestData` class from `models`**.

However, when importing `TestData` from the `client` module in `webapp/app/page.tsx`, the following error occurs:

```
Export TestData doesn't exist in target module
```

Despite this error, inspecting the generated TypeScript declarations confirms that `TestData` **exists** in the compiled JavaScript but is **not accessible as an export** from `client`.

## **Steps to Reproduce**
1. **Build the client module for JavaScript**
   ```sh
   ./gradlew :client:jsBrowserDistribution
   ```
2. **Inspect the generated JavaScript output**
    - Navigate to `build/js/packages/client/kotlin/`.
    - Verify that `TestData` is present inside the compiled output but not exported at the module level.
3. **Run the Next.js webapp**
   ```sh
   cd webapp
   npm install
   npm run dev
   ```
4. **Observe import errors in `page.tsx`**
    - The following import fails because `TestData` is not available from `client`:
      ```typescript
      import { ClientApi, TestData } from "@/lib";
      ```

## **Observed Behavior**
- `TestData` **exists** in the compiled JavaScript output.
- The `ClientApi` class is accessible in JavaScript.
- `TestData` is **not available as a direct export** of the `client` module, causing an import error in Next.js.

## **Expected Behavior**
- The `client` module should **expose** `TestData`, making it available when importing `client` in JavaScript.
- The following import should work without errors:
  ```typescript
  import { ClientApi, TestData } from "@/lib";
  ```
- Running `testLibrary()` in `webapp/app/page.tsx` should correctly invoke `ClientApi.getInstance().testFunc(new TestData());`.
