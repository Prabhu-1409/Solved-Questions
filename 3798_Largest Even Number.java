


class Solution {
    public String largestEven(String s) {
        String max = s.charAt(s.length()-1)=='2'?s:"";
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='2' && s.substring(0,i+1).length()>max.length()){
                max = s.substring(0,i+1);
                break;
            }
        }
        return max;
    }
}
// Example 1:

// Input: s = "1112"

// Output: "1112"

// Explanation:

// The string already represents the largest possible even number, so no deletions are needed.

// Example 2:

// Input: s = "221"

// Output: "22"

// Explanation:

// Deleting '1' results in the largest possible even number which is equal to 22.

// Example 3:

// Input: s = "1"

// Output: ""

// Explanation:

// There is no way to get an even number.

 

// Constraints:

// 1 <= s.length <= 100
// s consists only of the characters '1' and '2'.