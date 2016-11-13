
package com.blogspot.iserf.multibubblejoin;

import java.util.Arrays;

/**
 *
 * @author alex
 */
public class MultyBubbleSortJoin {

    static public int[] sort(int[] originalArray) throws InterruptedException {

        // Don't change original array
        int[] tmpArray = new int[originalArray.length];

        System.arraycopy(originalArray, 0, tmpArray, 0, originalArray.length);

        int arrayPartLength = tmpArray.length / 4;

        int[] tmpArrayPart1 = new int[arrayPartLength];
        int[] tmpArrayPart2 = new int[arrayPartLength];
        int[] tmpArrayPart3 = new int[arrayPartLength];
        int[] tmpArrayPart4 = new int[arrayPartLength];
        System.arraycopy(tmpArray, 0, tmpArrayPart1, 0, arrayPartLength);
        System.arraycopy(tmpArray, arrayPartLength, tmpArrayPart2, 0, arrayPartLength);
        System.arraycopy(tmpArray, arrayPartLength * 2, tmpArrayPart3, 0, arrayPartLength);
        System.arraycopy(tmpArray, arrayPartLength * 3, tmpArrayPart4, 0, arrayPartLength);

        Worker worker1 = new Worker(tmpArrayPart1);
        Thread threadWorker1 = new Thread(worker1, "worker1");
        threadWorker1.start();

        Worker worker2 = new Worker(tmpArrayPart2);
        Thread threadWorker2 = new Thread(worker2, "worker2");
        threadWorker2.start();

        Worker worker3 = new Worker(tmpArrayPart3);
        Thread threadWorker3 = new Thread(worker3, "worker3");
        threadWorker3.start();
        
        Worker worker4 = new Worker(tmpArrayPart4);
        Thread threadWorker4 = new Thread(worker4, "worker4");
        threadWorker4.start();

        
        threadWorker1.join();
        threadWorker2.join();
        threadWorker3.join();
        threadWorker4.join();
        

        int[] parallelResult = concat(tmpArrayPart1, tmpArrayPart2);
        parallelResult = concat(parallelResult, tmpArrayPart3);
        parallelResult = concat(parallelResult, tmpArrayPart4);

        int[] result = IserfArrays.sort(parallelResult);
        // for test
        // System.out.println(java.util.Arrays.toString(result));

        return result;
    }

    public static int[] concat(int[] first, int[] second) {
        int[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

}
