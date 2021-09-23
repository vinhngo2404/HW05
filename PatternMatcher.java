import java.util.Locale;
import java.util.Scanner;

/**
 * A program that simulate a game.
 *
 * <p>Purdue University -- CS18000 -- Fall 2021 -- Homework 05 -- Challenge</p>
 *
 * @author Purdue CS Vinh Ngo
 * @version September 23, 2021
 */

public class PatternMatcher {

    public static void main(String[] args) {

        String chooseLevel = "Choose Level Difficulty:" +
                "\n1. Easy\n2. Medium\n3. Hard";
        String startNumber = "Enter a number to start the pattern:";
        String nextThree = "Enter the next 3 numbers in the pattern:";
        String congratulations = "Congrats! Your answer was correct!";
        String sorry = "Sorry! Your answer was incorrect!";
        String again = "Play Game Again? (y/n)";
        String ending = "Ending Pattern Matcher...";
        int inputStartNum = 0;
        int inputAnswer = 0;
        int count = 0;
        boolean playAgain = true;


        while (playAgain) {
            Scanner scanner = new Scanner(System.in);
            boolean isValid = true;
            String inputLevel = "";
            while (isValid) {
                System.out.println(chooseLevel);
                inputLevel = scanner.nextLine();
                if (inputLevel.equals("1") || inputLevel.equals("2") || inputLevel.equals("3")) {
                    isValid = false;
                }
            }
            // difficulty level 1
            if (inputLevel.equals("1")) {
                // read the start number from the user
                System.out.println(startNumber);
                inputStartNum = scanner.nextInt();
                int ogValue = inputStartNum;
                scanner.nextLine();
                // print out first three number
                System.out.println(nextThree);
                for (int i = 1; i <= 4; i++) {
                    if (i == 4) {
                        System.out.print(inputStartNum);
                    } else {
                        System.out.print(inputStartNum + " ");
                    }
                    inputStartNum = inputStartNum + 2;
                }
                System.out.println();

                // declare an arr to store the correct num list
                inputStartNum = ogValue;
                int[] arr = new int[7];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = inputStartNum;
                    inputStartNum += 2;
                }
                // store user output and check if it matches the array
                int temp = 4;
                int[] arrAnswer = new int[3];
                for (int i = 0; i <= 2; i++) {
                    inputAnswer = scanner.nextInt();
                    scanner.nextLine();
                    arrAnswer[i] = inputAnswer;
                    if (arrAnswer[i] == arr[temp]) {
                        count++;
                    }
                    temp++;
                }
                // print out the result of the game;
                if (count == 3) {
                    System.out.println(congratulations);
                } else {
                    System.out.println(sorry);
                }
                // ask users whether they want to play again or not
                System.out.println(again);
                String isAgain = scanner.nextLine().toLowerCase();
                if (isAgain.equals("n")) {
                    playAgain = false;
                }
            } else if (inputLevel.equals("2")) {
                // read the start number from the user
                System.out.println(startNumber);
                inputStartNum = scanner.nextInt();
                int ogValue = inputStartNum;
                scanner.nextLine();
                // print out first three number
                System.out.println(nextThree);
                for (int i = 1; i <= 4; i++) {
                    if (i == 4) {
                        System.out.print(inputStartNum);
                    } else {
                        System.out.print(inputStartNum + " ");
                    }
                    inputStartNum = inputStartNum * 4;
                }
                System.out.println();

                // declare an arr to store the correct num list
                inputStartNum = ogValue;
                int[] arr = new int[7];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = inputStartNum;
                    inputStartNum *= 4;
                }
                // store user output and check if it matches the array
                int temp = 4;
                int[] arrAnswer = new int[3];
                for (int i = 0; i <= 2; i++) {
                    inputAnswer = scanner.nextInt();
                    scanner.nextLine();
                    arrAnswer[i] = inputAnswer;
                    if (arrAnswer[i] == arr[temp]) {
                        count++;
                    }
                    temp++;
                }
                // print out the result of the game;
                if (count == 3) {
                    System.out.println(congratulations);
                } else {
                    System.out.println(sorry);
                }
                // ask users whether they want to play again or not
                System.out.println(again);
                String isAgain = scanner.nextLine().toLowerCase();
                if (isAgain.equals("n")) {
                    playAgain = false;
                }
                // difficulty level 3
            } else {
                // read the start number from the user
                System.out.println(startNumber);
                inputStartNum = scanner.nextInt();
                int ogValue = inputStartNum;
                scanner.nextLine();
                // declare an arr to store the correct num list and also print out first three number
                System.out.println(nextThree);
                int[] arr = new int[7];
                for (int i = 0; i < arr.length; i++) {
                    if (i <= 3) {
                        arr[i] = ogValue * ogValue + 1;
                        if (i == 3) {
                            System.out.print(arr[i]);
                        } else {
                            System.out.print(arr[i] + " ");
                        }
                    } else {
                        arr[i] = ogValue * ogValue + 1;
                    }
                    ogValue++;
                }
                System.out.println();
                // store user output and check if it matches the array
                int temp = 4;
                int[] arrAnswer = new int[3];
                for (int i = 0; i <= 2; i++) {
                    inputAnswer = scanner.nextInt();
                    scanner.nextLine();
                    arrAnswer[i] = inputAnswer;
                    if (arrAnswer[i] == arr[temp]) {
                        count++;
                    }
                    temp++;
                }
                // print out the result of the game;
                if (count == 3) {
                    System.out.println(congratulations);
                } else {
                    System.out.println(sorry);
                }
                // ask users whether they want to play again or not
                System.out.println(again);
                String isAgain = scanner.nextLine().toLowerCase();
                if (isAgain.equals("n")) {
                    playAgain = false;
                }
            }
        }
        System.out.println(ending);
    }
}
