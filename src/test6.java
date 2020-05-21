import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(new Solution().lengthOfLongestSubstring("bbac"));
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int curr = 0;
        Map<Character, Integer> occurences = new HashMap<>();
        int maxLength = 0;
        int currMaxLength = 0;
        while(true && curr < s.length()) {
            if (occurences.containsKey(s.charAt(curr))) {
                curr = occurences.get(s.charAt(curr)) + 1;
                if (maxLength < currMaxLength)
                    maxLength = currMaxLength;
                currMaxLength = 0;
                occurences = new HashMap<>();
            } else {
                currMaxLength++;
                occurences.put(s.charAt(curr), curr);
                curr++;
            }
        }
        if (maxLength < currMaxLength)
            maxLength = currMaxLength;
        return maxLength;
    }
}