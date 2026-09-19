class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String str = s.replace("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder();

        int count = 0;

        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
            count++;

            if (count == k && i != 0) {
                sb.append("-");
                count = 0;
            }
        }

        return sb.reverse().toString();
    }
}