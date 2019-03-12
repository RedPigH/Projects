package dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class back_9466 {
	/*
	 * �̹� �����б⿡ '���� �ذ�' ���Ǹ� ��û�� �л����� �� ������Ʈ�� �����ؾ� �Ѵ�. ������Ʈ ���� ������ ������ ����. ������ ���
	 * �л����� ������ ���� ������ ���� ���� �� ���� ���� ���� �ִ�. ������Ʈ ���� �����ϱ� ����, ��� �л����� ������Ʈ�� �Բ��ϰ� ����
	 * �л��� �����ؾ� �Ѵ�. (��, �� �� �� ������ �� �ִ�.) ȥ�� �ϰ� �;��ϴ� �л��� �ڱ� �ڽ��� �����ϴ� �͵� �����ϴ�.
	 * 
	 * �л�����(s1, s2, ..., sr)�̶� �� ��, r=1�̰� s1�� s1�� �����ϴ� ��쳪, s1�� s2�� �����ϰ�, s2�� s3��
	 * �����ϰ�,..., sr-1�� sr�� �����ϰ�, sr�� s1�� �����ϴ� ��쿡�� �� ���� �� �� �ִ�.
	 * 
	 * ���� ���, �� �ݿ� 7���� �л��� �ִٰ� ����. �л����� 1������ 7������ ǥ���� ��, ������ ����� ������ ����.
	 * 
	 * 1 2 3 4 5 6 7 3 1 3 7 3 4 6
	 * 
	 * ���� ����� ���� (3)�� (4, 7, 6)�� ���� �̷� �� �ִ�. 1, 2, 5�� ��� ������ ������ �ʴ´�.
	 * 
	 * �־��� ������ ����� ���� ��� ������Ʈ ������ ������ �ʴ� �л����� ���� ����ϴ� ���α׷��� �ۼ��϶�.
	 */

	static int N;
	static int list[];
	static ArrayList<Integer> cycle;
	static boolean iscycle[];

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList result = new ArrayList();
		int T = s.nextInt();

		for (int j = 0; j < T; j++) {
			int cnt = 0;
			N = s.nextInt();
			list = new int[N];
			iscycle = new boolean[N];

			for (int i = 0; i < N; i++) {
				list[i] = s.nextInt();
			}

			for (int i = 0; i < N; i++) {
				cycle = new ArrayList<Integer>();
				dfs(list[i], cycle);
			}

			for (int i = 0; i < N; i++) {
				if (iscycle[i]) {
					cnt++;
				}
			}
			result.add(N-cnt);
		}
		
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	private static void dfs(int i, ArrayList cycle) {
		// TODO Auto-generated method stub

		if (list[i - 1] == i) {
			iscycle[i - 1] = true;
		}

		if (cycle.size() != 0) {
			if (Integer.parseInt(cycle.get(0).toString()) == list[i - 1]) {
				for (int j = 0; j < cycle.size(); j++) {
					iscycle[Integer.parseInt(cycle.get(j).toString()) - 1] = true;
				}
			}
		}

		if (!iscycle[i - 1]) {
			cycle.add(list[i - 1]);
			dfs(list[i - 1], cycle);
		}
	}

}
