/*
 * Space.java
 * 
 */

public class Space {

    private boolean isOccupied;
    private int row;
    private int column;
    private String name;

    public Space(int row, int column) {
        this.row = row;
        this.column = column;
        name = " ";

    }

    public void setName(String name) {

        this.name = name;

    }

    public void removeName() {

        name = " ";

    }

    public String getName() {

        if (name.equals(" ")) {

            return "-";
        }

        return name;

    }

    public void setIsOccupied(String name) {

        isOccupied = true;

        setName(name);

    }

    public void setAsOpen() {

        isOccupied = false;
        removeName();
    }

    public boolean getIsOccupied() {

        return isOccupied;

    }

    public void setRow(int row) {

        this.row = row;
    }

    public int getRow() {

        return row;

    }

    public void setColumn(int column) {

        this.column = column;
    }

    public int getColumn() {

        return column;
    }

}
