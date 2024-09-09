import java.util.*;
class Solution {
public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < progresses.length;i++){
            Integer day = (int)Math.ceil((100 - progresses[i])/(double)speeds[i]);
           queue.offer(day);
        }
        List<Integer> list = new ArrayList<>();
        int totalDay = queue.poll();;
        int count = 1;
        while(!queue.isEmpty()){
            int day =  queue.poll();
            if(day > totalDay){
                totalDay=day;
                list.add(count);
                count = 1 ;
            }
            else{
                count++;
            }
            System.out.println(totalDay + " "+ day);

        }
        if(count >= 1)list.add(count);
        System.out.println(list);
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}