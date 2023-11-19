import java.io.*;
import java.util.*;

class Pair {

    int x1, x2;

    public Pair(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}
public class Main {

    static List<Pair> list = new ArrayList<>();
    static List<Pair> nList = new ArrayList<>();
    static int n, max = 0;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            list.add(new Pair(x1, x2));
        }

        combi(0);

        //System.out.println(check(list.get(1), list.get(2)));

        if(n == 1) System.out.println(1);
        else System.out.println(max);        
    }
    static void combi(int idx) {
        if(idx == n) {

            int cnt = 0;
            for(int i = 0; i < nList.size() - 1; i++) {
                for(int j = i + 1; j < nList.size(); j++) {
                    if(check(nList.get(i), nList.get(j))) {
                        cnt++;
                    }
                }
            }
            
            max = Math.max(max, cnt);
            return;
        }

        nList.add(list.get(idx));
        combi(idx + 1);
        nList.remove(nList.size() - 1);

        combi(idx + 1);
    }
    static boolean check(Pair l1, Pair l2) {
        int x1 = l1.x1;
        int y1 = l1.x2;

        int x2 = l2.x1;
        int y2 = l2.x2;

        return !(x2 > y1 || y2 < x1);
    }
}