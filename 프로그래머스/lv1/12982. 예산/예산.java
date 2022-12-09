import java.util.Arrays;
class Solution {
        public static int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d); // 정렬해서 작은 수부터 예산에서 빼주어 처리한다. 
        for(int num: d){ 
            if(budget >= num){ //예산보다 필요한 값이 더 크면 X 
                budget = budget - num;
                answer++;
            }
        }

        return answer;
        }
}