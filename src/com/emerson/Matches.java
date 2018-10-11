package com.emerson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Matches {
    private static Map<String, int[]> matches = new HashMap<>();

    public static Map<String, int[]> getMatches() {
        return matches;
    }

    public static void setMatches(String name, int[] scores) {
        matches.put(name, scores);
    }

}
