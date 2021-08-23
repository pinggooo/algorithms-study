import java.io.*;
//2193_ROH 이친수
/*
단순한 DP 끝자리수가 0, 1인경우에 따라서 다음 자리수의 이친수가 생성되는 개수가 결정
*/
public class Main {
	
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        long one[] = new long[N];
        long zero[] = new long[N];
        long ans = 1;
        
        if(N>=2) {
	        one[0] = 1;
	        zero[0] = 0;
	        
	        for(int i = 1; i<N; i++) {
	        	one[i] = zero[i-1];
	        	zero[i] = one[i-1]+zero[i-1];
	        }
	        ans = one[N-1] + zero[N-1];
        }
        
        System.out.println(ans);

        br.close();
	}

}
