package regular;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    boolean find3Numbers(int A[], int arr_size, int sum) {
        int l, r;
        for (int i = 0; i < arr_size - 2; i++) {
            for (int j = i + 1; j < arr_size - 1; j++) {
                for (int k = j + 1; k < arr_size; k++) {
                    if (A[i] + A[j] + A[k] == sum) {
                        System.out.print("Triplet is " + A[i] + ", " + A[j] + ", " + A[k]);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

//    public static String toBinaryString(int n) {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(n % 2);
//        n /= 2;
//        while (n != 0) {
//            stringBuilder.insert(0, n % 2);
//            n = n / 2;
//        }
//        return stringBuilder.toString();
//    }