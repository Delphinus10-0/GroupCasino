package com.github.zipcodewilmington.casino.games.Trivia;
import java.util.List;
public class Questions {
    String text;
    List<String> choices;

    String correctAnswer;

    public Questions (String text, List<String> choices, String correctAnswer){
        this.choices=choices;
        this.text=text;
        this.correctAnswer=correctAnswer;

    }
public String getText(){
        return this.text;
}

public List<String> getChoices(){
        return this.choices;
    }

public String getCorrectAnswer(){
        return this.correctAnswer;
}




}


