import java.io.*;
import java.util.*;
class Solution {
    public int largestMagicSquare(int[][] grid) {
        int size = 1;
        int rs = 0;
        int re = rs + size;
        int cs = 0;
        int ce = cs + size;
        int carry = 0;
        int ans = 1;
        int it = 1;
        for(int i=1;i<=(grid.length*grid[0].length)*grid.length*grid[0].length;i++){
            if(rs>=0 && re<=grid.length-1 && cs>=0 && ce<=grid[0].length-1){
                int[][] mat = new int[size+1][size+1];
                int rI = 0;
                int cI = 0;
                for(int j=rs;j<=re;j++){
                    cI = 0;
                    for(int k=cs;k<=ce;k++){
                        mat[rI][cI] = grid[j][k];
                        cI++;
                    }
                    rI++;
                }
                if(isAllEquals(mat)) ans = Math.max(ans,size+1);
                cs++;
                ce = cs + size;
                it++;
            }else{
                rs++;
                re = rs + size;
                cs = 0;
                ce = cs + size;
            }
            if((((grid.length-size)*(grid[0].length-size))+carry)==it){
                carry = carry + (grid.length-size)*(grid[0].length-size);
                size++;
                rs = 0;
                re = rs + size;
                cs = 0;
                ce = cs + size;
            }
        }
        return ans;
    }
    public boolean isAllEquals(int[][] mat){
        HashSet<Integer> h = new HashSet<>();
        int fD = 0;
        int rD = 0;
        int rS = 0;
        int cS = 0;
        for(int i=0;i<=mat.length-1;i++){
            rS = 0;
            cS = 0;
            fD = fD + mat[i][i];
            rD = rD + mat[i][(mat.length-1)-i];
            for(int j=0;j<=mat[i].length-1;j++){
                rS = rS + mat[i][j];
                cS = cS + mat[j][i];
            }
            h.add(rS);
            h.add(cS);
        }
        h.add(fD);
        h.add(rD);
        if(h.size()==1) return true;
        return false;
    }
}
// Example 1:

// Input: grid = [[7,1,4,5,6],[2,5,1,6,4],[1,5,4,3,2],[1,2,7,3,4]]
// Output: 3
// Explanation: The largest magic square has a size of 3.
// Every row sum, column sum, and diagonal sum of this magic square is equal to 12.
// - Row sums: 5+1+6 = 5+4+3 = 2+7+3 = 12
// - Column sums: 5+5+2 = 1+4+7 = 6+3+3 = 12
// - Diagonal sums: 5+4+3 = 6+4+2 = 12
// Example 2:

// Input: grid = [[5,1,3,1],[9,3,3,1],[1,3,3,8]]
// Output: 2
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 50
// 1 <= grid[i][j] <= 106







