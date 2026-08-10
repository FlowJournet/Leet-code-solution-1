import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] count = new int[1001];

        // Count elements of arr1
        for (int x : arr1) {
            count[x]++;
        }

        int index = 0;

        // Put elements according to arr2
        for (int x : arr2) {
            while (count[x] > 0) {
                arr1[index++] = x;
                count[x]--;
            }
        }

        // Put remaining elements in ascending order
        for (int x = 0; x <= 1000; x++) {
            while (count[x] > 0) {
                arr1[index++] = x;
                count[x]--;
            }
        }

        return arr1;
    }
}