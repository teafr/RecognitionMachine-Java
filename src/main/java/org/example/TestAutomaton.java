package org.example;

public class TestAutomaton {

    public enum State { S, ONE, TWO, THREE, F }

    /**
     * @return state (F - found, 0/1/2/3 - current position)
     */
    public static State process(String input) {
        State state = State.S;

        for (char character : input.toCharArray()) {
            switch (state) {
                case S:
                    state = (character == 'T') ? State.ONE : State.S;
                    break;
                case ONE:
                    state = (character == 'E') ? State.TWO : (character == 'T') ? State.ONE : State.S;
                    break;
                case TWO:
                    state = (character == 'S') ? State.THREE : (character == 'T') ? State.ONE : State.S;
                    break;
                case THREE:
                    state = (character == 'T') ? State.F : (character == 'T') ? State.ONE : State.S;
                    break;
                case F:
                    state = State.F;
            }
        }
        return state;
    }

    private static State nextState(State state, char character) {
        switch (state) {
            case ONE:
                if (character == 'E') return State.TWO;
                break;
            case TWO:
                if (character == 'S') return State.THREE;
                break;
            case THREE:
                if (character == 'T') return State.F;
                break;
            case F:
                return State.F;
        }
        if (character == 'T') return State.ONE;
        return State.S;
    }

    public static String finalStateLabel(State state) {
        if (state == State.F) return "F";
        return String.valueOf(state.ordinal());
    }
}