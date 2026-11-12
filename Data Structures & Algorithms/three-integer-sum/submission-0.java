class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // questions?
        // range of elements in the input? -10^5 to 10^5
        // length of the input array? 10^4
        // does input contain duplicate elements?
        // am i permitted to sort the input array?
        // return type? List<List<Integer>> elements
        // is it okay if the output in any order?
        // is duplicate triplets allowed?
        // edge cases:
        // 1. null or <3 length input array
        // after sorting if the first element is > 0 or last element is < 0 return empty output
        // if last element is 0 and last is 0 then return 0,0,0
        // sol1: brute force, 3 pass approach. tc:o(n^3), sc:o(1) excluding output
        // sol2: hashset solution. take one element, find the 0-element value in the rest of the array by summing two elements and this for all elements. as this is hashset solution, duplicates are handled.
        // tc:o(n^2), sc:0(n)
        // sol3: sort input array. two pointer approach. iterate all elements, find the sum of two elements of the rest of the array is equal to 0-element.
        // tc:o(n^2), sc: o(1) if input array is modifyable.
        // 6:45
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        int n = nums.length-1;
        if(nums[0] > 0 || nums[n] < 0) return res;
        if(nums[0] == 0 && nums[n] == 0) {
            res.add(Arrays.asList(0, 0, 0));
            return res;
        }
        // 0,    0,0,0,0,1,1,2
        for(int i=0; i<n-1; ++i) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            if(nums[i] > 0) break;
            int first = nums[i];//0
            int l = i+1;
            int r = n;
            while(l<r) {
                long sum = (long)first + nums[l] + nums[r];
                if(sum == 0) {//0
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    ++l;//0
                    --r;//1
                    while(l < r && nums[l] == nums[l-1]) ++l;
                    while(l < r && nums[r] == nums[r+1]) --r;
                }
                else if(sum<0) {
                    ++l;
                }
                else {
                    --r;
                }
            }
        }
        return res;
    }
}
