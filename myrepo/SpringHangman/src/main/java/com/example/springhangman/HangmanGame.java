package com.example.springhangman;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class HangmanGame {

    private FileReader fileReader;


    public HangmanGame(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void playNext() {

       Controller controller = new Controller(fileReader.getRandomWord());
        View view = new View(controller);
        while (view.action()) playNext();
    }

}
