package com.emerson;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Initial friends
        String[] currentFriends = {"Mary", "Joe", "Sarah", "Eric"};

        //Add initial friends survey data
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
        Friend newFriend = new Friend(newFriendData, "Emerson");
        System.out.println(newFriend.getBestMatch());

        for (String s:Matches.getMatches().keySet()
             ) {
            System.out.println(s);
        }

//        for (String n:newFriendData.keySet()) {
//            System.out.println(n +" : "+ Friend.getNums(newFriendData.get(n)));
//        }
    }
}
