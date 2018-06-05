package com.arrays.rotation;

import java.util.Scanner;

import com.utility.Utility;

/** 
 * Left rotate integer array using reversal algorithm 
 *
 */
public class RotationApp {
	private static int[] iArray;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int d = scanner.nextInt();
		scanner.nextLine();
		iArray = new int[n];
		for (int i = 0; i < n; i++) {
			iArray[i] = scanner.nextInt();
		}
		scanner.close();
		rotate(iArray, d);
	}
	
	private static void rotate(int[] iArray, int d) {
		d = d % iArray.length;
		reverse(0, d - 1);
		reverse(d, iArray.length - 1);
		reverse(0, iArray.length - 1);
		Utility.printSpaceSeperatedIntArrayElements(iArray);
	}
	
	private static void reverse(int start, int end) {
		for (int i = 0; i < (end - start + 1) / 2; i++) {
			int temp = iArray[start + i];
			iArray[start + i] = iArray[end - i];
			iArray[end - i] = temp;
		}
	}
}
