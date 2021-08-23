//12865_ROH 평범한 배낭
/*
접근 순서
원래는 1차원 배열을 이용해서 풀려고 하였음
그런데 1차원 배열을 사용할 경우 해당 무게에서 어떤 짐들이 들어갔는지 확인이 불가
따라서 2차원 배열을 이용하는 방향으로선회 (벡터로 거기들어간짐까지 포함할까하다가 포기)
*/
import java.io.*;
import java.util.StringTokenizer;

public class 12865_ROH {
	
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] item = new int[N+1][2];
        int[][] dp = new int[N+1][K+1];
        
        for (int i = 1; i<=N; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine(), " ");
            int W = Integer.parseInt(temp.nextToken());
            int V = Integer.parseInt(temp.nextToken());
        	item[i][0] = W;
        	item[i][1] = V;
        }

        for(int i = 1; i<=N; i++) {
        	for(int j = 1;j<=K; j++) {
        		if(item[i][0]<=j) {
        			dp[i][j] = Math.max(dp[i-1][j],item[i][1]+dp[i-1][j-item[i][0]]);
        		}
        		else {
        			dp[i][j] = dp[i-1][j];
        		}
        	}
        }
        System.out.println(dp[N][K]);
        br.close();
	}

}
