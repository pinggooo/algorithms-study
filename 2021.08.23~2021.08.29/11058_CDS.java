import java.io.*;

public class Baekjoon_11058 {
    static int size = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        size = Integer.parseInt(br.readLine());

        long[] dp = new long[size + 1];

        for (int i = 0; i <= size; i++) {
            if (i <= 2) {
                dp[i] = i;
                continue;
            }

            dp[i] = dp[i - 1] + 1;

            //After Ctrl_A + Ctrl_C. we can multiple with Ctrl_V
            for (int j = 1; j < i - 2; j++) {
                dp[i] = Math.max(dp[i], dp[i - 2 - j] * (j + 1));
            }
        }

        bw.write(dp[size] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}