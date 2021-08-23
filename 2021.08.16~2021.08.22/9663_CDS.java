import java.io.*;

public class Baekjoon_9663 {
    static int size = 0;
    static int answer = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        size = Integer.parseInt(br.readLine());

        int[] queen = new int[size]; // save value(column) in array index(row)

        nQueen(queen, 0);

        bw.write(answer + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void nQueen(int[] queen, int row) {
        if (row == size) {
            answer++;
            return;
        }

        for (int i = 0; i < size; i++) {
            queen[row] = i;

            if (checkPossibility(queen, row)) {
                nQueen(queen, row + 1);
            }
        }
    }

    private static boolean checkPossibility(int[] queen, int row) {
        for (int i = 0; i < row; i++) {
            if (queen[i] == queen[row]) {
                return false;
            }

            if (Math.abs(row - i) == Math.abs(queen[row] - queen[i])) {
                return false;
            }
        }

        return true;
    }
}
