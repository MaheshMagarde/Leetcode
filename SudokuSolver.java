class Solution {
    // Char Array for identify the elements
    private static final char[] ca = {'.','1','2','3','4','5','6','7','8','9'};
    
  
    // Function for check digit 'd' can place at sudoku[r][c] position
    private boolean isSafe(char[][] sudoku,int r,int c,int d)
    {
        // check in row same digit are present or not
        for (int i=0;i<=8;i++)
        {
            if (sudoku[r][i]==ca[d]) return false;
        }
        //check in column same digit are present or not
        for (int i=0;i<=8;i++)
        {
            if(sudoku[i][c]==ca[d]) return false;
        }
        // check into 3x3 grid same digit are present or not
        int sr = (r/3)*3;
        int sc = (c/3)*3;
        for (int i=sr;i<=sr+2;i++)
        {
            for (int j=sc;j<=sc+2;j++)
            {
                if (sudoku[i][j]==ca[d]) return false;
            }
        }
        return true;
    }


    private boolean sudokuSolver(char[][] sudoku,int r,int c){
        if (r==9) return true;

        int nc=c+1,nr=r;
        if(nc==9){
            nc=0;
            nr=r+1;
        }
        if(sudoku[r][c]!=ca[0]) return sudokuSolver(sudoku,nr,nc);

        for (int i=1;i<=9;i++)
        {
            if(isSafe(sudoku,r,c,i))
            {
                sudoku[r][c] = ca[i];
                if(sudokuSolver(sudoku,nr,nc)) return true;
                sudoku[r][c] = ca[0];
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        sudokuSolver(board,0,0);
    }
}
