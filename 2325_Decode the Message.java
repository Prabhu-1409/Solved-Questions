class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character,Character> h = new HashMap<>();
        key = key.replaceAll("\\s+","");
        int i=0;
        int n = 0;
        while(i<=key.length()-1){
            if(n==26) break;
            if(!h.containsKey(key.charAt(i))){
                h.put(key.charAt(i),((char)(n+97)));
                n++;
            }
            i++;
        }
        String ans = "";
        for(int j=0;j<=message.length()-1;j++){
            if(message.charAt(j)==' '){
                ans = ans + " ";
            }else{
                ans = ans + h.get(message.charAt(j));
            }
        }
        return ans;
    }
}


// Example 1:


// Input: key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
// Output: "this is a secret"
// Explanation: The diagram above shows the substitution table.
// It is obtained by taking the first appearance of each letter in "the quick brown fox jumps over the lazy dog".
// Example 2:


// Input: key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb"
// Output: "the five boxing wizards jump quickly"
// Explanation: The diagram above shows the substitution table.
// It is obtained by taking the first appearance of each letter in "eljuxhpwnyrdgtqkviszcfmabo".
 

// Constraints:

// 26 <= key.length <= 2000
// key consists of lowercase English letters and ' '.
// key contains every letter in the English alphabet ('a' to 'z') at least once.
// 1 <= message.length <= 2000
// message consists of lowercase English letters and ' '.