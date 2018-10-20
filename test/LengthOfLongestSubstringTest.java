import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthOfLongestSubstringTest {

    LengthOfLongestSubstring length;

    @BeforeEach
    void setUp() {
        length = new LengthOfLongestSubstring();
    }

    @Test
    void testAllOneCharacter() {
        String testString = "aaaaaaaa";
        int substringLength = length.lengthOfLongestSubstring(testString);
        assertEquals(1, substringLength, "Expected 1, but was " + substringLength);
    }

    @Test
    void testPalindrome() {
        String testString = "bananab";
        int substringLength = length.lengthOfLongestSubstring(testString);
        assertEquals(3, substringLength, "Expected 3, but was " + substringLength);
    }

    @Test
    void testEmptyString() {
        String testString = "";
        int substringLength = length.lengthOfLongestSubstring(testString);
        assertEquals(0, substringLength, "Expected 0, but was " + substringLength);
    }

    @Test
    void testNullInput() {
        String testString = null;
        int substringLength = length.lengthOfLongestSubstring(testString);
        assertEquals(0, substringLength, "Expected 0, but was " + substringLength);
    }
}