package com.example.springhangman;


import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class View {

    Scanner sc = new Scanner(System.in);

    Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    void show() {
        System.out.println(new String(controller.getHiddenWord()));
        System.out.println("Ezekből válogathatsz még:");
        System.out.println(controller.getAbcList());
        for (char c: gallows.toCharArray()) {
            if (c == '\n') {
                System.out.println();
            } else if (c == ' ') {
                System.out.print(" ");
            } else {
                int  x = c - '0';
                if (controller.getLife() <= x ) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

        }
    }

    boolean action() {
        boolean isAlive = true;
        do {
            show();
            System.out.println("Adj meg egy bötűt:");
            char c = sc.next().charAt(0);
            c = Character.toUpperCase(c);
            String hiddenWord = controller.checkWord(c);
            if (hiddenWord == null) {
                isAlive = false;
                show();
            } else if (!hiddenWord.contains("_")) {
                show();
                break;
            }

        } while (isAlive);

        if (isAlive) {
            System.out.println("Nyertél!");
        } else {
            System.out.println("Meghaltál!");
            System.out.println(controller.getWord() + " volt a megfejtés!");
        }
        System.out.println("Játszanál mégegyet? Y/N");
        char c = sc.next().charAt(0);
        c = Character.toUpperCase(c);

        return c == 'Y';

    }

    private String gallows= """
        877777777
        8      6
        8     555
        8     5 5
        8      4
        8    33422
        8      4
        8     1 0
        8    1   0
        8
        """;
}
