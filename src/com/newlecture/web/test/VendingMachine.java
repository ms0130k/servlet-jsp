package com.newlecture.web.test;

public class VendingMachine {
	private int coffeeCount;
	private String coffeeName;
	
	public VendingMachine(String coffeeName) {
		this.coffeeCount = 0;
		this.coffeeName = coffeeName;
	}
	public int 캔커피뽑기() {
		System.out.println(coffeeCount + "개의 커피가 지급됩니다.");
		return coffeeCount;
	}

	public void 캔커피충전(int coffeeCount) {
		if (coffeeCount < 1) {
			System.out.println("커피는 한 개 이상 충전해주세요.");
			return;
		}
		System.out.println("커피가 " + coffeeCount + "개 충전됩니다.");
		this.coffeeCount = coffeeCount;
	}
}
