package com.programming.dynamic;

public class FriendsProblem {
	public static void main(String[] args) {
		FriendsProblem fp = new FriendsProblem();
		int noOfFriends = 6;
		System.out.println("=== By Recurssion ===");
		fp.recurssionMethod(noOfFriends);
		System.out.println();
		System.out.println("=== By DP ===");
		System.out.println(fp.dynamicProgrammingMethod(noOfFriends));
	}

	private void recurssionMethod(int noOfFriends) {
		int output = solveByRecurring(noOfFriends);
		System.out.println(output);
	}

	private int solveByRecurring(int n) {
		if (n <= 2) {
			return n;
		}
		return solveByRecurring(n - 1) + solveByRecurring(n - 1) * solveByRecurring(n - 2);
	}

	private int dynamicProgrammingMethod(int n) {
		int[] nArray = new int[n+1];
		nArray[0] = 1;
		nArray[1] = 2;
		for (int i = 2; i < n; i++) {
			nArray[i] = nArray[i - 1] + nArray[i - 1] * nArray[i - 2];
		}
		return nArray[n-1];
	}
}
