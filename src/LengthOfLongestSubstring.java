import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    //Assumes strings are words
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> longestSubstringCharactersSet = new HashSet<>();
        int lengthOfLongestSubstring = 1;
        int leftIndex = 0;
        while (leftIndex < s.length() - lengthOfLongestSubstring) {
            if (!longestSubstringCharactersSet.add(s.charAt(leftIndex))) {
                lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, longestSubstringCharactersSet.size());
                longestSubstringCharactersSet.clear();
                longestSubstringCharactersSet.add(s.charAt(leftIndex));
            }
            leftIndex++;
        }
        return lengthOfLongestSubstring;
    }
}