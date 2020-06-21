package com.programming.dynamic;

public class SubsetSum {
	public static void main(String[] args) {
		SubsetSum ss = new SubsetSum();
		int[] set = { 3, 34, 4, 12, 5, 2 };
		int sum = 13;
		System.out.println("=== By Recurssion ===");
		System.out.println(ss.recurssionMethod(set, set.length, sum, ""));
		System.out.println();
		System.out.println("=== By DP ===");
		System.out.println(ss.dynamicProgrammingMethod(set, set.length, sum));
	}

	private boolean recurssionMethod(int[] set, int n, int sum, String side) {
		if (sum == 0) {
			System.out.println(side);
			return true;
		}
		if (n == 0 && sum > 0) {
			return false;
		}
		if (set[n - 1] > sum) {
			return recurssionMethod(set, n - 1, sum, "none");
		}
		return recurssionMethod(set, n - 1, sum, "lhs") || recurssionMethod(set, n - 1, sum - set[n - 1], "rhs");
	}

	private boolean dynamicProgrammingMethod(int[] set, int length, int sum) {
		boolean subset[][] = new boolean[sum + 1][length + 1];
		for (int i = 0; i <= length; i++) {
			subset[0][i] = true;
		}
		for (int i = 1; i <= sum; i++) {
			subset[i][0] = false;
		}

		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= length; j++) {
				subset[i][j] = subset[i][j - 1];
				if (i >= set[j - 1]) {
					subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
				}
			}
		}
		printTable(subset);
		return subset[sum][length];
	}

	private void printTable(boolean[][] table) {
		System.out.println("==== Table STARTS ====");
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("==== Table ENDS ====");
	}
}
