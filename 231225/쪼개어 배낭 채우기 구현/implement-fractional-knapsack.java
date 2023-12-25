import java.io.*;
import java.util.*;

class Knapsack implements Comparable<Knapsack> {

    double weight, price;
    double value;

    public Knapsack(double weight, double price, double value) {
        this.weight = weight;
        this.price = price;
        this.value = value;
    } 

    @Override
    public int compareTo(Knapsack k) {
        if (this.value < k.value) {
            return 1;
        } else if (this.value > k.value) {
            return -1;
        } else {
            return 0;
        }
    }
}
public class Main {
    
    static int n, m;
    static final int MAX = 100000;
    static Knapsack[] nap = new Knapsack[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();

            nap[i] = new Knapsack(w, v, v / w);
        }

        Arrays.sort(nap, 0, n);

        double sum = 0;
        double max = 0;
        for(int i = 0; i < n; i++) {
            Knapsack np = nap[i];

            if(m - np.weight > 0) {
                sum += np.price;
            } else {
                sum += (np.price * (m / np.weight));
            }

            m -= np.weight;

            max = Math.max(max, sum);
        }

        System.out.printf("%.3f", max);
    }
}