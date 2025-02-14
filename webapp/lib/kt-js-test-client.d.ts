type Nullable<T> = T | null | undefined
export declare class TestData {
    constructor(data?: string);
    get data(): string;
    copy(data?: string): TestData;
    toString(): string;
    hashCode(): number;
    equals(other: Nullable<any>): boolean;
}
export declare interface ClientApi {
    testFunc(data: TestData): void;
    readonly __doNotUseOrImplementIt: {
        readonly "test.client.ClientApi": unique symbol;
    };
}
export declare const ClientApi: {
    getInstance(): {
        testFunc(data: TestData): void;
        readonly __doNotUseOrImplementIt: ClientApi["__doNotUseOrImplementIt"];
    } & ClientApi;
};