class Solution {
    public int checkRecord(int n) {

        int MOD = 1000000007;

        // dp[a][l]
        // a = number of absences (0 or 1)
        // l = consecutive late days (0, 1, 2)

        long[][] dp = new long[2][3];

        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {

            long[][] next = new long[2][3];

            for (int a = 0; a < 2; a++) {
                for (int l = 0; l < 3; l++) {

                    long value = dp[a][l];

                    if (value == 0) {
                        continue;
                    }

                    // Add P (Present)
                    next[a][0] = (next[a][0] + value) % MOD;

                    // Add L (Late)
                    if (l < 2) {
                        next[a][l + 1] =
                            (next[a][l + 1] + value) % MOD;
                    }

                    // Add A (Absent)
                    if (a < 1) {
                        next[a + 1][0] =
                            (next[a + 1][0] + value) % MOD;
                    }
                }
            }

            dp = next;
        }

        long answer = 0;

        for (int a = 0; a < 2; a++) {
            for (int l = 0; l < 3; l++) {
                answer = (answer + dp[a][l]) % MOD;
            }
        }

        return (int) answer;
    }
}