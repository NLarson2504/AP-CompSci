import java.util.Scanner;
import java.util.*;

/**
 * Javadoccing this thingy-majiggy
 * @version Monday, September 27, 2021
 * @author 23larson
 */
public class SimpleIOMath {
    private String name;
    private int age;
    private int favNumber;


    private int determinePrime(int age) {
        int smallest = 2;
        for (int i = 2; i <= (int)(Math.sqrt(age))+1; i++) {
            if(age%i == 0)
                return i;
        }
        return age;
    }


    /**
     * THIS METHOD PROMPTS THE USER FOR INFORMATION AND STORES IT
     */
    public void promptUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("Question 1: What is your name? ");
        name = input.nextLine();
        System.out.println("Question 2: How old are you? ");
        age = input.nextInt();
        System.out.println("Question 3: What is your favorite number? ");
        favNumber = input.nextInt();
    }

    /**
     * THIS METHOD TAKES THE STORED INFO AND PRINTS IT BACK TO THE USER
     */
    public void printInfo() {
        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + (age));
        System.out.println("At your next birthday, you will turn " + Math.addExact(age, 1));
        System.out.println("The first prime factor of " + age + " is " + determinePrime(age));
        System.out.println("Your favorite number is " + favNumber);
        System.out.println("Your favorite number squared is " + Math.pow(favNumber, 2));
    }

    /**
     * GUESSES USERS COLOR BASED OFF OF THE FIRST LETTER
     */
    public void colorGuesser() {
        Scanner input = new Scanner(System.in);
        String[] colorList = {"amber", "ash", "asphalt", "auburn", "avocado", "aquamarine", "azure", "beige", "bisque", "black", "blue", "bone", "bordeaux", "brass", "bronze", "brown", "burgundy", "camel", "caramel", "canary", "celeste", "cerulean", "champagne", "charcoal", "chartreuse", "chestnut", "chocolate", "citron", "claret", "coal", "cobalt", "coffee", "coral", "corn", "cream", "crimson", "cyan", "denim", "desert", "ebony", "ecru", "emerald", "feldspar", "fuchsia", "gold", "gray", "green", "heather","indigo", "ivory", "jet", "khaki", "lime", "magenta", "maroon", "mint", "navy", "olive", "orange", "pink", "plum", "purple", "red", "rust", "salmon", "sienna", "silver", "snow", "steel", "tan", "teal", "tomato", "violet", "white", "yellow"};
        String[] favColorList = {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ",};
        int newNum = 0;
        System.out.println("Whats the first letter of your favorite color?");
        String theirFirstLet;
        char firstLet;
        theirFirstLet = input.nextLine().toLowerCase();
        for (int i = 0; i < colorList.length; i++) {
            firstLet = colorList[i].charAt(0);
            String compareFirstLet = String.valueOf(firstLet);
            if(compareFirstLet.equals(theirFirstLet)) {
                favColorList[newNum] = colorList[i];
                newNum++;
            }
        }

        if (favColorList[0] != " "){
            Random rand = new Random();
            int n = rand.nextInt(favColorList.length);
            while(favColorList[n] == " ") {
                n = rand.nextInt(favColorList.length);
            }
            String guess = "Is Your Favorite Color " + favColorList[n] + "?";
            System.out.println(guess);
            String answer = input.nextLine().toLowerCase().strip();
            if(answer.equals("yes")) {
                System.out.println("Yay I got it!");
            } else {
                System.out.println(":(");
            }
        } else {
            System.out.println("Hmm, I dont know that color!");
        }

    }

    /**
     * THE 'MAIN' ENTRANCE POINT WHERE THE CODE RUNS
     * @param args THE ARGUMENTS GIVEN BY THE WRITER
     */
    public static void main(String[] args) {
        System.out.println("* Sit yourself down, take a seat *");
        System.out.println("* All you gotta do is repeat after me *");
        SimpleIOMath obj = new SimpleIOMath();
        obj.promptUser();
        System.out.println("I'm gonna teach you how to sing it out");
        System.out.println("Come on, come on, come on");
        System.out.println("Let me tell you what it's all about");
        System.out.println("Reading, writing, arithmetic");
        System.out.println("Are the branches of the learning tree");
        obj.printInfo();
        obj.colorGuesser();




    }


}