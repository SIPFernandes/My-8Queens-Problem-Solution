/**
 * Represents the board
 **/
class Board {
	private static final int dim=8;
	private int board[][];
	/**
	 * Board simple constructor
	 **/
	public Board(){ 
		board = new int[dim][dim];
	}
	/**
	 * Board constructor
	 * @param str		string with the initial position of the 8 queens, one per row
	 **/
	public Board(String str) throws IllegalStateException {
		if (str.length() != dim) throw new
		IllegalStateException("Invalid arg in Board constructor");
		board = new int[dim][dim];
		for(int i=0; i<dim; i++)
			board[i][Character.getNumericValue(str.charAt(i))] = 1;
	}
	/**
	 * Prints the board on console
	 * @return		the board
	 **/
	public String toString() {
		String s  = new String();
		for(int i=0; i<dim; i++) {
			for(int j=0; j<dim; j++) {
					s += board[i][j] + " ";
			}
			s += "\n";
		}
		return s;
	}
	/**
	 * Gets the first empty column it finds
	 * @return		column index
	 **/
	public int getEmptyColumn() {
		int col = -1;
		for(int j=0; j<dim; j++) {
			int tmp = 0;
			for(int i=0; i<dim; i++) {
				if(board[i][j] != 0) {
					tmp++;
					break;
				}
			}
			if(tmp == 0) {
				col = j;
				break;
			}
		}
		return col;
	}
	/**
	 * Sets a queen in a specific position
	 * @param row		the row index
	 * @param column	the column index
	 **/
	public void setQueen(int row, int column) {
		board[row][column] = 1;
	}
	/**
	 * switches two rows
	 * @param row1		the row index
	 * @param row2		the row index
	 **/
	public void rowSwitching(int row1, int row2) {
		int column1 = getQueenColumn(row1);
		int column2 = getQueenColumn(row2);
		board[row2][column2] = 0;
		board[row1][column1] = 0;
		board[row1][column2] = 1;
		board[row2][column1] = 1;
	}
	/**
	* Checks if the board as no conflicts
	* @return		true if there are no conflicts
	**/
	public boolean checkBoard() {
		for(int i=0; i<dim; i++) {
			for(int j=0; j<dim; j++) {
				if(board[i][j] != 0 && !checkQueen(i, j))
					return false;
			}
		}
		return true;
	}
	/**
	 * switches two columns
	 * @param row1		the row index
	 * @param row2		the row index
	 **/
	public void columnSwitching(int col1, int col2) {
		int row1 = getQueenRow(col1);
		int row2 = getQueenRow(col2);
		board[row1][col1] = 0;
		board[row2][col2] = 0;
		board[row1][col2] = 1;
		board[row2][col1] = 1;
	}
	/**
	 * Gets the row of the queen in the given column
	 * @param column	column index
	 * @return		row index
	 **/
	public int getQueenRow(int column) {
		int row = -1;
		for(int i = 0;  i< dim; i++)
			if(board[i][column] != 0)
				row = i;
		return row;
	}
	/**
	 * Gets the column of the queen in the given row
	 * @param row		row index
	 * @return		column index
	 **/	
	public int getQueenColumn(int row) {
		int col = -1;
		for(int j = 0; j < dim; j++)
			if(board[row][j] != 0)
				col = j;
		return col;
	}
	/**
	 * Checks if there is a position in the row to place a queen without being in conflict and if so places the queen
	 * @param row		row index
	 * @return		true if queen placed 		
	 **/
	public boolean rowSolve(int row) {
		for(int j = 0; j < dim; j++) {
			if(checkQueen(row, j)) {
				board[row][j] = 1;
				return true;
			}
		}
		return false;
	}
	/**
	 * Checks if that row is out of conflict
	 * @param row		row index
	 * @return		false if the row is in conflict and removes the queen 		
	 **/
	public boolean rowIsSolution(int row) {
			for(int j = 0; j < dim; j++) {
				if(board[row][j] != 0 && !checkQueen(row, j)) {
					board[row][j] = 0;
					return false;
				}
			}
			return true;
	}
	/**
	 * Checks if the specified queen is out of conflict
	 * @param row		row index
	 * @param column	column index
	 * @return		true if queen out of conflict 		
	 **/
	public boolean checkQueen(int row, int column) {
		for(int j = 0; j < dim; j++)
			if(column != j && board[row][j] == 1)
				return false;
		for(int i = 0; i < dim; i++)
			if(row != i && board[i][column] == 1)
				return false;
		for(int i = row, j = column; i < dim && j < dim; i++, j++)
			if(row != i && column != j && board[i][j] == 1)
				return false;
		for(int i = row, j = column; i >= 0 && j >= 0; i--, j--)
			if(row != i && column != j && board[i][j] == 1)
				return false;
		for(int i = row, j = column; i < dim && j >= 0; i++, j--)
			if(row != i && column != j && board[i][j] == 1)
				return false;
		for(int i = row, j = column; i >= 0 && j < dim; i--, j++)
			if(row != i && column != j && board[i][j] == 1)
				return false;
		return true;
	}
	
}
