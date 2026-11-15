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
        if(s1 == null || s2 == null) return false;
        if(s1.length() > s2.length()) return false;
        if(s1.isEmpty()) return true;
        if(s1.isEmpty() && s2.isEmpty()) return true;
        if(s2.isEmpty()) return false;
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
            if(isMatching(s1Freq, s2Freq)) return true;
            --s2Freq[s2.charAt(l++) - 'a'];
        }
        return false;
    }

    private boolean isMatching(int[] s1Freq, int[] s2Freq) {
        for(int i=0; i<26; ++i) {
            if(s1Freq[i] != s2Freq[i]) return false;
        }
        return true;
    }
}
