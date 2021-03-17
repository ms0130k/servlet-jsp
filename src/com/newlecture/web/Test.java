package com.newlecture.web;

import java.util.Scanner;

public class Test {

//	public static void main(String[] args) {
//		for (int j = 2; j < 10; j++) {
//			int num = j;
//			int result = 1;
//			String str = Integer.toString(j) + " = ";
//			for (int i = 1; i < 10; i++) {
//				result *= num;
//				if (i == 1) {
//					System.out.println(num + " x 1 = " + result);
//					continue;
//				}
//				str = Integer.toString(num) + " x " + str;
//				System.out.println(str + result);
//			}
//		}
//	}
	public static void main(String[] args) {
		int cnt = 0, answer = 0;
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (j == 1) {
					System.out.println(i + " X " + j + " = " + (i));
				} else {
					cnt = j - 1;
					answer = i;
					System.out.print(i);
					while (cnt > 0) {
						System.out.print(" X " + i);
						answer *= i;
						cnt--;
					}
					System.out.println(" = " + answer);
				}
			}
		}
	}

}
