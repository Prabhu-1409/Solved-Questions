import java.io.*;
import java.util.*;
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int calc = 0;
        List<String> temp = new ArrayList<>();
        int followUp = 0;
        for(int i=0;i<=words.length-1;i++){
            followUp = followUp + words[i].length();
            int spaces = (temp.size() - 1)>=0 ? temp.size()-1:0;
            if(words[i].length()==maxWidth && temp.size()==0){
                    int len = maxWidth - words[i].length();
                    ans.add(words[i] + " ".repeat(len));
                    followUp = 0;
                    continue;
            }
            if((followUp+spaces+1)<=maxWidth){
                temp.add(words[i]);
            }
            else if(temp.size()==1 && followUp>maxWidth){
                int len = maxWidth - temp.get(0).length();
                ans.add(temp.get(0) + " ".repeat(len));
                temp.clear();
                temp.add(words[i]);
                followUp = words[i].length();
            }
            else if(temp.size()>0){
                if(temp.size()==1 && (followUp+spaces+1)>maxWidth){
                int len = maxWidth - temp.get(0).length();
                ans.add(temp.get(0) + " ".repeat(len));
                temp.clear();
                temp.add(words[i]);
                followUp = words[i].length();
                continue;
                }
                followUp = followUp - words[i].length();
                int diff = maxWidth - (followUp + temp.size()-1);
                
                if((diff % (temp.size() - 1))==0){
                    int extras =  diff / (temp.size() - 1);
                    ans.add(String.join(" ".repeat(extras+1),temp));
                    temp.clear();
                    temp.add(words[i]);
                    followUp = words[i].length();
                }else{
                    String temp1 = "";
                    if(temp.size()>1){
                        int gaps = temp.size() - 1;
                        int spacedToadd = diff;
                        String temp2 = "";
                        if(spacedToadd<=gaps){
                            for(int j=0;j<=temp.size()-1;j++){
                            if(j!=temp.size()-1 && spacedToadd>0){
                                temp2 = temp2 + temp.get(j) + " ".repeat(2);
                                spacedToadd--;
                            }else if(j!=temp.size()-1){
                                temp2 = temp2 + temp.get(j) + " ".repeat(1);
                            }else{
                                 temp2 = temp2 + temp.get(j);
                            }
                            }
                        }
                        if(spacedToadd>gaps){
                            //  System.out.println("spaces"+spacedToadd+" "+gaps);
                            for(int j=0;j<=temp.size()-1;j++){
                                int spaces_add = (int) Math.ceil((float)spacedToadd/gaps);
                                if(j!=temp.size()-1){
                                    temp2 = temp2 + temp.get(j) + " ".repeat(spaces_add+1);
                                   spacedToadd = spacedToadd - spaces_add;
                                   gaps--;
                                }else{
                                     temp2 = temp2 + temp.get(j);
                                }
                            }
                            // if(temp2.length()<maxWidth){
                            //     temp2 = temp2 + " ".repeat(gap_calc+1);
                            // }
                        }
                        ans.add(temp2);
                        temp.clear();
                        temp.add(words[i]);
                        followUp = words[i].length();
                    }else{
                        temp1 = String.join(" ".repeat(diff+1),temp) +  " ".repeat(diff+1);
                        ans.add(temp1);
                        temp.clear();
                        temp.add(words[i]);
                        followUp = words[i].length();
                    }
                }
            }
        }
        
        if(temp.size()==1 && followUp>maxWidth){
                int len = maxWidth - temp.get(0).length();
                ans.add(temp.get(0) + " ".repeat(len));
                temp.clear();
        }
        else if(temp.size()>0){
                String ext = String.join(" ".repeat(1),temp);
                // System.out.println(temp.size()-1);
                ans.add(ext + " ".repeat(Math.abs(maxWidth - ext.length())));
                temp.clear();
        }
        return ans;
    }
}


// Example 1:

// Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
// Output:
// [
//    "This    is    an",
//    "example  of text",
//    "justification.  "
// ]
// Example 2:

// Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
// Output:
// [
//   "What   must   be",
//   "acknowledgment  ",
//   "shall be        "
// ]
// Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
// Note that the second line is also left-justified because it contains only one word.
// Example 3:

// Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
// Output:
// [
//   "Science  is  what we",
//   "understand      well",
//   "enough to explain to",
//   "a  computer.  Art is",
//   "everything  else  we",
//   "do                  "
// ]
 

// Constraints:

// 1 <= words.length <= 300
// 1 <= words[i].length <= 20
// words[i] consists of only English letters and symbols.
// 1 <= maxWidth <= 100
// words[i].length <= maxWidth