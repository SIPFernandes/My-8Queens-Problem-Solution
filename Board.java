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
	 * Board 
	 **/
	public Board(int[] m) throws IllegalStateException {
		if (m.length != dim*dim) throw new
		IllegalStateException("Invalid arg in Board constructor");
		board = new int[dim][dim];
		int si = 0;
		for(int i=0; i<dim; i++)
			for(int j=0; j<dim; j++)
				board[i][j] = m[si++];
	}
	
	public Board(String str) throws IllegalStateException {
		if (str.length() != dim) throw new
		IllegalStateException("Invalid arg in Board constructor");
		board = new int[dim][dim];
		for(int i=0; i<dim; i++)
			board[i][Character.getNumericValue(str.charAt(i))] = 1;
	}
	
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
	
	public void setQueen(int row, int column) {
		board[row][column] = 1;
	}
	
	public void rowSwitching(int row1, int row2) {
		int column1 = getQueenColumn(row1);
		int column2 = getQueenColumn(row2);
		board[row2][column2] = 0;
		board[row1][column1] = 0;
		board[row1][column2] = 1;
		board[row2][column1] = 1;
	}
	
	public boolean checkBoard() {
		for(int i=0; i<dim; i++) {
			for(int j=0; j<dim; j++) {
				if(board[i][j] != 0 && !checkQueen(i, j))
					return false;
			}
		}
		return true;
	}
	
	public void columnSwitching(int col1, int col2) {
		int row1 = getQueenRow(col1);
		int row2 = getQueenRow(col2);
		board[row1][col1] = 0;
		board[row2][col2] = 0;
		board[row1][col2] = 1;
		board[row2][col1] = 1;
	}
	
	public int getQueenRow(int column) {
		int row = -1;
		for(int i = 0;  i< dim; i++)
			if(board[i][column] != 0)
				row = i;
		return row;
	}
		
	public int getQueenColumn(int row) {
		int col = -1;
		for(int j = 0; j < dim; j++)
			if(board[row][j] != 0)
				col = j;
		return col;
	}
	
	public boolean rowSolve(int row) {
		for(int j = 0; j < dim; j++) {
			if(checkQueen(row, j)) {
				board[row][j] = 1;
				return true;
			}
		}
		return false;
	}
	
	public boolean rowIsSolution(int row) {
			for(int j = 0; j < dim; j++) {
				if(board[row][j] != 0 && !checkQueen(row, j)) {
					board[row][j] = 0;
					return false;
				}
			}
			return true;
	}
	
	//retorna a linha que está em conflito
	public boolean checkQueen(int row, int column) {
		//check row
		for(int j = 0; j < dim; j++)
			if(column != j && board[row][j] == 1)
				return false;
		//check column
		for(int i = 0; i < dim; i++)
			if(row != i && board[i][column] == 1)
				return false;
		//check topLeftDiagonal
		for(int i = row, j = column; i < dim && j < dim; i++, j++)
			if(row != i && column != j && board[i][j] == 1)
				return false;
		for(int i = row, j = column; i >= 0 && j >= 0; i--, j--)
			if(row != i && column != j && board[i][j] == 1)
				return false;
		//check topRightDiagonal
		for(int i = row, j = column; i < dim && j >= 0; i++, j--)
			if(row != i && column != j && board[i][j] == 1)
				return false;
		for(int i = row, j = column; i >= 0 && j < dim; i--, j++)
			if(row != i && column != j && board[i][j] == 1)
				return false;
		return true;
	}
	
}