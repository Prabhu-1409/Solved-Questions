/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        while(id>0 || !q.isEmpty()){
            for(int i=0;i<=employees.size()-1;i++){
                if(employees.get(i).id==id){
                    ans = ans + employees.get(i).importance;
                    for(int j=0;j<=employees.get(i).subordinates.size()-1;j++) q.add(employees.get(i).subordinates.get(j));
                    break;
                }
            }
            if(q.size()>=1){
                id = q.poll();
            }else{
                id = 0;
            }
        }
        return ans;
    }
}



// Example 1:


// Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
// Output: 11
// Explanation: Employee 1 has an importance value of 5 and has two direct subordinates: employee 2 and employee 3.
// They both have an importance value of 3.
// Thus, the total importance value of employee 1 is 5 + 3 + 3 = 11.
// Example 2:


// Input: employees = [[1,2,[5]],[5,-3,[]]], id = 5
// Output: -3
// Explanation: Employee 5 has an importance value of -3 and has no direct subordinates.
// Thus, the total importance value of employee 5 is -3.
 

// Constraints:

// 1 <= employees.length <= 2000
// 1 <= employees[i].id <= 2000
// All employees[i].id are unique.
// -100 <= employees[i].importance <= 100
// One employee has at most one direct leader and may have several subordinates.
// The IDs in employees[i].subordinates are valid IDs.