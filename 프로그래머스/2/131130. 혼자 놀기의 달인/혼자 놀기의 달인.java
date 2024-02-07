import java.util.*;

class Solution {
    static Integer[] init;
    public static int find(int a){
        if(init[a] == a)return a;
        return init[a] = find(init[a]);
    }
    public static void init(int N){
        for(int i = 1;i <= N;i++){
            init[i] = i;
        }
    }

    public static boolean union(int a , int b){
        int na = find(a);
        int nb = find(b);
        if(na == nb)return false;
        init[na] = nb;
        return true;
    }
    public static int solution(int[] cards) {
 init = new Integer[cards.length+1];
        init(cards.length);
        for(int i=0; i<cards.length; i++) {
            int boxA = i+1;
            int boxB = cards[i];
            union(boxA, boxB);
        }
        // 각 택배상자 집합의 대표인 루트노드의 개수를 기록한다.
        Map<Integer, Integer> rootAndCount = new HashMap<>();
        for(int box=1; box<=cards.length; box++) {
            int root = find(box);
            rootAndCount.put(root, rootAndCount.getOrDefault(root, 0) + 1);
        }
        // 루트노드가 한개인 경우 0이다.
        if(rootAndCount.size() == 1) {
            return 0;
        }
        // 루트노드가 두개 이상인 경우, 큰 값 2개를 곱한다.
        List<Integer> temp = new ArrayList<>();
        for(int root: rootAndCount.keySet()) {
            temp.add(rootAndCount.get(root));
        }
        Collections.sort(temp, Comparator.reverseOrder());
        int answer = temp.get(0) * temp.get(1);
        return answer;
    }
}