import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A program to simulate thread.
 *
 * <p>Purdue University -- CS18000 -- Fall 2021 -- Homework 10 -- Walkthrough</p>
 *
 * @author Purdue CS
 * @version Nov 5, 2021
 */

public class MazeNavigator extends Thread {
    private static int currentRow = 4;
    private static int currentColumn = 4;
    private static int moveNumber = 1;
    private static boolean started = false;
    private static char[][] maze = new char[10][10];
    private int playerNumber;
    private String fileName;
    public static Object o = new Object();

    // constructor
    public MazeNavigator(int playerNumber, String fileName) {
        this.playerNumber = playerNumber;
        this.fileName = fileName;
    }

    // methods
    public static void printMaze() {
        for (int i = 0; i < 10; i++) {
            System.out.print('[');
            for (int j = 0; j < 10; j++) {
                if (j == 9) {
                    System.out.print(maze[i][j]);
                } else {
                    String s = maze[i][j] + ",";
                    System.out.print(s);
                }
            }
            System.out.print(']');
            System.out.println();
        }
    }

    public void addMoveNumber() {
        moveNumber++;
    }

    public void incrementRow() {
        currentRow++;
    }

    public void incrementColumn() {
        currentColumn++;
    }

    public void decrementRow() {
        currentRow--;
    }

    public void decrementColumn() {
        currentColumn--;
    }

    public void run() {
        synchronized (o) {
            if (started == false) {
                System.out.println("Welcome! Initial Maze:");
                setInitialMaze();
                printMaze();
                started = true;
            }
        }
        String direction = "";

        try {
            BufferedReader bfr = new BufferedReader(new FileReader(fileName));
            String line = bfr.readLine();
            while (line != null) {
                int element = Integer.parseInt(line);
                synchronized (o) {
                    System.out.println("Move number: " + moveNumber + "\nPlayer: " + playerNumber);
                    if (element == 1) {
                        direction = "Left";
                        if (currentColumn == 0) {
                            //update prev position to ' '
                            setPositionToSpace(currentRow, currentColumn);
                            currentColumn = 9;
                            //update position of maze
                            setPositionToX(currentRow, currentColumn);
                            moveNumber++;
                        } else {
                            setPositionToSpace(currentRow, currentColumn);
                            decrementColumn();
                            setPositionToX(currentRow, currentColumn);
                            moveNumber++;
                        }
                    } else if (element == 2) {
                        direction = "Right";
                        if (currentColumn == 9) {
                            setPositionToSpace(currentRow, currentColumn);
                            currentColumn = 0;
                            setPositionToX(currentRow, currentColumn);
                            moveNumber++;
                        } else {
                            setPositionToSpace(currentRow, currentColumn);
                            incrementColumn();
                            setPositionToX(currentRow, currentColumn);
                            moveNumber++;
                        }
                    } else if (element == 3) {
                        direction = "Up";
                        if (currentRow == 0) {
                            setPositionToSpace(currentRow, currentColumn);
                            currentRow = 9;
                            setPositionToX(currentRow, currentColumn);
                            moveNumber++;
                        } else {
                            setPositionToSpace(currentRow, currentColumn);
                            decrementRow();
                            setPositionToX(currentRow, currentColumn);
                            moveNumber++; //increase the number of move
                        }
                    } else if (element == 4) {
                        direction = "Down";
                        if (currentRow == 9) {
                            setPositionToSpace(currentRow, currentColumn);
                            currentRow = 0;
                            setPositionToX(currentRow, currentColumn);
                            moveNumber++;
                        } else {
                            setPositionToSpace(currentRow, currentColumn);
                            incrementRow();
                            setPositionToX(currentRow, currentColumn);
                            moveNumber++;
                        }
                    } else {
                        System.out.println("Error, invalid input!");
                    }
                    System.out.println("Move: " + direction);
                    printMaze();
                    line = bfr.readLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setInitialMaze() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                maze[i][j] = ' ';
            }
        }
        maze[4][4] = 'X';
    }

    public static void setPositionToSpace(int cRow, int cColumn) {
        maze[cRow][cColumn] = ' ';
    }

    public static void setPositionToX(int cRow, int cColumn) {
        maze[cRow][cColumn] = 'X';
    }


    public static void main(String[] args) {
        try {
            MazeNavigator[] mazeNavigators = {new MazeNavigator(1, "/Users/ngokienvinh/Documents/vinhngo31/src/HW10/P1Moves.txt"),
                    new MazeNavigator(2, "/Users/ngokienvinh/Documents/vinhngo31/src/HW10/P2Moves.txt")};

            for (int i = 0; i < mazeNavigators.length; i++) {
                mazeNavigators[i].start();
            }
            for (int i = 0; i < mazeNavigators.length; i++) {
                mazeNavigators[i].join();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
}



