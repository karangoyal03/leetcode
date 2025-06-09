class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){

                if(board[i][j] =='.'){
                    continue;
                }

                String row = "r" + i + board[i][j];
                String col = "c" + j + board[i][j];
                String sqr = "s" + i/3 + j/3 + board[i][j];

                if(set.contains(row) || set.contains(col) || set.contains(sqr)){
                    return false;
                }

                set.add(row);
                set.add(col);
                set.add(sqr);
            }            
        }

        return true;
    }
}