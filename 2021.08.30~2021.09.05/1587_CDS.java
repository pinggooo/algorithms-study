import java.io.*;
import java.util.*;

public class Baekjoon_1587 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());
        int numEdge = Integer.parseInt(br.readLine());
        int[][] dp = new int[nA + 1][nB + 1];
        boolean[][] adj = new boolean[nA + 1][nB + 1];

        for (int i = 0; i < numEdge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj[A][B] = true;
        }

        for (int i = 0; i <= nA; i++) {
            for (int j = 0; j <= nB; j++) {
                if (adj[i][j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }

                if (i >= 2) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 2][j] + 1);
                }

                if (j >= 2) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 2] + 1);
                }

                if (i >= 2 && j >= 2) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 2][j - 2] + 2);
                }
            }
        }

        bw.write(dp[nA][nB] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
