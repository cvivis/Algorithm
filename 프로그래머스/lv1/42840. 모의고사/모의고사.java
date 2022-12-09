import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] first = {1,2,3,4,5}; //1번 수포자
        int[] second = {2,1,2,3,2,4,2,5}; // 2번수포자
        int[] third = {3,3,1,1,2,2,4,4,5,5}; //3번 수포자
        int[] score = {0,0,0};
        for (int i = 0; i < answers.length; i++) { // 답 맞았으면 score++
            if(answers[i] == first[i%first.length]){
                score[0] = score[0]+1;
            }
            if(answers[i] == second[i%second.length]){
                score[1] = score[1]+1;
            }
            if(answers[i] == third[i%third.length]){
                score[2] = score[2]+1;
            }
        }
        int max = Math.max(score[0],Math.max(score[1],score[2])); //1,2,3명중 가장 많이 맞은사람 
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) { // score 동점일경우 추가해주기
            if(score[i]==max){
                list.add(i+1);
            }
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {// list -> arr
            answer[i] = list.get(i).intValue();
        }
        return answer;
}
}