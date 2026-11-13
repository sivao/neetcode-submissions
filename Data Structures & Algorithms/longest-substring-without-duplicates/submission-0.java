class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        if(s.length() <=1) return s.length();
        int res = 0;
        boolean[] window = new boolean[128];
        int l = 0;
        int r = 0;
        // a,b,b,a
        // -1,-1,-1,-1
        while(r<s.length()) {
            char ch = s.charAt(r);
            if(window[ch]) {
                window[s.charAt(l)] = false;
                ++l;
            } else {
                window[ch] = true;
                res = Math.max(res, r-l+1);
                ++r;
            }
        }
        return res;
    }
}
