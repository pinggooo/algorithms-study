import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
//coin
public class 2294_ROH {
	
	static int[][] dp = new int[10001][2];
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		
		for(int i = 0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(coin);
		for(int j = 1; j<=K; j++) {
			for(int i = 0; i<N; i++) {
				if(j%coin[i] == 0) {
					dp[j][0] = 1;
					dp[j][1] = j/coin[i];
				}
			}
			for(int i = 1; i<j; i++) {
				if(dp[j-i][0]*dp[i][0] == 1) {
					if(dp[j][0] == 1) {
						dp[j][1] = Math.min(dp[j-i][1]+dp[i][1],dp[j][1]);
					}
					else {
						dp[j][1] = dp[j-i][1]+dp[i][1];
						dp[j][0] = 1;
					}
				}
			}
		}
		if(dp[K][0]==1) System.out.println(dp[K][1]);
		else System.out.println("-1");
	}
}
