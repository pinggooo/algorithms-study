import java.io.*;
import java.util.*;

public class Baekjoon_1956 {
    static int answer = -1;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int numVertex = Integer.parseInt(st.nextToken());
        int numEdge = Integer.parseInt(st.nextToken());
        int[][] adj = new int[numVertex + 1][numVertex + 1];

        for (int i = 0; i <= numVertex; i++) {
            for (int j = 0; j <= numVertex; j++) {
                adj[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < numEdge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int ori = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            adj[ori][dest] = distance;
        }

        for (int k = 1; k <= numVertex; k++) {
            for (int i = 1; i <= numVertex; i++) {
                for (int j = 1; j <= numVertex; j++) {
                    if (adj[i][k] != Integer.MAX_VALUE && adj[k][j] != Integer.MAX_VALUE) {
                        adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                    }

                    if (i == j && adj[i][i] != Integer.MAX_VALUE) {
                        answer = (answer == -1) ? adj[i][i] : Math.min(answer, adj[i][i]);
                    }
                }
            }
        }

        bw.write(answer + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}