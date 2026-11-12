class Solution {
    public boolean isPalindrome(String s) {
        if(s == null) return false;
        if(s.length() == 0) return true;
        s = s.toLowerCase();
        int l = 0;
        int r = s.length()-1;
        while(l<r) {
            char lc = s.charAt(l);
            char rc = s.charAt(r);
            if(!Character.isLetterOrDigit(lc)) {
                ++l;
                continue;
            }
            if(!Character.isLetterOrDigit(rc)) {
                --r;
                continue;
            }
            if(lc != rc) return false;
            ++l;
            --r;
        }
        return true;
    }
}
