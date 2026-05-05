class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            sb.append(str.length())
                .append("#")
                .append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int ind = 0;
        while(ind < str.length()) {
            StringBuilder num = new StringBuilder();
            while(str.charAt(ind) != '#') {
                num.append(str.charAt(ind++));
            }
            ++ind;
            int strLength = Integer.valueOf(num.toString());
            StringBuilder sb = new StringBuilder();
            for(int i = ind; i<ind+strLength; ++i) {
                sb.append(str.charAt(i));
            }
            ind = ind + strLength;
            res.add(sb.toString());
        }
        return res;
    }
}


// abc   de   ghij   klm   nop   q   stu   
// 3:abc;2:de;4:ghij 
// 
//