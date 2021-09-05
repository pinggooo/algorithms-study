import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class 1587_ROH {
	
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		
		int odd = 0;
		int add = 0;
		int n = A/2 + B/2;
		if(A%2==1 && B%2==1) odd = 1;
		
		for(int i = 0; i<N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(temp.nextToken());
			int b = Integer.parseInt(temp.nextToken());
			if(a%2 == 1 && b%2 == 1) add = 1;
		}
		
		System.out.println(n+odd*add);

	}
}
