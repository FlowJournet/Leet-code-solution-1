import java.util.*;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {

        // Handle zero
        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        // Check negative sign
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Use long to avoid integer overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Add integer part
        result.append(num / den);

        long remainder = num % den;

        // No fractional part
        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");

        // Stores remainder and its position
        HashMap<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {

            // Repeating part found
            if (map.containsKey(remainder)) {
                int position = map.get(remainder);
                result.insert(position, "(");
                result.append(")");
                break;
            }

            map.put(remainder, result.length());

            remainder *= 10;

            result.append(remainder / den);

            remainder %= den;
        }

        return result.toString();
    }
}