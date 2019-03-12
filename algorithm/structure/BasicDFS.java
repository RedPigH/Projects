package structure;

import java.util.*;

public class BasicDFS {
	static LinkedList<Integer> llist[];
	static int vertax;	// ������ ����
	static int edge;	// ������ ����
	static ArrayList<ArrayList<Integer>> list; //������ ������ ��Ÿ���� ���� ����Ʈ
	static boolean[] visit;	//�� ����(���)�� �湮 ����
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		vertax = s.nextInt();
		edge = s.nextInt();
		list = new ArrayList<>();
		visit = new boolean[vertax + 1];	//����(���)�� ����ŭ �迭 ũ�� ����
		
		for(int i = 0; i < vertax; i++) {
			list.add(new ArrayList<>());	//����(���)�� �� ��ŭ�� ArrayList�� �����Ͽ� list�� ����
		}
		
		for(int i = 0; i < edge; i++) {
			int start = s.nextInt();
			int end = s.nextInt();
			list.get(start).add(end);
			list.get(end).add(start);
		}
	}

}
