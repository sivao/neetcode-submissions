class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // constraints: characters? lower alphabets, length of string would be 10^5? cap on array of strings?
        // sol: 
        // TC: O(m * n), SC: O(m * n)
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }
        if (strs.length == 1) {
            return List.of(List.of(strs[0]));
        }
        Map<String, List<String>> anagrams = new HashMap<>();
        char[] count = new char[26];
        for(String str: strs) {
            for(char c: str.toCharArray()) {
                ++count[c-'a'];
            }
            String key = new String(count); 
            // Arrays.toString(count);
            // for(int c: count) key.append(c).append('#');
            // System.out.println(key);
            anagrams.computeIfAbsent(key, e -> new ArrayList<String>()).add(str);
            Arrays.fill(count, (char)0);
        }
        return new ArrayList(anagrams.values());
    }
}
