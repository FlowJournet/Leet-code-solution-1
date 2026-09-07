class Solution {
    public boolean isPalindrome(ListNode head) {

        // Store values in an array
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();

        ListNode current = head;

        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        // Check palindrome
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}