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

    static int[][] arr;
    static int[][] temp;
    static int n, max = 0;
    static List<Pair> list = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n][n];
        temp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                temp[i][j] = arr[i][j];

                if(arr[i][j] == 1) list.add(new Pair(i, j));
            }
        }

        combi(0);

        // three(2, 2);
        // deleteThree(2, 2);
        // print();

        System.out.println(max);
    }
    static void print() {
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void combi(int idx) {

        if(idx == list.size()) {
            max = Math.max(max, summation());
            //print();
            return;
        }
        
        int x = list.get(idx).x;
        int y = list.get(idx).y;

        one(x, y);
        combi(idx + 1);
        deleteOne(x, y);

        two(x, y);
        combi(idx + 1);
        deleteTwo(x, y);

        three(x, y);
        combi(idx + 1);
        deleteThree(x, y);
    }
    static int summation() {

        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] > 0) sum++;
            }
        }

        return sum;
    }
    static void one(int cx, int cy) {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if((cx != i && cy == j) && Math.abs(cx - i) + Math.abs(cy - j) <= 2) {
                    arr[i][j]++;
                }
            }
        }

    }
    static void deleteOne(int cx, int cy) {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if((cx != i && cy == j) && Math.abs(cx - i) + Math.abs(cy - j) <= 2) {
                    if(exist(i, j)) arr[i][j]--;
                }
            }
        }
    }
    static void two(int cx, int cy) {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(((cx == i || cy == j) && !(cx == i && cy == j)) && Math.abs(cx - i) + Math.abs(cy - j) <= 1) {
                    arr[i][j]++;
                }
            }
        }

    }
    static void deleteTwo(int cx, int cy) {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(((cx == i || cy == j) && !(cx == i && cy == j)) && Math.abs(cx - i) + Math.abs(cy - j) <= 1) {
                    if(exist(i, j)) arr[i][j]--;
                }
            }
        }
    }
    static void three(int cx, int cy) {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if((cx != i && cy != j) && Math.abs(cx - i) + Math.abs(cy - j) <= 2) {
                    arr[i][j]++;
                }
            }
        }
    }
    static void deleteThree(int cx, int cy) {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if((cx != i && cy != j) && Math.abs(cx - i) + Math.abs(cy - j) <= 2) {
                    if(exist(i, j)) arr[i][j]--;
                }
            }
        }
    } 
    static boolean exist(int x, int y) {
        for(Pair p : list) {
            if(p.x == x && p.y == y) {
                return false;
            }
        }

        return true;
    }
}