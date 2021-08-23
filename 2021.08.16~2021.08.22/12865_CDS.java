import java.io.*;
import java.util.*;

public class Baekjoon_12865 {
    static int size = 0;
    static int totalWeight = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        size = Integer.parseInt(st.nextToken());
        totalWeight = Integer.parseInt(st.nextToken());
        Item[] item = new Item[size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            item[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[][] dp = new int[size + 1][totalWeight + 1];
        int max = 0;

        for (int i = 0; i <= size; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= totalWeight; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j<= totalWeight; j++) {
                if (item[i - 1].weight <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - item[i - 1].weight] + item[i - 1].price, dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

                max = Math.max(dp[i][j], max);
            }
        }

        bw.write(max + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}

class Item {
    int weight;
    int price;

    Item(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }
}
