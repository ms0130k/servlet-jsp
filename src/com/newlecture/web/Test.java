package com.newlecture.web;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] numbers = new int[] { 43, 10, 3, 22, 14, 40, 500, 100 };
//		numbers = new int[] {};
//		System.out.println(Arrays.toString(remove_element_at2(numbers)));
//		System.out.println(Arrays.toString(numbers));
		
		System.out.println(Arrays.toString(getIncreasedDecreased(numbers)));
		System.out.println(Arrays.toString(numbers));
	}

	public static int[] remove_element_at2(int[] values) {
		int[] copiedValues = new int[values.length - 1];
		for (int i = 0; i < copiedValues.length; i++) {
			if (i >= 2) {
				copiedValues[i] = values[i + 1];
			} else {
				copiedValues[i] = values[i];
			}
		}
		return copiedValues;
	}

	public static int[] getIncreasedDecreased(int[] numbers) {
		int[] newvalue = new int[numbers.length];
		for (int i = 0; i < newvalue.length; i++) {
			if (numbers[i] < 100) {
				newvalue[i] = numbers[i] * 10;
			} else if (numbers[i] > 100) {
				newvalue[i] = numbers[i] / 10;
			}
		}
		return newvalue;
	}
	
}
