import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 14503_ROH {
	static int count = 0;
	static int N = 0;
	static int M = 0;
	static int x = 0;
	static int y = 0;
	static int w = 0;
	static int d = 0;
	static int[][] room = new int[52][52];
	static int[] dy = {0,1,0,-1};
	static int[] dx = {-1,0,1,0};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		StringTokenizer point = new StringTokenizer(br.readLine(), " ");
		x = Integer.parseInt(point.nextToken())+1;
		y = Integer.parseInt(point.nextToken())+1;
		w = Integer.parseInt(point.nextToken());
		
		for(int i = 1; i<=N; i++) {
			StringTokenizer line = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j<=M; j++) {
				room[i][j] = Integer.parseInt(line.nextToken());
			}
		}
		boolean run = true;
		while(run) {
			first();
			run = second();
		}
		

        System.out.println(count);
	}
	
	static void first() {
		
		room[x][y] = count+2;
		count++;
	}
	
	static boolean second() {
		d = 0;
		while(d!=4) {
			turn();
			if(go_check()) {
				return true;
			}
			else d++;
		}
		
		boolean temp = false;
		if(go_back()) {
			temp = second();
		}
		else return false;
		
		return temp;
	}
	
	static boolean go_back() {
		int temp = (w+2)%4;
		int tx = x+dx[temp];
		int ty = y+dy[temp];
		if(room[tx][ty] == 1) {
			return false;
		}
		else{
			x = tx;
			y = ty;
			return true;
		}
	}
	
	static boolean go_check() {
		int tx = x+dx[w];
		int ty = y+dy[w];
		if(room[tx][ty] == 1) {
			return false;
		}
		else{
			if(room[tx][ty] == 0) {
				x = tx;
				y = ty;
				return true;
			}
			else return false;
		}
	}
	
	static void turn() {
		int n = w-1;
		if(n==-1) {
			n = 3;
		}
		w = n;
	}
}
