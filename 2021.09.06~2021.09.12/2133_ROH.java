import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.StringTokenizer;

public class 2133_ROH {
	static int ans = 0;
	static int[] dp = new int[31];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(br.readLine());
		
		dp[0] = 1;
		dp[2] = 3;
		for(int i = 4; i<=N; i++) {
			if(N%2 == 1) dp[N] = 0;
			else {
				dp[i] = dp[i-2]*3;
				for(int j = 4; j<=i; j+=2) {
					dp[i] += dp[i-j]*2;
				}
			}
		}
		System.out.println(dp[N]);
	}
	
}
