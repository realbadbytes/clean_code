/* shit code

implies we must know
what kinds of things are in the list?
why do we care about x[0]?
what does 4 mean?
what is my return value used for? */

public List<int[]> getThem() {
    List<int[]> list1 = new ArrayList<int[]>();
    for (int[] x : theList)
        if (x[0] == 4)
            list1.add(4);
    return list1;
}

/* not shit code 

complexity remains the same
more explicit naming makes it clearer */

public List<int[]> getFlaggedCells() {
    List<int[]> flaggedCells = new ArrayList<int[]>();
    for (int[] cell : gameBoard)
        if (cell[STATUS_VALUE] == FLAGGED)
            flaggedCells.add(cell);
    return flaggedCells;
}

/* even less shit code

encapsulate the int[] of cells in a Cell class 
coupling and abstraction */

public List<Cell> getFlaggedCells() {
    List<Cell> flaggedCells = new ArrayList<Cell>();
    for (Cell cell : gameBoard)
        if (cell.isFlagged())
            flaggedCells.add(cell);
    return flaggedCells;
}
