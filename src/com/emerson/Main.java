package com.emerson;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //Initial friends
        String[] currentFriends = {"Mary", "Joe", "Sarah", "Eric"};
//        Map<String, int[]> friends = new HashMap<String, int[]>();

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



//        // using keySet() for iteration over keys
//        for (String name : friends.keySet()){
//            Matches.setMatches(name);
//            System.out.println(name +" : "+  Friend.getNums(friends.get(name)));
//
//    }
    }
}
