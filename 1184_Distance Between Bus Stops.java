class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int clockWise = 0;
        if(start<=destination){
            for(int i=start;i<destination;i++){
                clockWise = clockWise + distance[i];
            }
        }else{
            int c_start = start;
            while(c_start<=distance.length-1){
                clockWise = clockWise + distance[c_start];
                c_start++;
            }
            if(c_start>distance.length-1){
                c_start = 0;
                while(c_start<destination){
                    clockWise = clockWise + distance[c_start];
                    c_start++;
                }
            }
        }
        int anticlockwise = 0;
        if(start>=destination){
            for(int j=start-1;j>=destination;j--){
                anticlockwise = anticlockwise + distance[j];
            }
        }else{
            int j = start-1;
        while(j>=0){
            anticlockwise = anticlockwise + distance[j];
            j--;
        }
        if(j==-1){
            j = distance.length-1;
            while(j>=destination){
                anticlockwise = anticlockwise + distance[j];
                j--;
            }
        }
        }
        return Math.min(clockWise,anticlockwise);
    }
}


// Example 1:

// Input: distance = [1,2,3,4], start = 0, destination = 1
// Output: 1
// Explanation: Distance between 0 and 1 is 1 or 9, minimum is 1.
 

// Example 2:

// Input: distance = [1,2,3,4], start = 0, destination = 2
// Output: 3
// Explanation: Distance between 0 and 2 is 3 or 7, minimum is 3.
 

// Example 3:

// Input: distance = [1,2,3,4], start = 0, destination = 3
// Output: 4
// Explanation: Distance between 0 and 3 is 6 or 4, minimum is 4.
 

// Constraints:

// 1 <= n <= 10^4
// distance.length == n
// 0 <= start, destination < n
// 0 <= distance[i] <= 10^4