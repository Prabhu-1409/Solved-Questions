class Solution {
    public int countAsterisks(String s) {
        String[] temp = s.split("\\|");
        int max = 0;
        for(int i=0;i<=temp.length-1;i++){
            if((i%2)==0){
                for(int j=0;j<=temp[i].length()-1;j++){
                    if(temp[i].charAt(j)=='*') max++;
                }
            }
        }
        return max;
    }
}


// Example 1:

// Input: s = "l|*e*et|c**o|*de|"
// Output: 2
// Explanation: The considered characters are underlined: "l|*e*et|c**o|*de|".
// The characters between the first and second '|' are excluded from the answer.
// Also, the characters between the third and fourth '|' are excluded from the answer.
// There are 2 asterisks considered. Therefore, we return 2.
// Example 2:

// Input: s = "iamprogrammer"
// Output: 0
// Explanation: In this example, there are no asterisks in s. Therefore, we return 0.
// Example 3:

// Input: s = "yo|uar|e**|b|e***au|tifu|l"
// Output: 5
// Explanation: The considered characters are underlined: "yo|uar|e**|b|e***au|tifu|l". There are 5 asterisks considered. Therefore, we return 5.
 

// Constraints:

// 1 <= s.length <= 1000
// s consists of lowercase English letters, vertical bars '|', and asterisks '*'.
// s contains an even number of vertical bars '|'.