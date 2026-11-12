class Solution {
    public int maxArea(int[] heights) {
        // clarifying questions?
        // input is int[] heights
        // output is max amout of i,e int
        // (difference of index) * (min of height)?
        // Can I consider height as always >= 0?
        // Can I asssume left most and right most heights are not neighbours?
        // Input is not sorted.
        // what is length of the array? 10^5
        // what is range of the elements? 10^4
        // sample test scenario? 2,4,3,5,10,1 then output is 12
        // edge cases: null or length is < 1 return 0;
        // if any of the element of the array is < 0 then throw IAE.
        // all are equal height
        // 0, 100, 0
        // brute force: Nested loop approach - TC: O(N^2), SC: O(1)
        // two pointer approach: two pointers - TC: O(N), SC = O(1)
        if(heights == null || heights.length < 1) return 0;
        int l = 0;
        int r = heights.length -1;
        int res = 0;
        while(l<r) {
            res = Math.max((r-l) * Math.min(heights[l], heights[r]), res);
            if(heights[l] < heights[r]) ++l;
            else --r;
        }
        return res;
    }
}
