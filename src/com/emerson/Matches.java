package com.emerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Matches {
    private static Map<String, int[]> matches;

    public static Map<String, int[]> getMatches() {
        return matches;
    }

    public static void setMatches(String friend, int[] scores) {
        Matches.matches.put(friend, scores);
    }

}
