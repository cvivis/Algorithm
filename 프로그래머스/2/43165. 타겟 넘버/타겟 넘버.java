import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = bfs(numbers,target);
        return answer;
    }
    private int bfs(int[] numbers, int target){
        int result = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,numbers[0]});
        q.offer(new int[]{0,numbers[0] * -1});
        while(!q.isEmpty()){
            int[] now = q.poll();
//            System.out.println(Arrays.toString(now));
            if(now[0] == numbers.length -1 && target == now[1])result++;
            if(now[0]+1 < numbers.length){
                q.offer(new int[]{now[0]+1,now[1] + numbers[now[0]+1]});
                q.offer(new int[]{now[0]+1,now[1] - numbers[now[0]+1]});
            }
        }
        return result;
    }
}