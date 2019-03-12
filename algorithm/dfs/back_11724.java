package dfs;

import java.util.Scanner;

public class back_11724 {
	/*���� ���� �׷����� �־����� ��, ���� ��� (Connected Component)�� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.*/
	
	/*ù° �ٿ� ������ ���� N�� ������ ���� M�� �־�����. (1 �� N �� 1,000, 0 �� M �� N��(N-1)/2) 
	��° �ٺ��� M���� �ٿ� ������ �� ���� u�� v�� �־�����. (1 �� u, v �� N, u �� v) ���� ������ �� ���� �־�����.*/
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
