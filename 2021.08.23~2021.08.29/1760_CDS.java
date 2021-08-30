import java.io.*;
import java.util.*;

public class Baekjoon_1760 {
    static int row = 0;
    static int column = 0;
    static int cnt_row = 0;
    static int cnt_col = 0;
    static int answer = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());
        int[][] board = new int[row][column];
        int[][] proc_row = new int[row][column];
        int[][] proc_col = new int[row][column];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < column; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Bipartite Matching //
        // Preprocessing by row (Grouping) //
        for (int i = 0; i < row; i++) {
            boolean hasSpace = false;
            boolean isBlocked = true;

            for (int j = 0; j < column; j++) {
                if (hasSpace && board[i][j] == 2) {
                    isBlocked = true;
                    hasSpace = false;
                    continue;
                }

                if (board[i][j] == 0) {
                    if (isBlocked) {
                        cnt_row++;
                        isBlocked = false;
                    }

                    hasSpace = true;
                    proc_row[i][j] = cnt_row;
                }
            }
        }

        // Preprocessing by column (Grouping) //
        for (int i = 0; i < column; i++) {
            boolean hasSpace = false;
            boolean isBlocked = true;

            for (int j = 0; j < row; j++) {
                if (hasSpace && board[j][i] == 2) {
                    isBlocked = true;
                    hasSpace = false;
                    continue;
                }

                if (board[j][i] == 0) {
                    if (isBlocked) {
                        cnt_col++;
                        isBlocked = false;
                    }

                    hasSpace = true;
                    proc_col[j][i] = cnt_col;
                }
            }
        }

        boolean[][] adj = new boolean[cnt_row + 1][cnt_col + 1];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (proc_row[i][j] != 0 && proc_col[i][j] != 0) {
                    adj[proc_row[i][j]][proc_col[i][j]] = true;
                }
            }
        }

        int[] result = new int[cnt_row + 1];
        BFS(1, result, adj);

        bw.write(answer + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS(int depth, int[] result, boolean[][] adj) {
        if (depth > Math.min(cnt_row, cnt_col)) {
            return;
        }

        answer = Math.max(answer, depth);

        for (int i = 1; i <= cnt_col; i++) {
            if (adj[depth][i] && !hasSameElement(result, i)) {
                result[depth] = i;
                BFS(depth + 1, result, adj);
            }
        }
    }

    private static boolean hasSameElement(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return true;
            }
        }

        return false;
    }
}

// 개어렵네...
//TODO: 이분매칭 공부하기