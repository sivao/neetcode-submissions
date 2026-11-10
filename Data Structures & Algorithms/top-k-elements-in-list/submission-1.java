class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // constraints on input:
        // length of the array? range of numbers? range of k?
        // 0 < 10000, integers, k is always positive
        // base approach: sort the array o(nlogn + n*k), sc: o(k)
        // priority queue.
        // TC: O(nlogn), SC: O(n)
        // edge cases: null or empty array
        if(nums == null || nums.length == 0) return new int[]{};
        Map<Integer, Integer> frequencies = new HashMap<>();
        int maxFreq = 0;
        for(int num: nums) {
            int freq = 1 + frequencies.getOrDefault(num, 0);
            frequencies.put(num, freq);
            maxFreq = Math.max(maxFreq, freq);
        }

        List<Integer>[] bucket = new List[maxFreq+1];
        for(Map.Entry<Integer, Integer> e: frequencies.entrySet()) {
            if(bucket[e.getValue()] == null) {
                bucket[e.getValue()] = new ArrayList<>();
            }
            bucket[e.getValue()].add(e.getKey());
        }

        int[] res = new int[k];
        int ind = 0;
        for(int i=bucket.length-1; i>=0; --i) {
            if(bucket[i] != null) {
                for(int ele: bucket[i]) {
                    res[ind++] = ele;
                    if(ind >= k) return res;
                }
            }
        }
        return res;
    }
}
