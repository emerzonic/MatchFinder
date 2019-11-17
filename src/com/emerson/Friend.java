package com.emerson;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Friend {
    private static int userCount = 0;
    private Integer id;
    private String name;
    private int[] scores;
    private int sumOfScores;


    public Friend(String name, int[] scores) {
        this.name = name;
        this.scores = scores;
        userCount++;
        this.id = userCount;
        this.sumOfScores = setSumOfScores();
    }

    public String getName() {
        return name;
    }


    public Integer getId() {
        return id;
    }

    private int setSumOfScores() {
        int sum = 0;
        for (int i : this.scores)
            sum += i;
        return sum;
    }


    public String getBestMatch() {
        int bestMatch = 40;
        String matchedFriend = "";
        int friendTotal, variance;

        Set<Map.Entry<Integer, Friend>> entries = Matches.getMatches().entrySet();

        for (Map.Entry<Integer, Friend> value : entries) {
            Friend friend = value.getValue();
                variance = Math.abs((friend.sumOfScores) - (this.sumOfScores));
            if (variance <= bestMatch) {
                bestMatch = variance;
                matchedFriend = friend.name;
            }
        }
        return matchedFriend;
    }

}