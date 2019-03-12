package dfs;

import java.util.Scanner;

public class back_11724 {
	/*방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.*/
	
	/*첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 
	둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.*/
	static int N, M, cnt = 0;
	static int edge[][];
	static boolean visited[];
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		N = s.nextInt();
		edge = new int[N+1][N+1];
		visited = new boolean[N+1];
		M = s.nextInt();
		
		for(int i = 0; i < M; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			edge[x][y] = edge[y][x] = 1;
		}
		
		for(int i = 0; i < N + 1; i++) {
			for(int j = 0; j < N + 1; j++) {
				System.out.print(edge[i][j]);
			}
			System.out.println();
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i,cnt);
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static void dfs(int i, int cnt) {
		// TODO Auto-generated method stub
		visited[i] = true;
		for(int j = 1; j < N + 1; j++) {
			if(edge[i][j] == 1 && !visited[j]) {
				dfs(j,cnt);
			}
		}
		
	}

}
