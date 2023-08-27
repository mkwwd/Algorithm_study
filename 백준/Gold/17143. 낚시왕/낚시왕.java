import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

	static int R, C;
	static ArrayList<int[]> fishInfo;
	static int fishArea[][];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		fishArea = new int[R][C];
		
		// 해당 인덱스 번호 물고기의 속력, 이동방향, 크기 저장
		fishInfo = new ArrayList<>();
		fishInfo.add(new int[] {0, 0, 0, 0, 0, 0});
		
		for(int i=1; i<=M; i++) {
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			// 물고기 위치 저장
			fishArea[x][y] = i;
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			int newDir = 0;
			// 물고기 정보 저장
			fishInfo.add(new int[] {x, y, speed, dir, size, newDir});
		}
		
		int catchFish = 0;
		
		// 낚시왕 이동 => 크기가 C이므로 C-1만큼 이동
		for(int i=0; i<C; i++) {
			if(M==0) break;
			// 물고기 있으면 물고기 캐치
			for(int j=0; j<R; j++) {
				// 배열안에 0이 아닌 숫자가 있으면 잡음
				int fish = fishArea[j][i];
				if(fish != 0) {
					catchFish += fishInfo.get(fish)[4];
					fishInfo.set(fish, new int[] {0, 0, 0, 0, 0});
					break;
				}
			}
			// 물고기 이동			
			moveFish(fishInfo);			
		}
		
		System.out.println(catchFish);
	}

	private static void moveFish(ArrayList<int[]> fishInfo) {
		
		int newPos[][] = new int[R][C];
		ArrayList<Integer> deadFish = new ArrayList<>();
		
		for(int i=1; i<fishInfo.size(); i++) {
			// 물고기 가져오자
			int dir = fishInfo.get(i)[3];
			if(dir == 0) continue;
			int x = fishInfo.get(i)[0];
			int y = fishInfo.get(i)[1];
			int speed = fishInfo.get(i)[2];
			int size = fishInfo.get(i)[4];
			int newDir = fishInfo.get(i)[5];
			
			switch(dir) {
			// 위
			case 1:
				if(newDir == 0) { newDir = -1; }

				while(speed != 0) {
					if(newDir == -1 && x==0) {
						newDir = newDir*-1;
					}else if(newDir == 1 && x == R-1) {
						newDir = newDir*-1;
					}
					x += newDir;
					speed --;
				}
				break;
			// 아래
			case 2:
				if(newDir == 0) { newDir = 1; }
				
				while(speed != 0) {
					if(newDir == -1 && x==0) {
						newDir = newDir*-1;
					}else if(newDir == 1 && x == R-1) {
						newDir = newDir*-1;
					}
					x += newDir;
					speed --;
				}
				break;
			// 오른쪽
			case 3:
				if(newDir == 0) { newDir = 1; }
				
				while(speed != 0) {
					if(newDir == -1 && y ==0) {
						newDir = newDir*-1;
					}else if(newDir == 1 && y == C-1) {
						newDir = newDir*-1;
					}
					y += newDir;
					speed --;
				}
				break;
			// 왼쪽
			case 4:
				if(newDir == 0) { newDir = -1; }
				
				while(speed != 0) {
					if(newDir == -1 && y==0) {
						newDir = newDir*-1;
					}else if(newDir == 1 && y == C-1) {
						newDir = newDir*-1;
					}
					y += newDir;
					speed --;
				}
				break;
			
			}
			
			// 이동 완료 후에 물고기 위치
			fishInfo.get(i)[0] = x;
			fishInfo.get(i)[1] = y;
			fishInfo.get(i)[5] = newDir;
			
			// 이동 완료 후에 물고기 없으면 newPos에 물고기 위치 저장
			if(newPos[x][y] == 0) {				
				newPos[x][y] = i;
			}else { // 물고기가 존재하면 비교해서 하나는 없애고 하나는 저장
				if(fishInfo.get(newPos[x][y])[4] > size) {
					fishInfo.set(i, new int[] {0, 0, 0, 0, 0});
				}else {
					fishInfo.set(newPos[x][y], new int[] {0, 0, 0, 0, 0});
					newPos[x][y] = i;
				}
			}			
		}
		fishArea = newPos;
	}

}