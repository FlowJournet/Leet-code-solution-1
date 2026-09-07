import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {

        int n = score.length;

        // Store indexes
        Integer[] index = new Integer[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        // Sort indexes based on scores in descending order
        Arrays.sort(index, (a, b) -> score[b] - score[a]);

        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {

            if (i == 0) {
                answer[index[i]] = "Gold Medal";
            }
            else if (i == 1) {
                answer[index[i]] = "Silver Medal";
            }
            else if (i == 2) {
                answer[index[i]] = "Bronze Medal";
            }
            else {
                answer[index[i]] = String.valueOf(i + 1);
            }
        }

        return answer;
    }
}