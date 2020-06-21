package com.programming.dynamic;

public class UglyNumbers {
	public static void main(String[] args) {
		UglyNumbers un = new UglyNumbers();
		int input = 150;
		un.findNthUglyNumber(input);
	}

	private void findNthUglyNumber(int input) {
		System.out.println(simpleMethod(input));
		System.out.println(dynamicProgrammingMethod(input));
	}

	private int dynamicProgrammingMethod(int input) {
		return getNthUglyNumber(input);
	}

	private int getNthUglyNumber(int index) {
		int[] uglyArray = new int[index];
		uglyArray[0] = 1;
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		int nextUglyNumber = 1;
		for (int i = 1; i < index; i++) {
			nextUglyNumber = Math.min(Math.min(uglyArray[i2] * 2, uglyArray[i3] * 3), uglyArray[i5] * 5);
			uglyArray[i] = nextUglyNumber;
			if (nextUglyNumber == uglyArray[i2] * 2) {
				i2 += 1;
			}
			if (nextUglyNumber == uglyArray[i3] * 3) {
				i3 += 1;
			}
			if (nextUglyNumber == uglyArray[i5] * 5) {
				i5 += 1;
			}
		}
		return nextUglyNumber;
	}

	private int simpleMethod(int nth) {
		int i = 1;
		int count = 1;
		while (nth > count) {
			i++;
			if (isUgly(i)) {
				count++;
			}
		}
		return i;
	}

	private boolean isUgly(int num) {
		num = maxDivisorPower(num, 2);
		num = maxDivisorPower(num, 3);
		num = maxDivisorPower(num, 5);
		return num == 1 ? true : false;
	}

	private int maxDivisorPower(int num, int factor) {
		while (num % factor == 0) {
			num /= factor;
		}
		return num;
	}
}
