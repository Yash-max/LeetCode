class Solution {
    public boolean rowCheck(char[][] board, int x, int y) {
        for(int col = 0; col < 9; col++) {
            if(col != y && board[x][col] == board[x][y]) {
                return false;
            }
        }
        return true;    
    }
    
    public boolean colCheck(char[][] board, int x, int y) {
        for(int row = 0; row < 9; row++) {
            if(row != x && board[row][y] == board[x][y]) {
                return false;
            }
        }
        return true;    
    }
    
    public boolean boxCheck(char[][] board, int x, int y) {
        int rowBox = x - (x % 3);        
        int colBox = y - (y % 3);

        for(int row = rowBox; row < rowBox + 3; row++) {
            for(int col = colBox; col < colBox + 3; col++) {
                if(col != y && board[row][col] == board[x][y]) {
                    return false;
                }
            }
        }
        return true;    
    }
    
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(rowCheck(board, i, j) == false || colCheck(board, i, j) == false || boxCheck(board, i, j) == false) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}