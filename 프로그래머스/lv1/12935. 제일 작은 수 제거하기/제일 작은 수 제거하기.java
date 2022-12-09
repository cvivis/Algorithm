import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
class Solution {
    public static int[] solution(int[] arr) {
        int[] answer = {};
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int min = list.get(0);
        for(int num:list){
            if(min>num)min=num;
        }
        list.remove(Integer.valueOf(min));
        if(list.size()==0) list.add(-1);
        answer = list.stream().mapToInt(x->x).toArray();
        if(answer[0]==10)answer[0] = -1;
        return answer;
    }
}