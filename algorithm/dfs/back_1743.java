package dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class back_1743 {
	
	/*����
	�ڷ����� �ܵ��̴Ͼ� 8���� �л����� 3���� �Ļ縦 �ذ��ϴ� �����̴�. �׷��� ��� �������� �л����� �������� ���Ĺ��� ��� �߰� �߰��� ������ �ִ�. 
	�̷��� ���Ĺ����� ��ó�� �ִ� �ͳ��� ��ġ�� �ż� ū ���Ĺ� �����Ⱑ �ȴ�. 

	�� ������ ������ �������� ���������� �̷��� ���Ĺ��� �ǳ�ȭ�� ������ ���� ���� �������� �Ⱦ��Ѵ�. ����� �츮�� ���ؾ� �� ���� �� ������ �� ������ ���ߴ� ���� �ƴϴ�. 

	��ο� ������ ���Ĺ��� ���ذ���� ���� ���� �ƴϴ�. ���� �������� ������ ���Ĺ� �߿� ���� ū ���Ĺ����� ���� ������ �Ѵ�. 

	�������� ���� ���� ū ���Ĺ��� ũ�⸦ ���ؼ� ��10ra"�� ��ġ�� �ʰ� ��������.

	�Է�
	ù° �ٿ� ����� ���� ���� N(1 �� N �� 100)�� ���� ���� M(1 �� M �� 100) �׸��� ���Ĺ� �������� ���� K(1 �� K �� 10,000)�� �־�����.  
	�׸��� ���� K���� �ٿ� ���Ĺ��� ������ ��ǥ (r, c)�� �־�����.

	��ǥ (r, c)�� r�� ����������, c�� ���ʿ������Ͱ� �����̴�.*/
	
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
