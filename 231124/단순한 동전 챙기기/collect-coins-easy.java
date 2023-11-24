import java.io.*;
import java.util.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static int n, min = Integer.MAX_VALUE;
    static final int MX = 20;
    static int max = 0;
    static char[][] arr = new char[MX + 1][MX + 1];
    static List<Integer> list = new ArrayList<>();
    static Pair[] nList = new Pair[MX];
    static List<Integer> li = new ArrayList<>();
    static Pair start, end;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);

                if(arr[i][j] == 'S') start = new Pair(i, j);
                else if(arr[i][j] == 'E') end = new Pair(i, j);
                else if(arr[i][j] >= '1' && arr[i][j] <= '9') {
                    list.add((int) (arr[i][j] - '0'));
                    nList[(int) (arr[i][j] - '0')] = new Pair(i, j);
                }
            }
        }

        if(list.size() >= 3) {
            func(0, 0);
        } else {
            min = -1;
        }

        System.out.println(min);
    }
    static void func(int idx, int cnt) {
        if(idx == list.size()) {
            if(cnt == 3) {
                min = Math.min(min, check());
            }
            return;
        }

        li.add(list.get(idx));
        func(idx + 1, cnt + 1);
        li.remove(li.size() - 1);

        func(idx + 1, cnt);
    }
    static int check() {
        // for(int i = 0; i < li.size(); i++) System.out.print(li.get(i) + " ");
        // System.out.println();

        int sum = 0;
        for(int i = 0; i < li.size() - 1; i++) {

            Pair p1 = nList[li.get(i)];
            Pair p2 = nList[li.get(i + 1)];
            
            sum += minimum(p1, p2);
        }

        sum += minimum(start, nList[li.get(0)]);
        sum += minimum(end, nList[li.get(li.size() - 1)]);

        return sum;
    }
    static int minimum(Pair p1, Pair p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}