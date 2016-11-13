package com.blogspot.iserf;

import com.blogspot.iserf.multibubblejoin.MultyBubbleSortJoin;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The MainSort class provides compare different sorting type
 */
public class MainSort {

    public static final int ATTEMPTS = 20;
    public static final int ARRAY_SIZE = 10000;
    public static final int MIN_ELEMENT = -100;
    public static final int MAX_ELEMENT = 100;
    public static final int NUMBERS_SORTS_TYPE = 3;

    public static final int TEST_INDEX_BUBBLE = 0;
    public static final int TEST_INDEX_UTIL = 1;
    public static final int TEST_INDEX_MULTIBUBBLE_JOIN = 2;

    public static void main(String[] args) throws InterruptedException {

        long[][] testResults = new long[MainSort.ATTEMPTS][MainSort.NUMBERS_SORTS_TYPE];

        for (int i = 0; i < MainSort.ATTEMPTS; i++) {

            int[] generatedArray = generateArray(MainSort.ARRAY_SIZE);
            long startTime, endTime, duration;


            startTime = System.nanoTime();
            MultyBubbleSortJoin.sort(generatedArray);
            endTime = System.nanoTime();
            duration = (endTime - startTime);

            testResults[i][MainSort.TEST_INDEX_MULTIBUBBLE_JOIN] = duration;
            
            
            startTime = System.nanoTime();
            Arrays.sort(generatedArray);
            endTime = System.nanoTime();
            duration = (endTime - startTime);

            testResults[i][MainSort.TEST_INDEX_BUBBLE] = duration;
            
        
            startTime = System.nanoTime();
            java.util.Arrays.sort(generatedArray);
            endTime = System.nanoTime();
            duration = (endTime - startTime);

            testResults[i][MainSort.TEST_INDEX_UTIL] = duration;
            
                          
        }
        // for test
        // System.out.println(java.util.Arrays.deepToString(testResults));

        System.out.println("Average bubblesort result: " + getAverageResult(testResults, MainSort.TEST_INDEX_BUBBLE));

             
        System.out.println(
                "Average MULTIBUBBLE with join result: " + getAverageResult(testResults, MainSort.TEST_INDEX_MULTIBUBBLE_JOIN));
        
        System.out.println(
                "Average java.util.Arrays.sort result: " + getAverageResult(testResults, MainSort.TEST_INDEX_UTIL));
        

    }
    
    /**
     * Calculate average results for each type of sorting
     */
    private static long getAverageResult(long[][] testResults, int testIndex) {

        long tmp = 0;
        for (int i = 0; i < testResults.length; i++) {
            tmp += testResults[i][testIndex];
        }

        return tmp / testResults.length;
    }

    /**
     * Returns the  generated array
     */
    private static int[] generateArray(int size) {

        int[] generatedArray = new int[size];
        for (int i = 0; i < size; i++) {
            generatedArray[i] = ThreadLocalRandom.current().nextInt(MainSort.MIN_ELEMENT, MainSort.MAX_ELEMENT + 1);
        }

        return generatedArray;
    }

}
