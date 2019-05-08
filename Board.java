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
    public void Board() {
        board = new Space[ROWS][COLUMNS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = new Space(i, j);
            }
        }
        
        Random randomObject = new Random();
        
        
        //place one mountain on the board. Board is empty so any random place will do.
        int tempRow = randomObject.nextInt();
        int tempColumn = randomObject.nextInt();
        board[tempRow][tempColumn].setOccupant("Mountain");
        
        //Place two carrots on the board. Checking if something is in that square already.
        int[] carrotCoordinates1 = getRandomEmptySpaceCoordinates();
        board[carrotCoordinates1[0]][carrotCoordinates1[1]].setOccupant("Carrot");
        
        int[] carrotCoordinates2 = getRandomEmptySpaceCoordinates();
        board[carrotCoordinates2[0]][carrotCoordinates2[1]].setOccupant("Carrot");
        
        
        //Place the players on the board.
        
        
    }
    
    //Returns the row/column numbers for an empty square in the grid.
    //returns -1, -1 if error.
    private int[] getRandomEmptySpaceCoordinates() {
		int returnRow = -1;
		int returnColumn = -1;
		
		Random randObj = new Random();
		int tempRow = randObj.nextInt();
		int tempColumn = randObj.nextInt();
		
		//int counter = 0;
		//while ( counter < Integer.MAX_VALUE && !board[tempRow][tempColumn].isThisSpaceOccupiedByAnything() ) {
		while ( !board[tempRow][tempColumn].isThisSpaceOccupiedByAnything() ) {
			tempRow = randObj.nextInt();
			tempColumn = randObj.nextInt();
			//counter++;
		}
		returnRow = tempRow;
		returnColumn = tempColumn;
		
		return new int[] {returnRow, returnColumn};
	}

    public void setMountain(int row, int column) {

        mtRow = row;
        mtColumn = column;

        //remove previous F
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j].getName().equals("F")) {
                    board[i][j].setAsOpen();
                }

            }

        }

        board[mtRow][mtColumn].setIsOccupied("F");
        mtLocation();

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
		//Get rid of global flag
		
		return isThereAWinner;
	}

    public String displayWinner() {

        return board[mtRow][mtColumn].getName();
    }
    //call to see current content of grid 

    public void printGrid() {

        for (int i = 0; i < ROWS; i++) {
            String line = "";

            for (int j = 0; j < COLUMNS; j++) {

                line += "[" + board[j][i].getName() + "]";
            }

            System.out.println(line);
        }

    }
    //call to place or move players in grid 

    public void markGrid(int row, int column, String name) {

        if (!validMove(row, column)) {
            removeMark(name);
            board[row][column].setIsOccupied(name);

        }

    }

    //will be needed when we move player to remove previous mark 
    public void removeMark(String name) {

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j].getName().equals(name)) {
                    board[i][j].setAsOpen();
                }

            }

        }

    }

    public boolean validMove(int row, int column) {

        if (row == mtRow && column == mtColumn) {
            setWinner();
            return false;
        }

        return board[row][column].getIsOccupied();

    }
}
