import java.util.*;
class Solution {
    // public String solution(String[] participant, String[] completion) {
    //     String answer = "";
    //     Arrays.sort(participant);
    //     Arrays.sort(completion);
    //     for(int i = 0; i<completion.length; i++){
    //         if(!(completion[i].equals(participant[i]))){
    //             answer = participant[i];
    //             return answer;
    //         }
    //     }
    //     answer = participant[participant.length-1];
    //     return answer;
    // }
    public String solution(String[] participant, String[] completion) {
        String str = "";
    HashMap<String,Integer> participantCount = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            participantCount.put(participant[i],participantCount.getOrDefault(participant[i],0)+1);

        }
        for(int i = 0; i < completion.length;i++){
            participantCount.put(completion[i],participantCount.get(completion[i])-1);
        }
        Set<String> keys = participantCount.keySet();
            for(String key:keys){
                if(participantCount.get(key)!=0){
                    str = key;
                }
            }
        return str;
    }
}