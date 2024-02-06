import java.util.HashMap;
import java.util.Map;

class Solution {
     public int solution(int[] topping) {
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> youngMap = new HashMap<>();
        int result = 0;
        for(int i = 0; i<topping.length;i++){
            map.put(topping[i],map.getOrDefault(topping[i],0)+1);
        }
       for(int i = topping.length-1;i>=0;i--){
           youngMap.put(topping[i],map.getOrDefault(topping[i],0)+1);
           if(map.get(topping[i])==1){
               map.remove(topping[i]);
           }
           else{
               map.put(topping[i],map.get(topping[i])-1);
           }
           if(map.size() == youngMap.size()){
               result++;
           }
       }
        return result;
    }
}