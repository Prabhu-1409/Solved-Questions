class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        for(int i=0;i<=s.length()-1;i++){
            int calc = 25 - (s.charAt(i)-'a');
            ans = ans + ((calc+1)*(i+1));  
        }
        return ans;
    }
}