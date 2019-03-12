package dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class back_2667 {
	static int N;
	static int cnt; // 단지 집의 수
	static int danji[][]; // dfs를 실행할 배열
	static boolean visited[][]; // 방문 여부
	static int dx[] = { -1, 1, 0, 0 }; // 상하좌우
	static int dy[] = { 0, 0, -1, 1 };
	static ArrayList list = new ArrayList();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		N = s.nextInt();
		danji = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = s.next();
			String[] slist = str.split("");
			for (int j = 0; j < N; j++) {
				danji[i][j] = Integer.parseInt(slist[j]);
				visited[i][j] = false;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (danji[i][j] == 1 && visited[i][j] == false) {
					cnt = 1;
					dfs(i, j);
					list.add(cnt);
				}
			}
		}
		System.out.println(list.size());
		Collections.sort(list);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	static int dfs(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int x1 = x + dx[i];
			int y1 = y + dy[i];

			if (x1 >= 0 && y1 >= 0 && x1 < N && y1 < N) {
				if(danji[x1][y1] == 1 && visited[x1][y1] == false) {
					dfs(x1,y1);
					cnt++;
				}
			}
		}
		return cnt;
	}
}
