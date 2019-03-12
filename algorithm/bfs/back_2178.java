package bfs;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Node {
	int x, y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class back_2178 {
	static int N;
	static int M;
	static int cnt = 0;
	static int miro[][];
	static boolean visited[][];
	static int dx[] = { -1, 1, 0, 0 }; // »óÇÏÁÂ¿ì
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		M = s.nextInt();
		miro = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = s.next();
			String[] slist = str.split("");
			for (int j = 0; j < M; j++) {
				miro[i][j] = Integer.parseInt(slist[j]);
				visited[i][j] = false;
			}
		}
		bfs(new Node(0, 0));
		System.out.println(cnt);
	}

	public static void bfs(Node n) {
		Queue<Node> q = new LinkedList<>();
		
		q.add(n);
		visited[n.x][n.y] = true;
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			if(tmp.x == N -1 && tmp.y == M-1) {
				break;
			}
			for(int i = 0; i < 4; i++) {
				int x1 = tmp.x + dx[i];
				int y1 = tmp.y + dy[i];
				
				if(x1>=0 && y1>=0 && x1<N && y1 <M) {
					if(visited[x1][y1] == false && miro[x1][y1] == 1) {
						System.out.println(cnt);
						q.add(new Node(x1,y1));
					}
				}
			}
			cnt++;
		}
	}

}
