package com.emerson;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Survey {
    private static String[] getQuestions(){
        return new String[]{"Your mind is always buzzing with unexplored ideas and plans.",
                "Generally speaking, you rely more on your experience than your imagination.",
                "You find it easy to stay relaxed and focused even when there is some pressure.",
                "You rarely do something just out of sheer curiosity.",
                "People can rarely upset you.",
                "It is often difficult for you to relate to other people’s feelings.",
                "In a discussion, truth should be more important than people’s sensitivities.",
                "You rarely get carried away by fantasies and ideas.",
                "You think that everyone’s views should be respected regardless of whether they are supported by facts or not.",
                "You feel more energetic after spending time with a group of people.",};
    }


     static Map<String, int[]> takeSurvey(){
        Map<String, int[]> result = new HashMap<>();
        int [] scores = new int[10];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Take our survey to get matched up with a friend.");
        System.out.println("Please enter your full name.\r");
        String name = scanner.nextLine();
        System.out.println("Welcome " + name+"!\nPlease enter the number for the best option to each question.");
        String[] questions = Survey.getQuestions();
        int i = 1;
        for (String q:questions) {
            System.out.println("Q-"+i+". "+ q);
            System.out.println(displayOptions());
            int input = scanner.nextInt();
            scores[i-1] = input;
            i+=1;
        }
        result.put(name,scores);
        return result;

    }

    private static String displayOptions(){
        return "1 Strongly Disagreed\n2 Somehow Disagreed\n3 Not too sure\n4 Somehow Agreed\n5 Strongly Agreed";
    }


}
