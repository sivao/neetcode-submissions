class Solution {
    public int longestConsecutive(int[] nums) {
        // clarifications?
        // does array contain duplicates? if duplicates then how the response would be?
        // length of array? 1 to 10^5
        // edge cases -> null array or nums.length <=1 return nums.length
        // does the array contains only +ve integers? no can be -ve as well.
        // range of array elements? -10^9 to 10^9
        // brute force: sort the array and find the consecutive sequence.
        // tc: o(nlogn) sc: o(1) if input array is modifiable
        // optimized version: add all elements to hashset
        // travesrse the elements in nums array, look for -1 element if found find -1 of the new element and so on until -1 element is not found. do this for all elements.
        // tc: o(n), sc: O(n)
        if(nums == null) return 0;
        if(nums.length <= 1) return nums.length;
        Set<Integer> set = new HashSet<>();
        for(int ele: nums) {
            set.add(ele);
        }
        int res = 1;
        for(int ele: set) {
            int temp = ele;
            int seqCount = 1;
            if(!set.contains(temp+1)) {
                while(set.contains(temp-1)) {
                    ++seqCount;
                    // set.remove(temp-1);
                    temp = temp-1;
                }
                res = Math.max(res, seqCount);
            }
        }
        return res;
    }
}
