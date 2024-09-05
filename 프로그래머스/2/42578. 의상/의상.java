import java.util.*;
class Solution {
public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < clothes.length;i++){
            if(map.containsKey(clothes[i][1])){
                map.get(clothes[i][1]).add(clothes[i][0]);
            }
            else{
                map.put(clothes[i][1],new ArrayList<>());
                map.get(clothes[i][1]).add(clothes[i][0]);
            }
        }

    int mul = 1;
//        if(map.size() >= 2){
//            mul = 1;
//        }
        for(Map.Entry<String,List<String>> entry: map.entrySet()){
            mul *= (entry.getValue().size() + 1);
        }
        answer += (mul-1);
        return answer;

    }
}