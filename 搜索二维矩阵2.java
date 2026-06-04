class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix[0].length-1;
        int j = 0;
        while(i>=0&&j<matrix.length){
            if(target<matrix[j][i]){
                i--;
            }else if(target>matrix[j][i]){
                j++;
            }else{
                return true;
            }
        }
        return false;
    }
}