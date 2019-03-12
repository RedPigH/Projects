package dfs;

import java.util.LinkedList;
import java.util.Stack;
import java.util.NoSuchElementException;
import java.util.Scanner;

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

	void dfs(int index) {
		Node root = nodes[index];
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		root.visited = true;
		while (!stack.isEmpty()) {
			Node r = stack.pop();
			for (Node n : r.list) {
				if (n.visited == false) {
					n.visited = true;
					stack.push(n);
				}
			}
			isVisit(r);
		}
	}

	void dfsR(Node r) {
		if (r == null)
			return;
		r.visited = true;
		isVisit(r);
		for (Node n : r.list) {
			if (n.visited == false) {
				dfsR(n);
			}
		}
	}

	void dfsR(int index) {
		Node r = nodes[index];
		dfsR(r);
	}

	void isVisit(Node n) {
		System.out.print(n.data + " ");
	}
}

public class standardDFS {
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

		g.dfsR(sNode);
	}

}
