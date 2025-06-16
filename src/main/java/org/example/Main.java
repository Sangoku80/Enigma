package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Retor retor1 = new Retor();
        Scanner saisieUtilisateur = new Scanner(System.in);

        do
        {
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