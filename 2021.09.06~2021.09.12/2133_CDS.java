import java.io.*;

public class Baekjoon_2133 {
    static int[] dp = new int[31];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= N; i = i + 2) {
            dp[i] = dp[i - 2] * 3;

            for (int j = 4; j <= i; j = j + 2) {
                dp[i] += dp[i - j] * 2;
            }
        }

        bw.write(dp[N] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}