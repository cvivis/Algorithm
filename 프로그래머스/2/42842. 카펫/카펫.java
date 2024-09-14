import java.util.Arrays;
class Solution {
public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i = 3; i <= 2505;i++){
            int x = (brown+4)/2 - i;
            if((x - 2) * (i-2) == yellow){
                answer[0] = Math.max(x,i);
                answer[1] = Math.min(x,i);
                break;
            }
        }
        return answer;
    }
}