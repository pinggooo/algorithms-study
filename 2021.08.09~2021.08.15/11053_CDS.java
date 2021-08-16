import java.io.*;
import java.util.*;

public class Baekjoon_11053 {
    static int size = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        size = Integer.parseInt(br.readLine());
        int[] sequence = new int[size];
        int[] array = new int[size];
        int max = 1;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < size; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
            array[i] = 1;

            for (int j = 0; j < i; j++) {
                if (sequence[j] < sequence[i]) {
                    array[i] = Math.max(array[j] + 1, array[i]);
                    max = Math.max(array[i], max);
                }
            }
        }

        bw.write(max + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
