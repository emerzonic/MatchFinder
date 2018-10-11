package com.emerson;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class Friend {
    public static int userCount = 0;
    public int id;
    private String name;
    private int[] scores;


    public Friend(String name,int[] scores) {
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

    private int getSumOfScores(){
        int sum = 0;
        for (int i:this.scores)
            sum+=i;
        return sum;
    }



    public String getBestMatch() {
        int bestMatch = 40;
        String matchedFriend = "";
        int friendTotal, variance;

        for (String friend : Matches.getMatches().keySet()) {
            friendTotal = 0;
            int[] friendsList = Matches.getMatches().get(friend);
            for (int score :friendsList) {
                friendTotal+=score;
            }
            variance = Math.abs((friendTotal) - (this.getSumOfScores()));
            System.out.println(variance +" for "+ friend);

            if (variance <= bestMatch) {
                bestMatch = variance;
                matchedFriend = friend;
            }
        }
        Matches.setMatches(this.name, this.scores);
        return matchedFriend;
    }

}