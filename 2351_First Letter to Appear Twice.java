class Solution {
    public char repeatedCharacter(String s) {
        int[] temp = new int[26];
        for(int i=0;i<=s.length()-1;i++){
            temp[s.charAt(i)-'a']++;
            if(temp[s.charAt(i)-'a']==2){
                return s.charAt(i);
            }
        }
        return 'a';
    }
}


// Example 1:

// Input: s = "abccbaacz"
// Output: "c"
// Explanation:
// The letter 'a' appears on the indexes 0, 5 and 6.
// The letter 'b' appears on the indexes 1 and 4.
// The letter 'c' appears on the indexes 2, 3 and 7.
// The letter 'z' appears on the index 8.
// The letter 'c' is the first letter to appear twice, because out of all the letters the index of its second occurrence is the smallest.
// Example 2:

// Input: s = "abcdd"
// Output: "d"
// Explanation:
// The only letter that appears twice is 'd' so we return 'd'.
 

// Constraints:

// 2 <= s.length <= 100
// s consists of lowercase English letters.
// s has at least one repeated letter.

