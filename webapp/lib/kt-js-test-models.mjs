import {
  VOID7hggqo3abtya as VOID,
  protoOf180f3jzyo7rfj as protoOf,
  getStringHashCode26igk1bx568vk as getStringHashCode,
  THROW_CCE2g6jy02ryeudk as THROW_CCE,
  initMetadataForClassbxx6q50dy2s7 as initMetadataForClass,
} from './kotlin-kotlin-stdlib.mjs';
//region block: imports
//endregion
//region block: pre-declaration
initMetadataForClass(TestData, 'TestData', TestData);
//endregion
function TestData(data) {
  data = data === VOID ? 'Multi-Module JsExport Test' : data;
  this.data = data;
}
protoOf(TestData).j = function () {
  return this.data;
};
protoOf(TestData).k = function () {
  return this.data;
};
protoOf(TestData).l = function (data) {
  return new TestData(data);
};
protoOf(TestData).copy = function (data, $super) {
  data = data === VOID ? this.data : data;
  return this.l(data);
};
protoOf(TestData).toString = function () {
  return 'TestData(data=' + this.data + ')';
};
protoOf(TestData).hashCode = function () {
  return getStringHashCode(this.data);
};
protoOf(TestData).equals = function (other) {
  if (this === other)
    return true;
  if (!(other instanceof TestData))
    return false;
  var tmp0_other_with_cast = other instanceof TestData ? other : THROW_CCE();
  if (!(this.data === tmp0_other_with_cast.data))
    return false;
  return true;
};
//region block: exports
export {
  TestData as TestData,
};
//endregion

//# sourceMappingURL=kt-js-test-models.mjs.map
