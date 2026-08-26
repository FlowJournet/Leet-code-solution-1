import java.util.*;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {

        String[] morse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."
        };

        HashSet<String> set = new HashSet<>();

        for (String word : words) {
            String code = "";

            for (char ch : word.toCharArray()) {
                code += morse[ch - 'a'];
            }

            set.add(code);
        }

        return set.size();
    }
}