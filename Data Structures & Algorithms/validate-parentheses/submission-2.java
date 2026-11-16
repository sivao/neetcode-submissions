class Solution {
    public boolean isValid(String s) {
        if(s == null) return false;
        int n = s.length();
        // Valid bracket strings must have even length
        if ((n & 1) == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); ++i) {
            switch(s.charAt(i)) {
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                default:
                    stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
