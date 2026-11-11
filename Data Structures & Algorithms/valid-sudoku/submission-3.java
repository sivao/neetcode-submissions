class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9) {
            return false;
        }
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];
        for(int i=0; i<board.length; i++) {
            if (board[i] == null || board[i].length != 9) {
                return false;
            }
            for(int j=0; j<board[0].length; ++j) {
                char ch =  board[i][j];
                if(ch != '.') {
                    int ele = ch - '0';
                    if (ele < 1 || ele > 9) {
                        return false;
                    }
                    int bit = 1 << (ele - 1);
                    if((rows[i] & bit) != 0) return false;
                    else rows[i] = rows[i] | bit;

                    if((cols[j] & bit) != 0) return false;
                    else cols[j] = cols[j] | bit;

                    int boxInd = i / 3 * 3 + j / 3;
                    if((boxes[boxInd] & bit) != 0) return false;
                    else boxes[boxInd] = boxes[boxInd] | bit;
                }
            }
        }
        return true;
    }
}
