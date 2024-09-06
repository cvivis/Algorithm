import java.util.*;
class Solution {
    
    static List<Integer[]> list = new ArrayList<>();
    public static Integer[][] solution(int n) {
        dfs(n,1,2,3);
        Integer[][] answer = new Integer[list.size()][2];
        for(int i = 0; i < list.size();i++){
//            System.out.println(Arrays.toString(list.get(i)));
            answer[i] = list.get(i);
        }
        return answer;
    }
    static void dfs(int n , int from , int by , int to){
        if(n == 1){
            list.add(new Integer[]{from,to});
            return;
        }
        dfs(n-1,from,to,by);
        list.add(new Integer[]{from,to});
        dfs(n-1,by,from,to);
    }
}