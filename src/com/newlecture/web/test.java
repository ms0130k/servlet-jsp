package com.newlecture.web;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number1:");
		System.out.println("Enter a number2:");
		System.out.println("Enter a number3:");
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		int num3 = input.nextInt();

		int min;

		min = Math.min(num1, num2);
		min = Math.min(min, num3);

		for (int i = min; i >= 1; i--) {
			if ((num1 % i == 0) && (num2 % i == 0) && (num3 % i == 0)) {
				System.out.println("The greatest common divisor is: " + i);
				break;
			}
		}
		if (num1 <= 0 || num2 <= 0 || num3 <= 0) {
			min = -1;
			System.out.println("The greatest common divisor is: " + min);
		}
	}

}
