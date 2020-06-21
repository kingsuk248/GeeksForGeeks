package com.programming.dynamic;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	public static void main(String[] args) throws InterruptedException {
		Fibonacci f = new Fibonacci();
		int n = 4;
		/*
		 * for (int i = 0 ; i <= 10; i++) { f.recursiveMethod(i); }
		 */
		System.out.print("Digit at position " + n + ": ");
		f.recursiveMethod(n);
		System.out.print("Digit at position " + n + ": ");
		f.dynamicProgrammingMethod(n);
	}

	private void recursiveMethod(int n) {
		System.out.print(fibonacciOne(n) + " ");
	}

	private int fibonacciOne(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibonacciOne(n - 2) + fibonacciOne(n - 1);
		}
	}

	private void dynamicProgrammingMethod(int n) {
		System.out.print(fibonacciTwo(n) + " ");
	}

	Map<Integer, Integer> dpMap = new HashMap<>();
	private int fibonacciTwo(int n) {
		int[] fibArray = new int[n + 1];
		fibArray[0] = 0;
		fibArray[1] = 1;
		int i = 0;
		for (i = 2; i <= n; i++) {
			fibArray[i] = fibArray[i - 2] + fibArray[i - 1];
		}
		return fibArray[i - 1];
	}
}
