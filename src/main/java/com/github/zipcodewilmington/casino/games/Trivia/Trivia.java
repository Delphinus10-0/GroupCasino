package com.github.zipcodewilmington.casino.games.Trivia;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Trivia {
  HashMap<Integer, Questions> trivia;
  public int currentScore;
  Scanner input;
  int score = 0;


  public Trivia() {
    trivia = new HashMap<>();
    currentScore = 0;
    input = new Scanner(System.in);
    triviaAdd();
  }
      public void triviaAdd() {
          trivia = new HashMap<>();
          currentScore = 0;
          input = new Scanner(System.in);
        //adding questions and answers
        trivia.put(1, new Questions("What is the capital of France?", Arrays.asList("A. Paris", "B. Rome", "C. Madrid", "D. Berlin"), "Paris"));
        trivia.put(2, new Questions("How many continents are there?", Arrays.asList("A. 8", "B. 7", "C. 6", "D. 5"), "7"));
        trivia.put(3, new Questions("Who wrote 'Romeo and Juliet'?", Arrays.asList("A. William Shakespeare", "B. Charles Dickens", "C. Jane Austen", "D. Mark Twain"), "William Shakespeare"));
        trivia.put(4, new Questions("What is the largest ocean on Earth?", Arrays.asList("A. Atlantic Ocean", "B. Indian Ocean", "C. Arctic Ocean", "D. Pacific Ocean"), "Pacific Ocean"));
        trivia.put(5, new Questions("Who painted the Mona Lisa?", Arrays.asList("A. Vincent van Gogh", "B. Leonardo da Vinci", "C. Pablo Picasso", "D. Claude Monet"), "Leonardo da Vinci"));
        trivia.put(6, new Questions("What is the hardest natural substance on Earth?", Arrays.asList("A. Gold", "B. Iron", "C. Diamond", "D. Quartz"), "Diamond"));
        trivia.put(7, new Questions("Which planet is known as the Red Planet?", Arrays.asList("A. Mars", "B. Jupiter", "C. Venus", "D. Saturn"), "Mars"));
        trivia.put(8, new Questions("What is the chemical symbol for gold?", Arrays.asList("A. Ag", "B. Au", "C. Fe", "D. Hg"), "Au"));
        trivia.put(9, new Questions("Who invented the telephone?", Arrays.asList("A. Thomas Edison", "B. Nikola Tesla", "C. Alexander Graham Bell", "D. Michael Faraday"), "Alexander Graham Bell"));
        trivia.put(10, new Questions("What is the smallest country in the world?", Arrays.asList("A. Monaco", "B. Nauru", "C. Liechtenstein", "D. Vatican City"), "Vatican City"));
        trivia.put(11, new Questions("What is the main ingredient in guacamole?", Arrays.asList("A. Tomato", "B. Avocado", "C. Onion", "D. Pepper"), "Avocado"));
        trivia.put(12, new Questions("In what year did the Titanic sink?", Arrays.asList("A. 1910", "B. 1912", "C. 1914", "D. 1916"), "1912"));
        trivia.put(13, new Questions("Who is the author of 'Harry Potter'?", Arrays.asList("A. J.R.R. Tolkien", "B. J.K. Rowling", "C. George R.R. Martin", "D. Stephen King"), "J.K. Rowling"));
        trivia.put(14, new Questions("What is the capital of Japan?", Arrays.asList("A. Seoul", "B. Beijing", "C. Tokyo", "D. Bangkok"), "Tokyo"));
        trivia.put(15, new Questions("How many elements are in the periodic table?", Arrays.asList("A. 112", "B. 114", "C. 116", "D. 118"), "118"));
        trivia.put(16, new Questions("What is the largest mammal in the world?", Arrays.asList("A. Elephant", "B. Blue whale", "C. Giraffe", "D. Rhinoceros"), "Blue whale"));
        trivia.put(17, new Questions("What is the fastest land animal?", Arrays.asList("A. Lion", "B. Cheetah", "C. Tiger", "D. Gazelle"), "Cheetah"));
        trivia.put(18, new Questions("Who developed the theory of relativity?", Arrays.asList("A. Isaac Newton", "B. Niels Bohr", "C. Albert Einstein", "D. Galileo Galilei"), "Albert Einstein"));
        trivia.put(19, new Questions("What is the currency of Japan?", Arrays.asList("A. Chinese yuan", "B. South Korean won", "C. Japanese yen", "D. Thai baht"), "Japanese yen"));
        trivia.put(20, new Questions("What organ is capable of regenerating tissue?", Arrays.asList("A. Heart", "B. Brain", "C. Liver", "D. Lung"), "Liver"));
        trivia.put(21, new Questions("Which gas is most abundant in the Earth's atmosphere?", Arrays.asList("A. Oxygen", "B. Hydrogen", "C. Carbon dioxide", "D. Nitrogen"), "Nitrogen"));
        trivia.put(22, new Questions("What year did the first man walk on the moon?", Arrays.asList("A. 1965", "B. 1966", "C. 1967", "D. 1969"), "1969"));
        trivia.put(23, new Questions("What is the longest river in the world?", Arrays.asList("A. Amazon River", "B. Nile River", "C. Yangtze River", "D. Mississippi River"), "Nile River"));
        trivia.put(24, new Questions("Who is known as the father of computers?", Arrays.asList("A. Charles Babbage", "B. Alan Turing", "C. John Atanasoff", "D. Konrad Zuse"), "Charles Babbage"));
        trivia.put(25, new Questions("What is the pH of water?", Arrays.asList("A. 5", "B. 6", "C. 7", "D. 8"), "7"));
        trivia.put(26, new Questions("Who was the first woman to win a Nobel Prize?", Arrays.asList("A. Marie Curie", "B. Dorothy Hodgkin", "C. Rosalind Franklin", "D. Ada Yonath"), "Marie Curie"));
        trivia.put(27, new Questions("What is the capital of Canada?", Arrays.asList("A. Toronto", "B. Vancouver", "C. Ottawa", "D. Montreal"), "Ottawa"));
        trivia.put(28, new Questions("What does DNA stand for?", Arrays.asList("A. Deoxyribonucleic Acid", "B. Dinitrogen Amonoxide", "C. Dicarboxylic Nucleic Amide", "D. Deoxycytidine Acid"), "Deoxyribonucleic Acid"));
        trivia.put(29, new Questions("Who wrote 'The Odyssey'?", Arrays.asList("A. Homer", "B. Virgil", "C. Plato", "D. Aristotle"), "Homer"));
        trivia.put(30, new Questions("What is the boiling point of water at sea level in Celsius?", Arrays.asList("A. 90", "B. 95", "C. 100", "D. 105"), "100"));
        trivia.put(31, new Questions("Who discovered penicillin?", Arrays.asList("A. Marie Curie", "B. Alexander Fleming", "C. Louis Pasteur", "D. Gregory Mendel"), "Alexander Fleming"));
        trivia.put(32, new Questions("What is the largest desert in the world?", Arrays.asList("A. Gobi", "B. Sahara", "C. Arabian", "D. Kalahari"), "Sahara Desert"));
        trivia.put(33, new Questions("Who was the first president of the United States?", Arrays.asList("A. Thomas Jefferson", "B. Abraham Lincoln", "C. George Washington", "D. John Adams"), "George Washington"));
        trivia.put(34, new Questions("What is the currency of the European Union?", Arrays.asList("A. Pound Sterling", "B. Euro", "C. Swiss Franc", "D. U.S. Dollar"), "Euro"));
        trivia.put(35, new Questions("How many teeth does an adult human have?", Arrays.asList("A. 28", "B. 30", "C. 32", "D. 34"), "32"));
        trivia.put(36, new Questions("What is the capital of Australia?", Arrays.asList("A. Sydney", "B. Melbourne", "C. Canberra", "D. Brisbane"), "Canberra"));
        trivia.put(37, new Questions("What is the largest planet in our solar system?",Arrays.asList("A. Saturn", "B. Jupiter", "C. Uranus", "D. Neptune"), "Jupiter"));
        trivia.put(38, new Questions("What year did World War II end?", Arrays.asList("A. 1943", "B. 1944", "C. 1945", "D. 1946"), "1945"));
        trivia.put(39, new Questions("What is the capital of Italy?", Arrays.asList("A. Florence", "B. Milan", "C. Venice", "D. Rome"), "Rome"));
        trivia.put(40, new Questions("What is the largest island in the world?", Arrays.asList("A. New Guinea", "B. Borneo", "C. Madagascar", "D. Greenland"), "Greenland"));
    }

    public void play (){
      for(Map.Entry<Integer, Questions> entry : trivia.entrySet()){
        askQuestion(entry.getKey());
        String playerAnswer = getPlayerAnswer();
        boolean isCorrect = checkAnswer(playerAnswer, entry.getKey());
        updateScore(isCorrect);
      }
    }


    //why not public?
    private void askQuestion(Integer identifier){
        Questions question = trivia.get(identifier);
      System.out.println("\n" + question.getText());
      for (String choice : question.getChoices()) {
        System.out.println(choice);
      }

    }

    private String getPlayerAnswer(){
      System.out.println("What is your answer: ");
      Scanner answer = new Scanner(System.in);
      return answer.nextLine().trim().toUpperCase();

    }

  public boolean checkAnswer(String answer, int identifier) {
    Questions question = trivia.get(identifier);
    return question.getCorrectAnswer().equalsIgnoreCase(answer);
  }



    public void updateScore(boolean isTheAnswerCorrect){
        if (isTheAnswerCorrect){
          System.out.println("It is correct!");
          currentScore++;
        }
        else{
          System.out.println("Wrong asnwer! Try again... I am kiding, you had one chance");

        }
    }

//  public static void main(String[] args) {
//    Trivia trivia = new Trivia();
//    trivia.play();
//  }

}
