class Solution {
    // List for storing all the possible position of Queen
    List<List<String>> resultList =  new ArrayList<>();
  
    //Check the current position is safe for Queen or not
    private boolean isSafe(char[][] bord,int r,int c)
    {
        //Column
        for(int i=r-1;i>=0;i--)
        {
            if (bord[i][c]=='Q') return false;
        }
        //Left Diagonal
        for (int i=r-1,j=c-1;i>=0 && j>=0;i--,j--)
        {
            if (bord[i][j]=='Q') return false;
        }
        //Right Diagonal
        for (int i=r-1,j=c+1;i>=0 && j<=bord.length-1;i--,j++)
        {
            if (bord[i][j]=='Q') return false;
        }
        return true;
    }
    
   // Add the resultant string into resultList
    private void addToList(char[][] bord)
    {
        List<String> strs = new ArrayList<String>();
        for (int i=0;i<=bord.length-1;i++)
        {
            strs.add(new String(bord[i]));
        }
        resultList.add(strs);
        
    }
  
    //function will arrange the queens
    private void nQueens(char[][] bord,int r)
    {
        if (r==bord.length){
            addToList(bord);
            return;
        }

        for(int i=0;i<=bord.length-1;i++)
        {
            if (isSafe(bord,r,i)){
                bord[r][i]='Q';
                nQueens(bord,r+1);
                bord[r][i]='.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        if (n==2 || n==3) return resultList;
        char[][] bord = new char[n][n];
        for (int i=0;i<=bord.length-1;i++)
        {
            for (int j=0;j<=bord.length-1;j++)
            {
                bord[i][j]='.';
            }
        }
        nQueens(bord,0);
        return resultList;
    }
}
