import java.util.*;
class Solution {
public static double[] solution(int k, int[][] ranges) {
//        double[] answer = {};
        List<Double> result = new ArrayList<>();
        List<Integer> list = findCount(k);
        int count = list.size()-1;
        List<Double> area = findArea(list);
        for(int [] range :ranges){
            int start = range[0];
            int end = count + range[1];
            if(start == end){
                result.add(0.0);
                continue;
            }
            else if(start > end){
                result.add(-1.0);
                continue;
            }else{
                result.add(area.get(end) - area.get(start));
            }
        }
//        System.out.println(result);
//        System.out.println(list.toArray());
        double[] answer = new double[result.size()];
        for(int i = 0; i <result.size();i++){
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static List<Integer> findCount(int k){
        List<Integer> list = new ArrayList<>();
        list.add(k);
        while(k != 1){
            if(k % 2 == 0){
                k /= 2;
            }
            else{
                k = k * 3 + 1;
            }
            list.add(k);
        }
        return list;
    }
    public static List<Double> findArea(List<Integer> list){
        List<Double> areas = new ArrayList<>();
//        areas.add(0.0);
        areas.add((list.get(0) + list.get(1))/2.0);
        for(int i = 1; i < list.size()-1;i++){
            double area = (list.get(i) + list.get(i+1))/2.0;
            areas.add(area + areas.get(i-1));
        }
        areas.add(0,0.0);
        return areas;
    }
}