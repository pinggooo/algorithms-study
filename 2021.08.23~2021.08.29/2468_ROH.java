import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 2468_ROH {
	static int[][] area = new int[102][102];
	static int[][] safety = new int[102][102];
	static int[][] dfs = new int[102][102];
	static int ans = 0;
	static int temp = 0;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int n = 101; n>=0; n--) {
			boolean count = false;
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(area[i][j] == n) {
						safety[i][j] = 1;
						count = true;
					}
				}
			}
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					dfs[i][j] = 0;
				}
			}
			if(count) {
				countArea(N);
				//System.out.println(n+"+"+temp);
			}
			
			ans = Math.max(ans, temp);
		}
		System.out.println(ans);
	}
	
	public static void countArea(int N) {
		temp = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(safety[i][j] == 1 && dfs[i][j] == 0) {
					//dfs[i][j] = temp;
					temp++;
					//System.out.println(temp);
					dfs(N, i, j);
					
				}
			}
		}
	}
	public static void dfs(int N, int x, int y) {
		int i = x;
		int k = x-1;
		while(safety[i][y] == 1 && dfs[i][y] == 0) {
			dfs[i][y] = temp;
			if(safety[i][y+1] == 1 && dfs[i][y+1] == 0) {
				dfs(N, i, y+1);
			}
			if(safety[i][y-1] == 1 && dfs[i][y-1] == 0) {
				dfs(N, i, y-1);
			}
			i++;
		}
		while(safety[k][y] == 1 && dfs[k][y] == 0) {
			dfs[k][y] = temp;
			if(safety[k][y+1] == 1 && dfs[k][y+1] == 0) {
				dfs(N, k, y+1);
			}
			if(safety[k][y-1] == 1 && dfs[k][y-1] == 0) {
				dfs(N, k, y-1);
			}
			k--;
		}
	}
}
