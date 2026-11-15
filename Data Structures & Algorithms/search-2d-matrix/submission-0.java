class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // clarifying questions:
        // is each row of same length?
        // what is the range of values? and what is matrix size?
        // sample input & output
        // 1) input: [[1, 2, 3, 4, 5], [6,7,8,9,10,11]], targrt = 6
        // output: true
        // edcase cases:
        // 1. null or empty array -> return false
        // 2. if target is greater than the (last row, last column) element then return false;
        // 3. if target is less than the (first row, first column) element then return false; 
        // approaches:
        // 1. scan row by row -> TC:O(M*N), SC:O(1)
        // 2. scan first element & last element of every row, if the target is in between then scan every element of that row. TC: O(m+n), SC:O(1)
        // 3. as first element of every row is greater than the last element of every row, apply binary search. TC: O(log(m*n)), SC:O(1)
        if(matrix == null) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[m-1][n-1]) return false;
        int l = 0;
        int r = m * n - 1;
        while(l<=r) {
            int mid = l + ((r-l) >> 1);
            int rowInd = mid / n;
            int colInd = mid % n;
            if(matrix[rowInd][colInd] == target) return true;
            else if(matrix[rowInd][colInd] < target) l = mid+1;
            else r = mid-1;
        }
        return false;
    }
}
