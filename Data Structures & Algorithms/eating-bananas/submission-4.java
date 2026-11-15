class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 1, 2, 3, 4
        // 10
        // clarifying questions?
        // Should all the bananas be ate in exactly h hours? or eating in 8 hours is also fine?
        // is input array modifiable?
        // constraints:
        // range of bananas of piles and h?
        // return type is integer as min number of bananas per hour should be return
        // length of bananans piles?
        // sample test case:
        // input: [4,3,2,1], h = 9
        // output: 2
        // edgecase: array is null or empty or h < piles.length then return -1
        // approaches:
        // bruteforce: assume k is ranging from 1 to max of pile of bananas and linearly check for every k such that eating of every pile of bananas with speed of k finish in h hours. TC: O(max(input) * n), SC:O(1)
        // optimal: binary search on range of k (1 to max of pile of bananas)
        // TC:O(log(max(input)) * N), SC:O(1)
        if(piles == null || piles.length == 0 || h < piles.length) return -1;
        int max = 0;
        for (int pile : piles) {
            if (max < pile) {
                max = pile;
            }
        }
        if (h == piles.length) {
            return max;
        }
        int l = 1;
        int r = max;
        int res = max;
        while(l<=r) {
            int mid = l + ((r-l) >>> 1);
            boolean canEat = canEat(piles, mid, h);
            if(canEat) {
                res = Math.min(res, mid);
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return res;
    }
    public boolean canEat(int[] piles, int speed, int h) {
        long totalH = 0;
        for(int pile:piles) {
            totalH += (pile - 1) / speed + 1;
            if (totalH > h) {
                return false;
            }
        }
        return totalH <= h;
    }
}
