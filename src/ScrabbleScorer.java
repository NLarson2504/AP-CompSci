import java.util.*;
import java.io.*;

/**
 * @author 23larson
 * @version 20.1.2022
 * ScrabbleScorer takes string input from the user, checks to see if it is a valid word, and scores it.
 */
public class ScrabbleScorer {
    private ArrayList<String> dictionary;
    private int[] points = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    private String alpha;

    /**
     *Scrabble Scorer class initializes the dictionary, the alphabet, and builds the dictionary.
     */
    private ScrabbleScorer(){
        dictionary = new ArrayList<>();
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        buildDictionary();
    }

    /**
     * buildDictionary method uses a scanner to read the scrabble dictionary, add it to an ArrayList, and sorts the ArrayList.
     */
    public void buildDictionary(){
        try{
            Scanner boi = new Scanner(new File("SCRABBLE_WORDS.txt"));
            while(boi.hasNext()) {
                dictionary.add(boi.nextLine());
            }
            boi.close();
            Collections.sort(dictionary);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    /**
     * isValidWord method returns a boolean; True is it is in the scrabble dictionary, False if not.
     * Implements binary search to get the word from the sorted dictionary.
     * @param word String argument which is what the method checks to see if it is in the dictionary.
     * @return true or false based on whether or not the word is in the dictionary or not.
     */
    public boolean isValidWord(String word){
        return Collections.binarySearch(dictionary, word) >= 0;
    }

    /**
     * getWordScore scores every letter in the word provided and returns the sum of those scores.
     * @param word String argument which is what the method scores the points of.
     * @return returns points of the word.
     */
    public int getWordScore(String word) {
        int sum = 0;
        for(int i = 0; i < word.length(); i++){
            sum += points[alpha.indexOf(word.charAt(i))];
        }
        return sum;
    }

    /**
     * The main entry point for the code; where everything runs.
     * @param args are the arguments that can be set for the entry point.
     */
    public static void main(String[] args) {
        ScrabbleScorer app = new ScrabbleScorer();
        System.out.println("*Welcome to the Scrabble Scorer App*");
        String userWord;
        Scanner userIn = new Scanner(System.in);
        try {
            while(true) {
                System.out.print("Enter a word to score or 0 to quit: ");
                userWord = userIn.nextLine();
                if (userWord.equals("0")) {
                    break;
                }else{
                    if(app.isValidWord(userWord.toUpperCase())){
                        System.out.println(userWord + " = " + app.getWordScore(userWord.toUpperCase()) + " points");
                    } else {
                        System.out.println(userWord + " is not a valid word in the Dictionary");
                    }
                    }

                }
            userIn.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("Exiting the program thanks for playing");
    }
}
