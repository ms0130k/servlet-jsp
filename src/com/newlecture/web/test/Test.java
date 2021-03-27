package com.newlecture.web.test;

public class Test {

	public static void main(String[] args) {
		VendingMachine vm = new VendingMachine("레쓰비");
		//vm.coffeeCount = 0; //이 부분을 private int coffeeCount => public int coffeeCount로 수정해서 실행해보세요.
		vm.캔커피충전(0);
		vm.캔커피충전(10);
		vm.캔커피뽑기();
	}
}
