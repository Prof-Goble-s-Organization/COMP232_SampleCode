package recursion;

/*
 * A sudoku solver for a 3x3 board that uses recursive backtracking. In mini 
 * sudoku there is one 3x3 grid. Each row and each column must contain the values 
 * 1, 2, and 3. 
 * <code>
 *  3 2 1
 *  2 1 3
 *  1 3 2
 * </code> 
 * 
 * Example adapted from https://brilliant.org/wiki/recursive-backtracking/.
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Jan 30 2024
 */

public class MiniSudoku {
    /*
     * Try to solve a few boards
     * 
     * @params args none
     */
    public static void main(String[] args) {
        // Has solution that requires backtracking
        int[][] board_solution = {
            {0, 0, 0},
            {0, 0, 3},
            {1, 0, 0}
        };

        // Has no solution, and detects it by backtracking the whole way back
        int[][] board_noSolution = {
            {0, 1, 0},
            {0, 0, 3},
            {1, 0, 0}
        };
        
        printBoard(board_solution);
        System.out.println("------");
        miniSudokuSolver(board_solution);
        System.out.println("###############################################");
        printBoard(board_noSolution);
        System.out.println("------");
        miniSudokuSolver(board_noSolution);
    }

    /*
     * Try to solve the given mini sudoku board. If there is no solution, the 
     * message "No Solution" is printed. Otherwise, print the solution board
     * 
     * @param board
     *                  the mini board with the initial clues
     */
    public static void miniSudokuSolver(int[][] board) {
        if(miniSudokuSolver(board, 0, 0)) {
            // found a solution and print the board
            printBoard(board);
        } else {
            System.out.println("No solution");
        }
    }

    public static void printBoard(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    /*
     * Recursive Problem Transformation:
     *      Note: Cells will be processed in a row-major order, meaning across 
     *          and then down to the next row.
     *      This method tries to fill in a solution for the board assuming that 
     *      all cells before the indicated row and column already have values. 
     *      It returns true if such a solution exists, and false otherwise.
     * 
     * @param board
     *      The game board we are trying to solve
     * @param row
     *      which row we are working on
     * @param col 
     *      which column we are working on
     * @returns boolean     indicates solveability
     */
    private static boolean miniSudokuSolver(int[][] board, int row, int col) {
        if(isSolved(board)) {
            // The board is already solved so we are done!
            return true;
        } else if(!isValid(board)) {
            // The board is not valid as is, so it can't possibly be 
            // solved from row,col!
            return false;
        } else if(board[row][col] != 0) {
            /*
			 * Cell row,col already has a value (e.g. one of the hints), so skip
			 * over it and go onto the next cell. Note: Row stays the same
			 * unless col is 2. Column takes values 0,1,2,0,1,2...
			 */
            return miniSudokuSolver(board, row + (col / 2),  (col + 1) % 3);
        } else {
            /*
			 * Use recursive backtracking to solve the board. Try a 1 in the
			 * cell and see if we can find a solution. If that doesn't work, try
			 * a 2 and if that doesn't work try a 3.
			 */
            for(int i = 1; i <= 3; i++) {
                // Try value i in the cell at row,col
                board[row][col] = i;

                // Can we solve the rest of the board with i at row,col?
                if (miniSudokuSolver(board, row + (col / 2), (col + 1) % 3)) {
                    // yes!
                    return true;
                }
                /*
				 * We were unable to solve the rest of the board with i at 
				 * row,col. So, remove i from row,col and try the next value...
				 */
                board[row][col] = 0;
            }
            /*
			 * We were unable to solve the rest of the board with 1, 2 or 3 at
			 * row,col. So there must not be any solution at all.
			 * 
			 * Backtrack!
			 */
            return false;
        }
    }

    /*
	 * Some helper methods below here...
	 */

	/*
	 * Check if the board is solved. A board is solved if all of its rows and
	 * all of its columns are complete. This method does that by checking for
	 * incomplete rows or columns (i.e. does not contain the values 1, 2 & 3 in
	 * some order). If an incomplete row or column is found the board is not
	 * solved. If no incomplete rows or columns are found then the board is
	 * solved.
	 */
	private static boolean isSolved(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			if (!completeRow(board, i) || !completeCol(board, i)) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Check if an indicated row of the board is complete. Complete rows contain
	 * the values 1, 2 and 3 in some order.
	 */
	private static boolean completeRow(int[][] board, int row) {
		boolean[] used = new boolean[board[row].length + 1];

		/*
		 * NOTE: Marking used[0] = true ensures that if there is a cell with no
		 * value in it (i.e. it holds 0) that the row will be marked as not
		 * complete.
		 */
		used[0] = true;
		for (int col = 0; col < board[row].length; col++) {
			int val = board[row][col];
			if (used[val] == true) {
				return false;
			} else {
				used[val] = true;
			}
		}
		return true;
	}

	/*
	 * Check if an indicated column of the board is complete. Complete columns
	 * contain the values 1, 2 and 3 in some order.
	 */
	private static boolean completeCol(int[][] board, int col) {
		boolean[] used = new boolean[board.length + 1];

		/*
		 * NOTE: Marking used[0] = true ensures that if there is a cell with no
		 * value in it (i.e. it holds 0) that the col will be marked as not
		 * complete.
		 */
		used[0] = true;
		for (int row = 0; row < board.length; row++) {
			int val = board[row][col];
			if (used[val] == true) {
				return false;
			} else {
				used[val] = true;
			}
			//System.out.println(used[val]);
		}
		//System.out.println("---");
		return true;
	}

	/*
	 * Check if the board is valid. A board is valid if all of its rows and all
	 * of its columns are valid. If an invalid row or column is found the board
	 * is not valid. If no invalid rows or columns are found then the board is
	 * solved.
	 */
	private static boolean isValid(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			if (!validRow(board, i) || !validCol(board, i)) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Check if the row is valid. A row is valid if it can be a part of a valid
	 * solution (i.e. it does not contain two of any number.)
	 */
	private static boolean validRow(int[][] board, int row) {
		boolean[] used = new boolean[board[row].length + 1];

		for (int col = 0; col < board[row].length; col++) {
			int val = board[row][col];
			if (used[val] == true) {
				return false;
			} else if (val != 0) {
				used[val] = true;
			}
		}
		return true;
	}

	/*
	 * Check if the col is valid. A col is valid if it can be a part of a valid
	 * solution (i.e. it does not contain two of any number.)
	 */
	private static boolean validCol(int[][] board, int col) {
		boolean[] used = new boolean[board.length + 1];

		for (int row = 0; row < board.length; row++) {
			int val = board[row][col];
			if (used[val] == true) {
				return false;
			} else if (val != 0) {
				used[val] = true;
			}
		}
		return true;
	}
}
