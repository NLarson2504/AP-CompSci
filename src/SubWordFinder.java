/**
 * SubWord object contains the root word and the two interior words
 * @Version 2-1-2022
 * @Author 23larson
 */

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

/**
 * SubwordFinder is a class with private constants of a dictionary and alphabet
 */
public class SubWordFinder implements WordFinder {
    private final ArrayList<ArrayList<String>> dictionary;
    private final String alpha = "abcdefghijklmnopqrstuvwxyz";

    /**
     * The constructor for a SubWordFinder, populating a dictionary with the proper arraylists.
     */
    public SubWordFinder(){
        dictionary = new ArrayList<>();
        for(int i = 0; i < alpha.length(); i++){
            dictionary.add(new ArrayList<String>());
        }
        populateDictionary();
    }
    @Override
    /**
     * See comment on wordFinder.java
     */
    public void populateDictionary(){
        try{
            Scanner in = new Scanner(new File("words_all_os.txt"));
            while(in.hasNext()){
                String word = in.nextLine();
                dictionary.get(alpha.indexOf(word.charAt(0))).add(word);
            }in.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    /**
     * See comment on wordFinder.java
     */
    public boolean inDictionary(String word){
        int index = alpha.indexOf(word.charAt(0));
        ArrayList<String> bucket = dictionary.get(index);
        return bogoSortJustKiddingItsBinarySearch(bucket, word);
    }

    private boolean bogoSortJustKiddingItsBinarySearch(ArrayList<String> listy, String word) {
        int left = 0, right = listy.size() - 1;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            // Check if x is present at mid
            if (listy.get(mid).compareTo(word) == 0)
                return true;
            // If x greater, ignore left half
            if (listy.get(mid).compareTo(word) < 0)
                left = mid + 1;
                // If x is smaller, ignore right half
            else
                right = mid - 1;
        }
        // if we reach here, then element was
        // not present
        return false;
    }

    @Override
    /**
     * See comment on wordFinder.java
     */
    public ArrayList<SubWord> getSubWords(){
        ArrayList<SubWord> subwords = new ArrayList<>();
        for(ArrayList<String> bucket : dictionary){
            for(String word : bucket){
                if(word.length() > 5){
                    for(int i = 2; i < word.length()-2; i++){
                        if(inDictionary(word.substring(0, i)) && (inDictionary(word.substring(i)))){
                            subwords.add(new SubWord(word, word.substring(0, i), word.substring(i)));
                        }
                    }
                }
            }
        }
        return subwords;
    }

    /**
     * Finds maximum value from an Array of ints.
     * @param t is an Array of ints
     * @return returns the maximum value from the Array.
     */
    public static int max(int[] t) {
        int maximum = t[0];   // start with the first value
        for (int i=1; i<t.length; i++) {
            if (t[i] > maximum) {
                maximum = t[i];   // new maximum
            }
        }
        return maximum;
    }//end method max

    /**
     * mostCommonSuffix is a method that takes the parameter of an arraylist of subwords,
     * generates an Array of ints of the size of all the different subwords in order to count the number of occurences of each one,
     * and then prints the most common suffix with the number of occurences it has.
     * @param a is an ArrayList of subwords.
     */
    public static void mostCommonSuffix(ArrayList<SubWord> a) {
        ArrayList<String> Suffixes = new ArrayList<>();
        ArrayList<String> sizeFinder = new ArrayList<>();
        for(SubWord s : a){
            Suffixes.add(s.getSuffix());
            sizeFinder.add(s.getSuffix());
        }
        for(int i = sizeFinder.size()-1; i >= 0; i--){
            int occurences = Collections.frequency(sizeFinder, sizeFinder.get(i));
            if(occurences > 1) {
                sizeFinder.remove(i);
            }
        }
        Collections.sort(sizeFinder);
        int[] suffixCounter = new int[sizeFinder.size()];
        Arrays.fill(suffixCounter, 0);
        for(String thingy : sizeFinder){
            for(String otherThingy : Suffixes){
                if(otherThingy.equals(thingy)){
                    suffixCounter[sizeFinder.indexOf(thingy)] += 1;
                }
            }
        }
        List<Integer> list = Arrays.stream(suffixCounter).boxed().toList();
        int index = list.indexOf(max(suffixCounter));
        System.out.println( sizeFinder.get(index)+ " is the most common suffix with " + max(suffixCounter) + " occurrences.");
    }

    public static void mostCommonPrefix(ArrayList<SubWord> a) {
        ArrayList<String> Prefixes = new ArrayList<>();
        ArrayList<String> sizeFinder2 = new ArrayList<>();
        for(SubWord s : a){
            Prefixes.add(s.getPrefix());
            sizeFinder2.add(s.getPrefix());
        }
        for(int i = sizeFinder2.size()-1; i >= 0; i--){
            int occurences = Collections.frequency(sizeFinder2, sizeFinder2.get(i));
            if(occurences > 1) {
                sizeFinder2.remove(i);
            }
        }
        Collections.sort(sizeFinder2);
        int[] prefixCounter = new int[sizeFinder2.size()];
        Arrays.fill(prefixCounter, 0);
        for(String thingy : sizeFinder2){
            for(String otherThingy : Prefixes){
                if(otherThingy.equals(thingy)){
                    prefixCounter[sizeFinder2.indexOf(thingy)] += 1;
                }
            }
        }
        List<Integer> list = Arrays.stream(prefixCounter).boxed().toList();
        int index = list.indexOf(max(prefixCounter));
        System.out.println( sizeFinder2.get(index)+ " is the most common prefix with " + max(prefixCounter) + " occurrences.");
    }


    /**
     * The main entry point of the code
     * @param args arguments that the author can decide to provide or not
     */
    public static void main(String[] args) {
        SubWordFinder app = new SubWordFinder();
        for(SubWord a : app.getSubWords())
            System.out.println(a);
        System.out.println();
        System.out.println("There are " + app.getSubWords().size() + " words with subwords in the list");
        System.out.println();
        mostCommonSuffix(app.getSubWords());
        mostCommonPrefix(app.getSubWords());
    }
}
