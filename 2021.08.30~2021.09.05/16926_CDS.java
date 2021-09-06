import java.io.*;
import java.util.*;

public class Baekjoon_16926 {
    static int N;
    static int M;
    static int R;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][M];
        int[][] result = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                result[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < Math.min(N, M) / 2; i++) {
            rotate(matrix, result, i, R % (2 * ((M - (2 * i + 1)) + (N - (2 * i + 1)))));
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(Integer.toString(result[i][j]));

                if (j != M - 1) {
                    bw.write(" ");
                }
            }

            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void rotate(int[][] matrix, int[][] result, int depth, int number) {
        int i = depth;
        int j = depth;
        int count = 0;
        int index = 0;
        int[] array = new int[2 * ((M - (2 * depth + 1)) + (N - (2 * depth + 1)))];

        while (count < array.length) {
            array[index] = matrix[i][j];
            index++;
            count++;

            if (i < N - depth - 1 && j == depth) {
                i++;
                continue;
            }

            if (i == N - depth - 1 && j < M - depth - 1) {
                j++;
                continue;
            }

            if (i > depth && j == M - depth - 1) {
                i--;
                continue;
            }

            if (i == depth && j > depth) {
                j--;
            }
        }

        i = depth;
        j = depth;
        count = 0;
        index = array.length - number;

        while (count < array.length) {
            if (index == array.length) {
                index = 0;
            }

            result[i][j] = array[index];
            index++;
            count++;

            if (i < N - depth - 1 && j == depth) {
                i++;
                continue;
            }

            if (i == N - depth - 1 && j < M - depth - 1) {
                j++;
                continue;
            }

            if (i > depth && j == M - depth - 1) {
                i--;
                continue;
            }

            if (i == depth && j > depth) {
                j--;
            }
        }
    }
}