package com.pranav.javagrok.misc;

interface MyInterface{
	default void show() {
		System.out.println("inside the first interface");
	}
	
	static void print() {
		System.out.println("printing inside the first interface");
	}
}

interface MyInterface2{
	default void show() {
		System.out.println("inside the second interface");
	}
}


public class MyDefaultInterfaceClass implements  MyInterface, MyInterface2{

	@Override
	public void show() {
		MyInterface.super.show();
	}
	
	public static void main(String[] args) {
		MyInterface.print();
	}
}
