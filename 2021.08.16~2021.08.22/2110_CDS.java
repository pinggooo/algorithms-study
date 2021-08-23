import java.io.*;
import java.util.*;

public class Baekjoon_2110 {
    static int houseNum = 0;
    static int modemNum = 0;
    static int answer = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        houseNum = Integer.parseInt(st.nextToken());
        modemNum = Integer.parseInt(st.nextToken());
        int[] house = new int[houseNum];

        for (int i = 0; i < houseNum; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int start = 1;
        int end = house[houseNum - 1] - house[0];

        while (start <= end) {
            int mid = (start + end) / 2;
            int prev = house[0];
            int count = 1;

            for (int i = 1; i < houseNum; i++) {
                if (house[i] - prev >= mid) {
                    count++;
                    prev = house[i];
                }
            }

            if (count >= modemNum) {
                start = mid + 1;
                answer = Math.max(mid, answer);
            } else {
                end = mid - 1;
            }
        }

        bw.write(answer + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
