package bfs;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Queue<T> {
	class Node<T>{
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	private Node<T> first;
	private Node<T> last;
	
	public void add(T item) {
		Node<T> t = new Node<T>(item);
		
		if(last != null	) {
			last.next = t;
		}
		last = t;
		if(first == null) {
			first = last;
		}
	}
	
	public T remove() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		
		T data = first.data;
		first = first.next;
		
		if(first == null) {
			last = null;
		}
		return data;
	}
	
	public T peek() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}

}

class Graph {
	class Node {
		int data;
		LinkedList<Node> list;
		boolean visited;

		Node(int data) {
			this.data = data;
			this.visited = false;
			list = new LinkedList<Node>();
		}
	}

	Node[] nodes;

	Graph(int size) {
		nodes = new Node[size];
		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}

	void addEdge(int s, int e) {
		Node n1 = nodes[s];
		Node n2 = nodes[e];
		if (!n1.list.contains(n2)) {
			n1.list.add(n2);
		}
		if (!n2.list.contains(n1)) {
			n2.list.add(n1);
		}
	}
	
	void bfs(int index) {
		Node root = nodes[index];
		Queue<Node> queue = new Queue<Node>();
		queue.add(root);
		root.visited = true;
		while(!queue.isEmpty()) {
			Node r = queue.remove();
			for(Node n : r.list) {
				if(n.visited == false) {
					n.visited = true;
					queue.add(n);
				}
			}
			isVisit(r);
		}
	}
	void isVisit(Node n) {
		System.out.print(n.data + " ");
	}
}

public class standardBFS {
	public static void main(String[] args) {
		int n, edge;
		int start, end;
		int sNode;
		Scanner s = new Scanner(System.in);

		System.out.println("노드 개수 입력 : ");
		n = s.nextInt();

		Graph g = new Graph(n);

		System.out.println("간선 개수 입력 : ");
		edge = s.nextInt();

		for (int i = 0; i < edge; i++) {
			start = s.nextInt();
			end = s.nextInt();

			g.addEdge(start, end);
		}
		
		System.out.println("탐색 시작 노드 : ");
		sNode = s.nextInt();

		g.bfs(sNode);
	}

}
