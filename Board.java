/*
 * Grid.java
 * 
 * 
 */

import java.util.Random;

public class Board {

    //fields
    private Space[][] board;
    private boolean isThereAWinner = false;
    
    private final int ROWS = 9;
    private final int COLUMNS = 9;

    private int mtRow;
    private int mtColumn;

    private int carrotRow;
    private int carrotColumn;

    //method uses a 2-D array to creat grid 
    public Board() {
        board = new Space[ROWS][COLUMNS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = new Space(i, j);
            }
        }
        
        
        //place one mountain on the board. Board is empty so any random space will do.
        int[] mountainCoordinates = getRandomEmptySpaceCoordinates();
        board[ mountainCoordinates[0] ][ mountainCoordinates[1] ].setOccupant("Mountain");
        
        //Place two carrots on the board. Checking if something is in that space already.
        int[] carrotCoordinates1 = getRandomEmptySpaceCoordinates();
        board[carrotCoordinates1[0]][carrotCoordinates1[1]].setOccupant("Carrot");
        
        int[] carrotCoordinates2 = getRandomEmptySpaceCoordinates();
        board[carrotCoordinates2[0]][carrotCoordinates2[1]].setOccupant("Carrot");
        
        
        ///Place the players on the board.
        //Place Bugs on the board
        int[] bugsCoordinates = getRandomEmptySpaceCoordinates();
        board[bugsCoordinates[0] ][bugsCoordinates[1] ].setOccupant("Bugs");
        
        //place tweety
        int[] tweetyCoordinates = getRandomEmptySpaceCoordinates();
        board[tweetyCoordinates[0] ][tweetyCoordinates[1] ].setOccupant("Tweety");
        
        //place TazDevil
        int[] tazDevilCoordinates = getRandomEmptySpaceCoordinates();
        board[tazDevilCoordinates[0] ][tazDevilCoordinates[1] ].setOccupant("TazDevil");
        
        //place Marvin
        int[] marvinCoordinates = getRandomEmptySpaceCoordinates();
        board[marvinCoordinates[0] ][marvinCoordinates[1] ].setOccupant("Marvin");
        
    }
    
    //Returns the row/column numbers for an empty square in the grid.
    //returns -1, -1 if error.
    private synchronized int[] getRandomEmptySpaceCoordinates() {
        int returnRow = -1;
        int returnColumn = -1;
        
        Random randObj = new Random();
        int tempRow;
        int tempColumn;
        
        //int counter = 0;
        //while ( counter < Integer.MAX_VALUE && !board[tempRow][tempColumn].isThisSpaceOccupiedByAnything() ) {
        do {
            tempRow = randObj.nextInt(ROWS);
            tempColumn = randObj.nextInt(COLUMNS);
            //counter++;
        } while ( board[tempRow][tempColumn].isThisSpaceOccupiedByAnything() );
        returnRow = tempRow;
        returnColumn = tempColumn;
        
        return new int[] {returnRow, returnColumn};
    }


    public void mtLocation() {
        System.out.println("\nThe mountain has moved to row " + mtColumn + " column " + mtRow);
    }

    public void setCarrot(int row, int column) {

        carrotRow = row;
        carrotColumn = column;

    }

    public void setWinner() {

        isThereAWinner = true;

    }

    
    public boolean isGameOver() {
        //check if a player is on the mountain and has a carrot.
        
        return isThereAWinner;
    }

    //~ public String displayWinner() {

        //~ return board[mtRow][mtColumn].getName();
    //~ }
    
    //call to see current content of grid 
    public void printBoard() {

        for (int i = 0; i < ROWS; i++) {
            String line = "";

            for (int j = 0; j < COLUMNS; j++) {

                line += "[" + board[j][i].printOccupants() + "]";
            }

            System.out.println(line);
        }

    }
    
    public int getROWS() {
        return ROWS;
    }
    
    public int getCOLUMNS() {
        return COLUMNS;
    }
    
    //call to place or move players in grid 
    //~ public void markGrid(int row, int column, String name) {

        //~ if (!validMove(row, column)) {
            //~ removeMark(name);
            //~ board[row][column].setIsOccupied(name);

        //~ }

    //~ }

    //will be needed when we move player to remove previous mark 
    //~ public void removeMark(String name) {

        //~ for (int i = 0; i < ROWS; i++) {
            //~ for (int j = 0; j < COLUMNS; j++) {
                //~ if (board[i][j].getName().equals(name)) {
                    //~ board[i][j].setAsOpen();
                //~ }

            //~ }

        //~ }

    //~ }

//Maybe move isValidMove to player Threads Class. Marvin will need an overriden method.

    //~ public boolean isValidMove(int row, int column) {

        //~ if (row == mtRow && column == mtColumn) {
            //~ setWinner();
            //~ return false;
        //~ }

        //~ return board[row][column].getIsOccupied();

    //~ }
}
