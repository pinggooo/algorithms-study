import java.io.*;
import java.util.*;

public class Baekjoon_2294 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int type = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        List<Integer> coins = new ArrayList<>();
        int[] dp = new int[sum + 1];

        for (int i = 0; i <= sum; i++) {
            dp[i] = -1;
        }

        int count = 0;

        for (int i = 0; i < type; i++) {
            int coin = Integer.parseInt(br.readLine());
            if (coins.contains(coin)) {
                count++;
                continue;
            }

            coins.add(coin);
        }

        type -= count;

        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < type; j++) {
                if (i - coins.get(j) > 0) {
                    int dp_prev = dp[i - coins.get(j)];

                    if (dp_prev == -1) {
                        continue;
                    }

                    dp[i] = (dp[i] == -1) ? dp_prev + 1 : Math.min(dp[i], dp_prev + 1);
                }

                if (i - coins.get(j) == 0) {
                    dp[i] = 1;
                }
            }
        }

        bw.write(dp[sum] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}