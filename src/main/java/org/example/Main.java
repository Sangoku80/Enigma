package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner saisieUtilisateur = new Scanner(System.in);
        Retor retor1 = new Retor();

        do {
            // demander la clé d'accès pour comprendre le message
            System.out.println("Veuillez indiquer la clé d'accès : ");
            Integer key = saisieUtilisateur.nextInt();
            saisieUtilisateur.nextLine();
            retor1.setAssociationLettersNumbersBetweenCircle(key);

            System.out.println("Veuillez saisir un message à décrypter: ");
            String secretWord = saisieUtilisateur.nextLine();

            StringBuilder word = new StringBuilder();

            for (int i = 0; i < secretWord.length(); i++) {
                char c = secretWord.charAt(i);
                word.append(retor1.crypter(String.valueOf(c)));
            }

            System.out.println(word);

        } while (true);
    }
}