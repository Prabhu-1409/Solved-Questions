

class Solution {
    public String makeSmallestPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                if(s.charAt(i)<s.charAt(j)){
                    s = s.substring(0,i) + s.substring(i,j) + s.charAt(i) + s.substring(j+1,s.length());
                }else{
                    s = s.substring(0,i) + s.charAt(j) + s.substring(i+1,j) + s.substring(j,s.length());
                }
            }
            i++;
            j--;
        }
        return s;
    }
}


// Example 1:

// Input: s = "egcfe"
// Output: "efcfe"
// Explanation: The minimum number of operations to make "egcfe" a palindrome is 1, and the lexicographically smallest palindrome string we can get by modifying one character is "efcfe", by changing 'g'.
// Example 2:

// Input: s = "abcd"
// Output: "abba"
// Explanation: The minimum number of operations to make "abcd" a palindrome is 2, and the lexicographically smallest palindrome string we can get by modifying two characters is "abba".
// Example 3:

// Input: s = "seven"
// Output: "neven"
// Explanation: The minimum number of operations to make "seven" a palindrome is 1, and the lexicographically smallest palindrome string we can get by modifying one character is "neven".
 

// Constraints:

// 1 <= s.length <= 1000
// s consists of only lowercase English letters.