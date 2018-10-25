import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinningCandidateTest {

    static WinningCandidate winningCandidate;

    @BeforeAll
    static void init() {
        winningCandidate = new WinningCandidate();
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void winningCandidateTwoInputTieTest() {
        String[] testInput = new String[]{"John", "Max"};
        String expected = "John";
        String actual = winningCandidate.winningCandidate(testInput);
        assertEquals(expected, actual, "Expected " + expected + " and was " + actual);
    }

    @Test
    void winningCandidateFourInputStandardWinTest() {
        String[] testInput = new String[]{"John", "Max", "Abe", "Sandy", "Max"};
        String expected = "Max";
        String actual = winningCandidate.winningCandidate(testInput);
        assertEquals(expected, actual, "Expected " + expected + " and was " + actual);
    }

    @Test
    void winningCandidateAllOneInputTest() {
        String[] testInput = new String[]{"John", "John", "John", "John", "John", "John"};
        String expected = "John";
        String actual = winningCandidate.winningCandidate(testInput);
        assertEquals(expected, actual, "Expected " + expected + " and was " + actual);
    }

    @Test
    void winningCandidateManyInputTieShorterNameTest() {
        String[] testInput = new String[]{"John", "Johnny", "Nancy", "Maximus"};
        String expected = "John";
        String actual = winningCandidate.winningCandidate(testInput);
        assertEquals(expected, actual, "Expected " + expected + " and was " + actual);
    }

    @Test
    void winningCandidateNullInputTest() {
        String[] testInput = new String[]{"John", "Johnny", null, "Nancy", "Maximus"};
        String expected = "John";
        String actual = winningCandidate.winningCandidate(testInput);
        assertEquals(expected, actual, "Expected " + expected + " and was " + actual);
    }

    @Test
    void winningCandidateManyNameOneLessTest() {
        String[] testInput = new String[]{"John", "John", "John", "John", "Jim"};
        String expected = "John";
        String actual = winningCandidate.winningCandidate(testInput);
        assertEquals(expected, actual, "Expected " + expected + " and was " + actual);
    }
}