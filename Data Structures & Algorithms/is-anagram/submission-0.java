class Solution {
    public boolean isAnagram(String s, String t) {
        // constraints: length (1 < l < 10^3), characters in string (only lower case alphabets),  shall i consider special characters for anagram check?
        // HashMap - TC: O(n) SC: O(1)
        // count array - TC: O(n), SC: O(1)
        // will go with array 

        // 0, 1, 2, 3
        // abc
        int[] count = new int[26];
        for(char c: s.toCharArray()) {
            ++count[c-'a'];
        }
        for(char c: t.toCharArray()) {
            if(--count[c-'a'] < 0) {
                return false;
            }
        }
        for(int i: count) {
            if(i != 0) return false;
        }
        return true;
    }
}
