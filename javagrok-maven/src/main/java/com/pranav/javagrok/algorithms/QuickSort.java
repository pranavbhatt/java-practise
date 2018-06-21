package com.pranav.javagrok.algorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * 
 * @author pbhatt
 *
 */
public class QuickSort {
	public int[] sort(int[] array, boolean random) {
		if(array != null && array.length > 1) sortPartion(0,array.length-1,array, random);
		return array;
	}
	
	private void sortPartion(int st, int end, int[] array, boolean random) {
		if(st < end) {
			int partition = partition(st, end, array, random);
			sortPartion(st,partition-1,array, random);
			sortPartion(partition+1,end,array, random);
		}
	}
	
	private int partition(final int st, final int end, final int[] array, boolean random) {
		int i=st+1;
		int j=st+1;
		
		if(random) {
			Random r = new Random();
			int n = st + r.nextInt(end - st + 1);//find a random index and make it the pivot
			swap(st,n,array);
		}
		
		while(i <= end && j <= end) {
			if(array[j] < array[st]) {
				swap(i,j,array);
				i++;
				j++;
			}else {
				j++;
			}
		}
		//all elements to the left of pivot are less than pivot
		swap(i-1,st,array);
		return i-1;//position of the pivot

	}
	
	private void swap(final int i, final int j, final int[] array) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
	
	public static void main(String[] args) {
		QuickSort q = new QuickSort();
		 long st = System.currentTimeMillis();
		 int[] arr = q.sort(new int[] {-1,1,2,3,4,10,11,28,54,18}, false);
		 Arrays.stream(arr).forEach(x -> System.out.println(x));
		 long end = System.currentTimeMillis();
		 long diff = end-st;
		 System.out.println("Total execution time for quick sort:"+diff+" seconds");
		 System.out.println("==================");
		 
		 
		 st = System.currentTimeMillis();
		 int[] arr1 =q.sort(new int[] {-1,1,2,3,4,10,11,28,-1,54,18}, true);
		 Arrays.stream(arr1).forEach(x -> System.out.println(x));
		 end = System.currentTimeMillis();
		 diff = end-st;
		 System.out.println("Total execution time for randomized quick sort:"+diff+" seconds");
		 System.out.println("==================");

	}
}
