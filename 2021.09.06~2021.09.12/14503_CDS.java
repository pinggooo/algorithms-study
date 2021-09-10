import java.io.*;
import java.util.*;

public class Baekjoon_14503 {
    static int answer = 0;
    static int[][] map;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine(), " ");
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int heading = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        map[X][Y] = 2;
        answer++;

        while (!finish(X, Y, (heading + 2) % 4)) {
            if (goBackward(X, Y, (heading + 2) % 4)) {
                X = X + dx((heading + 2) % 4);
                Y = Y + dy((heading + 2) % 4);
                continue;
            }

            heading = (heading == 0) ? 3 : heading - 1;

            if (map[X + dx(heading)][Y + dy(heading)] == 0) {
                X = X + dx(heading);
                Y = Y + dy(heading);
                map[X][Y] = 2;
                answer++;
            }
        }

        bw.write(answer + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean goBackward(int X, int Y, int heading) {
        return (map[X - 1][Y] != 0) && (map[X + 1][Y] != 0) && (map[X][Y - 1] != 0) && (map[X][Y + 1] != 0) && (map[X + dx(heading)][Y + dy(heading)] != 1);
    }

    private static boolean finish(int X, int Y, int heading) {
        return (map[X - 1][Y] != 0) && (map[X + 1][Y] != 0) && (map[X][Y - 1] != 0) && (map[X][Y + 1] != 0) && (map[X + dx(heading)][Y + dy(heading)] == 1);
    }

    private static int dx(int heading) {
        if (heading == 0) {
            return -1;
        } else if (heading == 2) {
            return 1;
        } else {
            return 0;
        }
    }

    private static int dy(int heading) {
        if (heading == 3) {
            return -1;
        } else if (heading == 1) {
            return 1;
        } else {
            return 0;
        }
    }
}