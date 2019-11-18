package com.emerson;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Application {

    static void populateUsers() {
        String[] currentFriends = {"Mary DeVola", "Joe Particks", "Sarah Antoe", "Eric Massola"};
        for (String name : currentFriends) {
            int[] scores = new int[10];
            int index = 0;
            while (index < 10) {
                Random random = new Random();
                int score = random.nextInt((5 - 1) + 1) + 1;
                scores[index] = score;
                index++;
            }
            Friend friend = new Friend(name, scores);
            Matches.addFriend(friend.getId(), friend);
        }
    }

    static void start() {
        System.out.println("W E L C O M E  TO  M A T C H F I N D E R");
        int surveyCount = 0;
        boolean quit = false;

        while (!quit) {
            String input = promptUser(surveyCount);
            switch (input) {
                case "y":
                    Map<String, int[]> newFriendData = Survey.takeSurvey();
                    for (String name : newFriendData.keySet()) {
                        surveyCount = takeSurvey(surveyCount, newFriendData, name);
                    }
                    break;
                default:
                    System.out.println("No problem see you another time.");
                    quit = true;
                    break;
            }
        }

    }

    private static int takeSurvey(int surveyCount, Map<String, int[]> newFriendData, String name) {
        Friend newFriend = new Friend(name, newFriendData.get(name));
        System.out.println("Based on your responses, your best match is " + newFriend.getBestMatch().toUpperCase() + ".");
        Matches.addFriend(newFriend.getId(), newFriend);
        surveyCount++;
        return surveyCount;
    }

    private static String promptUser(int surveyCount) {
        String againOrNow = surveyCount > 0 ? "again" : "now";
        System.out.println("Will you like to take a quick survey " + againOrNow +"?." +
                "\nHit \"y\" to proceed to survey or hit any key to quit.");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();
        return response.toLowerCase();
    }

}
