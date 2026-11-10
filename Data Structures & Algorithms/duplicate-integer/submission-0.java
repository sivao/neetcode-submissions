class Solution {
    public boolean hasDuplicate(int[] nums) {
        // TC: O(n), SC: O(n)
        // idea: hashset, sort (tc: O(nlogn), sc: O(1), O(n) if array is not modifiable, )
        // will go twith hashset.
        Set<Integer> numSet = new HashSet<>();
        for(int num: nums) {
            if(!numSet.add(num)) return true;
        }
        return false;
    }
}