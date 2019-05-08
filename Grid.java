/*
 * Grid.java
 * 
 * 
 */

public class Grid {

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
    public void createGrid() {
        board = new Space[ROWS][COLUMNS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[j][i] = new Space(j, i);

            }

        }

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
