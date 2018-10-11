package com.emerson;

import java.util.Map;

public class Friend {
    private Map<String, int[]> data;
    private String name;

    public Friend(Map<String, int[]> data, String name) {
        this.data = data;
        this.name = name;
    }


    public static String getNums(int[] list) {
        StringBuilder numlist = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            String num1 = list[i] + ", ";
            numlist.append(num1);
        }
        return numlist.toString();
    }

    public int getScores() {

        for (String key : this.data.keySet()) {
            System.out.println(this.data.get(key)[0]);
        }
        return 1;
    }


    public String getBestMatch() {
        //initialize bestMatch number that starts at the highest possible variance
        int bestMatch = 40;
        String matchedFriend = "";
        int variance;

        for (String friend : Matches.getMatches().keySet()) {
            variance = 0;
            for (int i = 0; i < Matches.getMatches().get(friend).length; i++) {
                System.out.println(Matches.getMatches().get(friend)[i] + " : " + this.data.get(this.name)[i]);
                variance += Math.abs((Matches.getMatches().get(friend)[i]) - (this.data.get(this.name)[i]));
                System.out.println(variance);
            }
            if (variance <= bestMatch) {
                bestMatch = variance;
                matchedFriend = friend;
            }
        }
        Matches.setMatches(this.name, this.data.get(this.name));
        return matchedFriend;
    }

}