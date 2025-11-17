package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestAutomatonTest {

    @ParameterizedTest
    @CsvSource({
            "abcTESTabc, F",
            "abcTES, 3",
            "abcTE, 2",
            "abcT, 1",
            "abc, 0",
            "abcdefg, 0",
            "TEST, F",
            "TTEST, F",
            "TESTT, F",
            "TETEST, F",
            "TST, 1",
            "TEZZTESTEX, F",
            "TES, 3",
            "TEXXT, 1"
    })
    void testAutomaton(String input, String expected) {
        TestAutomaton.State state = TestAutomaton.process(input);
        String result = TestAutomaton.finalStateLabel(state);
        assertEquals(expected, result);
    }
}