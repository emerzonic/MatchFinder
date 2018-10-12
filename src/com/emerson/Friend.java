package com.emerson;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Friend {
    private static int userCount = 0;
    private Integer id;
    private String name;
    private int[] scores;


    public Friend(String name, int[] scores) {
        this.name = name;
        this.scores = scores;
        userCount++;
        this.id = userCount;
    }

    public String getName() {
        return name;
    }


    public Integer getId() {
        return id;
    }

    private int getSumOfScores() {
        int sum = 0;
        for (int i : this.scores)
            sum += i;
        return sum;
    }


    //This method compares the new user survey scores to each friend in storage and returns a best matched
    public String getBestMatch() {
        int bestMatch = 40;
        String matchedFriend = "";
        int friendTotal, variance;

        Set<Map.Entry<Integer, Friend>> entries = Matches.getMatches().entrySet();

        for (Map.Entry<Integer, Friend> frd : entries) {
            Friend friend = frd.getValue();
            friendTotal = 0;

            for (int score : friend.scores) {
                friendTotal += score;
            }
            variance = Math.abs((friendTotal) - (this.getSumOfScores()));

            if (variance <= bestMatch) {
                bestMatch = variance;
                matchedFriend = friend.name;
            }
        }
        return matchedFriend;
    }

}