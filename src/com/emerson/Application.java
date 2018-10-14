package com.emerson;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Application {

    static void populateUsers() {
        //Get some friends survey data to start with
        String[] currentFriends = {"Mary DeVola", "Joe Particks", "Sarah Antoe", "Eric Massola"};

        //Generate some random responses for survey
        for (String name : currentFriends) {
            int[] scores = new int[10];
            int index = 0;
            while (index < 10) {
                Random random = new Random();
                int score = random.nextInt((5 - 1) + 1) + 1;
                scores[index] = score;
                index++;
            }
            //Create new friend objects and add to storage
            Friend friend = new Friend(name, scores);
            Matches.addFriend(friend.getId(), friend);
        }
    }


    static void runApplication() {
        //Prompt the user to take the survey or not
        Scanner scanner = new Scanner(System.in);
        System.out.println("W E L C O M E  TO  M A T C H F I N D E R");
        int surveyCount = 0;
        boolean quit = false;

        while (!quit) {
            String againOrNow = surveyCount > 0 ? "again" : "now";
            System.out.println("Will you like to take a quick survey " + againOrNow +"?." +
                    "\nHit \"y\" to proceed to survey or hit any key to quit.");
            String response = scanner.nextLine();
            String input = response.toLowerCase();
            switch (input) {
                case "y":
                    //Conduct new survey for incoming friend and save his/her result to a newFriendData Map
                    Map<String, int[]> newFriendData = Survey.takeSurvey();
                    for (String name : newFriendData.keySet()) {
                        Friend newFriend = new Friend(name, newFriendData.get(name));
                        System.out.println("Based on your responses, your best match is " +
                                newFriend.getBestMatch().toUpperCase() + ".");
                        Matches.addFriend(newFriend.getId(), newFriend);
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
