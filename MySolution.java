import java.util.ArrayList;
import java.util.Stack;

/**
 * Represents the tree which old's the state nodes for the algorithm to solve
 **/
class MySolution {
	/**
	 * Represents the state node which old's the current board state, the previous board (father) and it's depth in the tree
	 **/
	static class State {
		private Board layout;
		private State father;
		private int depth;
		/**
		 * State node constructor
		 * @param l		the board state in this stage
		 * @param n 	the previous state that originated this one
		 **/
		public State(Board l, State n) {
			layout = l;
			father = n;
			if (father!=null) {
				depth = father.depth + 1;
			}
			else {
				depth = 0;
			}
		}
		/**
		 * @return		the board layout
		 **/
		public String toString() { 
			return layout.toString(); 
		}
		/**
		 * @return		current depth
		 **/
		public int getDepth() {
			return depth;
		}
	}
	
	private Stack<State> stack = new Stack<State>();
	private State current;
	/**
	 * creates a simple linked list with depth equal to the rows in a 8*8 board 
	 * which will simulate the backtracking algorithm tree
	 * @param root 		the initial board given in the input
	 **/
	public void start(Board root){
		State s = new State(root, null);
		stack.add(s);
		for(int i = 0; i < 7; i++) {
			s = new State(s.layout, stack.get(i));
			stack.add(s);
		}
	}
	/**
	 * Solves the 8 Queens problem by simplifying the backtracking algorithm and adding permutations to conclude
	 * @param root		the initial board given in the input
	 * @return			the final board with the solution
	 **/
	public Board simpleBacktrackingPermuted(Board root) {
		start(root);
		current = stack.firstElement();
		Board a = current.layout;
		ArrayList<Integer> emptyRows = new ArrayList<Integer>();
		while(true) {
			if(emptyRows.contains(current.depth) && current.depth < 7) {
				if(a.rowSolve(current.depth)) {
					for(int i = 0; i < emptyRows.size(); i++)
						if(emptyRows.get(i) == current.depth)
							emptyRows.remove(i);
					current = stack.get(current.depth+1);
				}
				else {
					while(emptyRows.size() > 0) {
						a.setQueen(emptyRows.get(0), a.getEmptyColumn());
						emptyRows.remove(0);
					}
					for(int col1 = 0; col1 < 7; col1++) 
						for(int col2 = col1+1; col2 < 8; col2++) {
							for(int row1 = 0; row1 < 7; row1++) 
								for(int row2 = row1+1; row2 < 8; row2++) {
									a.rowSwitching(row1, row2);
									if(a.checkBoard())
										return a;
								}							
							a.columnSwitching(col1, col2);
							if(a.checkBoard())
								return a;
						}													
				}
			}
			else {
				if(!a.rowIsSolution(current.depth) && !a.rowSolve(current.depth)) 
					emptyRows.add(current.depth);
				if(emptyRows.size() == 0 && current.depth == 7) 
					return a;
				else if(current.depth == 7 && emptyRows.size() != 0) 
					current = stack.get(0);		
				else 
					current = stack.get(current.depth+1);
			}
		}
	}
	/**
	 * @return 		the stack containing the states
	 **/
	public Stack<State> getStack(){
		return stack;
	}
	
	
}