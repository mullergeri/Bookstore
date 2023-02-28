package com.example.springhangman;


import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
@Component
public class Controller {

    private final String word;
    private char[] hiddenWord;
    private List<Character> abcList = new ArrayList<>();
    private int life = 9;

    public Controller(String word) {
        this.word = word;

        hiddenWord = "_".repeat(word.length()).toCharArray();

        for (char i = 'A'; i <= 'Z'; i++) {
            abcList.add(i);
        }
    }

    public String getWord() {
        return word;
    }

    public int getLife() {
        return life;
    }

    public List<Character> getAbcList() {
        return abcList;
    }

    public String checkWord(char c) {
        if (!abcList.contains(c)) {
            return new String(hiddenWord);
        }
        boolean isGood = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                hiddenWord[i] = c;
                isGood = true;
            }
        }
        abcList.remove((Character) c);

        if (!isGood) {
            life--;
            return life == 0 ? null : new String(hiddenWord);
        }
        return new String(hiddenWord);
    }


    public char[] getHiddenWord() {
        return hiddenWord;
    }
}
