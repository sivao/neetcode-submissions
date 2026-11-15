class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // length of strings? 
        // is s1 length always less than or equal to s2?
        // characters in strings? lower case alphabets
        // edge cases?
        // s1 and s2 should not be null
        // s1 length should always be less than or equal to s2.
        // empty s1 should be always be permutation of s2.
        // if s2 is empty return false.
        // examples:
        // "abcde", "dabceyryr" -? true
        // "", "fsfs" -> true
        // "fdsfs", "" -> false
        // "", "" -> true
        // "abc", "aabc" -> true
        // sol1: bruteforce: nested loop - take substrings for s2 and check each substring is permutation of s1 or not? TC: O(m+26*n^2), sc: O(1) aux
        // sol2: sliding window with two pointers - TC: O(m+n.26), SC: O(1) aux space
        if(s1 == null || s2 == null) return false;
        if(s1.isEmpty()) return true;
        if(s2.isEmpty()) return false;
        if(s1.length() > s2.length()) return false;
        int[] s1Freq = new int[26];
        for(int i=0; i<s1.length(); ++i) {
            ++s1Freq[s1.charAt(i) - 'a'];
        }
        int[] s2Freq = new int[26];
        for(int i=0; i<s1.length()-1; ++i) {
            ++s2Freq[s2.charAt(i) - 'a'];
        }
        for(int l=0, r=s1.length()-1; r<s2.length(); ++r) {
            ++s2Freq[s2.charAt(r) - 'a'];
            if(Arrays.equals(s1Freq, s2Freq)) return true;
            --s2Freq[s2.charAt(l++) - 'a'];
        }
        return false;
    }

}
