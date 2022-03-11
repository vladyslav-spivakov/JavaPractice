package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * This is a game that simulates "Contact" game
 * @author Vladyslav Spivakov
 * @since 11.03.2022
 * */

public class Main {
    static String[] words = {"Hero", "Car", "Ukraine", "Hunter", "Enemy", "Warship"}; // Words to guess
    static int[] indexes;
    static int turn = 0;
    static int progress = 1;

    static void formIndexes() {
        indexes = new int[words.length];
        var localIndexes = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            localIndexes[i] = i;
        }
        int n = words.length; // Indexes to add
        for( int i = 0; i < words.length; i++) {
            int randomInd = (int)(Math.random() * n); // Random index from 0 to n-1
            indexes[i] = localIndexes[randomInd];
            localIndexes[randomInd] = localIndexes[--n]; // We used randomInd element, so replace it with last element, that is not used still
        }
        // Now we have formed array of indexes randomly swapped
    }

    static String getWord() {
        System.out.print("Your guess: ");
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    static void sayWord( String word, String currentWord) {
        String substring = currentWord.substring(0,progress);
        if(!word.toLowerCase().startsWith(substring.toLowerCase())) {
            System.out.println("You`ve written a wrong word! My word starts with \"" + substring + "\"");
        } else if(word.equalsIgnoreCase(currentWord)) {
            System.out.println("Wonderful! " + currentWord + " was my word!");
            progress = 1;
            turn++;
        } else {
            if(Math.random() > 0.4) {
                System.out.println("Good, that`s a good word, but not mine!");
                progress++;
            } else {
                System.out.println("Not a good word, sorry.");
            }
        }
    }

    static void gameCycle(){
        String currentWord = words[indexes[turn]];
        for(int i = 0; i < currentWord.length(); i++) {
            System.out.print( i < progress ? currentWord.charAt(i) : '*' );
        }
        System.out.printf(" (%d%%)\n", progress * 100 / currentWord.length());
        if(progress == currentWord.length()) {
            System.out.println("That was good! My word was " + currentWord);
            progress = 1;
            turn++;
            return;
        }
        String playerWord = getWord(); // Get a word from user`s input
        sayWord(playerWord, currentWord); // Say a word
    }


    static void startGame(){
        // Form indexes[] array
        formIndexes();
        System.out.println("Welcome to Contact game! I am sure you`re ready!! So let`s begin..");
        System.out.println("I have a word, so try to reveal it!");
        do {
            gameCycle();
            System.out.print("\n\n");
        } while(turn != words.length);


    }

    static void endGame() {
        System.out.println("Thanks for playing my game!!!");
    }

    public static void main(String[] args) {
        startGame();
        endGame();
    }
}