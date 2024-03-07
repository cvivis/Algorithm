import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 종료 시점이 제일 빠른 것부터 해야한다.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer tokens;
        static StringBuilder output = new StringBuilder();
        static int N;
        static PriorityQueue<Meet> pq = new PriorityQueue();
        static class Meet implements Comparable<Meet> {
            int start;
            int end;

            public Meet(int start, int end) {
                this.start = start;
                this.end = end;
            }

            @Override
            public int compareTo(Meet o) {
                if(this.end == o.end){
                    return this.start - o.start;
                }
                return this.end - o.end;
            }

            @Override
            public String toString() {
                return "Meet{" +
                        "start=" + start +
                        ", end=" + end +
                        '}';
            }
        }
        public static void main(String[] args) throws IOException {
            tokens = new StringTokenizer(br.readLine());
            N = Integer.parseInt(tokens.nextToken());
            for (int i = 0; i < N; i++) {
                tokens = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(tokens.nextToken());
                int end = Integer.parseInt(tokens.nextToken());
                pq.add(new Meet(start, end));
            }
            int end = 0;
            int count = 0;
            for (int len = pq.size(); len > 0; len--) {
                Meet now = pq.poll();
//                System.out.println(now.toString());
//                System.out.println(now.start + " "+end);
                if (now.start >= end) {
                    count++;
                    end = now.end;
                }
            }
            System.out.println(count);
        }
}
