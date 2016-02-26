package com.hengtiansoft.nl.common.model;
public class MobileReturn<T> {
	T result = null;
	
	public MobileReturn() {
	}

	public MobileReturn(T result) {
		this.result = result;
	}
	
	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
}
