package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.Trivia.Trivia;
import com.github.zipcodewilmington.casino.games.Trivia.Questions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriviaTest {


//Test if the answer is correct
@Test
public void testCheckAnswerCorrect() {
    Trivia trivia = new Trivia();
    assertTrue(trivia.checkAnswer("Pacific Ocean", 4));
}

    @Test
    public void testIncorrectAnswer() {
        Trivia trivia = new Trivia();
        assertFalse(trivia.checkAnswer("Arctic Ocean", 4));
    }


//Test if the score is updating
@Test
    public void testUpdateScore(){
    Trivia trivia = new Trivia();
    trivia.updateScore(true);
    assertEquals(1, trivia.currentScore);
}

    @Test
    public void testNotUpdateScore(){
        Trivia trivia = new Trivia();
        trivia.updateScore(false);
        assertEquals(0, trivia.currentScore);
    }






















}
