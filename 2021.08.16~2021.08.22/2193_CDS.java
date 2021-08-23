import java.io.*;

public class Baekjoon_2193 {
    static int size = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        size = Integer.parseInt(br.readLine());

        long[] dp = new long[size + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= size; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        bw.write(dp[size] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
