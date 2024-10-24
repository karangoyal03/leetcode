class Solution {
    public void rotate(int[][] matrix) {
        // int n = matrix.length;
        // int m = matrix[0].length;
        // int[][] ans = new int[n][m];
        // for(int i=0;i<n;i++){
        //     for(int j =0;j<m;j++){
        //         ans[j][n-1-i] = matrix[i][j];
        //     }
        // }

        // int n = matrix.length;
        // for(int i=0;i<n;i++){
        //     for(int j = i+1 ;j<n;j++){
        //         int temp = matrix[j][i];
        //         matrix[j][i] = matrix[i][j];
        //         matrix[i][j] = temp;
        //     }
        // }

        // for(int[] row : matrix){
        //     int left =0;
        //     int right = row.length-1;
        //     while(left<right) {
        //         int temp = row[left];
        //         row[left] = row[right];
        //         row[right] = temp;
        //         left++;
        //         right--;
        //     }
        // }

       // approach 3 
              int left =0;
        int right = matrix.length-1;
        while(left < right){

            for(int i=0;i<right-left;i++){
                int top = left;
                int bottom = right;
                int topleft = matrix[top][left+i];
                matrix[top][left+i] = matrix[bottom-i][left];
                matrix[bottom-i][left] = matrix[bottom][right-i];
                matrix[bottom][right-i] = matrix[top+i][right];
                matrix[top+i][right] = topleft;
            }
            left++;
            right--;
        }



    }
}