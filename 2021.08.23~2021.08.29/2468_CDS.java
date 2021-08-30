import java.io.*;
import java.util.*;

public class Baekjoon_2468 {
    static int size = 0;
    static int answer = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        size = Integer.parseInt(br.readLine());
        Land[][] map = new Land[size][size];
        int maxHeight = 1;
        int minHeight = 100;

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < size; j++) {
                int height = Integer.parseInt(st.nextToken());
                map[i][j] = new Land(i, j, height);
                maxHeight = Math.max(maxHeight, map[i][j].height);
                minHeight = Math.min(minHeight, map[i][j].height);
            }
        }

        for (int height = minHeight; height <= maxHeight; height++) {
            List<Land> landList = new ArrayList<>();
            Land[][] copy_map = new Land[size][size];
            copy(map, copy_map);

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (copy_map[i][j].height < height) {
                        copy_map[i][j] = null;
                    } else {
                        landList.add(copy_map[i][j]);
                    }
                }
            }

            int count = 0;

            for (int i = 0; i < landList.size(); i++) {
                Land land = landList.get(i);
                if (!land.visited) {
                    DFS(land, copy_map);
                    count++;
                }
            }

            answer = Math.max(answer, count);
        }

        bw.write(answer + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(Land land, Land[][] map) {
        land.visited = true;

        if (land.X != 0 && map[land.X - 1][land.Y] != null && !map[land.X - 1][land.Y].visited) {
            DFS(map[land.X - 1][land.Y], map);
        }

        if (land.X != size - 1 && map[land.X + 1][land.Y] != null && !map[land.X + 1][land.Y].visited) {
            DFS(map[land.X + 1][land.Y], map);
        }

        if (land.Y != 0 && map[land.X][land.Y - 1] != null && !map[land.X][land.Y - 1].visited) {
            DFS(map[land.X][land.Y - 1], map);
        }

        if (land.Y != size - 1 && map[land.X][land.Y + 1] != null && !map[land.X][land.Y + 1].visited) {
            DFS(map[land.X][land.Y + 1], map);
        }
    }

    private static void copy(Land[][] ori, Land[][] dest) {
        for (int i = 0; i < ori.length; i++) {
            for (int j = 0; j < ori[i].length; j++) {
                dest[i][j] = new Land(ori[i][j].X, ori[i][j].Y, ori[i][j].height);
            }
        }
    }
}

class Land {
    int X;
    int Y;
    int height;
    boolean visited;

    Land(int X, int Y, int height) {
        this.X = X;
        this.Y = Y;
        this.height = height;
        visited = false;
    }
}