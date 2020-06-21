package com.programming.dynamic;

public class CatalanNumber {
	public static void main(String[] args) {
		CatalanNumber cn = new CatalanNumber();
		int n = 5;
		cn.recursiveMethod(n);
		cn.dynamicProgrammingMethod(n);
	}

	private void recursiveMethod(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("Catalan of " + i + ": " + catalan(i));
		}
	}

	private int catalan(int n) {
		int result = 0;
		if (n <= 1) {
			return 1;
		}
		for (int i = 0; i < n; i++) {
			result += catalan(i) * catalan(n - i - 1);
		}
		return result;

	}

	private void dynamicProgrammingMethod(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("Catalan by DP of " + i + ": " + catalanByDP(i));
		}
	}
	
	private int catalanByDP(int n) {
		int[] catalanArray = new int[n + 2];
		catalanArray[0] = 1;
		catalanArray[1] = 1;
		for (int i = 2; i <= n; i++) {
			catalanArray[i] = 0; 
			for (int j = 0; j < i; j++) {
				catalanArray[i] += catalanArray[j] * catalanArray[i - j - 1];
			}
		}
		return catalanArray[n];
	}
}
