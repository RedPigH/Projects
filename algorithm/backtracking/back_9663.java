package backtracking;

import java.util.Scanner;

public class back_9663 {
	static int[] result;
	static int count = 0;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		result = new int[n];
		
		backtracking(result,n,0);
		
		System.out.println(count);
	}

	private static void backtracking(int[] result, int n, int row) {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) { //���� �� �ٿ� �ϳ��� ���Ƿ� n����ŭ �ݺ��Ͽ� Ȯ��
			result[row] = i; //ù��° ���� �������� �� ���� �࿡ ���� ���� Ȯ��
			if(isPossible(result, n, row)) {	//���� ���ϼ� �ִ� �ڸ���� ��͸� �̿��Ͽ� �������� ���� ���� �ڸ��� Ž�� 
				if(row == n - 1) {	// ����� ����� ���� ���� ������ ���� ���ٸ� Ž���� �Ϸ�� ���̹Ƿ� count�� ������Ų��.
					count++;	
				}else {
					backtracking(result,n,row+1); // ���� ���� ������ ���� �ƴ϶�� ���� ���� ���� ���� ��ġ�� ���Ѵ�.
				}
			}
		}
		
	}

	private static boolean isPossible(int[] result, int n, int row) {
		// TODO Auto-generated method stub
		for(int i = 0; i < row; i++) {
			//���� ���� ���� ���� ������ ���� ���鿡 ���Ͽ� �����̳� �밢������ ������ ��� false�� return
			//result[row] == result[i] -> ������ �������� ������ ���, result�迭�� ���� ���� �� ���� ���� ��ġ(���° ������)�̹Ƿ� ���� ���� ���ٸ� �������� �������ִٴ� ��
			//row - i == Math.abs(result[row] - result[i] -> ������ �밢������ ������ ���
			if(result[row] == result[i] || row - i == Math.abs(result[row] - result[i])){
				return false;
			}
		}
		return true;
	}

}
