import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class 8980_ROH {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		
		List<Route> list =  new ArrayList<Route>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer info = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(info.nextToken());
			int e = Integer.parseInt(info.nextToken());
			int c = Integer.parseInt(info.nextToken());
			Route r = new Route(s, e, c);
			list.add(r);
		}
		
		Collections.sort(list);
		
		for(Route l : list) {
			System.out.println(l.start+"+"+l.end+"+"+l.capacity);
		}
	}
}

class Route implements Comparable<Route> {
	int start;
	int end;
	int capacity;
	public Route(int s, int e, int c) {
		this.start = s;
		this.end = e;
		this.capacity = c;
	}
	
	public int compareTo(Route o) {
		if(this.end > o.end) {
			return 1;
		}
		else if(this.end == o.end) {
			if(this.start > o.start) {
				return 1;
			}
			else if(this.start == o.start) {
				if(this.capacity > o.capacity) {
					return 1;
				}
				else if(this.capacity < o.capacity) {
					return -1;
				}
				else return 0;
			}
			else return -1;
		}
		else return -1;
	}
	
}