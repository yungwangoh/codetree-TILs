import java.io.*;
import java.util.*;

class Marble implements Comparable<Marble> {
    int x;
    int y;
    int d;
    int v;
    int num;

    public Marble(int x, int y, int d, int v, int num) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.v = v;
        this.num = num;
    }

    @Override
    public int compareTo(Marble marble) {
        if(v == marble.v) {
            return num - marble.num;
        }
        return v - marble.v;
    }
}
public class Main {

    // 아 위 왼 우
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Marble> list = new ArrayList<>();
    static int n, m, t, k;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        k = sc.nextInt();

        arr = new int[n][n];
        for(int i = 0; i < m; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            int d = dirMapper(sc.next().charAt(0));
            int v = sc.nextInt();

            Marble marble = new Marble(r, c, d, v, i);

            list.add(marble);
        }

        for(int i = 0; i < t; i++) {
            moveAll();

            remove();
        }

        System.out.println(list.size());
    }
    static Marble move(Marble marble) {
        int x = marble.x;
        int y = marble.y;
        int d = marble.d;
        int v = marble.v;
        int num = marble.num;

        int nx = x + dx[d];
        int ny = y + dy[d];

        if(isRange(nx, ny)) return new Marble(nx, ny, d, v, num);
        else {
            int dir = dirChange(d);
            return new Marble(x + dx[dir], y + dy[dir], dir, v, num);
        }
    }
    static void moveAll() {

        for(int i = 0; i < list.size(); i++) {
            Marble marble = list.get(i);

            int v = marble.v;

            for(int j = 0; j < v; j++) {
                marble = move(marble);
            }
            
            list.set(i, marble);
        }
    }
    static boolean duplicatedMarble(int idx) {
        int x = list.get(idx).x;
        int y = list.get(idx).y;
        int d = list.get(idx).d;
        int v = list.get(idx).v;

        return arr[x][y] > k;
    }
    static void remove() {
        List<Marble> temp = new ArrayList<>();
        List<Marble>[][] duplicatedTemp = new List[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) duplicatedTemp[i][j] = new ArrayList<>();
        }

        for(int i = 0; i < list.size(); i++) {
            int x = list.get(i).x;
            int y = list.get(i).y;

            arr[x][y]++;
        }

            // for(int j = 0; j < n; j++) {
            //     for(int k = 0; k < n; k++) {
            //         System.out.print(arr[j][k] + " ");
            //     }
            //     System.out.println();
            // }

        for(int i = 0; i < list.size(); i++) {
            Marble m = list.get(i);
            duplicatedTemp[m.x][m.y].add(m);
        }

        for(int i = 0; i < list.size(); i++) {
            int x = list.get(i).x;
            int y = list.get(i).y;

            arr[x][y]--;
        }


        List<Marble> duplicatedList = new ArrayList<>(duplicatedControl(duplicatedTemp));

        list = duplicatedList;
    }
    static List<Marble> duplicatedControl(List<Marble>[][] duplicate) {
        
        List<Marble>[][] duplicatedMarble = new List[n][n];
        List<Marble> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                duplicatedMarble[i][j] = new ArrayList<>(duplicate[i][j]);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(duplicatedMarble[i][j].size() == 0) continue;

                Collections.sort(duplicatedMarble[i][j]);

                //System.out.println(duplicatedMarble[i][j].size());

                // for(Marble m : duplicatedMarble[i][j]) 
                //     System.out.println(m.x + " " + m.y + " " + m.d + " " + m.v);

                int size = duplicatedMarble[i][j].size() - k;
                for(int l = 0; l < size; l++) {
                    duplicatedMarble[i][j].remove(l);
                }

                for(int l = 0; l < duplicatedMarble[i][j].size(); l++) {
                    Marble addMarble = duplicatedMarble[i][j].get(l);
                    list.add(addMarble);
                }
            }
        }

       // System.out.println("list -> " + list.size());

        return list;
    }
    static int dirMapper(char ch) {
        if(ch == 'D') {
            return 0;
        } else if(ch == 'U') {
            return 1;
        } else if(ch == 'L') {
            return 2;
        } else if(ch == 'R') {
            return 3;
        } else {
            return -1;
        }
    }
    static int dirChange(int dir) {
        return dir ^ 1;
    }   
    static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}