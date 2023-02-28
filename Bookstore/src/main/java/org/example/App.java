package org.example;

import java.util.Scanner;

public class App {
    private View view;

    public static void main(String[] args) throws Exception {
       App a = new App();
       View v = new View();

       try(
               Scanner sc = new Scanner(System.in);
               Controller c = new Controller()

               ) {
           a.view = v;
           v.controller = c;
           v.mainMenu(sc);

       }





    }
}