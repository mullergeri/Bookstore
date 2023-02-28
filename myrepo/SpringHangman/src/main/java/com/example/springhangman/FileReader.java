package com.example.springhangman;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
@Service
public class FileReader {

    private String filepath = "C:\\Users\\Geri\\OneDrive\\Asztali gép\\words.txt";

    private List<String> wordList = new ArrayList<>();

    public FileReader() throws FileNotFoundException {
        readFile();
    }

    void readFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filepath));

        while (sc.hasNextLine()) {
            wordList.add(sc.nextLine());
        }
    }
    @Bean
    public String getRandomWord() {
        return wordList.get(new Random().nextInt(wordList.size())).toUpperCase();
    }
}
