import java.io.*;

public class Baekjoon_1543 {
    static int answer = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String string = br.readLine();
        String substring = br.readLine();

        int index = -substring.length();

        while ((index = string.indexOf(substring, index + substring.length())) != -1) {
            answer++;
        }

        bw.write(answer + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}