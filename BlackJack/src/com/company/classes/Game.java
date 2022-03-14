package com.company.classes;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Game {

    String[] interfaceCommands = { "1", "2", "q"};

    public Game(){}

    public void start() {
        Deck mainDeck = new Deck(4);
        mainDeck.shuffle();
        DealerHand dealer = new DealerHand(mainDeck);
        Hand player = new Hand(mainDeck);
        do {
            Scanner in = new Scanner(System.in);
            dealer.showHand();
            player.showHand();
            gameInterface();
            System.out.print("Input: ");
            boolean flag = false;
            do {
                String inp = in.next();
                if(Arrays.asList(interfaceCommands).contains(inp.toLowerCase())) {
                    switch (inp.toLowerCase()) {
                        case "1" -> {
                            player.takeCard(mainDeck);
                            System.out.println("You`ve taken a card!");
                            if(player.calculate() > 21) {
                                System.out.println("You`ve lost!");
                                player.showHand();
                                System.out.println("Try again! Type something to continue..");
                                in.next();
                                dealer = new DealerHand(mainDeck);
                                player = new Hand(mainDeck);
                            }

                        }
                        case "2" -> {
                            dealer.openHand();
                            while(dealer.calculate() < 17) {
                                dealer.takeCard(mainDeck);
                            }
                            dealer.showHand();
                            player.showHand();
                            if(dealer.calculate() > player.calculate() && dealer.calculate() <= 21) {
                                System.out.println("You`ve lost!");
                            } else if (dealer.calculate() < player.calculate()) {
                                if(player.calculate() == 21) {
                                    System.out.println("You`ve won! BLACKJACK!!!");
                                } else {
                                    System.out.println("You`ve won!");
                                }
                            } else {
                                System.out.println("Draw!! Nobody wins!");
                            }
                            System.out.println("Want again?! Type something to continue..");
                            in.next();
                            dealer = new DealerHand(mainDeck);
                            player = new Hand(mainDeck);
                        }
                        case "q" -> flag = true;
                        default -> throw new UnsupportedOperationException(inp + " is not added to switch statement.");
                    }
                    break;
                }
                System.out.println("Wrong input!");
            } while(flag);
            if(flag) {
                break;
            }
            System.out.print("\n\n\n\n");

        } while(true);
        System.out.println("GoodBye!!");
    }

    public void gameInterface() {
        System.out.println("1. Take a card\n2. Open Dealer`s hand");
    }
}
