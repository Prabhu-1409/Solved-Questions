class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        List<Character> sl1 = new ArrayList<>();
        List<Character> sl2 = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<=s1.length()-1;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                l.add(i);
                sl1.add(s1.charAt(i));
                sl2.add(s2.charAt(i));
            }
        }
        Collections.sort(sl1);
        Collections.sort(sl2);
        if(l.size()==2 && sl1.size()==2 && sl2.size()==2){
            if(sl1.get(0)==sl2.get(0) && sl1.get(1)==sl2.get(1)){
                return true;
            }
        }
        return false;
    }
}


// Example 1:

// Input: s1 = "bank", s2 = "kanb"
// Output: true
// Explanation: For example, swap the first character with the last character of s2 to make "bank".
// Example 2:

// Input: s1 = "attack", s2 = "defend"
// Output: false
// Explanation: It is impossible to make them equal with one string swap.
// Example 3:

// Input: s1 = "kelb", s2 = "kelb"
// Output: true
// Explanation: The two strings are already equal, so no string swap operation is required.
 

// Constraints:

// 1 <= s1.length, s2.length <= 100
// s1.length == s2.length
// s1 and s2 consist of only lowercase English letters.