import java.io.*;
import java.util.*;

public class Baekjoon_14501 {
    static int totalDay = 0;
    static int answer = -1;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        totalDay = Integer.parseInt(br.readLine());
        int[] time = new int[totalDay];
        int[] price = new int[totalDay];

        for (int i = 0; i < totalDay; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        answer = counseling(time, price, 0, 0);
        bw.write(answer + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int counseling(int[] time, int[] price, int today, int benefit) {
        if (today == totalDay) {
            return Math.max(answer, benefit);
        }

        if (today + time[today] <= totalDay) {
            answer = counseling(time, price, today + time[today], benefit + price[today]);
        }

        for (int i = today + 1; i < totalDay; i++) {
            answer = counseling(time, price, i, benefit);
        }

        return Math.max(answer, benefit);
    }
}
