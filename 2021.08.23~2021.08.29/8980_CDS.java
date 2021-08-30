import java.io.*;
import java.util.*;

public class Baekjoon_8980 {
    static int townSize = 0;
    static int loadLimit = 0;
    static int size = 0;
    static int answer = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        townSize = Integer.parseInt(st.nextToken());
        loadLimit = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(br.readLine());
        Box[] box = new Box[size];
        int[] loads = new int[townSize + 1];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int ori = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            box[i] = new Box(ori, dest, size);
        }

        Arrays.sort(box);

        for (int i = 0; i < size; i++) {
            int maxLoad = 0;

            for (int j = box[i].ori; j < box[i].dest; j++) {
                maxLoad = Math.max(maxLoad, loads[j]);
            }

            int remainLoad = Math.min(box[i].size, loadLimit - maxLoad);
            answer += remainLoad;

            for (int j = box[i].ori; j < box[i].dest; j++) {
                loads[j] += remainLoad;
            }
        }

        bw.write(answer + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}

class Box implements Comparable<Box> {
    int ori;
    int dest;
    int size;

    Box (int ori, int dest, int size) {
        this.ori = ori;
        this.dest = dest;
        this.size = size;
    }

    @Override
    public int compareTo(Box o) {
        if (this.dest == o.dest) {
            return (this.ori - o.ori);
        } else {
            return (this.dest - o.dest);
        }
    }
}