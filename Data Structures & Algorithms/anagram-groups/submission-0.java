class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // constraints: characters? lower alphabets, length of string would be 10^5? cap on array of strings?
        // 
        Map<String, List<String>> anagrams = new HashMap<>();
        int[] count = new int[26];
        for(String str: strs) {
            for(char c: str.toCharArray()) {
                ++count[c-'a'];
            }
            String key = Arrays.toString(count);
            anagrams.computeIfAbsent(key, e -> new ArrayList<String>()).add(str);
            Arrays.fill(count, 0);
        }
        return new ArrayList(anagrams.values());
    }
}
