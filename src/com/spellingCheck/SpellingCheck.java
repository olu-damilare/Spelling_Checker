package com.spellingCheck;

public class SpellingCheck {


    private String[] words = {"LARGE", "SMALL", "SOURCE", "DEFAULT", "REMAIN", "SEED", "FOOD", "MONEY", "CAR", "HONEY"};

    public String check(String word) {
        for (String s : words) {
            if (word.equalsIgnoreCase(s))
                return "Word is spelled correctly";
        }
     return "Word is not spelled correctly";
    }

    public String checkTransposed(String word) {
        while(!check(word).equals("Word is spelled correctly")) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length - 1; i++) {
                char tempChar = chars[i];
                chars[i] = chars[i + 1];
                chars[i + 1] = tempChar;
            }
            word = String.valueOf(chars);
        }
        return "Did you mean " + word + "?";
    }

    public String checkDoubleTyped(String word) {
        StringBuilder newWord = new StringBuilder();
        for (int i = 0; i < word.length() - 1; i++) {
            if(word.charAt(i) != word.charAt(i + 1))
                newWord.append(word.charAt(i));
        }
        newWord.append(word.charAt(word.length() - 1));

        return "Did you mean " + newWord.toString() + "?";

    }
}
