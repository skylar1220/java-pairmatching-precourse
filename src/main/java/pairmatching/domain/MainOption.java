package pairmatching.domain;

import java.util.Arrays;

public enum MainOption {
    FAIR_MATCHING("1"),
    FAIR_SEARCH("2"),
    FAIR_INIT("3"),
    QUIT("Q"),
    ;

    private final String userCommand;

    MainOption(String userCommand) {
        this.userCommand = userCommand;
    }

    public static MainOption from(String input) {
        return Arrays.stream(values())
                .filter(option -> option.userCommand.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("입력은 1,2,3,Q 중에서 해야합니다."));
    }
}