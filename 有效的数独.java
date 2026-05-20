class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            Set<Character> set1 = new HashSet<>();
            Set<Character> set2 = new HashSet<>();
            for(int j=0;j<9;j++){
                if(set1.contains(board[i][j]))
                return false;
                if(board[i][j]=='.')
                continue;
                set1.add(board[i][j]);
            }
            for(int j=0;j<9;j++){
                if(set2.contains(board[j][i]))
                return false;
                if(board[j][i]=='.')
                continue;
                set2.add(board[j][i]);
            }
        }
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                HashSet<Character> set = new HashSet<>();
                for(int m=i;m<i+3;m++){
                    for(int n=j;n<j+3;n++){
                        if(set.contains(board[m][n]))
                        return false;
                        if(board[m][n]=='.')
                        continue;
                        set.add(board[m][n]);
                    }
                }
            }
        }
        return true;

    }
}