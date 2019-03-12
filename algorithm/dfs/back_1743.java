package dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class back_1743 {
	
	/*문제
	코레스코 콘도미니엄 8층은 학생들이 3끼의 식사를 해결하는 공간이다. 그러나 몇몇 비양심적인 학생들의 만행으로 음식물이 통로 중간 중간에 떨어져 있다. 
	이러한 음식물들은 근처에 있는 것끼리 뭉치게 돼서 큰 음식물 쓰레기가 된다. 

	이 문제를 출제한 선생님은 개인적으로 이러한 음식물을 실내화에 묻히는 것을 정말 진정으로 싫어한다. 참고로 우리가 구해야 할 답은 이 문제를 낸 조교를 맞추는 것이 아니다. 

	통로에 떨어진 음식물을 피해가기란 쉬운 일이 아니다. 따라서 선생님은 떨어진 음식물 중에 제일 큰 음식물만은 피해 가려고 한다. 

	선생님을 도와 제일 큰 음식물의 크기를 구해서 “10ra"를 외치지 않게 도와주자.

	입력
	첫째 줄에 통로의 세로 길이 N(1 ≤ N ≤ 100)과 가로 길이 M(1 ≤ M ≤ 100) 그리고 음식물 쓰레기의 개수 K(1 ≤ K ≤ 10,000)이 주어진다.  
	그리고 다음 K개의 줄에 음식물이 떨어진 좌표 (r, c)가 주어진다.

	좌표 (r, c)의 r은 위에서부터, c는 왼쪽에서부터가 기준이다.*/
	
	static int N,M,K, cnt, max = 0;
	static int food[][];
	static boolean visited[][];
	static int mx[] = {0,0,-1,1};
	static int my[] = {1,-1,0,0};
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		M = s.nextInt();
		K = s.nextInt();
		
		food = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		for(int i = 0; i < K; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			
			food[x][y] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(!visited[i][j] && food[i][j] == 1) {
					cnt = 1;
					dfs(i,j);
					if(cnt>max) max = cnt;
				}
			}
		}
		
		System.out.println(max);
		
	}

	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + mx[i];
			int ny = y + my[i];
			
			if(nx >= 0 && ny >= 0 && nx <= N && ny <= M) {
				if(food[nx][ny] == 1 && !visited[nx][ny]) {
					cnt++;
					dfs(nx,ny);
				}
			}
		}
	}

}
