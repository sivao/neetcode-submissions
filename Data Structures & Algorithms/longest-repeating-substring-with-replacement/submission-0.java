class Solution {
    public int characterReplacement(String s, int k) {
        // what is th elength of string?
        // k range?
        // example:
        // ABBA, K=2 then output is 4
        // ABCD, K=2 then return output 3.
        // null, or empty then return 0 irrespective of k
        // k > string.length throw illegal argument exception;
        // ABBA, K=2
        // bruteforce? nested loop with hashmap
        // TC:O(N^2), SC:O(26) ~ O(1)
        // optimal: sliding window with single pass - TC: O(N), SC: O(1) with auxilary space
        // 0,0,0,0
        // 1,0,0,0
        // 1,1,0,0  
        // time - 11:43
        if(s == null || s.length() == 0) return 0;
        if(s.length() < k) return s.length();
        int res = 0;//5
        int l = 0;
        int r = 0;
        int[] aux = new int[26];
        //    l  r
        // AAABABB, k=1
        // 1,3
        int maxFreq = 0; //2
        while(r<s.length()) {
            char ch = s.charAt(r);
            maxFreq = Math.max(maxFreq, aux[ch-'A']+1);
            // window length - maxFreq crossing replacement count
            // 4-3 > 1
            // System.out.println(maxFreq + " - " + r);
            if((r-l+1) - maxFreq > k) {
                --aux[s.charAt(l)-'A'];
                maxFreq = Math.max(maxFreq, aux[s.charAt(l)-'A']);
                ++l;
            } else {
                ++aux[ch-'A'];
                res = Math.max(res, r-l+1);
                ++r;
            }
        }
        return res;
    }
}
