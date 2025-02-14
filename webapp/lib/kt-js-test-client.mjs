import {
  protoOf180f3jzyo7rfj as protoOf,
  initMetadataForCompanion1wyw17z38v6ac as initMetadataForCompanion,
  VOID7hggqo3abtya as VOID,
  println2shhhgwwt4c61 as println,
  initMetadataForInterface1egvbzx539z91 as initMetadataForInterface,
} from './kotlin-kotlin-stdlib.mjs';
//region block: imports
//endregion
//region block: pre-declaration
function testFunc(data) {
  println('testFunc() called with: data = ' + data.toString());
}
initMetadataForInterface(ClientApi_0, 'ClientApi');
initMetadataForCompanion(Companion, VOID, [ClientApi_0]);
//endregion
function Companion() {
}
var Companion_instance;
function Companion_getInstance() {
  return Companion_instance;
}
function ClientApi_0() {
}
//region block: post-declaration
protoOf(Companion).testFunc = testFunc;
//endregion
//region block: init
Companion_instance = new Companion();
//endregion
//region block: exports
var ClientApi = {getInstance: Companion_getInstance};
export {
  ClientApi as ClientApi,
};
//endregion

//# sourceMappingURL=kt-js-test-client.mjs.map
