package com.emerson;

import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Initial friends list
        String[] currentFriends = {"Mary", "Joe", "Sarah", "Eric"};

        //Add initial friends to survey data
        for (String friend:currentFriends){
            int[] scores = new int[10];
            int index = 0;
            while(index < 10){
                Random random = new Random();
                int score = random.nextInt((5 - 1) + 1) + 1;
                scores[index] = score;
                index++;
            }
            Matches.setMatches(friend, scores);
        }

        Map<String, int[]> newFriendData = Survey.takeSurvey();
        Friend newFriend = new Friend(newFriendData, "Emerson");//testing
        System.out.println(newFriend.getBestMatch());

        for (String s:Matches.getMatches().keySet()
             ) {
            System.out.println(s);
        }
    }
}
