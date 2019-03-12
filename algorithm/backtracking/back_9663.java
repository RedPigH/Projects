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
		for(int i = 0; i < n; i++) { //퀸은 각 줄에 하나씩 들어가므로 n번만큼 반복하여 확인
			result[row] = i; //첫번째 열을 시작으로 각 열에 행에 퀸을 놓아 확인
			if(isPossible(result, n, row)) {	//퀸이 놓일수 있는 자리라면 재귀를 이용하여 다음열의 퀸이 놓일 자리를 탐색 
				if(row == n - 1) {	// 재귀의 결과로 현재 열이 마지막 열과 같다면 탐색이 완료된 것이므로 count를 증가시킨다.
					count++;	
				}else {
					backtracking(result,n,row+1); // 현재 열이 마지막 열이 아니라면 다음 열에 대한 퀸의 위치를 구한다.
				}
			}
		}
		
	}

	private static boolean isPossible(int[] result, int n, int row) {
		// TODO Auto-generated method stub
		for(int i = 0; i < row; i++) {
			//현재 열에 놓인 퀸이 이전에 놓인 퀸들에 대하여 직선이나 대각선으로 놓였을 경우 false를 return
			//result[row] == result[i] -> 퀸들이 직선으로 놓였을 경우, result배열에 들어가는 값은 각 열에 퀸의 위치(몇번째 행인지)이므로 행의 값이 같다면 직선으로 놓여져있다는 것
			//row - i == Math.abs(result[row] - result[i] -> 퀸들이 대각선으로 놓였을 경우
			if(result[row] == result[i] || row - i == Math.abs(result[row] - result[i])){
				return false;
			}
		}
		return true;
	}

}
