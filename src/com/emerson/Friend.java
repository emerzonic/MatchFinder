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

    public int[] getScores() {
        return scores;
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


    public String getBestMatch() {
        int bestMatch = 40;
        String matchedFriend = "";
        int friendTotal, variance;

        Set<Map.Entry<Integer, Friend>> entries = Matches.getMatches().entrySet();

        for (Map.Entry<Integer, Friend> frd : entries) {
            Friend friend = frd.getValue();
            friendTotal = 0;

            for (int score : friend.getScores()) {
                friendTotal += score;
            }

            variance = Math.abs((friendTotal) - (this.getSumOfScores()));
            System.out.println(variance + " for " + friend.name);

            if (variance <= bestMatch) {
                bestMatch = variance;
                matchedFriend = friend.name;
            }
        }
        return matchedFriend;
    }

}