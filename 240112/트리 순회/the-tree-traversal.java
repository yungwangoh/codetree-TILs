import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static final int MAX = 26;
    static int[] left = new int[MAX];
    static int[] right = new int[MAX];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            left[i] = -1;
            right[i] = -1;
        }

        for(int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            char p = st1.nextToken().charAt(0);
            char l = st1.nextToken().charAt(0);
            char r = st1.nextToken().charAt(0);

            if(l != '.') left[p - 'A'] = l - 'A';
            if(r != '.') right[p - 'A'] = r - 'A';
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();

        bw.flush();
        bw.close();
    }
    static void preOrder(int x) {
        if(x == -1) return;

        System.out.print((char) (x + 'A'));
        preOrder(left[x]);
        preOrder(right[x]);
    }
    static void inOrder(int x) {

        if(x == -1) return;

        inOrder(left[x]);
        System.out.print((char) (x + 'A'));
        inOrder(right[x]);
    }
    static void postOrder(int x) {

        if(x == -1) return;

        postOrder(left[x]);
        postOrder(right[x]);
        System.out.print((char) (x + 'A'));
    }
}