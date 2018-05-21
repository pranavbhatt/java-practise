package com.pranav.javagrok.misc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyStream {
	public static void main(String[] args) {
		// stream of
		Stream<Integer> st = Stream.of(1,2,3,4);
		st.forEach(i -> System.out.println(i));
		System.out.println("=======");
		
		// from an array
		Stream<Integer> st1 =  Stream.of(new Integer[] {1,2,4});
		st1.forEach(i -> System.out.println(i));
		System.out.println("=======");
		
		// from a collection
		List<String> list = Arrays.asList("1", "2","3");
		long count = list.stream()
		.filter( str -> Integer.parseInt(str) > 2)
		.count();
        list.stream().collect(Collectors.toList());
        
		System.out.println(count);
		
		System.out.println("=======");
        IntStream stream = "12345_abcdefg".chars();
        stream.forEach(p -> System.out.println((char) p));
	}
}
