import java.util.Arrays;
class Solution {
    
    // 될 수 있는 인용횟수를 돌면서 해당 인용 횟수 이상의 논문 갯수가 있는지 확인
    // 이분탐색 진행시 동일값에 대해 가장 앞에 인덱스를 보장 하지 않기에 틀린 흐름인듯
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
     if(citations[citations.length-1] >0) answer = 1;
        for(int i = 0; i <= citations.length;i++){
            int id = Arrays.binarySearch(citations,i);
            if(id < 0){
                id = (id+1) * -1;
            }
            int upCnt = citations.length - id;
            if(i <= upCnt){
                answer = i;
            }
        }
        return answer;
    }
    
    // 각 항목을 돌면서 인용횟수와 인용한 갯수 중 작은게 h 점수가 된다.
    // 그 h점수가 가장 큰 값이 정답이 됨
    public int solution2(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }

        return max;
    }
}

