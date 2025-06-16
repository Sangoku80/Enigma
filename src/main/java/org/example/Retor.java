package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Retor {

    HashMap<String, Integer> associationLettersNumbersExternCircle = new HashMap<>();
    HashMap<Integer, Integer> associationNumbersNumbersInternCircle = new HashMap<>();
    HashMap<Integer, Integer> associationNumbersNumbersBetweenCircles = new HashMap<>();

    public Retor() {

        // associationLettersNumbersExternCircle
        associationLettersNumbersExternCircle.put("A", 26);
        associationLettersNumbersExternCircle.put("B", 4);
        associationLettersNumbersExternCircle.put("C", 3);
        associationLettersNumbersExternCircle.put("D", 5);
        associationLettersNumbersExternCircle.put("E", 6);
        associationLettersNumbersExternCircle.put("F", 8);
        associationLettersNumbersExternCircle.put("G", 7);
        associationLettersNumbersExternCircle.put("H", 9);
        associationLettersNumbersExternCircle.put("I", 11);
        associationLettersNumbersExternCircle.put("J", 12);
        associationLettersNumbersExternCircle.put("K", 10);
        associationLettersNumbersExternCircle.put("L", 14);
        associationLettersNumbersExternCircle.put("M", 13);
        associationLettersNumbersExternCircle.put("N", 15);
        associationLettersNumbersExternCircle.put("O", 16);
        associationLettersNumbersExternCircle.put("P", 18);
        associationLettersNumbersExternCircle.put("Q", 19);
        associationLettersNumbersExternCircle.put("R", 20);
        associationLettersNumbersExternCircle.put("S", 17);
        associationLettersNumbersExternCircle.put("T", 21);
        associationLettersNumbersExternCircle.put("U", 23);
        associationLettersNumbersExternCircle.put("V", 24);
        associationLettersNumbersExternCircle.put("W", 25);
        associationLettersNumbersExternCircle.put("X", 22);
        associationLettersNumbersExternCircle.put("Y", 1);
        associationLettersNumbersExternCircle.put("Z", 2);

        // associationNumbersNumbersInternCircle
        associationNumbersNumbersInternCircle.put(13, 1);
        associationNumbersNumbersInternCircle.put(20, 2);
        associationNumbersNumbersInternCircle.put(15, 3);
        associationNumbersNumbersInternCircle.put(17, 4);
        associationNumbersNumbersInternCircle.put(24, 5);
        associationNumbersNumbersInternCircle.put(21, 6);
        associationNumbersNumbersInternCircle.put(18, 7);
        associationNumbersNumbersInternCircle.put(26, 8);
        associationNumbersNumbersInternCircle.put(16, 9);
        associationNumbersNumbersInternCircle.put(23, 10);
        associationNumbersNumbersInternCircle.put(25, 11);
        associationNumbersNumbersInternCircle.put(19, 12);
        associationNumbersNumbersInternCircle.put(1, 13);
        associationNumbersNumbersInternCircle.put(22, 14);
        associationNumbersNumbersInternCircle.put(3, 15);
        associationNumbersNumbersInternCircle.put(9, 16);
        associationNumbersNumbersInternCircle.put(4, 17);
        associationNumbersNumbersInternCircle.put(7, 18);
        associationNumbersNumbersInternCircle.put(12, 19);
        associationNumbersNumbersInternCircle.put(2, 20);
        associationNumbersNumbersInternCircle.put(6, 21);
        associationNumbersNumbersInternCircle.put(14, 22);
        associationNumbersNumbersInternCircle.put(10, 23);
        associationNumbersNumbersInternCircle.put(5, 24);
        associationNumbersNumbersInternCircle.put(11, 25);
        associationNumbersNumbersInternCircle.put(8, 26);

        // associationNumbersNumbersBetweenCircles
        associationNumbersNumbersBetweenCircles.put(1, 18);

        for (int number = 2; number < 27; number++)
        {
            int addition = associationNumbersNumbersBetweenCircles.get(1)+(number - 1);

            if (addition > 26)
            {
                addition -= 26;
            }

            associationNumbersNumbersBetweenCircles.put(number, addition);
        }

    }

    public void tournerRetor()
    {
        for(Integer entry: associationNumbersNumbersBetweenCircles.keySet()) {
            if (associationNumbersNumbersBetweenCircles.get(entry)-1 > 0)
            {
                associationNumbersNumbersBetweenCircles.put(entry, associationNumbersNumbersBetweenCircles.get(entry)-1);
            }
            else
            {
                associationNumbersNumbersBetweenCircles.put(entry, 26);
            }
        }
    }

    public String crypter(String letter) {

        String newLetter = null;

        for (String element : associationLettersNumbersExternCircle.keySet()) {
            if (Objects.equals(element, letter)) {
                int firstNumber = associationLettersNumbersExternCircle.get(element);
                int secondNumber = associationNumbersNumbersBetweenCircles.get(firstNumber);
                int thirdNumber = associationNumbersNumbersInternCircle.get(secondNumber);

                int fourthNumber = 0;

                for (Map.Entry<Integer, Integer> entry : associationNumbersNumbersBetweenCircles.entrySet()) {

                    if (entry.getValue() == thirdNumber) {
                        fourthNumber = entry.getKey();
                    }
                }

                for (Map.Entry<String, Integer> entry : associationLettersNumbersExternCircle.entrySet()) {

                    if (entry.getValue() == fourthNumber) {
                        newLetter = entry.getKey();
                    }
                }

                tournerRetor();
            }
        }
        return newLetter;
    }
}
