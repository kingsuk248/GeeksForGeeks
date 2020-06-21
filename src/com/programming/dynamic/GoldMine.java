package com.programming.dynamic;

public class GoldMine {
	public static void main(String[] args) {
		int[][] goldMine = {
				{1, 3, 1, 5},
				{2, 2, 4, 1},
				{5, 0, 2, 3},
				{0, 6, 1, 2}
		};
		int rows = 4;
		int cols = 4;
		GoldMine gm = new GoldMine();
		int maxGold = gm.getMaxGold(goldMine, rows, cols);
		System.out.println(maxGold);
	}

	private int getMaxGold(int[][] goldMine, int m, int n) {
		int[][] goldCollectionTable = new int[m][n];
		
		for (int col = n - 1; col >= 0; col--) {
			for (int row = 0; row < m; row++) {
				int right = (col == n-1) ? 0 : goldCollectionTable[row][col+1];
				int rightUp = (col == n-1) || (row == 0) ? 0 : goldCollectionTable[row-1][col+1];
				int rightDown = (col == n-1) || (row == n-1) ? 0 : goldCollectionTable[row+1][col+1];
				goldCollectionTable[row][col] = goldMine[row][col] + Math.max(right, Math.max(rightUp, rightDown));
			}
		}
		int maxGold = goldCollectionTable[0][0];
		for (int i = 1; i < m; i++) {
			maxGold = Math.max(maxGold, goldCollectionTable[i][0]);
		}
		return maxGold;
	}
}

