package com.pranav.javagrok.misc;

import java.util.Arrays;
import java.util.List;

public class MyParallelStrem {
	public static void main(String[] args) {
		//Use a program like htop, to see load on cores while this program is executing
	    int count = 10;
	    while(count > 0) {
	    	count--;
	    	new Thread(MyParallelStrem::parallelExection).start();
	    }
	}
	
	private static void parallelExection() {
	    List<Integer> nums = Arrays.asList(1, 2, 4, 6, 8, 9, 11);
	    long st = System.currentTimeMillis();
	    nums.parallelStream().filter(i -> i%2==0).mapToInt(i -> i*2).sum();
	    long end = System.currentTimeMillis();
	    long diff = end-st;
	    System.out.println("Total execution time for parallel strem:"+diff+" seconds");
	    System.out.println("==================");
	}
}
