class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i=0;i<=nums.length-1;i++){
            h.put(nums[i],h.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry i:h.entrySet()){
            int c = 0;
            for(int j=(int)i.getValue();j>=1;j--){
                int v = (int) i.getValue();
                if(v%j==0){
                    c++;
                }
            }
            if(c==2){
                return true;
            }
        }
        return false;
    }
}


// Example 1:

// Input: nums = [1,2,3,4,5,4]

// Output: true

// Explanation:

// 4 has a frequency of two, which is a prime number.

// Example 2:

// Input: nums = [1,2,3,4,5]

// Output: false

// Explanation:

// All elements have a frequency of one.

// Example 3:

// Input: nums = [2,2,2,4,4]

// Output: true

// Explanation:

// Both 2 and 4 have a prime frequency.

 

// Constraints:

// 1 <= nums.length <= 100
// 0 <= nums[i] <= 100
 
