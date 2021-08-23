//9663_N-Queen
/*
이차원 배열로 해결
기존에는 1을 다 집어넣었는데 개무식한 방법
일차원 배열로도 해결가능한 것을 인터넷에서 확인
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int ans = 0;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		if(N==1) {
			ans = 1;
		}
		else if(N==2 || N==3) {
			ans = 0;
		}
		else {
			N_Queen(board, 0, N);
		}
		System.out.println(ans);
	}
	
	private static boolean checkboard(int[][] board, int n, int i, int N) {
		for(int j = n-1; j>=0; j--) {
			if(board[j][i] == 1) return false;
			if(i-n+j>= 0 && board[j][i-n+j] == 1) return false;
			if(i+n-j<N && board[j][i+n-j] == 1) return false;
		}
		
		return true;
	}
	/*
	private static void printboard(int[][] board, int N) {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println(" ");
		}
	}
	*/
	
	private static void N_Queen(int[][] board, int n, int N) {
		for(int i = 0; i < N; i++) {
			board[n][i] = 1;
			if(checkboard(board, n, i, N)) {
				if(n == N-1) {
					ans++;
					//printboard(board, N);
				}
				else N_Queen(board, n+1, N);
			}
			
			board[n][i] = 0;
		}
	}
		
}