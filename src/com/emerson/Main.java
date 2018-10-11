package com.emerson;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Get some friends survey data to start with
        String[] currentFriends = {"Mary", "Joe", "Sarah", "Eric"};

        //Generate some random responses for survey
        for (String name : currentFriends) {
            int[] scores = new int[10];
            int index = 0;
            while (index < 3) {
                Random random = new Random();
                int score = random.nextInt((5 - 1) + 1) + 1;
                scores[index] = score;
                index++;
            }

            //Create new friend objects
            Friend friend = new Friend(name, scores);
            System.out.println(Friend.userCount);
            System.out.println(friend.id);
            Matches.setMatches(friend.getName(), friend.getScores());
        }


        Scanner scanner = new Scanner(System.in);
        System.out.println("W E L C O M E  TO  M A T C H F I N D E R.");
        int surveyCount = 0;
        boolean quit = false;

        while (!quit) {
            String again = surveyCount>0?"again":"now";
            System.out.println("Will you like to take a quick survey "+again+ "?. Hit y to proceed or hit any key to quit.");
            String input = scanner.nextLine();

            switch (input) {
                case "y":
                    //Conduct new survey for incoming friend and save his/her result to a newFriendData Map
                    Map<String, int[]> newFriendData = Survey.takeSurvey();
                    for (String name : newFriendData.keySet()) {
                        Friend newFriend = new Friend(name, newFriendData.get(name));
                        System.out.println(newFriend.id);
                        System.out.println("Based on your responses, your best match is " + newFriend.getBestMatch().toUpperCase() + ".");
                        surveyCount++;
                    }
                    break;
                 default:
                    System.out.println("No problem see you another time");
                    quit = true;
                    break;
            }
        }
    }
}
