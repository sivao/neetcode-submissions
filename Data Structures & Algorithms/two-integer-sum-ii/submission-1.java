class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // clarifying questions?
        // assuming no duuplicates as only one valid solution.
        // inputs are int[] nums, int target?
        // pos, negatives and 0,
        // range of elements in nums -> -10^6 to 10^6
        // target -> -10^9 to 10^9
        // array length -> 10^5
        // edge cases: nums is null, nums size is less than 2 
        // if target > last two elements summation then return false
        // brute force -> two pass approach -> tc: o(n^2), sc: O(1)
        // Intermediate -> hashmap approach -> tc: o(n), sc: O(n)
        // optimized one -> two pointers -> tc: o(n), sc: O(1)
        if(numbers == null || numbers.length < 2 ) return new int[0];
        int l = 0;
        int r = numbers.length-1;
        while(l<r) {
            long sum = numbers[l]+numbers[r];
            if(target == sum) return new int[] {l+1, r+1};
            if(sum < target) {
                ++l;
            } else {
                --r;
            }
        }
        return new int[0];
    }
}
