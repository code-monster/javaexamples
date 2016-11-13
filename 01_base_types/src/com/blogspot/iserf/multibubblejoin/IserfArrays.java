package com.blogspot.iserf.multibubblejoin;

/**
 * The IserfArrays class provides bubble sorting
 */
public class IserfArrays {

	static public int[] sort(int[] tmpArray) {

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
