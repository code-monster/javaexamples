package com.blogspot.iserf;

/**
 * The Arrays class provides bubble sorting
 */
public class Arrays {

	static public int[] sort(int[] originalArray) {

		// Don't change original array
		int[] tmpArray = new int[originalArray.length];
		System.arraycopy(originalArray, 0, tmpArray, 0, originalArray.length);

		int temp;
		for (int a = 0; a < tmpArray.length - 1; a++) {
			boolean changed = false;
			for (int i = 0; i < tmpArray.length -a- 1; i++) {

				if (tmpArray[i] > tmpArray[i + 1]) {

					temp = tmpArray[i + 1];
					tmpArray[i + 1] = tmpArray[i];
					tmpArray[i] = temp;

					changed = true;
				}
			}

			if (changed == false) {
				break;
			}

		}

		return tmpArray;
	}

}
