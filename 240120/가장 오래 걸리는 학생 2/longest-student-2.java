import java.io.*;
import java.util.*;

class Node {
    int idx, dist;

    Node(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }
}
class Element implements Comparable<Element>{
    int dist, idx;

    Element(int dist, int idx) {
        this.dist = dist;
        this.idx = idx;
    }

    @Override
    public int compareTo(Element e) {
        return dist - e.dist;
    }
}
public class Main {

    static int n, m;
    static final int MAX = 100000;
    static List<Node>[] graph = new List[MAX + 1];
    static Queue<Element> pq = new PriorityQueue<>();
    static int[] dist = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for(int i = 1; i <= n; i++) dist[i] = (int)1e9;

        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            graph[y].add(new Node(x, z));
        }

        dist[n] = 0;

        pq.add(new Element(0, n));

        while(!pq.isEmpty()) {
            Element e = pq.poll();

            int minIdx = e.idx;
            int minDist = e.dist;

            if(minDist != dist[minIdx]) continue;

            for(Node node : graph[minIdx]) {
                int targetIdx = node.idx;
                int targetDist = node.dist;

                int newDist = dist[minIdx] + targetDist;

                if(dist[targetIdx] > newDist) {
                    dist[targetIdx] = newDist;
                    pq.add(new Element(newDist, targetIdx));
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }

        System.out.println(max);
    }
}