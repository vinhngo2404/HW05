import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MazeNavigator extends Thread {
    private static int currentRow;
    private static int currentColumn;
    private static int moveNumber;
    private static boolean started;
    private static char[][] maze;
    private int playerNumber;
    private String fileName;

    // constructor
    public MazeNavigator(int playerNumber, String fileName) {
        this.playerNumber = playerNumber;
        this.fileName = fileName;
    }

    // methods

    public static char[][] printInitialMaze() {
        System.out.println("Welcome! Initial Maze:");
        char[][] arr = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = ' ';
            }
        }
        arr[4][4] = 'X';
        for (int i = 0; i < 10; i++) {
            System.out.print('[');
            for (int j = 0; j < 10; j++) {
                if (j == 9) {
                    System.out.print(arr[i][j]);
                } else {
                    String s = arr[i][j] + ",";
                    System.out.print(s);
                }
            }
            System.out.print(']');
            System.out.println();
        }
        return arr;
    }

    public void run() {
        char[][] arr = new char[10][10];
        arr = printInitialMaze();
        ArrayList<Integer> arrayListP1 = new ArrayList<>();
        ArrayList<Integer> arrayListP2 = new ArrayList<>();
        arrayListP1 = readFile("/Users/ngokienvinh/Documents/vinhngo31/src/HW10/P1Moves.txt");
        arrayListP2 = readFile("/Users/ngokienvinh/Documents/vinhngo31/src/HW10/P2Moves.txt");

    }

    public static void printMazeWhilePlaying(ArrayList<Integer> arr, char[][] arr2D) {
        // loop through array to find the index of character X
        int indexRowOfX = 0;
        int indexColumnOfX = 0;
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                if (arr2D[i][j] == 'X') {
                    indexRowOfX = i;
                    indexColumnOfX = j;
                    break;
                }
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) >= 1 && arr.get(i) <= 4) {
                if (arr.get(i) == 1) {
                    if(indexColumnOfX == 0) {
                        arr2D[indexRowOfX][indexColumnOfX] = ' ';
                        arr2D[indexRowOfX][9] = 'X';
                    }else {
                        arr2D[indexRowOfX][indexColumnOfX] = ' ';
                        arr2D[indexRowOfX][indexColumnOfX - 1] = 'X';
                    }
                }else if(arr.get(i) == 2) {
                    if(indexColumnOfX == 9) {
                        arr2D[indexRowOfX][indexColumnOfX] = ' ';
                        arr2D[indexRowOfX][0] = ' ';
                    }else {
                        arr2D[indexRowOfX][indexColumnOfX] = ' ';
                        arr2D[indexRowOfX][indexColumnOfX + 1] = ' ';
                    }
                }else if(arr.get(i) == 3) {
                    if(indexRowOfX == 0) {
                        arr2D[indexRowOfX][indexColumnOfX] = ' ';
                        arr2D[9][indexColumnOfX] = 'X';
                    }else {
                        arr2D[indexRowOfX][indexColumnOfX] = ' ';
                        arr2D[indexRowOfX - 1][indexColumnOfX] = 'X';
                    }
                }else {
                    if(indexRowOfX == 9) {
                        arr2D[indexRowOfX][indexColumnOfX] = ' ';
                        arr2D[0][indexColumnOfX] = 'X';
                    } else {
                        arr2D[indexRowOfX][indexColumnOfX] = ' ';
                        arr2D[indexRowOfX + 1][indexColumnOfX] = 'X';
                    }
                }
            } else {
                System.out.println("Error, invalid input!");
            }
        }
    }

    public static ArrayList<Integer> readFile(String fileName) {
        ArrayList<String> arr = new ArrayList<>();
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(fileName));
            String line = bfr.readLine();
            while (line != null) {
                arr.add(line);
                line = bfr.readLine();
            }
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            int element = Integer.parseInt(arr.get(i));
            arrayList.add(element);
        }
        return arrayList;
    }

    public static void main(String[] args) {
//        try {
//            MazeNavigator[] mazeNavigators = {new MazeNavigator(1, "PlayerOneMoves.txt"),
//                    new MazeNavigator(2, "PlayerTwoMoves.txt")};
//
//            for (int i = 0; i < mazeNavigators.length; i++) {
//                mazeNavigators[i].start();
//            }
//            for (int i = 0; i < mazeNavigators.length; i++) {
//                mazeNavigators[i].join();
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return;
//        }

        //test print out initial maze
        char[][] arr = new char[10][10];
        arr = printInitialMaze();
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.println();
            }
        }
    }

}
