import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int max = Integer.MIN_VALUE;

        // Add the first element of every list
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);

            pq.offer(new int[]{value, i, 0});
            max = Math.max(max, value);
        }

        int start = pq.peek()[0];
        int end = max;

        while (true) {

            int[] current = pq.poll();

            int min = current[0];
            int listIndex = current[1];
            int elementIndex = current[2];

            // Check current range
            if (max - min < end - start ||
                (max - min == end - start && min < start)) {

                start = min;
                end = max;
            }

            // If this list has no more elements, stop
            if (elementIndex + 1 == nums.get(listIndex).size()) {
                break;
            }

            // Add next element from the same list
            int next = nums.get(listIndex).get(elementIndex + 1);

            pq.offer(new int[]{next, listIndex, elementIndex + 1});

            max = Math.max(max, next);
        }

        return new int[]{start, end};
    }
}