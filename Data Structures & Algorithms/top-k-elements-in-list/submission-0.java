class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // constraints on input:
        // length of the array? range of numbers? range of k?
        // 0 < 10000, integers, k is always positive
        // priority queue.
        Map<Integer, Integer> counts = new HashMap<>();
        for(int num: nums) {
            counts.put(num, 1 + counts.getOrDefault(num, 0));
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> counts.get(a) - counts.get(b));
        for(Map.Entry<Integer, Integer> e: counts.entrySet()) {
            pq.add(e.getKey());
            if(pq.size() > k) pq.remove();
        }
        int[] res = new int[k];
        int ind = 0;
        while(!pq.isEmpty()) {
            res[ind++] = pq.remove();
        }
        return res;
    }
}
