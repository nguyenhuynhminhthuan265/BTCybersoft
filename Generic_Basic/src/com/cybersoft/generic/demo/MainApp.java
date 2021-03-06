package com.cybersoft.generic.demo;

public class MainApp {
	public static void main(String[] args) {
		Book book = new Book("go", "di");
		String key = book.getKey();
		String value = book.getValue();
		System.out.println(key + ": " + value); 
	}
}
