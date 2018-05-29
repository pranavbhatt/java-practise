package com.pranav.javagrok.misc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class MyLambda {
	public static void main(String[] args) {
		List<String> sList = Arrays.asList("hello", "world", "pranav", "test","pab");
		Collections.sort(sList, (s1, s2) -> s1.compareTo(s2));
		printConditionally(sList, s -> true); 
		printConditionally(sList, s -> s.startsWith("p")); //passing behavior as a lambda
		printConditionally(sList, s -> s.startsWith("w"));
		printConditionally(sList, s -> s.startsWith("h"));
		
		
		int[] nums = new int[] {1,2,3,4};
		int key = 0;
		// Lambda exception handling
		process(nums, wrapperLambda((i, k) -> System.out.println(i/k)), key);
	}
	
	private static void printConditionally(List<String> sList, Predicate<String> c) {
		for(String str:sList) {
			if(c.test(str)) System.out.println(str);
		}
	}
	
	private static void process(int[] nums, BiConsumer<Integer, Integer> biC, int key) {
		for(Integer i:nums) {
			biC.accept(i, key);
		}
	}
	
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer){
		return (k, v) -> {
			try {
				consumer.accept(k, v);
			}catch(ArithmeticException e) {
				System.out.println("Arithmetic Exception handled");
			}
		};
	}
}