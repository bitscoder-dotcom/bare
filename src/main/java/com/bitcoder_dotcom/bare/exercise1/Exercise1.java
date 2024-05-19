package com.bitcoder_dotcom.bare.exercise1;

import java.util.HashSet;
import java.util.Set;

/**
 *Write a simple Java >= 7 program that returns the smallest non occurring integer in a given
 * Array.
 * E.g Given an Array1 = [1,3,6,4,1,2] returns 5, and Array2 = [5, -1, -3] returns 1
 */
public class Exercise1 {
    public static void main(String[] args) {
        int[] array1 = {1,3,6,4,1,2};
        int[] array2 = {5,-1,-3};

        System.out.println(smallestNonOccurring(array1));
        System.out.println(smallestNonOccurring(array2));
    }

    private static int smallestNonOccurring(int[] array) {

        Set<Integer> set = new HashSet<>();

        for (int num : array) {
            set.add(num);
        }

        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        throw new RuntimeException("Non-occurring number not found");
    }

}
