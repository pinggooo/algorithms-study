import java.io.BufferedReader;
import java.io.InputStreamReader;

class 11058_ROH {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N];
		
		
		if(N>6) {
			for(int i = 0; i<6; i++) {
				dp[i] = i+1;
			}
			for(int i = 6; i<N; i++) {
				long temp = Math.max(dp[i-3]*2, dp[i-4]*3);
				dp[i] = Math.max(temp, dp[i-5]*4);
			}
		}
		else {
			for(int i = 0; i<N; i++) {
				dp[i] = i+1;
			}
			
		}
		
		System.out.println(dp[N-1]);
		/*for(int i = 0; i<N; i++) {
			System.out.println(dp[i]);
		}*/
		

	}

		
}