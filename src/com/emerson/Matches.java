package com.emerson;

import java.util.*;

public class Matches {
    private static Map<Integer, Friend> matches = new HashMap<>(100);

    public static Map<Integer, Friend> getMatches() {
        return matches;
    }


    public static void addFriend(Integer id, Friend friend) {
        matches.put(id, friend);
    }

}
