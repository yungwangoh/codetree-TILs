import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p) {
        if(y == p.y) return x - p.x;
        return y - p.y;
    }
}
public class Main {

    static int n, m;
    static TreeSet<Pair> set = new TreeSet<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int l = sc.nextInt();

            set.add(new Pair(p, l));
        }

        m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            String s = sc.next();

            if(s.equals("ad")) {
                int p = sc.nextInt();
                int l = sc.nextInt();

                set.add(new Pair(p, l));
            } else if(s.equals("sv")) {
                int p = sc.nextInt();
                int l = sc.nextInt();

                set.remove(new Pair(p, l));
            } else if(s.equals("rc")){
                int x = sc.nextInt();

                if(x == 1) {
                    Pair p = set.last();
                    System.out.println(p.x);
                } 
                else if(x == -1){
                    Pair p = set.first();
                    System.out.println(p.x);    
                }
            }
        }
    }
}