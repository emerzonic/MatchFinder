package com.emerson;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Survey {
    private static final Scanner scanner = new Scanner(System.in);
    private static int questionIndex = 0;
    private static final Map<String, int[]> result = new HashMap<>();
    private static final int[] scores = new int[10];

    static Map<String, int[]> takeSurvey() {
        String name = getUserInfo();
        takeUserSurveyResponses();
        result.put(name, scores);
        return result;
    }

    private static String getUserInfo() {
        System.out.println("Take our survey to get matched up with a friend.");
        System.out.println("Please enter your username.\r");
        String name = scanner.nextLine();
        System.out.println("Welcome " + name + "!\nPlease enter the number for the best option to each question.\n");
        return name;
    }

    private static void takeUserSurveyResponses() {
        String[] questions = getQuestions();
        while (questionIndex <= questions.length - 1) {
            String input = getUserInput(questions);
            String errorMessage = "\u001B[31m" + input + " is not a valid input. Enter any option from 1 to 5.\n" + "\u001B[0m";
            try{
                checkInput(input, errorMessage);
            }catch (NumberFormatException e){
                System.out.println(errorMessage);
            }
        }
    }

    private static String[] getQuestions() {
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

    private static String getUserInput(String[] questions) {
        String question = "#" + (questionIndex + 1) + ". " + questions[questionIndex];
        System.out.println(question);
        System.out.println(displayOptions());
        return scanner.nextLine();
    }

    private static String displayOptions() {
        return "1 Strongly Disagreed\n2 Somehow Disagreed\n3 Not too sure\n4 Somehow Agreed\n5 Strongly Agreed";
    }

    private static void checkInput(String input, String errorMessage) {
        int optionNumber = Integer.parseInt(input);
        if(isValidOptionNumber(optionNumber)) {
            scores[questionIndex] = optionNumber;
            questionIndex += 1;
        }else {
            System.out.println(errorMessage);
        }
    }

    private static boolean isValidOptionNumber(int index) {
        return index > 0 && index < 6;
    }
}
