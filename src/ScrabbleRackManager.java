package src;

import java.sql.Array;
import java.util.*;
import java.io.*;

public class ScrabbleRackManager {
    ArrayList<ArrayList<String>> dictionary;
    ArrayList<String> tileRack;
    String alpha = "abcdefghijklmnopqrstuvwxyz";
    ArrayList<String> tiles;
    int[] base;

    /** class constructor */
    public ScrabbleRackManager(){
        dictionary = new ArrayList<>();
        tileRack = new ArrayList<>();
        tiles = new ArrayList<String>();
        String[] tileList = new String[]{"A", "A", "A", "A", "A", "A", "A", "A", "A", "B", "B", "C", "C", "D", "D", "D", "D",
                "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "F", "F", "G", "G", "G", "H", "H", "I", "I",
                "I","I","I","I","I","I","I","J","K","L","L","L","L","M","M","N","N","N","N","N","N","O","O","O","O","O",
                "O","O","O","P","P","Q", "R","R","R","R","R","R","S","S","S","S","T","T","T","T","T","T","U","U","U","U",
                "V","V","W","W","X","Y","Y","Z"," ", " "};
        for(int i = 0; i < alpha.length(); i++){
            dictionary.add(new ArrayList<String>());
        }
        tiles.addAll(Arrays.asList(tileList));

        //build dictionary
        try{
            Scanner in = new Scanner(new File("datafiles/2019_collins_scrabble.txt"));
            while(in.hasNext()){
                String word = in.nextLine();
                if(word.length()>0)
                    dictionary.get(alpha.indexOf(word.toLowerCase().charAt(0))).add(word);
            }
            in.close();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error opening file...");
        }

        //shuffle tiles
        Collections.shuffle(tiles);

        //add to tileRack
        for(int i = 0; i<7; i++)
            tileRack.add(tiles.remove((int)(Math.random()*tiles.size())));
    }

    /** displays the contents of the player's tile rack */
    public void printRack() {
        System.out.println("Letters in the rack: " + tileRack);
    }

    /**
     * Determines if a word is playable with given tiles
     * @param word the letters being checked to see if it makes a word
     * @return returns true if it is a word, false if not
     */
    public boolean isPlayable(String word){
        ArrayList<String> tempRack = new ArrayList<>(tileRack);
        int spaces = 0;

        for(String a : tempRack)
            if (a.equals(" "))
                spaces+=1;

        if (word.length() > 7){ return false; }
        for(int i = 0; i < word.length() ; i++){
            if(!tempRack.contains(word.substring(i, i + 1)) && spaces == 0) {
                return false;
            } else {
                if (!tempRack.contains(word.substring(i, i + 1)))
                    spaces -= 1;
                else
                    tempRack.remove(tempRack.indexOf(word.substring(i, i + 1)));
            }
        }
        return (true);
    }

    /** builds and returns an ArrayList of String objects that are values pulled
     from
     * the dictionary/database based on the available letters in the user's tile
     * rack */
    public ArrayList<String> getPlaylist() {
        ArrayList<String> playList = new ArrayList<>();
        for(ArrayList<String> a : dictionary){
            if((a.get(0)).charAt(0) == tileRack.get(0).charAt(0) || (a.get(0)).charAt(0) == tileRack.get(1).charAt(0) || (a.get(0)).charAt(0) == tileRack.get(2).charAt(0) || (a.get(0)).charAt(0) == tileRack.get(3).charAt(0) || (a.get(0)).charAt(0) == tileRack.get(4).charAt(0) || (a.get(0)).charAt(0) == tileRack.get(5).charAt(0) || (a.get(0)).charAt(0) == tileRack.get(6).charAt(0)){
                playList.addAll(a);
            }
        }
        for(int m = playList.size()-1; m >= 0; m--){
            if(!isPlayable(playList.get(m))){
                playList.remove(m);
            }
        }
        return playList;
    }


    /** print all of the playable words based on the letters in the tile rack DONE */
    public void printMatches() {
        ArrayList<String> plays = getPlaylist();
        boolean bingo = false;
        for(int i = 0; i < plays.size(); i++){
            String word = plays.get(i);
            if(word.length() == 7){
                word += "*";
                bingo = true;
            }
            System.out.printf("%-10s", word);
            if((i+1) % 10 == 0){System.out.println();}
            }
        if(bingo) {System.out.println("\n* Denotes BINGO");}
    }

    /** main method for the class; use only 3 command lines in main DONE */
    public static void main(String[] args){
        ScrabbleRackManager app = new ScrabbleRackManager();
        app.printRack();
        app.printMatches();
    }
}
