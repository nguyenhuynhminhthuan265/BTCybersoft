package com.cybersoft.generic;

public class ClassGenericDemo<T> {
	private T data;

	public ClassGenericDemo() {
		this.data = null;
	}

	public ClassGenericDemo(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}




