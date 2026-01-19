class Solution {
    public int alternateDigitSum(int n) {
        String s = String.valueOf(n);
        int ans = 0;
        for(int i=0;i<=s.length()-1;i++){
            if(i%2==0){
                ans = ans + Integer.parseInt(s.substring(i,i+1));
            }else{
                ans = ans - Integer.parseInt(s.substring(i,i+1));
            }
        }
        return ans;
    }
}

// Example 1:

// Input: n = 521
// Output: 4
// Explanation: (+5) + (-2) + (+1) = 4.
// Example 2:

// Input: n = 111
// Output: 1
// Explanation: (+1) + (-1) + (+1) = 1.
// Example 3:

// Input: n = 886996
// Output: 0
// Explanation: (+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0.
 

// Constraints:

// 1 <= n <= 109
 