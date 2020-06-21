package com.programming.dynamic;

public class CoinChange {
	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		int sum = 12;
		int[] coinsArray = { 1, 5, 10 };
		cc.recursiveMethod(coinsArray, coinsArray.length, sum);
		cc.dynamicProgrammingMethod(coinsArray, coinsArray.length, sum);
	}

	private void recursiveMethod(int[] coinsArray, int length, int sum) {
		System.out.println(countSolutions(coinsArray, length, sum));
	}

	private int countSolutions(int[] coinsArray, int arrLength, int sum) {
		if (sum == 0) {
			return 1;
		}
		if (sum < 0) {
			return 0;
		}
		if (arrLength <= 0 && sum >= 1) {
			return 0;
		}
		return countSolutions(coinsArray, arrLength - 1, sum)
				+ countSolutions(coinsArray, arrLength, sum - coinsArray[arrLength - 1]);
	}

	private int dynamicProgrammingMethod(int[] coinsArray, int length, int sum) {
		int table[] = new int[sum + 1];
		table[0] = 1;
		for (int i = 0; i < length; i++) {
			for (int j = coinsArray[i]; j <= sum; j++) {
				table[j] = table[j - coinsArray[i]] + table[j];
			}
		}
		System.out.println(table[sum]);
		return table[sum];

	}
}
