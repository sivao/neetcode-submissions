class Solution {
    public int[] twoSum(int[] nums, int target) {
        // constraints : length of the array, range of the numbers, target range?, 
        // 10000, integer range, target range is integer range, 
        // assuming summation of the two integers may cross integer range.
        // if the answer is not found then what should I return?
        // is the array sorted? if yes, two pointer problem or else 
        // naive approach: TC: O(n^2), SC: O(1)
        // second approach: TC: O(n), SC: O(n)
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int ind =0; ind < nums.length; ++ind) {
            int secondNum = target - nums[ind];
            if(indexMap.containsKey(secondNum)) {
                return new int[]{indexMap.get(secondNum), ind};
            }
            indexMap.put(nums[ind], ind);
        }
        return new int[]{};
    }
}
