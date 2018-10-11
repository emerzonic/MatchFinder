package com.emerson;

import java.util.Map;

public class Friend {
    Map<String, int[]> data;

    public Friend(Map<String, int[]> data) {
        this.data = data;
    }


    public static String getNums(int[] list){
        StringBuilder numlist = new StringBuilder();
        for(int i = 0; i< list.length; i++){
            String num1 = list[i] + ", ";
            numlist.append(num1);
        }
        return numlist.toString();
    }

    public static String getBestMatch() {
        //initialize bestMatch number that starts at the highest possible variance
        int bestMatch = 40;
        String matchedFriend = "";
        int variance;
        //select each friend from the group
        for (String friend: Matches.getMatches()
             ) {

        }
        matches.forEach(friend => {
                variance = 0;
        //Compare each friend score to the score of the new friend
        for (var i = 0; i < friend.scores.length && i < newFriend.scores.length; i++) {
            //Add up the absolute difference from comparing each of their score
            variance += Math.abs(parseInt(friend.scores[i]) - parseInt(newFriend.scores[i]));
        }
        //compare the total difference to the highest possible difference
        if (variance <= bestMatch) {
            //if the difference is less or equal, the difference is now the best matched
            bestMatch = variance;
            //create a new object of the matched friend to be send back in the response
            matchedFriend = {
                    name: friend.name,
                    image: friend.image,
                    score: bestMatch
            };
        }
    });
        matches.push(newFriend);
        //send the matched friend back
        res.json(matchedFriend);

    });

}


