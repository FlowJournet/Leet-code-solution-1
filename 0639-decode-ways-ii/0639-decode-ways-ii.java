class Solution {
    public int numDecodings(String s) {

        long MOD = 1000000007;

        long prev2 = 1;
        long prev1 = waysOne(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {

            char current = s.charAt(i);
            char previous = s.charAt(i - 1);

            long currentWays = 0;

            // Decode current character alone
            currentWays += waysOne(current) * prev1;

            // Decode previous + current together
            currentWays += waysTwo(previous, current) * prev2;

            currentWays %= MOD;

            prev2 = prev1;
            prev1 = currentWays;
        }

        return (int) prev1;
    }

    // Number of ways to decode one character
    private long waysOne(char c) {

        if (c == '*') {
            return 9;
        }

        if (c == '0') {
            return 0;
        }

        return 1;
    }

    // Number of ways to decode two characters
    private long waysTwo(char a, char b) {

        if (a == '*' && b == '*') {
            return 15;
        }

        if (a == '*') {
            if (b >= '0' && b <= '6') {
                return 2;
            }
            return 1;
        }

        if (b == '*') {
            if (a == '1') {
                return 9;
            }

            if (a == '2') {
                return 6;
            }

            return 0;
        }

        int number = (a - '0') * 10 + (b - '0');

        if (number >= 10 && number <= 26) {
            return 1;
        }

        return 0;
    }
}