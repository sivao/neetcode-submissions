class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return nums;
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);
        for(int i=1; i<nums.length; ++i) {
            output[i] = output[i-1] * nums[i-1];
        }
        int rightMul = nums[nums.length-1];
        for(int i=nums.length-2; i>=0; --i) {
            output[i] *= rightMul;
            rightMul *= nums[i];
        }
        return output;
    }
}  
