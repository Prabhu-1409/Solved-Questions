
class Solution {
    public String arrangeWords(String text) {
        TreeMap<Integer,List<String>> h = new TreeMap<>();
        String[] temp = text.split("\\s+");
        for(String i:temp){
            List<String> l;
            if(h.containsKey(i.length())){
                l = (List<String>) h.get(i.length());
                l.add(i.toLowerCase());
            }else{
                l  = new ArrayList<>();
                l.add(i.toLowerCase());
            }
            h.put(i.length(),l);
        }
        String ans = "";
        for(Map.Entry j:h.entrySet()){
            List<String> l = (List<String>) j.getValue();
            ans = ans + " " + String.join(" ",l);
        }
        ans = ans.substring(1,ans.length());
       // System.out.println(h);
        return Character.toUpperCase(ans.charAt(0)) + ans.substring(1,ans.length());
    }
}


// Example 1:

// Input: text = "Leetcode is cool"
// Output: "Is cool leetcode"
// Explanation: There are 3 words, "Leetcode" of length 8, "is" of length 2 and "cool" of length 4.
// Output is ordered by length and the new first word starts with capital letter.
// Example 2:

// Input: text = "Keep calm and code on"
// Output: "On and keep calm code"
// Explanation: Output is ordered as follows:
// "On" 2 letters.
// "and" 3 letters.
// "keep" 4 letters in case of tie order by position in original text.
// "calm" 4 letters.
// "code" 4 letters.
// Example 3:

// Input: text = "To be or not to be"
// Output: "To be or to be not"
 

// Constraints:

// text begins with a capital letter and then contains lowercase letters and single space between words.
// 1 <= text.length <= 10^5