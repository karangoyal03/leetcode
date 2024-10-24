class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(matrix[i][j] ==0){
        //             // mark row and column all with -1
        //             markRowMinus1(matrix,i,m);
        //             markColumnMinus1(matrix,j,n);
        //         }
        //     }
        // }

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(matrix[i][j] == -1){
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }
        int[] col = new int[m];
        int[] row = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == 0){
                    col[j] =1;
                    row[i] =1;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(col[j]==1 || row[i] ==1){
                    matrix[i][j] =0;
                }
            }
        }
    }

    // private void markRowMinus1(int[][] matrix ,int i  , int m){
    //     for(int row = 0 ; row<m;row++){
    //         if(matrix[i][row] != 0){
    //             matrix[i][row] = -1;
    //         } 
    //     }
    // }

    // private void markColumnMinus1(int[][] matrix , int j ,  int n) {
    //         for(int col = 0 ; col<n;col++){
    //         if(matrix[col][j] != 0){
    //             matrix[col][j] = -1;
    //         } 
    //          }
    // }
}