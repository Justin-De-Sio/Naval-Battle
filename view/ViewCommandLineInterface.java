package view;

import controller.GameController;
import model.Board;

import java.io.IOException;
import java.util.Scanner;

public class ViewCommandLineInterface {


    private GameController controller;

    public void setController(GameController gameController) {
        this.controller = gameController;

    }

    public void displayBoard(Board board) {

        System.out.println("\tA   B   C   D   E   F   G   H   I   J   K   L   M   N   O");

        for (int i = 0; i < 15; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < 15; j++) {
                if (!board.getBoard()[i][j].isContainShip())
                    System.out.print("~" + " | ");
                else {
                    System.out.print("■" + " | ");
                }

            }
            System.out.println();
        }

    }

    public void displayMenu() {
        System.out.println("               ************************************                ");
        System.out.println("               ************************************                ");
        System.out.println("*************  Bienvenue dans la bataille Navale  ************* ");
        System.out.println("               ************************************                ");
        System.out.println("                        ******************                         ");
        System.out.println("                        ******************                         ");
        System.out.println("                             *********                             ");


        System.out.println("1 : Jouer une partie");
        System.out.println("2 : Charger une partie");
        System.out.println("3 : Aide");
        System.out.println("4 : Quitter\n");

        controller.MenuChoice(new Scanner(System.in).nextInt());

    }


    public void displayHelp() {

        System.out.println("                 **********  Aide  **********");
        System.out.println("                 |      L'objectif est de faire couler tous les bateaux ennemi     |");
        System.out.println("                 |     Chacun des joueurs posséde une grille afin de positionner les navires, l'autre grille sert à visualisé les dégats    |");
        System.out.println("                 |     Chaque joueur possede 10 navires : 1 cuirassé, 2 croiseurs, 3 destroyers et 4 sous marins     |");
        System.out.println("                 |     Taille : ");
        System.out.println("                 |     Cuirassé : 7 cases");
        System.out.println("                 |     Croiseur : 5 cases");
        System.out.println("                 |     Destroyer : 3 cases");
        System.out.println("                 |     Sous marin : 1 case");
        System.out.println("                 |     Puissance de tir : ");
        System.out.println("                 |     Cuirassé : 9 cases");
        System.out.println("                 |     Croiseur : 4 cases");
        System.out.println("                 |     Destroyer : 1 cases");
        System.out.println("                 |     Sous marin : 1 case");
        System.out.println("                 |      L'objectif est de faire couler tous les bateaux ennemis     |");

        System.out.println();
        System.out.println("                 Appuyez sur Entrée pour confirmer.");

        Scanner readinput = new Scanner(System.in);

        String enterkey = "x";

        while (!enterkey.equals("")) {
            enterkey = readinput.nextLine();
        }

    }

    public String askSelectShip() {
        System.out.println("Où souhaitez-vous Tirer ?");
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        try {
            if (!controller.isValideCoord(result)) {
                throw new IOException("Mauvais input ! Vous devez écrire un input au format 'A0' ou 'C13' ! ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            askSelectShip();
        }
        return result;
    }


    // Retourne 1 si déplacement
    // Retourne 2 si tir
    public void askForMoveOrShoot() {
        System.out.println();
        System.out.println("Choisissez une option :");
        System.out.println("1 - Se déplaceṙ");
        System.out.println("2 - Tirer");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 1 && choice != 2) {
            try {
                choice = scanner.nextInt();

            } catch (java.util.InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Vous devez entrer un chiffre !");
            }

            System.out.println();
        }
        controller.callMoveOrShoot(choice);

    }


    public void displayGameOver(String winner) {

        System.out.println("                 **********  Quitter **********");
        System.out.println("                 |       La partie est finie      |");

        //  afficher le gagnant et faire un switch case
//        controller.quit();
//        displayMenu();
    }

    public void askForMove() {

    }
}
