package com.utility;

import java.util.List;

public class Utility {
	public static void printSpaceSeperatedIntArrayElements(int[] iArray) {
		if (iArray != null) {
			for (int i = 0; i < iArray.length; i++) {
				System.out.print(iArray[i] + " ");
			}
			System.out.println();
		}
	}
	
	public static void printSpaceSeperatedIntListElements(List<Integer> iList) {
		if (iList != null) {
			for (Integer i : iList) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
}
