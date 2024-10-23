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

        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j = i+1 ;j<n;j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        for(int[] row : matrix){
            int left =0;
            int right = row.length-1;
            while(left<right) {
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;
                left++;
                right--;
            }
        }
        


    }
}