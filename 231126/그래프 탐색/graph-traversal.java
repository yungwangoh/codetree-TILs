import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 1000;
    static int n, m, cnt = 0;
    static List<Integer>[] list = new List[MAX + 1];
    static boolean[] visit = new boolean[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n + 1; i++) list[i] = new ArrayList<>();

        // 인접 리스트
        for(int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            list[s].add(e);
            list[e].add(s);
        }

        visit[1] = true;
        dfs(1);

        System.out.println(cnt);
    }
    static void dfs(int idx) {
    
        for(int i = 0; i < list[idx].size(); i++) {
            int vertex = list[idx].get(i);
            if(!visit[vertex]) {
                cnt++;
                visit[vertex] = true;
                dfs(vertex);
            }
        }
    }
}