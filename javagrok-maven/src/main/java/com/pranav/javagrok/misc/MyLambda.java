package com.pranav.javagrok.misc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MyLambda {
	public static void main(String[] args) {
		List<String> sList = Arrays.asList("hello", "world", "pranav", "test","pab");
		Collections.sort(sList, (s1, s2) -> s1.compareTo(s2));
		printConditionally(sList, s -> true, System.out::println); // p -> method(p) 
	    System.out.println("==================");
		printConditionally(sList, s -> s.startsWith("p"),p -> System.out.println(p)); //passing behavior as a lambda
	    System.out.println("==================");		
		printConditionally(sList, s -> s.startsWith("w"),System.out::println);
	    System.out.println("==================");
		printConditionally(sList, s -> s.startsWith("h"),System.out::println);
		
		
		Integer[] nums = new Integer[] {1,2,3,4};
		int key = 0;
		// Lambda exception handling
		process(nums, wrapperLambda((i, k) -> System.out.println(i/k)), key);
	}
	
	private static void printConditionally(List<String> sList, Predicate<String> predicate, Consumer<String> consumer) {
		for(String str:sList) {
			if(predicate.test(str)) consumer.accept(str);
		}
	}
	
	private static void process(Integer[] nums, BiConsumer<Integer, Integer> biC, int key) {
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