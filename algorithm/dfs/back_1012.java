package dfs;

import java.util.Scanner;

public class back_1012 {
	
	/*차세대 영농인 한나는 강원도 고랭지에서 유기농 배추를 재배하기로 하였다. 
	   농약을 쓰지 않고 배추를 재배하려면 배추를 해충으로부터 보호하는 것이 중요하기 때문에,
	   한나는 해충 방지에 효과적인 배추흰지렁이를 구입하기로 결심한다. 이 지렁이는 배추근처에 서식하며 해충을 잡아 먹음으로써 배추를 보호한다.
	   특히, 어떤 배추에 배추흰지렁이가 한 마리라도 살고 있으면 이 지렁이는 인접한 다른 배추로 이동할 수 있어, 그 배추들 역시 해충으로부터 보호받을 수 있다.

	(한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있다고 간주한다)

	한나가 배추를 재배하는 땅은 고르지 못해서 배추를 군데군데 심어놓았다. 
	배추들이 모여있는 곳에는 배추흰지렁이가 한 마리만 있으면 되므로 서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면 총 몇 마리의 지렁이가 필요한지 알 수 있다.

	예를 들어 배추밭이 아래와 같이 구성되어 있으면 최소 5마리의 배추흰지렁이가 필요하다.

	(0은 배추가 심어져 있지 않은 땅이고, 1은 배추가 심어져 있는 땅을 나타낸다.)

	1	1	0	0	0	0	0	0	0	0
	0	1	0	0	0	0	0	0	0	0
	0	0	0	0	1	0	0	0	0	0
	0	0	0	0	1	0	0	0	0	0
	0	0	1	1	0	0	0	1	1	1
	0	0	0	0	1	0	0	1	1	1   */
	
	static int[] mx = {0, 0, -1, 1};	//dfs시 상하좌우 탐색용
	static int[] my = {1, -1, 0, 0};
	static int[][] list; 				//입력값과 방문여부를 저장할 이차원 배열
	static boolean[][] visited;
	static int N,M;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		
		for(int i = 0; i < T; i++) {
			int cnt = 0;
			N = s.nextInt();
			M = s.nextInt();
			list = new int[N][M];
			visited = new boolean[N][M];
			int K = s.nextInt();
			
			for(int j = 0; j < K; j++) {
				int x = s.nextInt();
				int y = s.nextInt();
				list[x][y] = 1;
			}	//값 입력받아 배열 생성
			
			for(int j = 0; j < N; j++) {		// (0,0), 부터 (N,M)까지 탐색하며 값이 1이고 방문여부가 false인 경우 dfs실행
				for(int k = 0; k < M; k++) {
					if(!visited[j][k] && list[j][k] == 1) {
						dfs(j,k);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
		
	}

	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		visited[x][y] = true;				//방문 여부 갱신
		
		for(int i = 0; i < 4; i++) {		//상하좌우 탐색
			int nx = x + mx[i];
			int ny = y + my[i];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < M) {		// 배열 범위 벗어나는지 검사
				if(list[nx][ny] == 1 && !visited[nx][ny]) {		// 상하좌우 인접 위치에서 값이 1이고 방문여부가 false인 경우에만 이동하여 dfs실행
					dfs(nx,ny);
				}
			}
		}
	}

}
