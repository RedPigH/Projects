package structure;

import java.util.*;

public class BasicDFS {
	static LinkedList<Integer> llist[];
	static int vertax;	// 정점의 갯수
	static int edge;	// 간선의 갯수
	static ArrayList<ArrayList<Integer>> list; //정점간 연결을 나타내는 인접 리스트
	static boolean[] visit;	//각 정점(노드)의 방문 여부
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		vertax = s.nextInt();
		edge = s.nextInt();
		list = new ArrayList<>();
		visit = new boolean[vertax + 1];	//정점(노드)의 수만큼 배열 크기 지정
		
		for(int i = 0; i < vertax; i++) {
			list.add(new ArrayList<>());	//정점(노드)의 수 만큼의 ArrayList를 생성하여 list에 저장
		}
		
		for(int i = 0; i < edge; i++) {
			int start = s.nextInt();
			int end = s.nextInt();
			list.get(start).add(end);
			list.get(end).add(start);
		}
	}

}
