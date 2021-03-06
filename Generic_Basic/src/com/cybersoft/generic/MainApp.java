package com.cybersoft.generic;

public class MainApp {
	public static void main(String[] args) {
		ClassGenericDemo<Integer> demo = new ClassGenericDemo<Integer>();
		demo.setData(1);
		System.out.println("data: " + demo.getData());
	}
}



