package com.emerson;

import java.util.Map;

public class Friend {
    Map<String, Integer> data;

    public Friend(Map<String, Integer> data) {
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



}


