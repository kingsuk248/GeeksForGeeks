package com.programming.dynamic;

import java.util.List;

public class PerfectSum {
	public static void main(String[] args) {
		// int[] inputArray = {2, 3, 5, 6, 8, 10};
		// int sum = 10;
		int[] inputArray = { 1, 2, 3, 4, 5 };
		int sum = 7;
		PerfectSum ps = new PerfectSum();
		int[][] output = ps.retrieveSubsets(inputArray, sum);
		// ps.printTable(output);
	}

	private int[][] retrieveSubsets(int[] set, int sum) {
		int l = set.length;
		boolean[][] subsets = new boolean[sum + 1][l + 1];
		for (int i = 0; i <= l; i++) {
			subsets[0][i] = true;
		}
		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= l; j++) {
				subsets[i][j] = subsets[i][j - 1];
				if (i >= set[j - 1]) {
					subsets[i][j] = subsets[i][j] || subsets[i - set[j - 1]][j - 1];
				}
			}
		}
		printBooleanTable(subsets);
		extractSums(subsets);
		return null;
	}
	
	private List<int[]> extractSums(boolean[][] subsets) {
		return null;
	}

	private void printBooleanTable(boolean[][] table) {
		System.out.println("==== Table STARTS ====");
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("==== Table ENDS ====");
	}

	private void printTable(int[][] table) {
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
