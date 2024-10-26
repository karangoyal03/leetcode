class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(check(board,word , i , j , n , m ,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board , String word , int row , int col , int n , int m , int indx){
        if(indx == word.length()){
            return true;
        }

        if(row < 0 || col < 0 || row >=n || col>=m || board[row][col] == '!' || board[row][col] != word.charAt(indx)){
            return false;
        }
        
        char ch = board[row][col];
        board[row][col] = '!';
        // top
        boolean top = check(board, word, row-1 ,col , n , m , indx+1);
        //bottom
        boolean bottom = check(board,word,row+1,col,n,m,indx+1);
        //right
        boolean right = check(board,word,row,col+1,n,m,indx+1);
        //left
        boolean left = check(board,word,row,col-1,n,m,indx+1);

        board[row][col] = ch;

        return top || bottom || right || left;


    }
}