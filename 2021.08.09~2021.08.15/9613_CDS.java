import java.io.*;
import java.util.*;

public class Baekjoon_9613 {
    static int testCase = 0;
    static long answer = -1;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            long[] array = new long[num];
            int index = 0;

            for (int j = 0; j < num; j++) {
                array[index] = Long.parseLong(st.nextToken());
                index++;
            }

            answer = 0;

            for (int j = 0; j < num - 1; j++) {
                for (int k = j + 1; k < num; k++) {
                    answer += calculateGCD(array[j], array[k]);
                }
            }

            bw.write(answer + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    // Euclidean algorithm
    private static long calculateGCD(long x, long y) {
        if (x == 0 || y == 0) {
            return (y == 0) ? x : y;
        }

        if (x >= y) {
            return calculateGCD(x % y, y);
        } else {
            return calculateGCD(x, y % x);
        }
    }
}
