import java.util.*;
class Solution {
static class Rank implements Comparable<Rank>{
        int totalView;
        String genre;
        int id;
        int view;

        public Rank(int totalView, String genre, int id, int view) {
            this.totalView = totalView;
            this.genre = genre;
            this.id = id;
            this.view = view;
        }

        @Override
        public int compareTo(Rank o) {
            if(this.totalView == o.totalView){
                if(this.view == o.view){
                    return (o.id - this.id) * -1;
                }
                return o.view - this.view;
            }
            return o.totalView - this.totalView;
        }
    }
    
    public static Integer[] solution(String[] genres, int[] plays) {
        PriorityQueue<Rank> pq = new PriorityQueue<>();
//        int[] answer = new int[genres.length];
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<String,Integer> bestCount = new HashMap<>();
        for(int i = 0; i < genres.length;i++){
            map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
            bestCount.put(genres[i],0);
        }
//        for(Map.Entry<String,Integer> entry : map.entrySet()){
//            System.out.println(entry.getKey() + " "+entry.getValue());
//        }
        for(int i = 0; i < genres.length;i++){
            pq.offer(new Rank(map.get(genres[i]),genres[i],i,plays[i]));
        }
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < genres.length;i++){
            Rank rank = pq.poll();
            if(bestCount.get(rank.genre) != 2){
                answer.add(rank.id);
//                System.out.println(bestCount.get(rank));
                bestCount.put(rank.genre,bestCount.get(rank.genre)+1);
            }
        }

        return answer.toArray(Integer[]::new);
    }
}