
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, min;
	static int city[][], selected[];
	static List<int[]> homes = new ArrayList<>();
	static List<int[]> chickens = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		city = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());	
				if(city[i][j] == 1) {
					homes.add(new int[] {i, j});
				}
				if(city[i][j] == 2) {
					chickens.add(new int[] {i, j});
				}
			}
		}
		
		selected = new int[M];
		min = Integer.MAX_VALUE;
		
		select(0,0);
		
		System.out.println(min);

	}

	private static void select(int st, int cnt) {
		
		if(cnt == M) {
			distance();
			return;
		}
		
		for(int i=st; i<chickens.size(); i++) {
			selected[cnt] = i;
			select(i+1, cnt+1);
		}
				
	}

	private static void distance() {
		
		int sum = 0;
		// 가장 가까운 치킨집과의 거리 구해서 더해주기
		for(int i=0; i<homes.size(); i++) {
			int home[] = homes.get(i);
			int dis = 0;
			int mindis = 200;
			for(int j=0; j<selected.length; j++) {
				int chicken[] = chickens.get(selected[j]);
				dis = Math.abs(home[0]-chicken[0]) + Math.abs(home[1]-chicken[1]);
				mindis = Math.min(dis, mindis);
			}
			sum += mindis;
		}
		
		min = Math.min(min, sum);
		
	}

}
