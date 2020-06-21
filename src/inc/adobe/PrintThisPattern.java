package inc.adobe;

import java.util.Scanner;

public class PrintThisPattern {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] inputArray = new int[n];
		for (int i = 0; i < n; i++) {
			inputArray[i] = scanner.nextInt();
		}
		scanner.close();
		for (int i = 0; i < n; i++) {
			printPattern(inputArray[i]);
		}
	}

	private static void printPattern(int n) {
		for (int x = 0; x < (n * 2 - 1); x++) {
			for (int y = 0; y < (n * 2 - 1); y++) {
				int out = 1 + Math.max(Math.abs(n - x - 1), Math.abs(n - y - 1));
				System.out.print(out);
			}
			System.out.println();
		}
	}
}
