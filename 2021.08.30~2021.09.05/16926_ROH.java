import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

//turn Arrays
public class 16926_ROH {
	static int[][] array = new int[302][302];
	static int count = 1;
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i<=N; i++) {
			StringTokenizer nn = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j<=M; j++) {
				array[i][j] = Integer.parseInt(nn.nextToken());
			}
		}
		
		for(int n = 0; n<R; n++) {
			count = 1;
			turnAround(N, M);
		
		}
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				System.out.print(array[i][j]);
				if(j!=M) System.out.print(" ");
			}
			System.out.println("");
		}
	}
	
	static void turnAround(int N, int M) {
		int temp1 = array[count][count];
		int temp2 = array[count+N-1][count+M-1];
		
		if(N!=0 && M!=0) {
			//System.out.println(temp1+"+"+temp2+":"+N+M);
			for(int i = 0; i<M-1; i++) {
				array[count][count+i] =  array[count][count+i+1];
				array[count+N-1][count+M-1-i] = array[count+N-1][count+M-i-2]; 
			}
			for(int j = 0; j<N-2; j++) {
				array[count+N-1-j][count] = array[count+N-2-j][count];
				array[count+j][count+M-1] = array[count+j+1][count+M-1];
			}
			
			array[count+1][count] = temp1;
			array[count+N-2][count+M-1] = temp2;
			
			count++;
			N = N-2;
			M = M-2;
			
			turnAround(N, M);
		}
		else return;
		
	}
}

