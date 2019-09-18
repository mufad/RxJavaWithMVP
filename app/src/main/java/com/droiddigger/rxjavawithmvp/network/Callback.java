package com.droiddigger.rxjavawithmvp.network;

/*Custom callback to receive errors and status messages*/
public abstract class Callback<T> {
    public abstract void returnResult(T t);
    public abstract void returnError(String message);
}
